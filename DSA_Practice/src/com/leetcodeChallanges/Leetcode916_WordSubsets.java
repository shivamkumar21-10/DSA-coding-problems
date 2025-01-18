package com.leetcodeChallanges;

import java.util.ArrayList;
import java.util.List;

public class Leetcode916_WordSubsets {
	
	class Solution {
	    public List<String> wordSubsets(String[] words1, String[] words2) {
	        // Step 1: Create a frequency array `freq` to store the maximum required frequency of each letter
	        // across all words in `words2`. This will represent the combined constraints for `words1`.
	        int[] freq = new int[26]; // Array of size 26 (for letters 'a' to 'z') initialized to 0.
	        
	        // Step 2: Populate the `freq` array using the words in `words2`.
	        for (String word : words2) { // Iterate through each word in `words2`.
	            int[] count = new int[26]; // Temporary frequency array for the current word.
	            for (char c : word.toCharArray()) { 
	                // Count the occurrences of each character in the current word.
	                count[c - 'a']++;
	            }
	            for (int i = 0; i < 26; i++) {
	                // Update the global `freq` array to the maximum of the current word's frequency
	                // and the previously stored frequency. This ensures `freq` captures the maximum
	                // frequency of each character required across all words in `words2`.
	                freq[i] = Math.max(freq[i], count[i]);
	            }
	        }

	        // Step 3: Initialize the result list to store words from `words1` that satisfy the constraints in `freq`.
	        List<String> res = new ArrayList<>();

	        // Step 4: Iterate through each word in `words1` and check if it satisfies the `freq` requirements.
	        for (String word : words1) {
	            int count[] = new int[26]; // Frequency array for the current word in `words1`.
	            int i = 0; // Index used to iterate through `freq`.

	            // Step 5: Calculate the frequency of each character in the current word.
	            for (char c : word.toCharArray()) {
	                count[c - 'a']++;
	            }

	            // Step 6: Compare the character frequencies of the current word against the `freq` array.
	            for (i = 0; i < 26; i++) {
	                // If the current word does not meet the required frequency for any character, break the loop.
	                if (count[i] < freq[i]) {
	                    break;
	                }
	            }

	            // Step 7: If the loop completes without breaking (i.e., `i == 26`), it means the word satisfies
	            // the constraints for all characters in `freq`. Add the word to the result list.
	            if (i == 26) {
	                res.add(word);
	            }
	        }

	        // Step 8: Return the list of words from `words1` that satisfy the constraints in `freq`.
	        return res;
	    }
	}


}
