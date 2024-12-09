package com.recursion;

public class CasePermutation {

    /**
     * Recursive function to generate all permutations of a string with different cases.
     * Each character in the input string can either be included in lowercase or uppercase
     * in the permutations.
     *
     * @param inp The remaining part of the input string to process.
     * @param op  The current permutation being constructed.
     */
    public static void solve(String inp, String op) {
        // Base case: If the input string is fully processed (empty),
        // print the current output string and return.
        if (inp.length() == 0) {
            System.out.println(op); // Output the current permutation.
            return; // End this recursive branch.
        }

        /**
         * Two options for each character in the input string:
         * 1. Include the character in lowercase in the output string.
         * 2. Include the character in uppercase in the output string.
         */

        // Option 1: Keep the character as it is (lowercase by default).
        String op1 = op + inp.charAt(0);

        // Option 2: Change the character to uppercase.
        String op2 = op + Character.toUpperCase(inp.charAt(0));

        // Remove the first character from the input string for the next recursive call.
        String remainingInp = inp.substring(1);

        // Recursive call for option 1: Append lowercase character.
        solve(remainingInp, op1);

        // Recursive call for option 2: Append uppercase character.
        solve(remainingInp, op2);
    }

    public static void main(String[] args) {
        // Driver code to test the solve function.

        // Define the input string.
        String str = "ab";

        // Initialize the output string as empty.
        String op = "";

        /**
         * Start recursion with:
         * - The input string (`str`) to process.
         * - The empty output string (`op`) to construct the permutations.
         */
        solve(str, op);
    }
}
