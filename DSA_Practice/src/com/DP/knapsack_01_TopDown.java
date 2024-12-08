package com.DP;

import java.util.Arrays;

public class knapsack_01_TopDown {

    /**
     * Function to solve the 0/1 Knapsack problem using the top-down dynamic programming approach.
     * 
     * @param wt   Array representing weights of items.
     * @param val  Array representing values (profits) of items.
     * @param W    Maximum capacity of the knapsack.
     * @param n    Number of items available.
     * @return     Maximum value that can be achieved with the given constraints.
     */
    static int knapsackTopDown(int[] wt, int[] val, int W, int n) {
        // Create a 2D DP table where t[i][j] represents the maximum profit 
        // achievable with the first 'i' items and knapsack capacity 'j'.
        int[][] t = new int[n + 1][W + 1];

        /**
         * Initialization of the DP table:
         * - If the number of items (i) is 0 or the knapsack capacity (j) is 0,
         *   the maximum profit is 0, because no items can be selected or 
         *   there is no space in the knapsack.
         */
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        /**
         * Fill the DP table using the bottom-up approach:
         * - For each item (i) and capacity (j), decide whether to include or exclude the current item.
         * - If the weight of the current item (wt[i-1]) is less than or equal to the current capacity (j):
         *   1. Include the item: Add its value (val[i-1]) to the maximum profit achievable 
         *      with the reduced capacity (j - wt[i-1]) and the remaining items (i-1).
         *   2. Exclude the item: Take the maximum profit achievable without including this item, 
         *      which is t[i-1][j].
         *   - The maximum of these two options is stored in t[i][j].
         * - If the weight of the current item exceeds the current capacity:
         *   - Exclude the item, and the value remains the same as the previous row (t[i-1][j]).
         */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    // Item can be included.
                    t[i][j] = Math.max(
                        val[i - 1] + t[i - 1][j - wt[i - 1]], // Include the item.
                        t[i - 1][j]                          // Exclude the item.
                    );
                } else {
                    // Item cannot be included.
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // The bottom-right corner of the DP table contains the maximum profit
        // achievable with all items and the full knapsack capacity.
        return t[n][W];
    }

    public static void main(String[] args) {
        // Define the values (profits) of the items.
        int profit[] = new int[] { 60, 100, 120 };
        // Define the weights of the items.
        int weight[] = new int[] { 10, 20, 30 };
        // Define the maximum capacity of the knapsack.
        int W = 50;
        // Get the number of items available.
        int n = profit.length;

        /**
         * Call the knapsackTopDown function and print the result:
         * - This will output the maximum profit that can be achieved by optimally 
         *   selecting items to include in the knapsack.
         */
        System.out.println("Maximum profit: " + knapsackTopDown(weight, profit, W, n));
    }
}
