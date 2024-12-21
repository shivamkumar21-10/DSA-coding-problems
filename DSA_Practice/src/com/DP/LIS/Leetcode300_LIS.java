package com.DP.LIS;

import java.util.*;

public class Leetcode300_LIS {
	


	    /**
	     * Recursive function to find the length of the longest increasing subsequence (LIS).
	     * 
	     * @param nums The input array of integers.
	     * @param idx The current index being considered in the array.
	     * @param prev The index of the previous element in the LIS. -1 indicates no element has been taken yet.
	     * @param t A memoization table to store the result of subproblems to avoid redundant computations.
	     * @return The length of the LIS starting from the current index.
	     */
	    public int solve(int[] nums, int idx, int prev, int[][] t) {
	        // **Base Case**: If we've processed all elements in the array, return 0.
	        if (idx == nums.length) return 0;

	        // **Memoization Check**: If the result for this state (idx, prev) has already been computed,
	        // return the stored value to save computation time.
	        if (t[idx][prev + 1] != -1) {
	            return t[idx][prev + 1];
	        }

	        // **Option 1 (Not Take)**:
	        // Skip the current element and move to the next index.
	        int len = solve(nums, idx + 1, prev, t);

	        // **Option 2 (Take)**:
	        // If the current element can be part of the LIS (i.e., either no element has been taken yet
	        // or the current element is greater than the previous element in the LIS), include it.
	        if (prev == -1 || nums[idx] > nums[prev]) {
	            len = Math.max(len, 1 + solve(nums, idx + 1, idx, t)); // Add 1 to the length as we include this element.
	        }

	        // Store the result of the current state in the memoization table.
	        return t[idx][prev + 1] = len;
	    }

	    /**
	     * Function to calculate the length of the longest increasing subsequence (LIS) in the input array.
	     * 
	     * @param nums The input array of integers.
	     * @return The length of the LIS.
	     */
	    public int lengthOfLIS(int[] nums) {
	        int n = nums.length;

	        // Initialize the memoization table `t` with dimensions [n][n+1].
	        // `prev` is offset by +1 to handle the case when no element is chosen initially (prev = -1).
	        int[][] t = new int[n][n + 1];
	        for (int i = 0; i < n; i++) {
	            Arrays.fill(t[i], -1); // Fill all cells with -1 to indicate uncomputed states.
	        }

	        // Start the recursion with index 0 and no previous element (prev = -1).
	        return solve(nums, 0, -1, t);
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
