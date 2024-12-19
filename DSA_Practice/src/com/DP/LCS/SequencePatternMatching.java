package com.DP.LCS;

public class SequencePatternMatching {

    /**
     * Function to check if string `x` is a subsequence of string `y`.
     * 
     * Sequence Pattern Matching checks whether all the characters of one string `x`
     * appear in the same order (not necessarily contiguous) in another string `y`.
     * 
     * The approach uses the concept of Longest Common Subsequence (LCS) to determine 
     * whether `x` is a subsequence of `y`.
     *
     * The logic:
     * - If the length of the LCS of `x` and `y` is equal to the length of `x`,
     *   it implies that all characters of `x` appear in `y` in the same order.
     * - Therefore, we return `true` if `t[m][n] == x.length()`, otherwise `false`.
     *
     * @param x The potential subsequence string.
     * @param y The main string in which to check for subsequence.
     * @return `true` if `x` is a subsequence of `y`, `false` otherwise.
     */
    public static boolean sequencePatternMatching(String x, String y) {
        int m = x.length(); // Length of string `x`.
        int n = y.length(); // Length of string `y`.

        // Create a DP table to compute the LCS of `x` and `y`.
        int[][] t = new int[m + 1][n + 1];

        // Fill the DP table using the LCS logic.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Base case: If either string is empty, the LCS length is 0.
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }

                // If characters match, include this character in the LCS.
                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                }

                // If characters do not match, take the maximum LCS length
                // by excluding either the current character of `x` or `y`.
                else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Check if the LCS length is equal to the length of string `x`.
        // If true, `x` is a subsequence of `y`.
        if (t[m][n] == x.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example test case to check if `x` is a subsequence of `y`.
        System.out.println(sequencePatternMatching("AXYZ", "ADXCPY")); // Output: true
    }
}
