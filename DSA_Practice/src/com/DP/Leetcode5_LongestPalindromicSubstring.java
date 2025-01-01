package com.DP;

public class Leetcode5_LongestPalindromicSubstring {
	

	    /**
	     * This function checks whether a substring of `s` from index `i` to `j` is a palindrome.
	     * It uses memoization to avoid redundant computations by storing previously calculated results.
	     *
	     * @param s     The input string.
	     * @param i     The starting index of the substring.
	     * @param j     The ending index of the substring.
	     * @param memo  A 2D Boolean array for memoization where memo[i][j] stores
	     *              whether the substring `s[i..j]` is a palindrome.
	     * @return      True if the substring `s[i..j]` is a palindrome, false otherwise.
	     */
	    public boolean isPalindrome(String s, int i, int j, Boolean[][] memo) {
	        // Base case: A single character or an empty substring is always a palindrome
	        if (i >= j) return true;

	        // If the result is already computed, return the cached value
	        if (memo[i][j] != null) {
	            return memo[i][j];
	        }

	        // Recursive check: If the characters at the current boundaries match,
	        // check the inner substring recursively
	        if (s.charAt(i) == s.charAt(j)) {
	            memo[i][j] = isPalindrome(s, i + 1, j - 1, memo);
	        } else {
	            memo[i][j] = false; // Not a palindrome if characters don't match
	        }

	        return memo[i][j];
	    }

	    /**
	     * This function generates all substrings of `inputString` starting from `startPos` and
	     * finds the longest palindromic substring using the helper function `isPalindrome`.
	     *
	     * @param inputString The input string.
	     * @param startPos    The starting position from which substrings are generated.
	     * @param memo        A 2D Boolean array for memoization to check palindromes efficiently.
	     * @return            The longest palindromic substring found starting from `startPos`.
	     */
	    public String generateSubstring(String inputString, int startPos, Boolean[][] memo) {
	        // Base case: If the starting position exceeds the string length, return an empty string
	        if (startPos >= inputString.length()) {
	            return "";
	        }

	        int maxLen = 0; // Variable to track the maximum length of the palindrome
	        String longestPalindrome = ""; // Variable to store the longest palindromic substring

	        // Iterate through all possible substrings starting from `startPos`
	        for (int j = startPos; j < inputString.length(); j++) {
	            // Check if the substring from `startPos` to `j` is a palindrome
	            if (isPalindrome(inputString, startPos, j, memo)) {
	                int currLen = j - startPos + 1; // Calculate the length of the current substring

	                // Update the longest palindrome if the current one is longer
	                if (currLen > maxLen) {
	                    maxLen = currLen;
	                    longestPalindrome = inputString.substring(startPos, j + 1);
	                }
	            }
	        }

	        // Recur for the next starting position and get the longest palindrome from there
	        String nextResult = generateSubstring(inputString, startPos + 1, memo);

	        // Return the longer palindrome between the current and the recursive result
	        return longestPalindrome.length() > nextResult.length() ? longestPalindrome : nextResult;
	    }

	    /**
	     * This is the main function to find the longest palindromic substring in the given string `s`.
	     * It initializes the memoization table and starts the recursive search.
	     *
	     * @param s The input string.
	     * @return  The longest palindromic substring in the input string `s`.
	     */
	    public String longestPalindrome(String s) {
	        int n = s.length(); // Get the length of the string
	        Boolean[][] memo = new Boolean[n][n]; // Initialize the memoization table

	        // Call the helper function to generate substrings and find the longest palindrome
	        return generateSubstring(s, 0, memo);
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
