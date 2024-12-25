package com.DP.LCS;

public class Leetcode712_MinimumASCIIDeleteSumforTwoStrings {
	


	    // Recursive function to calculate the minimum ASCII sum of deleted characters
	    public int minimumAscii(String s1, String s2, int n, int m, int[][] t) {
	        // Base Case 1: If the first string is empty
	        // We need to delete all remaining characters from the second string.
	        if (n == 0) {
	            int sum = 0;
	            for (int j = 0; j < m; j++) {
	                sum += s2.charAt(j); // Add ASCII values of all characters in s2
	            }
	            return sum; // Return the total ASCII sum of deletions
	        }

	        // Base Case 2: If the second string is empty
	        // We need to delete all remaining characters from the first string.
	        if (m == 0) {
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                sum += s1.charAt(i); // Add ASCII values of all characters in s1
	            }
	            return sum; // Return the total ASCII sum of deletions
	        }

	        // Memoization: If the result for this subproblem is already computed, return it
	        if (t[n][m] != -1) {
	            return t[n][m];
	        }

	        // Recursive Case 1: Characters at the current position are equal
	        // No need to delete any character, so move to the next position in both strings
	        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
	            return t[n][m] = minimumAscii(s1, s2, n - 1, m - 1, t);
	        }

	        // Recursive Case 2: Characters are not equal
	        // We need to delete one of the characters and compute the minimum cost
	        // Option 1: Delete the last character from the first string
	        int deleteFromS1 = s1.charAt(n - 1) + minimumAscii(s1, s2, n - 1, m, t);

	        // Option 2: Delete the last character from the second string
	        int deleteFromS2 = s2.charAt(m - 1) + minimumAscii(s1, s2, n, m - 1, t);

	        // Store the minimum cost in the memoization table and return it
	        return t[n][m] = Math.min(deleteFromS1, deleteFromS2);
	    }

	    // Main function to calculate the minimum ASCII delete sum
	    public int minimumDeleteSum(String s1, String s2) {
	        int n = s1.length(); // Length of the first string
	        int m = s2.length(); // Length of the second string

	        // Create a 2D memoization table to store results of subproblems
	        // The size of the table is (n+1) x (m+1) to handle all cases, including empty strings
	        int[][] t = new int[n + 1][m + 1];

	        // Initialize the memoization table with -1
	        // -1 indicates that no subproblem has been solved yet
	        for (int i = 0; i <= n; i++) {
	            for (int j = 0; j <= m; j++) {
	                t[i][j] = -1;
	            }
	        }

	        // Call the recursive function with the full lengths of both strings
	        return minimumAscii(s1, s2, n, m, t);
	    }
	


}
