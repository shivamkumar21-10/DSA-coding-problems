package com.DP;

public class Leetcode647_PalindromicSubstrings {
	
	class Solution {
	    public int countSubstrings(String s) {
	        int n = s.length();
	        
	        // Create a memoization table to store whether a substring s[i...j] is a palindrome.
	        // memo[i][j] == true means s[i...j] is a palindrome.
	        // memo[i][j] == false means s[i...j] is not a palindrome.
	        Boolean[][] memo = new Boolean[n][n];

	        int count = 0; // To count the total number of palindromic substrings.

	        // Iterate over all possible substrings (i, j) such that i <= j.
	        for (int i = 0; i < n; i++) { // Start of the substring.
	            for (int j = i; j < n; j++) { // End of the substring.
	                // Check if the substring s[i...j] is a palindrome.
	                if (isPalindrome(s, i, j, memo)) {
	                    count++; // If it's a palindrome, increment the count.
	                }
	            }
	        }

	        return count; // Return the total number of palindromic substrings.
	    }

	    /**
	     * Helper function to determine if a substring s[i...j] is a palindrome.
	     * Uses memoization to store the result of previously computed substrings.
	     *
	     * @param s     The input string.
	     * @param i     The starting index of the substring.
	     * @param j     The ending index of the substring.
	     * @param memo  The memoization table to avoid redundant computations.
	     * @return      True if s[i...j] is a palindrome, false otherwise.
	     */
	    private boolean isPalindrome(String s, int i, int j, Boolean[][] memo) {
	        // Base case 1: A single character is always a palindrome.
	        if (i == j) return true;

	        // Base case 2: If the range is invalid (i > j), return false.
	        if (i > j) return false;

	        // Check if the result for s[i...j] is already computed and stored in the memo table.
	        if (memo[i][j] != null) {
	            return memo[i][j]; // Return the stored result.
	        }

	        // Check if the first and last characters are equal.
	        if (s.charAt(i) == s.charAt(j)) {
	            // If they are equal:
	            // - The substring is a palindrome if:
	            //   1. It's a 2-character substring (j - i == 1), OR
	            //   2. The inner substring s[i+1...j-1] is a palindrome.
	            memo[i][j] = (j - i == 1) || isPalindrome(s, i + 1, j - 1, memo);
	        } else {
	            // If the first and last characters are not equal, the substring is not a palindrome.
	            memo[i][j] = false;
	        }

	        // Return the computed result for s[i...j].
	        return memo[i][j];
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
