package com.DP.Knapsack._01;

public class Leetcode416_PartitionEqualSubsetSum {

    /**
     * Function to determine if an array can be partitioned into two subsets with equal sums.
     * This is a variation of the Subset Sum problem using dynamic programming.
     *
     * @param nums Array of positive integers.
     * @return     True if the array can be partitioned into two subsets with equal sums,
     *             otherwise false.
     */
    public static boolean canPartition(int[] nums) {
        // Calculate the total sum of the array elements.
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // If the total sum is odd, it's impossible to partition into two equal subsets.
        if (sum % 2 != 0) {
            return false;
        }

        // Target sum for one subset (half of the total sum).
        int s = sum / 2;

        // Number of elements in the array.
        int n = nums.length;

        // DP table where t[i][j] represents whether a subset with sum 'j' can be formed
        // using the first 'i' elements of the array.
        boolean[][] t = new boolean[n + 1][s + 1];

        /**
         * Initialization of the DP table:
         * - If the target sum 'j' is 0 (j == 0), the result is true because an empty subset
         *   always has a sum of 0.
         * - If there are no elements to consider (i == 0) and the target sum is non-zero,
         *   the result is false because no subset can be formed.
         */
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = true; // Base case: An empty subset with sum 0 exists.
                } else if (j == 0) {
                    t[i][j] = true; // A subset with sum 0 always exists (empty subset).
                } else if (i == 0) {
                    t[i][j] = false; // No subset can be formed if there are no elements.
                }
            }
        }

        /**
         * Fill the DP table using a bottom-up approach:
         * - Iterate through all elements of the array and possible target sums.
         * - For each element and sum:
         *   1. If the current element is greater than the target sum (nums[i-1] > j),
         *      exclude the element, and the result is the same as without this element
         *      (t[i-1][j]).
         *   2. Otherwise, check if the target sum can be achieved by either:
         *      - Including the current element: Check t[i-1][j-nums[i-1]].
         *      - Excluding the current element: Check t[i-1][j].
         *   - The result is true if either case is true.
         */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (nums[i - 1] > j) {
                    // Current element is greater than the target sum, so exclude it.
                    t[i][j] = t[i - 1][j];
                } else {
                    // Check for both cases: include or exclude the current element.
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                }
            }
        }

        // The result for the full array and the target sum is stored in t[n][s].
        return t[n][s];
    }

    public static void main(String[] args) {
        // Define the array of integers.
        int[] arr = new int[] {1, 5, 5, 11};

        /**
         * Call the canPartition function and print the result:
         * - This will output true if the array can be partitioned into two subsets 
         *   with equal sums, otherwise false.
         */
        System.out.println("Can partition into equal subsets: " + canPartition(arr));
    }
}
