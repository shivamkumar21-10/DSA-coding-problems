package com.DP.Knapsack.unbounded;

public class Leetcode518_CoinChange_II_MaxNoOfWays {

    /**
     * Function to calculate the maximum number of ways to achieve a given sum using the given coins.
     *
     * @param coin Array of coin denominations.
     * @param sum  Total amount for which the number of ways is to be calculated.
     * @param n    Number of available coin denominations.
     * @return Maximum number of ways to achieve the given sum.
     */
    static int CoinChange(int[] coin, int sum, int n) {
        // Create a DP table where `t[i][j]` represents the number of ways to make sum `j` using the first `i` coins.
        int[][] t = new int[n + 1][sum + 1];

        // Initialize the base cases for the DP table.
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    // If there are no coins and the sum is 0, there is exactly one way (do nothing).
                    t[i][j] = 1;
                } else if (j == 0) {
                    // If the target sum is 0, there is always one way regardless of the available coins (choose nothing).
                    t[i][j] = 1;
                } else if (i == 0) {
                    // If there are no coins but the target sum is positive, there are 0 ways to make the sum.
                    t[i][j] = 0;
                }
            }
        }

        // Fill the DP table using the recursive relation for the unbounded knapsack.
        for (int i = 1; i < n + 1; i++) { // Iterate through each coin.
            for (int j = 1; j < sum + 1; j++) { // Iterate through each possible sum.
                if (coin[i - 1] <= j) {
                    /*
                     * If the value of the current coin is less than or equal to the target sum `j`:
                     * - Include the coin: Add the number of ways to make the remaining sum (`j - coin[i-1]`) with the current coin.
                     * - Exclude the coin: Use the previous result (i.e., the number of ways without using the current coin).
                     * Combine these two possibilities to get the total ways for the current sum `j`.
                     */
                    t[i][j] = t[i][j - coin[i - 1]] + t[i - 1][j];
                } else {
                    /*
                     * If the value of the current coin is greater than the target sum `j`:
                     * - Exclude the coin: Use the result from the previous row, i.e., without considering the current coin.
                     */
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // The final answer will be stored in `t[n][sum]`, which represents the number of ways to make the given sum using all coins.
        return t[n][sum];
    }

    public static void main(String[] args) {
        // Define the array of coin denominations and the target sum.
        int[] coin = new int[] {1, 2, 3}; // Coin denominations.
        int sum = 5; // Target sum.

        // Call the function and print the result.
        System.out.println("Maximum number of ways to make the sum: " + CoinChange(coin, sum, coin.length));
    }
}
