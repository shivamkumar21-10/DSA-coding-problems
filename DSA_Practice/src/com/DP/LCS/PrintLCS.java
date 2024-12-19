package com.DP.LCS;

public class PrintLCS {

    /**
     * Method to print the Longest Common Subsequence (LCS) of two strings.
     * @param x The first input string.
     * @param y The second input string.
     * @return The Longest Common Subsequence as a string.
     */
    public static String printLcs(String x, String y) {
        int m = x.length(); // Length of the first string
        int n = y.length(); // Length of the second string

        // Create a 2D DP table to store the length of LCS for each substring combination
        int[][] t = new int[m + 1][n + 1];

        // Fill the DP table using the iterative approach
        for (int i = 0; i <= m; i++) { // Loop over the length of the first string
            for (int j = 0; j <= n; j++) { // Loop over the length of the second string

                // Base case: If either string is empty, LCS length is 0
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }

                // If the characters match, increment the value from the previous diagonal cell
                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                }

                // If characters do not match, take the maximum value from the top or left cell
                else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // At this point, the DP table `t` is filled, and `t[m][n]` contains the length of the LCS.

        // Start backtracking to find the actual LCS string
        int i = m; // Start from the last character of the first string
        int j = n; // Start from the last character of the second string
        String s = ""; // String to store the LCS characters

        // Backtracking process to construct the LCS string
        while (i > 0 && j > 0) { 
            // If characters match, include this character in the LCS and move diagonally
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                s = s + x.charAt(i - 1); // Append character to LCS
                i--; // Move up one row
                j--; // Move left one column
            }

            // If characters do not match, move in the direction of the greater value
            else {
                if (t[i][j - 1] > t[i - 1][j]) {
                    j--; // Move left if the left cell has the larger value
                } else {
                    i--; // Move up if the top cell has the larger value
                }
            }
        }

        // Since we build the LCS string in reverse order, reverse it before returning
        StringBuffer sb = new StringBuffer(s);
        sb.reverse(); // Reverse the string to get the correct LCS order
        return sb.toString();
    }

    /**
     * Main method to test the PrintLCS function.
     */
    public static void main(String[] args) {
        // Example input strings
        String x = "acbcf";
        String y = "abcdaf";

        // Print the Longest Common Subsequence of the two strings
        System.out.println(printLcs(x, y)); // Output: "abcf"
    }
}
