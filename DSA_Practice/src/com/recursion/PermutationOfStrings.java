package com.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Class to generate all unique permutations of a given string
public class PermutationOfStrings {

    /**
     * Recursive method to generate all unique permutations of the input string.
     * 
     * @param inp The remaining input string from which characters are picked
     * @param op  The current permutation being built
     * @param res The list of resulting unique permutations
     * @return The updated list of permutations
     */
    public static List<String> permutations(String inp, String op, List<String> res) {

        // Base case: If the input string is empty, we have a complete permutation
        if (inp.isEmpty()) {
            /*
             * When the input string is empty, it means that all characters
             * have been used in the current permutation `op`. Add this complete
             * permutation to the result list `res`.
             */
            res.add(op);
            return res; // Return the result list as this branch of recursion is done
        }

        // Use a HashMap to track characters already processed in this recursive call
        HashMap<Character, String> map = new HashMap<>();

        // Loop through each character in the current input string
        for (int i = 0; i < inp.length(); i++) {

            // Check if the current character is already used in this level of recursion
            if (!map.containsKey(inp.charAt(i))) {
                /*
                 * If the character is not in the map, this ensures that we do not
                 * generate duplicate permutations at this level of recursion. 
                 * For example, for input "aac", we only process the first 'a' at
                 * this level and skip the second 'a'.
                 */
                map.put(inp.charAt(i), "PRESENT"); // Mark the character as processed

                // Create a new input string by removing the current character
                /*
                 * `newInp` represents the string after removing the character
                 * at index `i` from the original `inp`. This ensures that the
                 * same character is not reused in this permutation branch.
                 */
                String newInp = inp.substring(0, i) + inp.substring(i + 1);

                // Add the current character to the output string `op`
                /*
                 * `newOp` represents the permutation being built so far.
                 * The character at index `i` of `inp` is appended to the
                 * existing `op`, progressively building the current permutation.
                 */
                String newOp = op + inp.charAt(i);

                // Recursive call to generate permutations for the reduced input
                /*
                 * The recursion continues with `newInp` as the reduced input and
                 * `newOp` as the updated partial permutation. This allows the
                 * algorithm to explore all possible arrangements of the remaining
                 * characters.
                 */
                permutations(newInp, newOp, res);
            }
        }

        // Return the result list containing all unique permutations
        return res;
    }

    public static void main(String[] args) {
        // Initialize the result list to store permutations
        List<String> res = new ArrayList<>();

        // Call the recursive permutations method and print the result
        /*
         * The method is initially called with the full input string "aac",
         * an empty string `""` as the starting permutation, and an empty list `res`
         * to collect the results. The resulting list of unique permutations
         * will be printed to the console.
         */
        System.out.println(permutations("aac", "", res));
    }
}
