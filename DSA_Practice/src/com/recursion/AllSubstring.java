package com.recursion;

public class AllSubstring {
	
    // Recursive function to print all subsets of the input string
    public static void solve(String inp, String op) {
        // Base condition: if the input string is empty, print the current output string
        if (inp.length() == 0) {
            System.out.println(op);
            return;
        }
        
        // Create two output strings: one with the current character and one without it
        String op1 = op;  // Do not add the first character of 'inp' to 'op'
        String op2 = op;  // Add the first character of 'inp' to 'op'
        op2 = op2 + inp.charAt(0);  // Add the current character to op2

        // Remove the first character from the input string for the next recursive call
        inp = inp.substring(1);

        // Recursive call to solve for both options: without adding the current character and with adding it
        solve(inp, op1);  // Call without adding the character
        solve(inp, op2);  // Call with adding the character
    }

    public static void main(String[] args) {
        // Driver code to test the recursive function
        String str = "ab";  // Input string for which we need to find all subsets
        String op = "";     // Initial output is an empty string
        solve(str, op);     // Call the recursive function
    }

}
