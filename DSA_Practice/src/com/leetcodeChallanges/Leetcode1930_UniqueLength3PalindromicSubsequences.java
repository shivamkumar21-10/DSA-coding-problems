package com.leetcodeChallanges;

import java.util.HashSet;

public class Leetcode1930_UniqueLength3PalindromicSubsequences {
	// LOGIC
//	Observation 1: Outer Characters (c)
//	To form a palindrome of length 3, the first and last characters must be the same.
//	For each character c (from 'a' to 'z'), identify:
//	The first occurrence (i) of c.
//	The last occurrence (k) of c.
//	Observation 2: Middle Characters (x)
//	If the first and last occurrence of c are at indices i and k, we only need to count unique characters between i+1 and k-1.
//	Using a HashSet to collect these middle characters ensures uniqueness.

	public int countPalindromicSubsequence(String s) {
		// Step 1: Get the length of the string and initialize the counter for
		// palindromic subsequences
		int n = s.length();
		int count = 0;

		// Step 2: Iterate over each character in the English alphabet ('a' to 'z')
		// Purpose: We are looking for palindromic subsequences of the form 'c_x_c'
		for (char c = 'a'; c <= 'z'; c++) {
			// Initialize variables to store the first and last occurrence of the current
			// character
			int first = -1, last = -1;

			// Step 3: Find the first and last occurrence of the character `c` in the string
			// This helps identify the potential boundaries for the middle character(s)
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == c) {
					if (first == -1) {
						first = i; // Set `first` when we encounter `c` for the first time
					}
					last = i; // Update `last` every time we see `c`
				}
			}

			// Step 4: Ensure the first and last occurrence of the character `c` forms a
			// valid boundary
			// Condition: The distance between `first` and `last` must be greater than 1
			// (so that there's at least one character between them for the middle)
			if (first != -1 && last != -1 && last - first > 1) {
				// Use a HashSet to store unique middle characters between the first and last
				// occurrence of `c`
				HashSet<Character> middleChars = new HashSet<>();

				// Step 5: Iterate over all characters between `first` and `last` (exclusive)
				// Add them to the HashSet to ensure uniqueness
				for (int i = first + 1; i < last; i++) {
					middleChars.add(s.charAt(i)); // Add the middle character to the set
				}

				// Step 6: The size of the HashSet represents the count of unique palindromic
				// subsequences
				// of the form 'c_x_c' where `c` is the current character and `x` is any
				// character
				count += middleChars.size(); // Add the size of the HashSet to the total count
			}
		}

		// Step 7: Return the total count of unique palindromic subsequences of length 3
		return count;
	}

}
