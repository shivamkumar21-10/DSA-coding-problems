package com.DP.LCS;

public class Leetcode1143_LongestCommonSubsequence_TopDown {
	


	public int longestCommonSubsequence(String x, String y) {
	    int m = x.length(); // Length of the first string
	    int n = y.length(); // Length of the second string

	    // Create a 2D array to store the LCS length for substrings
	    // t[i][j] will store the length of the LCS of the first `i` characters of `x`
	    // and the first `j` characters of `y`
	    int[][] t = new int[m + 1][n + 1];

	    // Fill the DP table using bottom-up approach
	    for (int i = 0; i <= m; i++) { // Iterate over the first string (x)
	        for (int j = 0; j <= n; j++) { // Iterate over the second string (y)

	            // Base case: If either of the strings is empty (i=0 or j=0),
	            // the length of the LCS is 0 because there are no characters to compare
	            if (i == 0 || j == 0) {
	                t[i][j] = 0;
	            }

	            // If the current characters of both strings match (x[i-1] == y[j-1]),
	            // the LCS length increases by 1. We add 1 to the LCS of the substrings
	            // without these characters (t[i-1][j-1]).
	            else if (x.charAt(i - 1) == y.charAt(j - 1)) {
	                t[i][j] = 1 + t[i - 1][j - 1];
	            }

	            // If the current characters of both strings do not match,
	            // we take the maximum of the two possible scenarios:
	            // 1. Exclude the current character of the first string (`t[i-1][j]`)
	            // 2. Exclude the current character of the second string (`t[i][j-1]`)
	            // This ensures that we find the longest LCS by trying all possible cases.
	            else {
	                t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
	            }
	        }
	    }

	    // The length of the LCS of the entire strings `x` and `y`
	    // will be stored in `t[m][n]` (bottom-right corner of the table).
	    return t[m][n];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
