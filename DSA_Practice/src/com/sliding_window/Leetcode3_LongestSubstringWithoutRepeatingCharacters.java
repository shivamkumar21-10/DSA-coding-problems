package com.sliding_window;

import java.util.HashMap;

public class Leetcode3_LongestSubstringWithoutRepeatingCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		
		int i = 0; // Left pointer (start of the sliding window)
		int j = 0; // Right pointer (end of the sliding window)
		HashMap<Character, Integer> map = new HashMap<>();  // Map to track the frequency of each character in the current window
		int maxLen = 0;  // To store the maximum length of the valid substring

		while (j < s.length()) {
		    // Add the current character at position 'j' to the map (expanding the window)
		    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

		    // Check if the current window has more unique characters than its size (which is invalid)
		    while (map.size() < j - i + 1) { 
		        // If the window is invalid (too many characters), shrink it from the left by moving 'i'
		        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);  // Decrease the frequency of the character at 'i'
		        
		        // If the frequency of a character becomes zero, remove it from the map
		        if (map.get(s.charAt(i)) == 0) {
		            map.remove(s.charAt(i));
		        }
		        // Move the left pointer to the right, shrinking the window
		        i++;
		    }

		    // If the window is valid (unique characters match the window size), check for the maximum length
		    if (map.size() == j - i + 1) {
		        maxLen = Math.max(maxLen, j - i + 1);  // Update maxLen with the largest valid window size
		    }

		    // Move the right pointer to expand the window
		    j++;
		}

		return maxLen;  // Return the maximum length of the substring foun
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("pwwkew")); 
	}

}
