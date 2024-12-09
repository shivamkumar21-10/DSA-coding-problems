package com.DP;

public class SubsetSum_topDown {

    /**
     * Function to solve the Subset Sum problem using a top-down dynamic programming approach.
     * 
     * @param arr Array of positive integers.
     * @param s   Target sum to check if a subset exists.
     * @param n   Number of elements in the array.
     * @return    True if a subset with sum 's' exists, otherwise false.
     */
    static boolean subsetSum(int[] arr, int s, int n) {
        // Create a DP table where t[i][j] represents whether a subset with sum 'j' 
        // can be formed using the first 'i' elements of the array.
        boolean t[][] = new boolean[n + 1][s + 1];

        /**
         * Initialization of the DP table:
         * - If the target sum 'j' is 0 (j == 0), the result is true because an empty subset 
         *   always has a sum of 0.
         * - If there are no elements to consider (i == 0) and the target sum is non-zero, 
         *   the result is false because we cannot form any subset.
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
         * Fill the DP table using the bottom-up approach:
         * - Iterate through all elements of the array and possible target sums.
         * - For each element and sum:
         *   1. If the current element is greater than the target sum (arr[i-1] > j), 
         *      exclude the element, and the result is the same as without this element 
         *      (t[i-1][j]).
         *   2. Otherwise, check if the target sum can be achieved by either:
         *      - Including the current element: Check t[i-1][j-arr[i-1]].
         *      - Excluding the current element: Check t[i-1][j].
         *   - The result is true if either case is true.
         */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i - 1] > j) {
                    // Current element is greater than the target sum, so exclude it.
                    t[i][j] = t[i - 1][j];
                } else {
                    // Check for both cases: include or exclude the current element.
                    t[i][j] = t[i - 1][j - arr[i - 1]]  // included
                    		|| 
                    		t[i - 1][j];    //excluded 
                }
            }
        }

        // The result for the full array and the target sum is stored in t[n][s].
        return t[n][s];
    }

    public static void main(String[] args) {
        // Define the array of integers.
        int[] arr = new int[] {2, 3, 7, 8, 10};
        // Define the target sum to check for.
        int s = 11;

        /**
         * Call the subsetSum function and print the result:
         * - This will output true if a subset with the target sum exists in the array, 
         *   otherwise false.
         */
        System.out.println("Subset with sum " + s + " exists: " + subsetSum(arr, s, arr.length));
    }
}
