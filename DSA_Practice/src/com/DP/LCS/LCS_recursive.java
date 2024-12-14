package com.DP.LCS;

public class LCS_recursive {
	

	    // Helper function to compute the length of the Longest Common Subsequence (LCS)
	    // using recursion.
	    public int LCSHelper(String x, String y, int n, int m) {
	        // Base case:
	        // If either string is empty (n == 0 or m == 0), the LCS length is 0.
	        if (n == 0 || m == 0) {
	            return 0;
	        }

	        // If the characters at the current positions in both strings match,
	        // include this character in the LCS and move diagonally to the next characters
	        // (decrease both `n` and `m`).
	        if (x.charAt(n - 1) == y.charAt(m - 1)) {
	            return 1 + LCSHelper(x, y, n - 1, m - 1);
	        } else {
	            // If the characters do not match, we have two choices:
	            // 1. Ignore the current character in string `x` and move one step back in `x`.
	            // 2. Ignore the current character in string `y` and move one step back in `y`.
	            // Take the maximum result from both choices.
	            return Math.max(LCSHelper(x, y, n, m - 1), LCSHelper(x, y, n - 1, m));
	        }
	    }

	    // Main function to compute the Longest Common Subsequence (LCS) of two strings.
	    public int longestCommonSubsequence(String text1, String text2) {
	        // Start the recursion with the lengths of the two strings.
	        return LCSHelper(text1, text2, text1.length(), text2.length());
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
