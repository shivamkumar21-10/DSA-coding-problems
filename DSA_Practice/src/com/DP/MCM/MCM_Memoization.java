package com.DP.MCM;

public class MCM_Memoization {

    /**
     * Function to calculate the minimum cost of matrix chain multiplication using memoization.
     *
     * @param arr An array representing the dimensions of matrices. 
     *            For example, arr[i-1] x arr[i] gives the dimensions of the i-th matrix.
     * @param i   The starting index for the current subproblem.
     * @param j   The ending index for the current subproblem.
     * @param t   A memoization table (2D array) to store results of subproblems to avoid redundant calculations.
     * @return The minimum cost to multiply matrices from index i to j.
     */
    static int minMCMcost(int[] arr, int i, int j, int[][] t) {
        // Base condition: If there is only one matrix or no matrix in the range,
        // the cost of multiplication is zero.
        if (i >= j)
            return 0;

        // Check if the result for this subproblem is already calculated and stored in the memoization table.
        if (t[i][j] != -1) {
            return t[i][j]; // Return the stored result to save computation time.
        }

        // Initialize the minimum cost to a very large value.
        int mn = Integer.MAX_VALUE;

        /**
         * Loop through all possible points to split the matrices between i and j.
         * 'k' represents the split point:
         * - Left subchain: matrices from i to k.
         * - Right subchain: matrices from k+1 to j.
         */
        for (int k = i; k <= j - 1; k++) {
            // Recursively calculate the cost of multiplying matrices in the left subchain (i to k).
            int leftCost = minMCMcost(arr, i, k, t);

            // Recursively calculate the cost of multiplying matrices in the right subchain (k+1 to j).
            int rightCost = minMCMcost(arr, k + 1, j, t);

            /**
             * Calculate the cost of merging the resulting two matrices from the subchains.
             * - Left matrix dimensions: arr[i-1] x arr[k].
             * - Right matrix dimensions: arr[k] x arr[j].
             * - The cost of multiplying these two matrices is:
             *   arr[i-1] * arr[k] * arr[j]
             */
            int mergeCost = arr[i - 1] * arr[k] * arr[j];

            // Calculate the total cost for this split: leftCost + rightCost + mergeCost.
            int temp = leftCost + rightCost + mergeCost;

            // Update the minimum cost if the current split gives a smaller cost.
            if (temp < mn) {
                mn = temp;
            }
        }

        /**
         * Store the result of this subproblem in the memoization table `t` to avoid redundant computation
         * in future calls with the same range (i, j).
         */
        t[i][j] = mn;

        // Return the minimum cost for multiplying matrices from i to j.
        return mn;
    }

    public static void main(String[] args) {
        // Input array representing the dimensions of matrices.
        // Example: {10, 30, 5, 60} represents:
        // - Matrix 1: 10x30
        // - Matrix 2: 30x5
        // - Matrix 3: 5x60
        int[] arr = new int[]{10, 30, 5, 60};

        /**
         * Initialize the memoization table `t`.
         * - t[i][j] will store the minimum cost of multiplying matrices from index i to j.
         * - Initially, set all values to -1 to indicate that no subproblem has been solved yet.
         */
        int[][] t = new int[1000][1000];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1; // -1 indicates the subproblem (i, j) has not been computed yet.
            }
        }

        /**
         * Call the minMCMcost function with:
         * - Starting index: 1 (first matrix).
         * - Ending index: arr.length-1 (last matrix).
         * - Memoization table: `t`.
         */
        System.out.println(minMCMcost(arr, 1, arr.length - 1, t));
    }
}
