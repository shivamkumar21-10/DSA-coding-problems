package com.DP.LCS;

public class LongestCommonSubstring {
	
	public static int longestCommonSubstring(String x, String y) {
	    // Get the lengths of the two input strings
	    int m = x.length(); // Length of the first string
	    int n = y.length(); // Length of the second string

	    // Create a 2D DP table `t` where t[i][j] represents the length of the
	    // common substring ending at position i in string x and position j in string y.
	    int[][] t = new int[m + 1][n + 1];

	    // Variable to keep track of the maximum length of the common substring found so far.
	    int maxLength = 0;

	    // Fill the DP table by iterating through both strings
	    for (int i = 0; i <= m; i++) { // Loop over the characters of string x
	        for (int j = 0; j <= n; j++) { // Loop over the characters of string y

	            // Base Case: If either string is empty, the length of the common substring is 0
	            if (i == 0 || j == 0) {
	                t[i][j] = 0; // No substring exists if one of the strings has no characters
	            }

	            // If the characters at position (i-1) in string x and (j-1) in string y match
	            else if (x.charAt(i - 1) == y.charAt(j - 1)) {
	                // Extend the common substring length by 1 from the previous diagonal value (t[i-1][j-1])
	                t[i][j] = 1 + t[i - 1][j - 1];

	                // Update the maximum length of the common substring encountered so far
	                maxLength = Math.max(maxLength, t[i][j]);
	            }

	            // If the characters do not match, the common substring length ends here
	            else {
	                t[i][j] = 0; // Reset to 0 since we are looking for continuous substrings
	            }
	        }
	    }

	    // Return the maximum length of any common substring found
	    return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonSubstring("abcde","abfce"));
	}

}
