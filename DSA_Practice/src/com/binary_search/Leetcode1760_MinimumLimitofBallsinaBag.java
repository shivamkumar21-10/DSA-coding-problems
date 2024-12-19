package com.binary_search;

import java.util.Arrays;

public class Leetcode1760_MinimumLimitofBallsinaBag {
	
	class Solution {
	    public int minimumSize(int[] nums, int maxOperations) {
	        // Step 1: Set the range for binary search.
	        // `left` represents the smallest possible size of a bag, which is at least 1.
	        int left = 1;
	        
	        // `right` represents the largest possible size of a bag, 
	        // which is the maximum number in the array `nums` (because initially, no splits are done).
	        int right = Arrays.stream(nums).max().getAsInt();
	        
	        // The answer will store the minimum possible size of the largest bag.
	        // Start by assuming the largest number as the initial answer.
	        int ans = right;

	        // Step 2: Perform binary search to minimize the size of the largest bag.
	        while (left <= right) {
	            // Calculate the mid-point (current guess for the largest possible bag size).
	            int mid = (left + right) / 2;

	            // Step 3: Calculate how many operations are required to ensure all numbers <= `mid`.
	            int op = 0; // `op` tracks the total number of operations required for this `mid`.

	            for (int n : nums) {
	                // If a number `n` is greater than the current `mid`, we need to split it.
	                // The number of splits required for `n` is calculated as (n - 1) / mid.
	                // Why (n - 1) / mid? 
	                // - If `n` is divisible by `mid`, it takes (n / mid - 1) splits to ensure all parts are ≤ mid.
	                // - If not divisible, (n - 1) / mid approximates the required splits.
	                op += (n - 1) / mid;

	                // Early exit: If operations exceed the allowed `maxOperations`, no need to continue.
	                if (op > maxOperations) {
	                    break;
	                }
	            }

	            // Step 4: Check if the current guess (`mid`) is valid.
	            if (op <= maxOperations) {
	                // If the required operations are within the allowed limit, `mid` is a valid solution.
	                ans = mid; // Update the answer to the current `mid`.

	                // Try to find an even smaller valid bag size by searching the left half.
	                right = mid - 1;
	            } else {
	                // If the required operations exceed `maxOperations`, `mid` is too small.
	                // Increase the minimum bag size by searching the right half.
	                left = mid + 1;
	            }
	        }

	        // Step 5: Return the smallest possible maximum bag size.
	        return ans;
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
