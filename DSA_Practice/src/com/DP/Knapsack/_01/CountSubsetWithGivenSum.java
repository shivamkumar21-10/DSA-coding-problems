package com.DP.Knapsack._01;

public class CountSubsetWithGivenSum {

    /**
     * Function to count the number of subsets in the array that have a given sum.
     *
     * @param arr Array of positive integers.
     * @param s   Target sum to achieve.
     * @param n   Number of elements in the array.
     * @return    Count of subsets that sum to the given target.
     */
    static int subsetSum(int[] arr, int s, int n) {

        // Create a DP table where t[i][j] represents the count of subsets with sum 'j'
        // that can be formed using the first 'i' elements.
        int[][] t = new int[n + 1][s + 1];

        /**
         * Initialization:
         * - If the target sum is 0 (j == 0), there is always one subset: the empty subset.
         * - If there are no elements in the array (i == 0) and the target sum is non-zero,
         *   there are 0 subsets that can achieve the sum.
         */
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = 1; // Base case: One empty subset with sum 0.
                } else if (j == 0) {
                    t[i][j] = 1; // Only the empty subset satisfies this condition.
                } else if (i == 0) {
                    t[i][j] = 0; // No elements available to form a subset.
                }
            }
        }

        /**
         * Fill the DP table using a bottom-up approach:
         * - Iterate through all elements of the array and possible target sums.
         * - For each element and sum:
         *   1. If the current element is greater than the target sum (arr[i-1] > j),
         *      exclude the element, and the count is the same as without this element (t[i-1][j]).
         *   2. Otherwise, include the current element and add:
         *      - The count of subsets that can be formed with the remaining sum (t[i-1][j - arr[i-1]]).
         *      - The count of subsets without including the current element (t[i-1][j]).
         */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i - 1] > j) {
                    // Current element is greater than the target sum; exclude it.
                    t[i][j] = t[i - 1][j];
                } else {
                    // Count subsets by including or excluding the current element.
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                }
            }
        }

        // Return the count of subsets that sum to the target sum using all elements.
        return t[n][s];
    }

    public static void main(String[] args) {
        // Define the array of integers.
        int[] arr = new int[] {2, 3, 5, 6, 8, 10};
        // Define the target sum.
        int s = 10;

        /**
         * Call the subsetSum function and print the result:
         * - This will output the count of subsets that sum to the target value.
         */
        System.out.println("Number of subsets with sum " + s + ": " + subsetSum(arr, s, arr.length));
    }
}
