package com.DP.Knapsack.unbounded;

public class UnboundedKnapsack {

    /**
     * Function to calculate the maximum profit using the Unbounded Knapsack approach.
     *
     * @param wt  Array representing the weights of items.
     * @param val Array representing the values (profits) of items.
     * @param W   Maximum weight (capacity) of the knapsack.
     * @param n   Number of items available.
     * @return Maximum profit that can be obtained with the given constraints.
     */
    static int UnboundedKnapsackTopDown(int[] wt, int[] val, int W, int n) {
        // Create a 2D DP table to store the maximum profit for different capacities and items.
        int[][] t = new int[n + 1][W + 1];

        // Initialize the table for base cases:
        // - If there are no items (i = 0) or the knapsack capacity is 0 (j = 0), the profit is 0.
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0; // Base case: No profit when no items or capacity is 0.
                }
            }
        }

        // Fill the DP table using the unbounded knapsack logic:
        // - If the current item's weight is less than or equal to the current capacity:
        //     * Include the item: Add its value and reduce the capacity (`j - wt[i-1]`).
        //     * Exclude the item: Carry forward the value from the previous row.
        // - Take the maximum of these two values.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    // Include the item multiple times (unbounded) or exclude it.
                    t[i][j] = Math.max(
                        val[i - 1] + t[i][j - wt[i - 1]], // Include the item (remain in the same row).
                        t[i - 1][j]                       // Exclude the item (move to the previous row).
                    );
                } else {
                    // If the item's weight is greater than the current capacity, exclude it.
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // The value at `t[n][W]` represents the maximum profit for `n` items and capacity `W`.
        return t[n][W];
    }

    public static void main(String[] args) {
        // Input data: profits, weights, and maximum capacity.
        int profit[] = new int[] { 60, 100, 120 }; // Values of the items.
        int weight[] = new int[] { 10, 20, 30 };  // Weights of the items.
        int W = 50; // Maximum weight capacity of the knapsack.
        int n = profit.length; // Number of items.

        // Call the UnboundedKnapsackTopDown function and print the maximum profit.
        System.out.println("Maximum profit: " + UnboundedKnapsackTopDown(weight, profit, W, n));
    }
}
