package com.DP.Knapsack._01;

public class SubsetSum_recursive {

    /**
     * Recursive function to determine if a subset with a given sum exists in the array.
     * 
     * @param arr Array of positive integers.
     * @param s   Target sum to check if a subset exists.
     * @param n   Number of elements remaining in the array to consider.
     * @return    True if a subset with sum 's' exists, otherwise false.
     */
    static boolean subsetSum(int[] arr, int s, int n) {

        // Base condition 1: If the target sum 's' becomes 0, 
        // a subset with the desired sum is found, so return true.
        if (s == 0) {
            return true;
        }

        // Base condition 2: If no elements are left to consider (n == 0) 
        // and the target sum is not 0, no valid subset exists, so return false.
        if (n == 0) {
            return false;
        }

        /**
         * Recursive logic:
         * - If the current item's value (arr[n-1]) is greater than the remaining sum 's', 
         *   skip this item and solve the problem for the remaining items (n-1).
         * - Otherwise, solve the problem in two ways:
         *   1. Exclude the current item and check if a valid subset exists without it.
         *   2. Include the current item (subtract its value from 's') and check if a 
         *      valid subset exists with the remaining items.
         * - Return true if any of the two cases return true, indicating a valid subset exists.
         */
        if (arr[n - 1] > s) {
            // Current item's value exceeds the remaining sum, so exclude it.
            return subsetSum(arr, s, n - 1);
        }

        // Check for both cases: excluding or including the current item.
        return subsetSum(arr, s, n - 1) || subsetSum(arr, s - arr[n - 1], n - 1);
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
