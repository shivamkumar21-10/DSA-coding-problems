package com.DP.LCS;

public class LongestRepeatingSubsequence {

    /**
     * Function to find the length of the longest repeating subsequence in a string.
     * 
     * A "repeating subsequence" is a subsequence that appears at least twice in the string, 
     * but at different positions. The positions of the characters in the subsequence must 
     * be distinct.
     * 
     * This problem is a variation of the standard Longest Common Subsequence (LCS) problem.
     * The key difference here is:
     * - Instead of comparing two different strings, we compare the string with itself.
     * - To ensure we are identifying a *repeating* subsequence, we add the condition 
     *   `i != j` while matching characters during the LCS computation.
     *
     * @param x The input string.
     * @param y A reversed copy of the input string (optional but used here for demonstration).
     * @return The length of the longest repeating subsequence.
     */
    public static int longestRepeatingSubsequence(String x, String y) {
        int m = x.length(); // Length of the string.
        int n = y.length(); // Length of the string.

        // Create a DP table to store the LCS lengths.
        int[][] t = new int[m + 1][n + 1];

        // Fill the DP table using the modified LCS algorithm.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Base case: If either string is empty, the LCS length is 0.
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }

                // If characters match and indices `i` and `j` are not the same,
                // include this character in the LCS.
                else if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1]; // Move diagonally in the DP table.
                }

                // If characters do not match or are at the same index,
                // take the maximum value from the previous states (either excluding
                // the current character of `x` or `y`).
                else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // The value at `t[m][n]` is the length of the longest repeating subsequence.
        return t[m][n];
    }

    public static void main(String[] args) {
        // Example test case to demonstrate the longest repeating subsequence.
        String a = "AABEBCDD"; // Input string.

        // Find the longest repeating subsequence.
        System.out.println("Length of Longest Repeating Subsequence: " 
                           + longestRepeatingSubsequence(a, a));
    }
}
