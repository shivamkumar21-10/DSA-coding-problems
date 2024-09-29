package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22_generate_parenthesis {

    // Helper method to generate all combinations of balanced parentheses
    public static List<String> solve(int o, int c, String op, List<String> res) {

        // Base case: if there are no more open or close parentheses to add, add the result to the list
        if (o == 0 && c == 0) {
            res.add(op);  // Add the complete combination of parentheses to the result list
            return res;
        }

        // Add an open parenthesis if there are open parentheses left
        if (o != 0) {
            String op1 = op + "(";  // Append an open parenthesis
            solve(o - 1, c, op1, res);  // Recursive call with one fewer open parenthesis
        }

        // Add a close parenthesis if the count of close parentheses is greater than open parentheses
        if (c > o) {
            String op2 = op + ")";  // Append a close parenthesis
            solve(o, c - 1, op2, res);  // Recursive call with one fewer close parenthesis
        }

        return res;
    }

    // Method to generate all valid combinations of n pairs of parentheses
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();  // Result list to store all valid combinations

        int o = n;  // Number of open parentheses to add
        int c = n;  // Number of close parentheses to add
        String op = "";  // Output string to store the current combination

        return solve(o, c, op, res);  // Start the recursion
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);  // Generate all valid combinations of 3 pairs of parentheses
        System.out.println(res);  // Print the result list
    }
}
