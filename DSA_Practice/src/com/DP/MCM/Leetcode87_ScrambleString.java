package com.DP.MCM;

import java.util.HashMap;
import java.util.Map;

public class Leetcode87_ScrambleString {

	/**
	 * This method recursively checks if string `b` is a scrambled version of string
	 * `a`. It uses memoization to optimize repeated subproblems.
	 *
	 * @param a  The first string (or substring) to check
	 * @param b  The second string (or substring) to check against
	 * @param mp A map for memoization to store results of (a, b) pairs
	 * @return True if `b` is a scrambled version of `a`, otherwise false
	 */
	public boolean solve(String a, String b, Map<String, Boolean> mp) {
		// Base case: If both strings are equal, they are scrambled versions
		if (a.equals(b))
			return true;

		// If the strings are too short, they cannot be scrambled
		if (a.length() <= 1)
			return false;

		// Generate a unique key to represent the current pair of strings
		String key = a + " " + b;

		// Check if this problem has already been solved
		if (mp.containsKey(key)) {
			return mp.get(key); // Return the precomputed result
		}

		int n = a.length(); // Length of the current strings
		boolean flag = false; // To track if a valid scramble is found

		// Iterate over all possible split points in the string
		for (int i = 1; i <= n - 1; i++) {

			/**
			 * Recursive checks:
			 *
			 * There are two cases to consider for a scramble:
			 *
			 * 1. The two segments of `a` are swapped: - Left part of `a` (0 to i) matches
			 * the right part of `b` (n-i to n) - Right part of `a` (i to n) matches the
			 * left part of `b` (0 to n-i)
			 *
			 * 2. The two segments of `a` are not swapped: - Left part of `a` (0 to i)
			 * matches the left part of `b` (0 to i) - Right part of `a` (i to n) matches
			 * the right part of `b` (i to n)
			 */

			if (
			// Case 1: Swapped segments
			(solve(a.substring(0, i), b.substring(n - i), mp) && solve(a.substring(i), b.substring(0, n - i), mp)) ||
			// Case 2: Non-swapped segments
					(solve(a.substring(0, i), b.substring(0, i), mp) && solve(a.substring(i), b.substring(i), mp))) {
				flag = true; // If either case matches, set the flag to true
				break; // No need to check further splits
			}
		}

		// Store the result in the memoization map
		mp.put(key, flag);

		return flag;
	}

	/**
	 * Main method to determine if string `s2` is a scrambled version of `s1`.
	 *
	 * @param s1 The original string
	 * @param s2 The string to check if it is scrambled
	 * @return True if `s2` is a scrambled version of `s1`, otherwise false
	 */
	public boolean isScramble(String s1, String s2) {
		// Create a map for memoization
		Map<String, Boolean> mp = new HashMap<>();

		// If the lengths of the two strings are different, they cannot be scrambled
		if (s1.length() != s2.length()) {
			return false;
		}

		// Handle empty strings
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}

		// Call the recursive function to solve the problem
		return solve(s1, s2, mp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
