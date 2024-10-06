package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1498_subsequenceWithSumK {

    // Recursive function to solve the problem of counting valid subsequences
    public static int solve(List<Integer> nums, int k, List<Integer> op, int t) {

        // Base case: if there are no numbers left to consider
        if (nums.size() == 0) {
            int sum = 0;

            // Calculate the sum of the first and last elements of the current subset
            if (op.size() > 1) {
                sum = op.get(0) + op.get(op.size() - 1);
            } else if (op.size() == 1) {
                sum = op.get(0) * 2; // If there is only one element, double it for the sum
            }

            // If the sum is less than or equal to k, return 1 (indicating a valid subsequence)
            if (sum <= k) {
                return 1;
            } else {
                return 0; // Not a valid subsequence
            }
        }

        // Create two branches: one without including the current number, and one including it
        List<Integer> op1 = new ArrayList<>(op); // Copy of current subset without including the next number
        List<Integer> op2 = new ArrayList<>(op); // Copy of current subset to include the next number
        op2.add(nums.get(0)); // Add the first element to the new subset

        // Remove the first element from the remaining numbers list
        List<Integer> rem = new ArrayList<>(nums);
        rem.remove(0);

        // Recursive calls to count subsequences for both branches
        int t1 = solve(rem, k, op1, t); // Not including the current element
        int t2 = solve(rem, k, op2, t); // Including the current element

        // Return the total count of valid subsequences from both branches
        return t1 + t2;
    }

    // Function to find the number of subsequences that satisfy the condition
    public static int numSubseq(int[] nums, int k) {
        // Convert the input array to a list for easier manipulation in recursion
        List<Integer> inp = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to simplify the calculation of the subsequence
        for (int i = 0; i < nums.length; i++) {
            inp.add(nums[i]);
        }

        // Start with an empty subset and a count of zero
        List<Integer> op = new ArrayList<>();
        int t = 0;

        // Call the recursive function to get the count of valid subsequences
        int x = solve(inp, k, op, t);

        // Subtract 1 because the empty subset was counted (but it doesn't qualify as a valid subsequence)
        return x - 1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 6, 7 }; // Input array
        int k = 9; // Target sum

        // Get the result and print it
        int result = numSubseq(nums, k);
        System.out.println("Number of valid subsequences: " + result);
    }
}
