package com.recursion;

public class NBinaryWithPrefixMore1 {

    // Recursive function to generate all binary strings of length n,
    // ensuring that the count of '1's is always greater than or equal to the count of '0's.
    public static void solve(int n, String op, int ones, int zeroes) {

        // Base case: if n becomes 0, print the generated output string and return.
        if (n == 0) {
            System.out.println(op);
            return;
        }

        // Always add '1' to the output string because it doesn't violate the condition.
        if (ones <= zeroes) {
            String op1 = op + "1";
            solve(n - 1, op1, ones + 1, zeroes);
        } 
        // If the count of ones is greater than zeroes, we can add either '1' or '0'.
        else {
            // Create two output strings - one with '1' and another with '0'.
            String op1 = op + "1";
            String op2 = op + "0";

            // Recursive call after adding '1'. This increases the count of ones.
            solve(n - 1, op1, ones + 1, zeroes);
            // Recursive call after adding '0'. This increases the count of zeroes.
            solve(n - 1, op2, ones, zeroes + 1);
            return;
        }
    }

    public static void main(String[] args) {
        // Starting output string is empty.
        String op = "";
        // Generate all binary strings of length 3 that satisfy the condition.
        solve(3, op, 0, 0);
    }
}
