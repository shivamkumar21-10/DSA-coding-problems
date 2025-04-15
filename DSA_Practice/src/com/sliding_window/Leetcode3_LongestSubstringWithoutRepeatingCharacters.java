package com.sliding_window;

import java.util.HashMap;

public class Leetcode3_LongestSubstringWithoutRepeatingCharacters {
    
    public static int lengthOfLongestSubstring(String s) {
        
        int i = 0; // Left pointer (start of the sliding window)
        int j = 0; // Right pointer (end of the sliding window)
        HashMap<Character, Integer> map = new HashMap<>();  // Map to store the frequency of characters in the window
        int maxLen = 0;  // Variable to track the maximum length of a valid substring

        /**
         * Intuition:
         * - We use the **Sliding Window technique** to find the longest substring without repeating characters.
         * - The **right pointer (j)** expands the window, adding characters one by one.
         * - If a character is repeated, the **left pointer (i)** shrinks the window until it's valid again.
         * - We maintain a **HashMap** to keep track of the character frequencies.
         * - The longest valid window found is stored in `maxLen`.
         * - The goal is to ensure the window always has **unique characters** (no duplicates).
         * 
         * Time Complexity: **O(N)** (Each character is added & removed from the map at most once)
         * Space Complexity: **O(min(N, 26)) = O(1)** (Since the map stores at most 26 lowercase English letters)
         */

        while (j < s.length()) { // Expand the window by moving 'j' (right pointer)
            char currentChar = s.charAt(j); 
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1); // Add current char to the map

            // If the map size is smaller than the window size, it means there are duplicate characters.
            while (map.size() < j - i + 1) { // Shrink the window if there are repeating characters
                char leftChar = s.charAt(i); // Get character at 'i'
                
                // Decrease frequency of the leftmost character in the window
                map.put(leftChar, map.get(leftChar) - 1);

                // If frequency of the leftmost character becomes 0, remove it from the map
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                
                i++; // Move left pointer to shrink the window
            }

            // If the window contains unique characters (valid window), update max length
            if (map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++; // Expand the window by moving 'j' to the right
        }

        return maxLen;  // Return the maximum length of the valid substring found
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew")); // Expected output: 3 ("wke" or "kew")
    }
}

/**
 * Dry Run Example:
 * 
 * Input: "pwwkew"
 * 
 * Step-by-step window expansion & shrinking:
 * 
 * i=0, j=0: "p"  → map={p:1} → Valid → maxLen=1
 * i=0, j=1: "pw" → map={p:1, w:1} → Valid → maxLen=2
 * i=0, j=2: "pww" → map={p:1, w:2} → Invalid (duplicate 'w') → Shrink window
 * i=1, j=2: "ww" → map={w:2} → Still Invalid → Shrink again
 * i=2, j=2: "w" → map={w:1} → Valid → maxLen remains 2
 * i=2, j=3: "wk" → map={w:1, k:1} → Valid → maxLen=2
 * i=2, j=4: "wke" → map={w:1, k:1, e:1} → Valid → maxLen=3
 * i=2, j=5: "wkew" → map={w:2, k:1, e:1} → Invalid → Shrink window
 * i=3, j=5: "kew" → map={k:1, e:1, w:1} → Valid → maxLen remains 3
 * 
 * Output: 3 ("wke" or "kew")
 */
