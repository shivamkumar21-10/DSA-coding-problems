package com.DP.MCM;

public class PalindromePartitioning_Memoization {

    /**
     * Utility function to check if a given substring is a palindrome.
     * This function ensures that all substrings we partition are valid palindromes.
     *
     * @param s The input string.
     * @return True if the string is a palindrome, otherwise false.
     */
    public static boolean isPalindrome(String s) {
        // Convert the string to lowercase to make the check case-insensitive.
        s = s.toLowerCase();

        // Two-pointer approach: compare characters from both ends of the string.
        int start = 0, end = s.length() - 1;

        // Check each character pair until the middle is reached.
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false; // If any character pair mismatches, it's not a palindrome.
            }
            start++; // Move start pointer forward.
            end--;   // Move end pointer backward.
        }

        return true; // If all characters match, it's a palindrome.
    }

    /**
     * Recursive function with memoization to calculate the minimum number of cuts 
     * needed to partition a string such that every substring in the partition is a palindrome.
     *
     * @param s The input string.
     * @param i The starting index of the substring.
     * @param j The ending index of the substring.
     * @param t The memoization table to store results of overlapping subproblems.
     * @return The minimum number of cuts required to achieve the partition.
     */
    public static int solve(String s, int i, int j, int[][] t) {
        // **Base Case 1**: If the starting index `i` is greater than or equal to the ending index `j`,
        // we are looking at either a single character or an empty substring.
        // Both cases are palindromes by default, so no cuts are needed.
        if (i >= j) {
            return 0;
        }

        // **Base Case 2**: If the substring from index `i` to `j` is already a palindrome,
        // no cuts are needed, as the entire substring is valid.
        if (isPalindrome(s.substring(i, j + 1))) { // `j + 1` since `substring` excludes the end index.
            return 0;
        }

        // **Memoization Check**:
        // If the result for this subproblem `(i, j)` is already computed, return the stored result.
        if (t[i][j] != -1) {
            return t[i][j];
        }

        // Initialize the minimum cuts to a very large value (similar to infinity).
        int ans = Integer.MAX_VALUE;

        /**
         * **Partition Logic with Memoization**:
         * - Try every possible position `k` to make a cut in the substring from `i` to `j`.
         * - For each cut at position `k`, divide the substring into:
         *    1. Left part: From index `i` to `k`.
         *    2. Right part: From index `k + 1` to `j`.
         * - Use memoization to avoid recalculating results for overlapping subproblems.
         */
        for (int k = i; k < j; k++) { // `k` is the position where we make the cut.

            // **Left Subproblem**: Minimum cuts required for the substring `i` to `k`.
            int leftCost = 0;
            if (t[i][k] != -1) {
                // If already computed, use the cached value.
                leftCost = t[i][k];
            } else {
                // Otherwise, compute it recursively and store the result in the memoization table.
                leftCost = solve(s, i, k, t);
                t[i][k] = leftCost; // Store the result in the table.
            }

            // **Right Subproblem**: Minimum cuts required for the substring `k + 1` to `j`.
            int rightCost = 0;
            if (t[k + 1][j] != -1) {
                // If already computed, use the cached value.
                rightCost = t[k + 1][j];
            } else {
                // Otherwise, compute it recursively and store the result in the memoization table.
                rightCost = solve(s, k + 1, j, t);
                t[k + 1][j] = rightCost; // Store the result in the table.
            }

            // **Total Cost**: Combine the results of left and right subproblems with 1 additional cut.
            int temp = leftCost + rightCost + 1;

            // Update the minimum cuts if the current partition gives a smaller value.
            ans = Math.min(ans, temp);
        }

        // Store the result for the current subproblem `(i, j)` in the memoization table.
        return t[i][j] = ans;
    }

    public static void main(String[] args) {
        // Initialize the memoization table.
        int[][] t = new int[1000][1000];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1; // Fill the table with -1, indicating uncomputed subproblems.
            }
        }

        // Input string for palindrome partitioning.
        String s = "nitin";

        /**
         * **Recursive Call**:
         * - Start with the entire string.
         * - i = 0 (starting index).
         * - j = s.length() - 1 (ending index).
         * - Output the minimum number of cuts needed to partition the string such
         *   that all substrings are palindromes.
         */
        System.out.println("Minimum cuts needed: " + solve(s, 0, s.length() - 1, t));
    }
}
