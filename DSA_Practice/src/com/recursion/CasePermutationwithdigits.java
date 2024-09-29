package com.recursion;

public class CasePermutationwithdigits {

    // Function to generate all case permutations for the given input string,
    // while keeping any digits unchanged
    private static void solve(String inp, String op) {

        // Base condition: If the input string is empty, print the output
        if (inp.length() == 0) {
            System.out.println(op);
            return;
        }

        // If the current character is a digit, it remains unchanged in the output
        if (Character.isDigit(inp.charAt(0))) {
            // Copy current output to a new string and add the digit
            String op1 = op;
            op1 = op1 + inp.charAt(0);

            // Remove the processed character from the input
            inp = inp.substring(1);

            // Recur with the updated input and output
            solve(inp, op1);
            return;
        } else {
            // If the current character is not a digit, generate two permutations
            String op1 = op; // Permutation with the current character in lowercase
            String op2 = op; // Permutation with the current character in uppercase

            // Add the lowercase version of the character to op1
            op1 = op1 + Character.toLowerCase(inp.charAt(0));

            // Add the uppercase version of the character to op2
            op2 = op2 + Character.toUpperCase(inp.charAt(0));

            // Remove the processed character from the input
            inp = inp.substring(1);

            // Recur for both permutations
            solve(inp, op1); // Recursive call for the lowercase version
            solve(inp, op2); // Recursive call for the uppercase version
        }
    }

    public static void main(String[] args) {
        // Initialize the input string which contains both letters and digits
        String str = "a2b1";

        // Output string starts empty
        String op = "";

        // Call the recursive function to generate all permutations
        solve(str, op);
    }
}
