package com.leetcodeChallanges;

public class Leetcode2559_CountVowelStringsinRanges {
	
	    // Helper function to check if a word starts and ends with vowels
	    boolean isVowel(String s) {
	        char start = s.charAt(0); // Extract the first character of the word
	        char end = s.charAt(s.length() - 1); // Extract the last character of the word
	        // Check if both the first and last characters are vowels
	        return isVowelChar(start) && isVowelChar(end);
	    }

	    // Helper function to check if a character is a vowel
	    boolean isVowelChar(char c) {
	        // Return true if the character is one of 'a', 'e', 'i', 'o', 'u'
	        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	    }

	    public int[] vowelStrings(String[] words, int[][] queries) {
	        // Step 1: Precompute the prefix sum array
	        int[] prefix = new int[words.length]; // Array to store the cumulative count of vowel strings
	        prefix[0] = isVowel(words[0]) ? 1 : 0; // Initialize the first element of the prefix array:
	        // If the first word is a vowel string, set it to 1; otherwise, set it to 0.

	        // Iterate over the words array to compute the prefix sums
	        for (int i = 1; i < words.length; i++) {
	            // The prefix sum at position `i` is the prefix sum at position `i-1`
	            // plus 1 if the current word is a vowel string, otherwise it remains the same.
	            prefix[i] = prefix[i - 1] + (isVowel(words[i]) ? 1 : 0);
	        }

	        // Explanation of the Prefix Sum:
	        // - `prefix[i]` stores the total number of vowel strings from `words[0]` to `words[i]`.
	        // - This allows us to quickly compute the number of vowel strings in any subarray `[l, r]`
	        //   by subtracting `prefix[l-1]` from `prefix[r]` (if `l > 0`), or just taking `prefix[r]` if `l == 0`.
	        // - The prefix sum helps avoid recalculating the count of vowel strings repeatedly for each query.

	        // Step 2: Answer each query using the prefix sum
	        int[] ans = new int[queries.length]; // Array to store the results for each query

	        for (int i = 0; i < queries.length; i++) {
	            int left = queries[i][0];  // Start index of the query range
	            int right = queries[i][1]; // End index of the query range

	            // If the query range starts at index 0, the answer is just `prefix[right]`
	            // Otherwise, subtract `prefix[left-1]` from `prefix[right]` to get the count of vowel strings in `[left, right]`
	            ans[i] = left > 0 ? prefix[right] - prefix[left - 1] : prefix[right];
	        }

	        // Return the results for all queries
	        return ans;
	    }
	


}
