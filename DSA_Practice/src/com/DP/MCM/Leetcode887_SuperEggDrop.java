package com.DP.MCM;

import java.util.*;

public class Leetcode887_SuperEggDrop {
	class Solution {
	    int solve(int k, int n, int[][] t) {
	        /*
	         * Base Cases:
	         * 1. If there are no floors (`n == 0`), no attempts are needed.
	         * 2. If there is one floor (`n == 1`), only one attempt is needed regardless of the number of eggs.
	         * 3. If there is only one egg (`k == 1`), the worst-case scenario requires testing all floors sequentially
	         *    to avoid breaking the last egg. Hence, the number of attempts equals `n`.
	         */
	        if (n == 0 || n == 1) return n;
	        if (k == 1) return n;

	        /*
	         * Memoization:
	         * If the result for `k` eggs and `n` floors has already been calculated, return the stored result
	         * from the memoization table `t`.
	         */
	        if (t[k][n] != -1) return t[k][n];

	        // Initialize `mn` (minimum attempts) to a very large value, as we are looking for the minimum.
	        int mn = Integer.MAX_VALUE;

	        /*
	         * Use Binary Search:
	         * Instead of trying every possible floor linearly (from 1 to n), binary search is applied to reduce
	         * the number of comparisons. This optimizes the solution significantly from O(n^2) to O(n log n).
	         */
	        int low = 1, high = n;
	        while (low <= high) {
	            int mid = (low + high) / 2; // `mid` represents the current floor we are testing.

	            /*
	             * Break Case:
	             * If the egg breaks when dropped from floor `mid`, it means:
	             * - We need to check all floors below `mid` (from 1 to `mid - 1`).
	             * - We now have one less egg available (`k - 1`).
	             */
	            int breakCase;
	            if (t[k - 1][mid - 1] != -1) { // If result is memoized, use it.
	                breakCase = t[k - 1][mid - 1];
	            } else { // Otherwise, calculate it recursively.
	                breakCase = solve(k - 1, mid - 1, t);
	                t[k - 1][mid - 1] = breakCase; // Store result for future use.
	            }

	            /*
	             * Not Break Case:
	             * If the egg does not break when dropped from floor `mid`, it means:
	             * - The critical floor lies above `mid` (from `mid + 1` to `n`).
	             * - We still have all `k` eggs intact.
	             */
	            int notBreakCase;
	            if (t[k][n - mid] != -1) { // If result is memoized, use it.
	                notBreakCase = t[k][n - mid];
	            } else { // Otherwise, calculate it recursively.
	                notBreakCase = solve(k, n - mid, t);
	                t[k][n - mid] = notBreakCase; // Store result for future use.
	            }

	            /*
	             * Combine Results:
	             * The worst-case number of attempts for this `mid` is the maximum of the two cases (since we
	             * are considering the worst-case scenario for every drop).
	             * Add 1 to include the current drop attempt.
	             */
	            int temp = 1 + Math.max(breakCase, notBreakCase);

	            // Update the minimum attempts (`mn`) for the current configuration.
	            mn = Math.min(mn, temp);

	            /*
	             * Adjust Binary Search Range:
	             * - If `breakCase > notBreakCase`, it means the critical floor lies below `mid`, so we
	             *   narrow the search to the lower half (`high = mid - 1`).
	             * - Otherwise, if `notBreakCase >= breakCase`, the critical floor lies above `mid`, so we
	             *   narrow the search to the upper half (`low = mid + 1`).
	             */
	            if (breakCase > notBreakCase) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }

	        /*
	         * Store the result in the memoization table `t[k][n]` and return it.
	         * This avoids redundant calculations in future calls with the same inputs.
	         */
	        return t[k][n] = mn;
	    }

	    public int superEggDrop(int k, int n) {
	        /*
	         * Memoization Table:
	         * `t[k][n]` represents the minimum number of attempts required with `k` eggs and `n` floors.
	         * Initialize all values to `-1` to indicate uncalculated states.
	         */
	        int[][] t = new int[k + 1][n + 1];
	        for (int i = 0; i <= k; i++) {
	            Arrays.fill(t[i], -1);
	        }

	        // Solve the problem recursively with memoization.
	        return solve(k, n, t);
	    }
	}


}
