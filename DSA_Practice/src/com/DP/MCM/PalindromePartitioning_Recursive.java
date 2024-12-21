package com.DP.MCM;

public class PalindromePartitioning_Recursive {

    /**
     * Utility function to check if a given substring is a palindrome.
     * 
     * @param s The input string.
     * @return True if the string is a palindrome, otherwise false.
     */
    public static boolean isPalindrome(String s) {
        // Convert the string to lowercase to make the check case-insensitive.
        // For example, "Abba" will be treated the same as "abba".
        s = s.toLowerCase();

        // Use the two-pointer technique to efficiently check if the string is a palindrome.
        // Start one pointer from the beginning and another from the end of the string.
        int start = 0, end = s.length() - 1;

        // Continue comparing characters until the pointers meet in the middle.
        while (start < end) {
            // If characters at the start and end are not the same, the string is not a palindrome.
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            // Move the start pointer forward and the end pointer backward.
            start++;
            end--;
        }

        // If all characters match, the string is a palindrome.
        return true;
    }

    /**
     * Recursive function to calculate the minimum number of cuts needed to partition
     * a string such that every substring in the partition is a palindrome.
     * 
     * @param s The input string.
     * @param i The starting index of the substring.
     * @param j The ending index of the substring.
     * @return The minimum number of cuts required to achieve the partition.
     */
    public static int solve(String s, int i, int j) {
        // **Base Case 1**: If the starting index is greater than or equal to the ending index,
        // it means we are looking at either a single character or an empty substring.
        // Both are palindromes by definition, so no cuts are needed.
        if (i >= j) {
            return 0;
        }

        // **Base Case 2**: If the substring from index i to j is already a palindrome,
        // no cuts are needed as the whole substring is valid.
        // Example: For "nitin", solve(s, 0, 4) will directly return 0 since "nitin" is a palindrome.
        if (isPalindrome(s.substring(i, j + 1))) { // j + 1 because substring excludes the end index.
            return 0;
        }

        // Initialize the minimum cuts to the largest possible value (infinity-like).
        // This ensures we can compare and find the minimum cuts later.
        int ans = Integer.MAX_VALUE;

        /**
         * **Partition Logic**:
         * - We try every possible position `k` to make a cut in the substring from `i` to `j`.
         * - For each cut at position `k`, we divide the substring into:
         *    1. Left part: From index `i` to `k`.
         *    2. Right part: From index `k + 1` to `j`.
         * - The number of cuts required is the sum of:
         *    a. Minimum cuts for the left part.
         *    b. Minimum cuts for the right part.
         *    c. Plus 1 for the current cut.
         */
        for (int k = i; k < j; k++) { // `k` is the position where we make the cut.
            // Recursively calculate the minimum cuts for the left substring (from `i` to `k`).
            int leftCost = solve(s, i, k);

            // Recursively calculate the minimum cuts for the right substring (from `k+1` to `j`).
            int rightCost = solve(s, k + 1, j);

            // Add 1 for the current cut and calculate the total cost for this split.
            int temp = leftCost + rightCost + 1;

            // Update the minimum cuts if the current split gives a smaller value.
            ans = Math.min(ans, temp);
        }

        // Return the minimum cuts needed for the substring from `i` to `j`.
        return ans;
    }

    public static void main(String[] args) {
        // **Input String**: Example string for palindrome partitioning.
        String s = "nitin";

        /**
         * **Recursive Call**:
         * - Start with the entire string.
         * - i = 0 (starting index).
         * - j = s.length() - 1 (ending index).
         * - Output the minimum number of cuts needed to partition the string such
         *   that all substrings are palindromes.
         */
        System.out.println("Minimum cuts needed: " + solve(s, 0, s.length() - 1));
    }
}
