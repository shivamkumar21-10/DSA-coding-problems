package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    // Recursive function to solve the Josephus problem
    // a: list of people represented by their position (1 to n)
    // index: current starting index for counting
    // k: step count for elimination (zero-based)
    public static int solve(List<Integer> a, int index, int k) {
        // Base case: if only one person is left, return their position
        if (a.size() == 1) {
            return a.get(0);
        }

        // Find the index of the next person to be eliminated
        index = (index + k) % a.size();
        
        // Remove the person at the calculated index
        a.remove(index);

        // Recursively solve the problem with the remaining people
        solve(a, index, k);
        
        // Return the last person left after all recursive calls
        return a.get(0);
    }

    public static void main(String[] args) {
        int n = 40; // Total number of people
        int k = 7;  // Every 7th person is eliminated

        // Create a list representing people from 1 to n
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a.add(i);
        }

        // Call the solve function with initial index as 1 and k-1 for 0-based indexing
        // Printing the result, which is the safe position
        System.out.println(solve(a, 1, k - 1));
    }
}
