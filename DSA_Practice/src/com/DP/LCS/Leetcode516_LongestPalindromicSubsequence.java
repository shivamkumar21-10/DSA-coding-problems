package com.DP.LCS;

public class Leetcode516_LongestPalindromicSubsequence {

	    // Function to calculate the Longest Common Subsequence (LCS) between two strings
	    public static int LCS(String x, String y) {
	        int m = x.length(); // Length of the first string
	        int n = y.length(); // Length of the second string

	        // Create a 2D DP array to store the LCS values
	        int[][] t = new int[m + 1][n + 1];

	        // Build the DP table iteratively
	        for (int i = 0; i <= m; i++) {
	            for (int j = 0; j <= n; j++) {

	                // Base case: If either string is empty, the LCS is 0
	                if (i == 0 || j == 0) {
	                    t[i][j] = 0;
	                }

	                // If the characters match, extend the LCS by 1
	                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
	                    t[i][j] = 1 + t[i - 1][j - 1];
	                }
	                
	                // If the characters do not match, take the maximum LCS found so far
	                else {
	                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
	                }
	            }
	        }

	        // Return the length of the LCS of x and y
	        return t[m][n];
	    }

	    /**
	     * Function to calculate the Longest Palindromic Subsequence in a given string.
	     * 
	     * Explanation:
	     * A palindrome is a sequence that reads the same forward and backward.
	     * To find the longest palindromic subsequence:
	     * 1. Reverse the string `s` to get its reverse `sb`.
	     * 2. Calculate the LCS of `s` and `sb`.
	     * 
	     * Why LCS is used here:
	     * - The LCS between a string `s` and its reverse `sb` gives the longest
	     *   sequence of characters that appear in both `s` and `sb` in the same order.
	     * - Since `sb` is the reverse of `s`, the LCS gives the longest subsequence
	     *   that is a palindrome, because these characters appear in the same order
	     *   both forward (in `s`) and backward (in `sb`).
	     */
	    public static int longestPalindromeSubseq(String s) {
	        StringBuffer sb = new StringBuffer(s); // Create a reverse of the string
	        sb.reverse(); // Reverse the string
	        return LCS(s, sb.toString()); // Find the LCS of the string and its reverse
	    }

	    public static void main(String[] args) {
	        String s = "bbbab";
	        System.out.println(longestPalindromeSubseq(s)); // Output: 4 (Longest Palindromic Subsequence is "bbbb")
	    }
	}



