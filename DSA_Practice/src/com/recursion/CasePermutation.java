package com.recursion;

public class CasePermutation {

    // Recursive function to generate all permutations of the string with different cases
    public static void solve(String inp, String op) {
        // Base case: if the input string is empty, print the current output string
        if (inp.length() == 0) {
            System.out.println(op); // Print the current output when the input is fully processed
            return; // End the current recursive call
        }

        // Create two options for the current character:
        // Option 1: Keep the character in lowercase (as it is)
        // Option 2: Change the character to uppercase
        String op1 = op; // Copy the current output to op1
        String op2 = op; // Copy the current output to op2

        // Append the character to op1 as is (lowercase)
        op1 = op1 + inp.charAt(0);

        // Append the uppercase version of the character to op2
        op2 = op2 + Character.toUpperCase(inp.charAt(0));

        // Remove the first character from the input for the next recursive call
        inp = inp.substring(1);

        // Recursive call with the updated input and first option (lowercase character)
        solve(inp, op1);

        // Recursive call with the updated input and second option (uppercase character)
        solve(inp, op2);
    }

    public static void main(String[] args) {
        // Driver code to test the solve function
        String str = "ab"; // Define the input string

        String op = ""; // Initialize the output string as empty

        // Start recursion with the input string and empty output string
        solve(str, op);
    }
}
