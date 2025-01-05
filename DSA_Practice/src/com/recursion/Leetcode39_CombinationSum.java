package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Leetcode39_CombinationSum {

    /**
     * Recursive method to find all unique combinations of numbers that sum up to the target.
     *
     * @param idx  The current index in the list of candidates being processed.
     * @param arr  The list of candidate numbers (converted from the input array).
     * @param target  The remaining target sum to achieve.
     * @param ds  The current combination of numbers being explored (a temporary list).
     * @param ans  The final list to store all valid combinations.
     * @return The list of all valid combinations found so far.
     */
    public static List<List<Integer>> solve(int idx, List<Integer> arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        // Base Case 1: If the target is exactly 0, it means we found a valid combination.
        if (target == 0) {
            // Add the current combination (deep copy of `ds`) to the result list `ans`.
            ans.add(new ArrayList<>(ds));
            return ans; // Return to backtrack and explore other possibilities.
        }

        // Base Case 2: If we run out of candidates (idx >= arr.size()) or the target becomes negative (target < 0),
        // this means no valid combination is possible in the current recursion path.
        if (idx >= arr.size() || target < 0) {
            return ans; // Return without adding anything to `ans`.
        }

        /* 
         * Choice 1: Include the current candidate in the combination.
         * - We check if the current candidate `arr.get(idx)` can be included without exceeding the target.
         */
        if (arr.get(idx) <= target) { // Only include the candidate if it does not exceed the target.
            ds.add(arr.get(idx)); // Add the current candidate to the combination list `ds`.

            // Recursive call to `solve` with:
            // - The same index `idx` to allow the same candidate to be reused.
            // - The target reduced by the value of the included candidate.
            solve(idx, arr, target - arr.get(idx), ds, ans);

            // Backtrack:
            // - Remove the last added element (the current candidate) from `ds` to explore other combinations.
            ds.remove(ds.size() - 1);
        }

        /* 
         * Choice 2: Exclude the current candidate from the combination.
         * - Move to the next index (`idx + 1`) and continue exploring other candidates.
         */
        solve(idx + 1, arr, target, ds, ans);

        // Return the list of valid combinations found so far.
        return ans;
    }

    /**
     * Method to initiate the process of finding combinations.
     * 
     * @param candidates  The array of candidate numbers.
     * @param target  The target sum to achieve.
     * @return The list of all unique combinations that sum up to the target.
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ip = new ArrayList<>(); // To store the candidates as a list.
        List<Integer> ds = new ArrayList<>(); // To store the current combination (temporary list during recursion).
        List<List<Integer>> ans = new ArrayList<>(); // To store all valid combinations.

        // Convert the input array `candidates` into a List `ip` for easier manipulation.
        for (int i = 0; i < candidates.length; i++) {
            ip.add(candidates[i]);
        }

        // Start the recursive process from index 0 with the given target.
        return solve(0, ip, target, ds, ans);
    }

    public static void main(String[] args) {
        // Input array of candidate numbers.
        int[] inp = new int[] { 2, 3, 6, 7 };
        int target = 7; // Target sum to be achieved.

        // Call the method and print all unique combinations.
        System.out.println(combinationSum(inp, target));
    }
}
