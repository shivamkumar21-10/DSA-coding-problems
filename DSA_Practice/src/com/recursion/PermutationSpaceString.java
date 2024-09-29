package com.recursion;

public class PermutationSpaceString {
    
    // Recursive function to print all permutations of a string with spaces between characters
    public static void solve(String inp, String op) {
        // Base condition: if the input string is empty, print the current output string
        if (inp.length() == 0) {
            System.out.println(op);
            return;
        }

        // Create two output strings:
        // 1. One with adding a space before the current character
        // 2. One without adding a space
        String op1 = op; // Adding a space before the character
        String op2 = op; // Adding without a space
        op1 = op1 + " " + inp.charAt(0); // Append space followed by the current character
        op2 = op2 + inp.charAt(0); // Append only the current character

        // Remove the first character from the input string for the next recursive call
        inp = inp.substring(1);

        // Recursive call to solve for both options: adding space and without adding space
        solve(inp, op1);  // Call for adding the space
        solve(inp, op2);  // Call for not adding the space
    }

    public static void main(String[] args) {
        // Driver code to test the recursive function
        String str = "abc"; // Input string for which we need to find all permutations with spaces

        // Initial output string contains only the first character of the input
        String op = "";
        solve(str.substring(1), op + str.charAt(0)); // Pass the first character and remaining string to the function
    }
}
