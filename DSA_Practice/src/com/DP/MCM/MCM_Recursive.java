package com.DP.MCM;

public class MCM_Recursive {

    /**
     * Function to calculate the minimum cost of matrix chain multiplication.
     * 
     * @param arr An array where each element represents the dimension of a matrix.
     *            For example, arr[i-1] x arr[i] represents the dimension of the ith matrix.
     * @param i   The starting index for the current subproblem.
     * @param j   The ending index for the current subproblem.
     * @return The minimum cost to multiply matrices from index i to j.
     */
    static int minMCMcost(int[] arr, int i, int j) {
        // Base condition: If there is only one matrix or no matrix in the range,
        // the cost of multiplication is zero.
        if (i >= j)
            return 0;

        // Initialize the minimum cost to a very large value.
        int mn = Integer.MAX_VALUE;

        /**
         * Loop through all possible ways of splitting the matrices between i and j.
         * Each split is represented by the index 'k'.
         * - 'k' splits the matrices into two groups: from i to k and from k+1 to j.
         * - The cost of multiplying these two groups is calculated recursively.
         */
        for (int k = i; k <= j - 1; k++) {
            // Recursively calculate the cost of multiplying matrices from i to k (left subproblem).
            int leftCost = minMCMcost(arr, i, k);

            // Recursively calculate the cost of multiplying matrices from k+1 to j (right subproblem).
            int rightCost = minMCMcost(arr, k + 1, j);

            /**
             * Calculate the cost of multiplying the two resulting matrices from the split.
             * - The dimensions of the resulting matrix from i to k are determined by arr[i-1] x arr[k].
             * - The dimensions of the resulting matrix from k+1 to j are determined by arr[k] x arr[j].
             * - When multiplying these two resulting matrices, the cost is:
             *   arr[i-1] * arr[k] * arr[j]
             */
            int mergeCost = arr[i - 1] * arr[k] * arr[j];

            // Calculate the total cost for this split: left cost + right cost + merge cost.
            int temp = leftCost + rightCost + mergeCost;

            /**
             * Update the minimum cost if the current split produces a smaller cost.
             * - We are trying to find the optimal split that minimizes the cost.
             */
            if (temp < mn) {
                mn = temp;
            }
        }

        // Return the minimum cost found for multiplying matrices from i to j.
        return mn;
    }

    public static void main(String[] args) {
        // Input array representing the dimensions of matrices.
        // Example: {10, 30, 5, 60} represents:
        // - Matrix 1: 10x30
        // - Matrix 2: 30x5
        // - Matrix 3: 5x60
        int[] arr = new int[] {10, 30, 5, 60};

        /**
         * Call the function with the range from the first matrix (index 1)
         * to the last matrix (index arr.length-1).
         * - The starting index is 1 because the first dimension (arr[0]) is only used
         *   to define the dimension of the first matrix.
         */
        System.out.println(minMCMcost(arr, 1, arr.length - 1));
    }
}
