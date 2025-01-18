package com.leetcodeChallanges;

import java.util.*;

public class Leetcode3223_MinimumLengthofStringAfterOperations {
	class Solution {
	    /**
	     * This method calculates the minimum length of a string after repeatedly 
	     * removing the same characters from both ends. 
	     *
	     * Logic:
	     * 1. Count the frequency of each character in the string using a HashMap.
	     * 2. Iterate through the frequency map to determine how many characters
	     *    would remain in the final result after considering pairs.
	     * 3. If a character occurs an even number of times, it can be fully paired.
	     *    If it occurs an odd number of times, one unpaired character remains.
	     * 4. The final count (`cnt`) represents the minimum length of the string
	     *    after all valid pair removals.
	     *
	     * Time Complexity: O(n), where n is the length of the string (for counting and iterating).
	     * Space Complexity: O(1) for the frequency map (limited by the number of characters).
	     *
	     * @param s - Input string containing characters.
	     * @return Minimum possible length of the string after removal.
	     */
	    public int minimumLength(String s) {
	        int n = s.length(); // Length of the input string
	        HashMap<Character, Integer> map = new HashMap<>(); // To store character frequencies

	        // Step 1: Count the frequency of each character in the string
	        for (int i = 0; i < n; i++) {
	            // Get the current character
	            char currentChar = s.charAt(i);
	            // Update its frequency in the map
	            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
	        }

	        int cnt = 0; // This variable stores the minimum length of the string after processing

	        // Step 2: Iterate through the frequency map to calculate the final count
	        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	            // Get the frequency of the current character
	            int frequency = entry.getValue();
	            
	            // If the frequency is even, it contributes fully to the pairs
	            if (frequency % 2 == 0) {
	                cnt += 2; // Add the count of pairs (2 characters)
	            } else {
	                // If the frequency is odd, at least one character remains
	                cnt += 1; // Add 1 for the single unpaired character
	            }
	        }

	        // Return the total count, representing the minimum length of the string
	        return cnt;
	    }
	}


}
