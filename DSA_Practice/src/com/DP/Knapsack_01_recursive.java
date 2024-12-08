package com.DP;

public class Knapsack_01_recursive {
	    
	    /**
	     * Recursive function to solve the 0/1 Knapsack problem.
	     * 
	     * @param wt   Array representing weights of items.
	     * @param val  Array representing values (profits) of items.
	     * @param W    Maximum capacity of the knapsack.
	     * @param n    Number of items remaining to consider.
	     * @return     Maximum value that can be achieved with the given constraints.
	     */
	    static int knapsack(int[] wt, int[] val, int W, int n) {
	        
	        // Base condition: If no items are left to consider (n == 0) 
	        // or the capacity of the knapsack is 0 (W == 0), 
	        // the maximum value is 0.
	        if (n == 0 || W == 0) {
	            return 0;
	        }

	        /**
	         * Recursive logic:
	         * Case 1: Item is included in the knapsack:
	         * - Add the value of the current item (val[n-1]) to the result of solving the problem 
	         *   with reduced capacity (W - wt[n-1]) and the remaining items (n-1).
	         * Case 2: Item is not included in the knapsack:
	         * - Exclude the current item and solve the problem for the same capacity (W) 
	         *   but with one fewer item (n-1).
	         * - The maximum of these two cases is returned, representing the optimal solution 
	         *   at this step.
	         */
	        // for item is included val[n-1] + knapsack(wt,val,W-wt[n-1],n-1) -- val is added and weight is subtracted and n to n-1 last item discarded (to make ip smaller
			//for item is not included knapsack(wt,val,W,n-1) - just item is discarded
	        if (wt[n - 1] <= W) {
	            // Check if the weight of the current item is less than or equal to the remaining capacity.
	            // Include the current item and find the max value between including or excluding it.
	            return Math.max(
	                val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), // Case 1: Include the item
	                knapsack(wt, val, W, n - 1)                          // Case 2: Exclude the item
	            );
	        }

	        /**
	         * Case 3: Item cannot be included because its weight exceeds the remaining capacity:
	         * - Simply skip the current item and solve the problem for the same capacity (W) 
	         *   and remaining items (n-1).
	         */
	        else if (wt[n - 1] > W) {
	            return knapsack(wt, val, W, n - 1);
	        }

	        // This return is redundant and logically unreachable due to the above conditions, 
	        // but included for completeness.
	        return 0;
	    }

	    public static void main(String[] args) {
	        // Test case:
	        // Define the profits (values) of the items.
	        int profit[] = new int[] { 60, 100, 120 };
	        // Define the weights of the items.
	        int weight[] = new int[] { 10, 20, 30 };
	        // Define the capacity of the knapsack.
	        int W = 50;
	        // Get the number of items.
	        int n = profit.length;
	        
	        /**
	         * Call the knapsack function with the defined inputs and print the result:
	         * - This will output the maximum profit that can be achieved by optimally 
	         *   selecting items to include in the knapsack.
	         */
	        System.out.println(knapsack(weight, profit, W, n));
	    }
	


}
