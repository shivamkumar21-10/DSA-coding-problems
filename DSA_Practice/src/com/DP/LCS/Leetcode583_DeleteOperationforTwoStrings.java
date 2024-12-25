package com.DP.LCS;

public class Leetcode583_DeleteOperationforTwoStrings {
	

	    // Recursive function to calculate the minimum number of operations to convert `s1` to `s2`.
	    public int minOp(String s1, String s2, int n, int m, int[][] t) {

	        // Base case 1: If `s1` is empty, we need to insert all characters of `s2`. The cost is `m`.
	        if (n == 0)
	            return m;

	        // Base case 2: If `s2` is empty, we need to delete all characters of `s1`. The cost is `n`.
	        if (m == 0)
	            return n;

	        // If the result for this subproblem is already calculated, return it from the memoization table.
	        if (t[n][m] != -1)
	            return t[n][m];

	        // If the current characters of both strings match, no operation is needed.
	        // Move to the next characters by reducing both `n` and `m`.
	        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
	            return t[n][m] = minOp(s1, s2, n - 1, m - 1, t);
	        }

	        // If the current characters are different, we have three choices:
	        // 1. Insert: Add the current character of `s2` to `s1` and move to the next character in `s2` (`m-1` remains the same).
	        // 2. Delete: Remove the current character of `s1` and move to the next character in `s1` (`n-1`).
	        // 3. Replace: Replace the current character of `s1` with `s2` and move both pointers (`n-1` and `m-1`).
	        // The cost of the current operation is `1`, and we take the minimum of the three options.
	        return t[n][m] = 1 + Math.min(
	            minOp(s1, s2, n - 1, m, t),   // Delete operation
	            minOp(s1, s2, n, m - 1, t)    // Insert operation
	        );
	    }

	    // Main function to calculate the minimum number of operations to convert `word1` to `word2`.
	    public int minDistance(String word1, String word2) {

	        // `n` and `m` represent the lengths of `word1` and `word2`, respectively.
	        int n = word1.length();
	        int m = word2.length();

	        // Create a memoization table to store the results of subproblems.
	        // The table size is `(n+1) x (m+1)` to handle cases where one or both strings are empty.
	        int[][] t = new int[n + 1][m + 1];

	        // Initialize the table with `-1` to indicate that no subproblem has been solved yet.
	        for (int i = 0; i <= n; i++) {
	            for (int j = 0; j <= m; j++) {
	                t[i][j] = -1;
	            }
	        }

	        // Start the recursive function with the full lengths of `word1` and `word2`.
	        return minOp(word1, word2, n, m, t);
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
