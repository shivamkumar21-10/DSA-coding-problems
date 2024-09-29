package com.recursion;

import java.util.*;

public class Leetcode78_Subsets {
    
    // Helper method to recursively find all subsets
    public static List<List<Integer>> solve(List<Integer> nums, List<Integer> op, List<List<Integer>> result) {
        // Base case: if there are no more elements to process, add the current subset to the result
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(op));  // Adding a copy of 'op' to avoid reference issues
            return result;
        }

        // Creating two branches: one without including the current element, one with including it
        List<Integer> op1 = new ArrayList<>(op);  // op1 is without including the current element
        List<Integer> op2 = new ArrayList<>(op);  // op2 is with including the current element
        op2.add(nums.get(0));  // Adding the current element to op2 to represent inclusion

        // Creating a new list to pass the remaining elements, instead of modifying 'nums' directly
        List<Integer> remainingNums = new ArrayList<>(nums);
        remainingNums.remove(0);  // Removing the current element to process the next elements

        // Recursive calls: one without including the current element, and one with including it
        solve(remainingNums, op1, result);  
        solve(remainingNums, op2, result);

        return result;
    }

    // Method to find all subsets of a given array
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();  // List to store the result containing all subsets
        List<Integer> num = new ArrayList<>();
        
        // Converting the input array into a list to facilitate recursive processing
        for (int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
        }

        List<Integer> op = new ArrayList<>();  // Initial output subset is empty
        return solve(num, op, res);  // Starting recursion to generate subsets
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};  // Input array
        System.out.println(subsets(nums));  // Finding and printing all subsets of the array
    }
}
