package com.DP.LCS;

public class Leetcode1035_UncrossedLines {
	

	    // Recursive function to calculate the maximum number of uncrossed lines (similar to finding the Longest Common Subsequence).
	    public int maxCrossed(int[] num1, int[] num2, int n, int m, int[][] t) {

	        // Base case: If either array has no elements left to compare, the result is 0.
	        if (n == 0 || m == 0) return 0;

	        // If the result for this subproblem is already computed, return it from the memoization table.
	        if (t[n][m] != -1) {
	            return t[n][m];
	        }

	        // If the last elements of both arrays are the same, they form an uncrossed line.
	        // Move both pointers back by one and add 1 to the result.
	        if (num1[n - 1] == num2[m - 1]) {
	            return t[n][m] = 1 + maxCrossed(num1, num2, n - 1, m - 1, t);
	        }

	        // If the last elements are different, we have two choices:
	        // 1. Exclude the last element of `num1` and solve for the rest of `num1` and `num2`.
	        // 2. Exclude the last element of `num2` and solve for `num1` and the rest of `num2`.
	        // Take the maximum of these two choices.
	        return t[n][m] = Math.max(
	            maxCrossed(num1, num2, n - 1, m, t), // Exclude last element of num1
	            maxCrossed(num1, num2, n, m - 1, t)  // Exclude last element of num2
	        );
	    }

	    // Main function to calculate the maximum number of uncrossed lines between `nums1` and `nums2`.
	    public int maxUncrossedLines(int[] nums1, int[] nums2) {
	        int n = nums1.length; // Length of the first array.
	        int m = nums2.length; // Length of the second array.

	        // Create a 2D memoization table to store results of subproblems.
	        // The size of the table is (n+1) x (m+1) to handle empty arrays as well.
	        int[][] t = new int[n + 1][m + 1];

	        // Initialize the memoization table with -1 to indicate that no subproblem has been solved yet.
	        for (int i = 0; i <= n; i++) {
	            for (int j = 0; j <= m; j++) {
	                t[i][j] = -1;
	            }
	        }

	        // Start the recursive function with the full length of both arrays and return the result.
	        return maxCrossed(nums1, nums2, n, m, t);
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
