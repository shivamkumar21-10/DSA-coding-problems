package com.DP;

public class Leetcode2466_CountWaysToBuildGoodStrings {

	int mod = 1000000007; // Modulo to avoid integer overflow, as result can grow large.

	/**
	 * Recursive function to count the number of "good" strings starting from index
	 * `i`. A "good" string has its length between `low` and `high`, and its
	 * formation involves adding either `zero` or `one` characters at each step.
	 *
	 * @param low  Minimum valid length for a "good" string.
	 * @param high Maximum valid length for a "good" string.
	 * @param zero Length increment if "0" is added.
	 * @param one  Length increment if "1" is added.
	 * @param i    Current length of the string.
	 * @param t    Memoization array to store results for a given length `i`.
	 * @return Total count of "good" strings starting from length `i`.
	 */
	public int solve(int low, int high, int zero, int one, int i, int[] t) {
		// Base case: If the current length exceeds `high`, no valid string can be
		// formed.
		if (i > high)
			return 0;

		// If the result for the current length `i` is already computed, return it.
		if (t[i] != -1)
			return t[i];

		int count = 0; // Initialize count of valid strings starting from `i`.

		// If the current length is within the valid range [low, high], count this as a
		// valid string.
		if (i >= low && i <= high) {
			count = 1;
		}

		// Recursively calculate the count for the two possible choices:
		// 1. Adding `zero` characters to the current length.
		int x = solve(low, high, zero, one, i + zero, t) % mod;

		// 2. Adding `one` characters to the current length.
		int y = solve(low, high, zero, one, i + one, t) % mod;

		// Sum up the results from both choices and take modulo to prevent overflow.
		count += x + y;

		// Store the result in the memoization array for reuse and return it.
		return t[i] = count % mod;
	}

	/**
	 * Main function to count the total number of "good" strings that can be formed.
	 *
	 * @param low  Minimum valid length for a "good" string.
	 * @param high Maximum valid length for a "good" string.
	 * @param zero Length increment if "0" is added.
	 * @param one  Length increment if "1" is added.
	 * @return Total count of "good" strings modulo `10^9 + 7`.
	 */
	public int countGoodStrings(int low, int high, int zero, int one) {
		// Create a memoization array to store results for lengths up to 100000.
		int[] t = new int[100001];

		// Initialize all entries in the memoization array to -1 (uncomputed state).
		for (int i = 0; i < 100001; i++) {
			t[i] = -1;
		}

		// Start the recursive process from length `0`.
		return solve(low, high, zero, one, 0, t);
	}
}
