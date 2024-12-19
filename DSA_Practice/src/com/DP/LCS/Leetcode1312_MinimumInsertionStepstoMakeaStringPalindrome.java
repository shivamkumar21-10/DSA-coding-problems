package com.DP.LCS;

public class Leetcode1312_MinimumInsertionStepstoMakeaStringPalindrome {


	    /**
	     * Function to compute the Longest Common Subsequence (LCS) between two strings.
	     * 
	     * @param x The first string.
	     * @param y The second string.
	     * @return The length of the LCS between x and y.
	     */
	    public static int LCS(String x, String y) {
	        int m = x.length(); // Length of the first string.
	        int n = y.length(); // Length of the second string.

	        // Create a 2D DP table to store the LCS values for substrings of x and y.
	        int[][] t = new int[m + 1][n + 1];

	        // Fill the DP table iteratively.
	        for (int i = 0; i <= m; i++) {
	            for (int j = 0; j <= n; j++) {

	                // Base case: If either string is empty, the LCS length is 0.
	                if (i == 0 || j == 0) {
	                    t[i][j] = 0;
	                }

	                // If the characters match, extend the LCS length by 1.
	                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
	                    t[i][j] = 1 + t[i - 1][j - 1];
	                }

	                // If characters do not match, take the maximum LCS length
	                // found by excluding the current character from either x or y.
	                else {
	                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
	                }
	            }
	        }
	        // Return the LCS length for the entire strings x and y.
	        return t[m][n];
	    }

	    /**
	     * Function to calculate the minimum number of insertions required 
	     * to make a string a palindrome.
	     * 
	     * Logic Explanation:
	     * - A **palindrome** reads the same forward and backward.
	     * - To determine the minimum insertions required to make a string `s` a palindrome:
	     *   1. Reverse the string `s` to get `sb`.
	     *   2. Find the Longest Common Subsequence (LCS) between `s` and `sb`.
	     *   3. The LCS gives the longest subsequence in `s` that is already a palindrome.
	     *   4. The characters not part of this LCS need to be inserted to make `s` a palindrome.
	     * 
	     * Formula:
	     * - Minimum Insertions = Total Length of `s` - Length of LCS of `s` and `sb`.
	     * - This is because the characters not part of the LCS need to be added to make `s` a palindrome.
	     * 
	     * @param s The input string.
	     * @return The minimum number of insertions to make `s` a palindrome.
	     */
	    public static int minInsertions(String s) {
	        // Reverse the input string to create its reverse.
	        StringBuffer sb = new StringBuffer(s);
	        sb.reverse();

	        // Calculate the LCS between the original string `s` and its reverse `sb`.
	        return s.length() - LCS(s, sb.toString());
	    }

	    public static void main(String[] args) {
	        
	        // Example usage:
	        String s = "abcde";
	        System.out.println(minInsertions(s)); // Output: 4 (e.g., result palindrome: "edcbabcde")
	    }
	}



