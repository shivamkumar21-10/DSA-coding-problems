package com.DP.LCS;

public class Leetcode1143_LongestCommonSubsequence_Memoization {
	
	    /**
	     * Helper function to compute the Longest Common Subsequence (LCS) using recursion with memoization.
	     * @param x The first string.
	     * @param y The second string.
	     * @param n The current length of the first string being considered.
	     * @param m The current length of the second string being considered.
	     * @param dp A 2D array for memoization to store intermediate results.
	     * @return The length of the LCS for the given substrings.
	     */
	    public int LCSHelper(String x, String y, int n, int m, int dp[][]) {
	        // Base case: If either string is empty, LCS length is 0.
	        if (n == 0 || m == 0) {
	            return dp[n][m] = 0; // Set dp[n][m] to 0 for future reference and return 0.
	        }

	        // If the value for the current subproblem has already been computed, return it.
	        if (dp[n][m] != -1) {
	            return dp[n][m];
	        }

	        // Case 1: If the last characters of both strings match.
	        // Include this character in the LCS and recursively compute for the remaining substrings.
	        if (x.charAt(n - 1) == y.charAt(m - 1)) {
	            return dp[n][m] = 1 + LCSHelper(x, y, n - 1, m - 1, dp);
	        } 
	        // Case 2: If the last characters do not match.
	        // Find the maximum LCS by either:
	        // 1. Ignoring the last character of string x (move to n-1).
	        // 2. Ignoring the last character of string y (move to m-1).
	        else {
	            return dp[n][m] = Math.max(LCSHelper(x, y, n, m - 1, dp), LCSHelper(x, y, n - 1, m, dp));
	        }
	    }

	    /**
	     * Main function to find the Longest Common Subsequence (LCS) of two strings.
	     * @param text1 The first string.
	     * @param text2 The second string.
	     * @return The length of the LCS of text1 and text2.
	     */
	    public int longestCommonSubsequence(String text1, String text2) {
	        // Create a 2D dp array initialized to -1.
	        // dp[i][j] represents the length of the LCS for the first 'i' characters of text1
	        // and the first 'j' characters of text2.
	        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

	        // Initialize the dp array with -1, indicating uncomputed states.
	        for (int i = 0; i <= text1.length(); i++) {
	            for (int j = 0; j <= text2.length(); j++) {
	                dp[i][j] = -1; // -1 indicates this state has not been solved yet.
	            }
	        }

	        // Call the recursive helper function to compute the LCS.
	        return LCSHelper(text1, text2, text1.length(), text2.length(), dp);
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
