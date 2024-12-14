package com.DP.Knapsack._01;

public class Leetcode494_TargetSum {
	
	    public int findTargetSumWays(int[] nums, int target) {
	        int sum = 0; // Initialize a variable to store the total sum of the array elements.
	        int n = nums.length; // Length of the input array.

	        // Calculate the total sum of the array elements.
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	        }

	        // Check if it is possible to partition the array to achieve the target:
	        // 1. (sum + target) must be even, because we are dividing it into two subsets with equal difference.
	        // 2. Target must not exceed the total sum or fall below -sum.
	        if ((sum + target) % 2 != 0 || target > sum || target < -sum) {
	            return 0; // If these conditions are not met, return 0 as it's not feasible.
	        }

	        // Calculate the subset sum we need to find:
	        // Let `s1` and `s2` be the sums of two subsets where `s1 - s2 = target`.
	        // Adding `s1 + s2 = sum` gives `2 * s1 = sum + target`.
	        // Therefore, `s1 = (sum + target) / 2`, which is the subset sum we need to calculate.
	        int s = (sum + target) / 2;

	        // Initialize a DP table:
	        // `t[i][j]` represents the number of ways to get a subset sum `j` using the first `i` elements of the array.
	        int[][] t = new int[n + 1][s + 1];

	        // Base case initialization:
	        // When subset sum (`j`) is 0, there is exactly one way to achieve it: by taking no elements.
	        for (int i = 0; i <= n; i++) {
	            t[i][0] = 1; 
	        }

	        // Fill the DP table iteratively.
	        for (int i = 1; i <= n; i++) { // Iterate over each element of the array.
	            for (int j = 0; j <= s; j++) { // Iterate over all possible subset sums from 0 to `s`.
	                if (nums[i - 1] > j) {
	                    // If the current element is greater than the target subset sum `j`, we can't include it.
	                    // The number of ways to achieve `j` is the same as excluding this element.
	                    t[i][j] = t[i - 1][j];
	                } else {
	                    // Otherwise, we have two options:
	                    // 1. Exclude the current element: `t[i - 1][j]`.
	                    // 2. Include the current element: `t[i - 1][j - nums[i - 1]]`.
	                    // Add both possibilities to get the total number of ways to achieve `j`.
	                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
	                }
	            }
	        }

	        // The answer is stored in `t[n][s]`, which gives the number of ways to achieve the subset sum `s`
	        // using all `n` elements of the array.

	        // **Handling multiple zeroes**:
	        // - Zeroes do not change the subset sum when included. For example:
	        //     - If the current subset sum is 5, adding a `0` doesn't change the sum.
	        //     - If the current subset sum is 5, adding a `0` results in the same sum of 5.
	        // - As a result, multiple zeroes in the array increase the number of ways to achieve a sum
	        //   because each zero can either be included or excluded from a subset. For each zero,
	        //   the number of ways doubles, as it can be part of the subset in two ways:
	        //     - Included in the subset.
	        //     - Excluded from the subset.
	        // - Hence, zeroes increase the number of possible ways to partition the set, but they do not
	        //   affect the actual sum of the subset.
	        
	        return t[n][s]; // Return the result from the DP table.
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
