package com.DP.LCS;

public class ShortestCommonSupersequence {

    /**
     * Method to calculate the length of the Shortest Common Supersequence (SCS).
     * 
     * @param a The first input string.
     * @param b The second input string.
     * @return The length of the Shortest Common Supersequence.
     */
    static int shortestCommonSupersequence(String a, String b) {
        // The length of the Shortest Common Supersequence is calculated as:
        // Total length of both strings combined minus the length of their Longest Common Subsequence (LCS).
        // Explanation:
        // - The Shortest Common Supersequence is the smallest string that contains both strings as subsequences.
        // - If you add the lengths of both strings (a.length() + b.length()), it counts all characters in both strings.
        // - However, the characters in the LCS are common to both strings and would be counted twice in the sum.
        // - To avoid this double-counting, we subtract the length of the LCS.
        // - This gives us the exact number of characters needed to construct the SCS.
        return a.length() + b.length() - LCS(a, b);
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

        // Create a 2D DP table to store the length of LCS for substrings of x and y
        int[][] t = new int[m + 1][n + 1];

        // Fill the DP table iteratively
        for (int i = 0; i <= m; i++) { // Loop through all characters of string x
            for (int j = 0; j <= n; j++) { // Loop through all characters of string y

                // Base case: If either string is empty, LCS length is 0
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }

                // If characters match, add 1 to the LCS length of the previous diagonal cell
                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                }

                // If characters don't match, take the maximum value from the top or left cell
                else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Return the length of the LCS, which is stored in the bottom-right cell of the DP table
        return t[m][n];
    }

    /**
     * Main method to test the Shortest Common Supersequence calculation.
     */
    public static void main(String[] args) {
        // Input strings
        String s1 = "AGGTAB"; // First string
        String s2 = "GXTXAYB"; // Second string

        // Print the length of the Shortest Common Supersequence
        System.out.println(shortestCommonSupersequence(s1, s2)); // Output: 9
    }
}
