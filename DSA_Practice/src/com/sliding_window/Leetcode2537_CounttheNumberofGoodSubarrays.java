package com.sliding_window;
import java.util.HashMap;

public class Leetcode2537_CounttheNumberofGoodSubarrays {

	    public static long countGood(int[] nums, int k) {
	        int i = 0; // Left pointer
	        int j = 0; // Right pointer
	        long ans = 0; // Count of subarrays that have at least `k` good pairs
	        long cnt = 0; // Count of pairs in the current window
	        HashMap<Integer, Integer> map = new HashMap<>(); // To track the frequency of elements in the current window

	        // Iterate through the array using the right pointer `j`
	        while (j < nums.length) {
	            // Add the current element at `j` to the map and update the pair count
	            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
	            cnt += map.get(nums[j]) - 1; // Increase the count of pairs involving the element at `j`

	            // If there are `k` or more pairs in the current window
	            while (cnt >= k) {
	                // All subarrays starting at `i` and ending at `j` will have at least `k` good pairs
	                ans += (nums.length - j); 
	                /* 
	                 Once we know that the subarray from i to j (i.e., nums[i]...nums[j]) 
	                 contains at least k good pairs, every subarray that starts from i and ends 
	                 from j to the end of the array is also valid.

					This is because any subarray starting from i and extending beyond j 
					(i.e., nums[i]...nums[j+1], nums[i]...nums[j+2], etc.) 
					will also contain at least k good pairs, since you are only expanding the 
					right boundary without removing elements from the left.

					Therefore, if nums.length - j represents the number of possible subarrays 
					that start from i and include nums[j] as the last element, we add that many to ans.
	                */

	                // Shrink the window from the left by removing `nums[i]` and adjusting the pair count
	                cnt -= map.get(nums[i]) - 1;
	                map.put(nums[i], map.get(nums[i]) - 1); // Decrease the frequency of `nums[i]`
	                if (map.get(nums[i]) == 0) {
	                    map.remove(nums[i]); // Remove the element from the map if its count reaches zero
	                }

	                i++; // Move the left pointer to shrink the window
	            }

	            // Move the right pointer to expand the window
	            j++;
	        }

	        return ans; // Return the total count of subarrays with at least `k` good pairs
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp = new int[] {1,1,1,1,1};
		System.out.println(countGood(inp, 10));

	}

}
