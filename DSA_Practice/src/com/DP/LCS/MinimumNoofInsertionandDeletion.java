package com.DP.LCS;

public class MinimumNoofInsertionandDeletion {

    /**
     * Method to calculate the minimum number of insertions and deletions
     * required to transform string `a` into string `b`.
     *
     * @param a The source string that needs to be transformed.
     * @param b The target string.
     * @return The total number of insertions and deletions required.
     */
    static int minimumNoofInsertionandDeletion(String a, String b) {
        // Calculate the Longest Common Subsequence (LCS) of the two strings
        int lcs = LCS(a, b);

        /**
         * Logic for using LCS:
         * - The Longest Common Subsequence is the largest sequence of characters
         *   that appear in both strings in the same order.
         * - These characters already exist in both strings, so no insertions or
         *   deletions are required for them.
         * - To transform `a` into `b`, we:
         *   1. **Delete the characters in `a` that are not part of the LCS.**
         *      - The number of such characters is `a.length() - lcs`.
         *   2. **Insert the characters in `b` that are not part of the LCS.**
         *      - The number of such characters is `b.length() - lcs`.
         * - Total operations = deletions + insertions.
         */

        // Calculate the number of deletions required
        int deletion = a.length() - lcs;

        // Calculate the number of insertions required
        int insertion = b.length() - lcs;

        // Return the total number of operations
        return deletion + insertion;
    }

    /**
     * Method to calculate the Longest Common Subsequence (LCS) between two strings.
     *
     * @param x The first input string.
     * @param y The second input string.
     * @return The length of the Longest Common Subsequence.
     */
    static int LCS(String x, String y) {
        int m = x.length(); // Length of the first string
        int n = y.length(); // Length of the second string

        // Create a 2D DP table to store the length of LCS for substrings of `x` and `y`
        int[][] t = new int[m + 1][n + 1];

        // Fill the DP table iteratively
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Base case: If either string is empty, the LCS length is 0
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }

                // If the current characters of both strings match
                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                }

                // If characters don't match, take the maximum value from the top or left cell
                else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // The bottom-right cell contains the length of the LCS
        return t[m][n];
    }

    /**
     * Main method to test the calculation of minimum insertions and deletions.
     */
    public static void main(String[] args) {
        // Example input: Transform "heap" into "pea"
        String a = "heap"; // Source string
        String b = "pea";  // Target string

        // Output the minimum number of insertions and deletions
        System.out.println(minimumNoofInsertionandDeletion(a, b));
    }
}
