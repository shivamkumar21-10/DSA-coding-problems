package com.DP.LCS;

public class Leetcode72_EditDistance {

	    public int minOp(String s1, String s2, int n, int m, int[][] t) {
	        // Base cases: When one string is empty
	        if (n == 0) return m; // If s1 is empty, all characters of s2 need to be inserted
	        if (m == 0) return n; // If s2 is empty, all characters of s1 need to be deleted

	        // If the result for this subproblem is already computed, return it
	        if (t[n][m] != -1) {
	            return t[n][m];
	        }

	        // If the last characters are the same, no operation is needed; move both pointers back
	        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
	            t[n][m] = minOp(s1, s2, n - 1, m - 1, t);
	        } else {
	            // Otherwise, consider the minimum of the three operations:
	            // 1. Insert: Move the pointer of s2 back (n, m-1)
	            // 2. Delete: Move the pointer of s1 back (n-1, m)
	            // 3. Replace: Move both pointers back (n-1, m-1)
	            t[n][m] = 1 + Math.min(
	                Math.min(minOp(s1, s2, n, m - 1, t),   // Insert
	                         minOp(s1, s2, n - 1, m, t)), // Delete
	                minOp(s1, s2, n - 1, m - 1, t)         // Replace
	            );
	        }

	        return t[n][m];
	    }

	    public int minDistance(String word1, String word2) {
	        int n = word1.length();
	        int m = word2.length();
	        int[][] t = new int[n + 1][m + 1];

	        // Initialize the memoization table with -1
	        for (int i = 0; i <= n; i++) {
	            for (int j = 0; j <= m; j++) {
	                t[i][j] = -1;
	            }
	        }

	        // Start the recursive function with memoization
	        return minOp(word1, word2, n, m, t);
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
