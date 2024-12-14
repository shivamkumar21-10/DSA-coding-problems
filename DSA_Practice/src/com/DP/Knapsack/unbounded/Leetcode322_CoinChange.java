package com.DP.Knapsack.unbounded;

public class Leetcode322_CoinChange {
	
	    public int coinChange(int[] coins, int amount) {
	        // Step 1: Get the number of coin types
	        int n = coins.length;

	        // Step 2: Create a 2D array for dynamic programming
	        // `t[i][j]` will represent the minimum number of coins needed to make amount `j`
	        // using the first `i` types of coins.
	        int[][] t = new int[n + 1][amount + 1];

	        // Step 3: Initialize the DP table with base cases
	        // Iterate over each cell in the table to set initial values
	        for (int i = 0; i < n + 1; i++) { // Loop for all rows (number of coin types)
	            for (int j = 0; j < amount + 1; j++) { // Loop for all columns (amounts)

	                if (i == 0) {
	                    // If no coins are available (`i == 0`), we cannot make any amount
	                    // For positive amounts, set the value to a very large number (infinity).
	                    t[i][j] = Integer.MAX_VALUE - 1;
	                }

	                if (j == 0 && i != 0) {
	                    // If the amount is zero (`j == 0`), no coins are needed.
	                    // This is true regardless of the number of coins available.
	                    t[i][j] = 0;
	                }
	            }
	        }

	        // Step 4: Special case for the first row of coins
	        // This row determines how to handle when we can only use the first coin type.
	        for (int j = 1; j < amount + 1; j++) { // Loop over all amounts for the first coin type
	            if (j % coins[0] == 0) {
	                // If the amount `j` is a multiple of the first coin's value, we can make it
	                // For example, if the coin value is 2, amounts like 2, 4, 6, etc., can be made
	                // with 1, 2, and 3 coins, respectively.
	                t[1][j] = j / coins[0];
	            } else {
	                // If the amount is not a multiple of the first coin's value,
	                // it is not possible to make the amount using only the first coin.
	                t[1][j] = Integer.MAX_VALUE - 1;
	            }
	        }

	        // Step 5: Fill the rest of the DP table using the remaining coin types
	        for (int i = 2; i < n + 1; i++) { // Start from the second coin type
	            for (int j = 0; j < amount + 1; j++) { // Loop over all amounts

	                if (coins[i - 1] <= j) {
	                    // If the current coin's value is less than or equal to the amount `j`,
	                    // we have two choices:
	                    // 1. Include the current coin in the solution.
	                    //    In this case, we add 1 to the result of the remaining amount (j - coin value).
	                    // 2. Exclude the current coin and use the previous solution.
	                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
	                } else {
	                    // If the current coin's value is greater than the amount `j`,
	                    // we cannot include the current coin in the solution.
	                    // Simply copy the result from the previous row (exclude this coin).
	                    t[i][j] = t[i - 1][j];
	                }
	            }
	        }

	        // Step 6: Check the result in the last cell of the table
	        // If the value in `t[n][amount]` is still infinity, it means the amount cannot be formed.
	        return t[n][amount] == Integer.MAX_VALUE - 1 ? -1 : t[n][amount];
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
