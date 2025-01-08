package com.prefixsum;
import java.util.*;

public class Leetcode_523ContinuousSubarraySum {
	

	    public boolean checkSubarraySum(int[] nums, int k) {
	        // Map to store the remainder when the cumulative sum is divided by k and the first index where this remainder occurred
	        // Key: remainder, Value: index
	        Map<Integer, Integer> map = new HashMap<>();
	        
	        // Variables to track the cumulative sum and its remainder when divided by k
	        int rem = 0; // Remainder
	        int sum = 0; // Cumulative sum

	        // Iterate through the array
	        for (int i = 0; i < nums.length; i++) {
	            // Add the current element to the cumulative sum
	            sum += nums[i];

	            // Compute the remainder when the cumulative sum is divided by k
	            rem = sum % k;

	            // Handle negative remainders:
	            // If rem is negative, make it positive by adding k (as remainder should always be non-negative)
	            if (rem < 0) {
	                rem += k;
	            }

	            // Check if the remainder is 0 and there are at least two elements in the subarray
	            // This means the sum of the subarray from the start to the current index is divisible by k
	            if (rem == 0 && i > 0) {
	                return true; // Valid subarray found
	            }

	            // Check if the current remainder has been seen before
	            if (map.containsKey(rem)) {
	                // Get the index where this remainder was first encountered
	                int prevIndex = map.get(rem);

	                // If the subarray length (i - prevIndex) is greater than 1, it is a valid subarray
	                // The sum of elements between these indices is divisible by k
	                if (i - prevIndex > 1) {
	                    return true;
	                }
	            }

	            // If the remainder is not already in the map, store it along with the current index
	            // We store only the first occurrence of the remainder to ensure we check the longest subarray possible
	            if (!map.containsKey(rem)) {
	                map.put(rem, i);
	            }
	        }

	        // If no valid subarray is found, return false
	        return false;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
