package com.DP;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDefference {

    /**
     * Function to calculate the minimum difference between the sums of two subsets.
     *
     * @param nums Array of integers representing the input set.
     * @return Minimum difference between the sums of two subsets.
     */
    public static int minimumDifference(int[] nums) {
        int n = nums.length; // Length of the input array.
        int s = 0; // Variable to store the total sum of the array.

        // List to store all possible subset sums up to half of the total sum.
        List<Integer> s1 = new ArrayList<>();

        // Step 1: Calculate the total sum of the array.
        for (int i = 0; i < n; i++) {
            s += nums[i]; // Accumulate the sum of all elements in the array.
        }

        // Step 2: Initialize the DP table.
        // `t[i][j]` indicates whether a subset with sum `j` can be formed using the first `i` items.
        boolean[][] t = new boolean[n + 1][s + 1];

        // Base conditions for the DP table:
        // - If there are no items (i == 0) and the target sum (j) is also 0, it's true (empty subset).
        // - If the target sum (j) is 0, it's true because we can achieve sum 0 by taking an empty subset.
        // - If there are no items (i == 0) and the target sum (j) > 0, it's false (not possible).
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = true; // Base case: no items, sum 0 -> true.
                } else if (j == 0) {
                    t[i][j] = true; // Base case: sum 0 is always possible.
                } else if (i == 0) {
                    t[i][j] = false; // Base case: no items and non-zero sum -> false.
                }
            }
        }

        // Step 3: Fill the DP table using the subset sum logic.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                if (nums[i - 1] > j) {
                    // Case 1: If the current item's value is greater than the target sum `j`, 
                    // we cannot include it in the subset. We carry forward the result from the previous row.
                    t[i][j] = t[i - 1][j];
                } else {
                    // Case 2: If the current item's value is less than or equal to the target sum `j`,
                    // we have two choices:
                    // - Exclude the item (result depends on previous row).
                    // - Include the item (subtract the item's value from the target sum and use the remaining items).
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                }
            }
        }

        // Step 4: Collect all subset sums that are possible up to half of the total sum.
        // This is because we only need to check sums up to `s / 2` to minimize the difference.
        for (int i = 0; i <= s / 2; i++) {
            if (t[n][i]) { // If a subset with sum `i` is possible.
                s1.add(i); // Add the sum `i` to the list.
            }
        }

        // Step 5: Calculate the minimum difference.
        int mn = Integer.MAX_VALUE; // Variable to store the minimum difference.

        // For each possible subset sum in `s1`, calculate the difference between the two subsets:
        // The two subset sums will be `i` (subset sum) and `s - i` (remaining elements' sum).
        // The absolute difference is `|s - 2 * i|`.
        for (int i = 0; i < s1.size(); i++) {
            mn = Math.min(mn, s - 2 * s1.get(i));
        }

        return mn; // Return the minimum difference between subset sums.
    }

    public static void main(String[] args) {
        // Test case: Calculate the minimum subset sum difference for the given array.
        System.out.println(minimumDifference(new int[] {1, 2, 7})); // Output: 4
    }
}
