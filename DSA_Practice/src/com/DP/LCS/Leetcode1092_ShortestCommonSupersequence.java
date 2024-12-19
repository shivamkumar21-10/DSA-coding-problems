package com.DP.LCS;

public class Leetcode1092_ShortestCommonSupersequence {


	    /**
	     * Function to find the shortest common supersequence (SCS) of two strings `x` and `y`.
	     * The SCS is the shortest string that contains both `x` and `y` as subsequences.
	     *
	     * @param x The first string.
	     * @param y The second string.
	     * @return The shortest common supersequence of `x` and `y`.
	     */
	    public static String shortestCommonSupersequence(String x, String y) {
	        int m = x.length(); // Length of the first string.
	        int n = y.length(); // Length of the second string.

	        // Create a 2D DP table to calculate the length of the LCS.
	        int[][] t = new int[m + 1][n + 1];

	        // Fill the DP table using the standard LCS algorithm.
	        for (int i = 0; i <= m; i++) {
	            for (int j = 0; j <= n; j++) {

	                // Base case: If either string is empty, LCS is 0.
	                if (i == 0 || j == 0) {
	                    t[i][j] = 0;
	                }

	                // If the characters match, include it in the LCS and move diagonally.
	                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
	                    t[i][j] = 1 + t[i - 1][j - 1];
	                }

	                // If characters do not match, take the maximum LCS length
	                // by either excluding the current character of `x` or `y`.
	                else {
	                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
	                }
	            }
	        }

	        /**
	         * Backtracking logic to construct the shortest common supersequence:
	         * - Starting from the bottom-right of the DP table (`t[m][n]`),
	         *   we trace back to determine the shortest sequence that contains both strings.
	         *
	         * Differences from LCS Backtracking:
	         * - In LCS backtracking, we only include the characters that are part of the LCS.
	         * - Here, we include **all characters** from both strings:
	         *   - If characters match, add the matching character to the result.
	         *   - If characters do not match, we choose the larger LCS value
	         *     and add the respective character to the result.
	         * - Any leftover characters from either string are directly added to the result.
	         */

	        int i = m; // Pointer for string `x`.
	        int j = n; // Pointer for string `y`.
	        String s = ""; // String to store the result.

	        // Backtrack through the DP table.
	        while (i > 0 && j > 0) {
	            // Case 1: If characters match in both strings, include them in the result.
	            if (x.charAt(i - 1) == y.charAt(j - 1)) {
	                s = s + x.charAt(i - 1); // Add the character to the result.
	                i--; // Move diagonally up in the DP table.
	                j--;
	            }

	            // Case 2: If characters do not match, choose the larger LCS value.
	            else {
	                if (t[i][j - 1] > t[i - 1][j]) {
	                    // Add the character from string `y` to the result and move left.
	                    s = s + y.charAt(j - 1);
	                    j--;
	                } else {
	                    // Add the character from string `x` to the result and move up.
	                    s = s + x.charAt(i - 1);
	                    i--;
	                }
	            }
	        }

	        // Add any remaining characters from string `x`.
	        while (i > 0) {
	            s = s + x.charAt(i - 1);
	            i--;
	        }

	        // Add any remaining characters from string `y`.
	        while (j > 0) {
	            s = s + y.charAt(j - 1);
	            j--;
	        }

	        // The constructed string `s` is in reverse order, so reverse it before returning.
	        StringBuffer sb = new StringBuffer(s);
	        sb.reverse(); // Reverse the string.
	        return sb.toString(); // Return the shortest common supersequence.
	    }

	    public static void main(String[] args) {
	        // Test case: Find the shortest common supersequence of two strings.
	        String x = "abac";
	        String y = "cab";
	        System.out.println(shortestCommonSupersequence(x, y)); // Output: "cabac"
	    }
	}


