package com.prefixsum;
import java.util.HashMap;
import java.util.Map;
public class Leetcode525_ContiguousArray {

	    public int findMaxLength(int[] nums) {
	        int n = nums.length;
	        int psum = 0; // Prefix sum to track the balance between 1s and 0s.
	        int ans = 0;  // Variable to store the maximum length of the subarray with equal 0s and 1s.

	        // Initialize the HashMap to store the first occurrence of each prefix sum.
	        // Key: Prefix sum, Value: Index of the first occurrence of this prefix sum.
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, -1); // Important: Handle cases where a valid subarray starts from index 0.

	        for (int i = 0; i < n; i++) {
	            // Update the prefix sum:
	            // Increment by 1 for each `1` and decrement by 1 for each `0`.
	            psum += nums[i] == 1 ? 1 : -1;

	            // Intuition: If the prefix sum (psum) is seen again, it means the subarray
	            // between the first occurrence of that psum and the current index has a sum of 0.
	            // This happens because the net count of 1s and 0s in that subarray is equal.

	            if (map.containsKey(psum)) {
	                // Calculate the length of the subarray with sum 0 (equal 0s and 1s).
	                ans = Math.max(ans, i - map.get(psum));
	            } else {
	                // If this prefix sum is seen for the first time, store its index.
	                // This ensures we always consider the earliest occurrence of this psum,
	                // allowing us to maximize the subarray length.
	                map.put(psum, i);
	            }
	        }

	        // Return the maximum length of the subarray with equal numbers of 0s and 1s.
	        return ans;
	    }
	


}
