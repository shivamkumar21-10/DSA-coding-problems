package com.sliding_window;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

    // Function to find the length of the longest substring with exactly K unique characters
    public static int Kunique(String s, int k) {
        // Initialize two pointers for the sliding window
        int i = 0;  // 'i' is the left pointer
        int j = 0;  // 'j' is the right pointer
        
        // A HashMap to store the frequency of characters in the current window
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Variable to store the maximum length of the substring with exactly K unique characters
        int maxLen = -1;
        
        // Start iterating over the string with the right pointer 'j'
        while (j < s.length()) {
            // Add the character at index 'j' to the map and increase its frequency count
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            // If the size of the map exceeds 'k', reduce the window size from the left
            // The map size represents the number of unique characters in the current window
            while (map.size() > k) {
                // Decrease the frequency of the character at index 'i' (left pointer)
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);                
                // If the frequency becomes zero, remove the character from the map
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }               
                // Move the left pointer 'i' to the right to reduce the window size
                i++;
            }
            
            // If the map size is exactly 'k', check if the current window length is the largest so far
            if (map.size() == k) {
                // Calculate the window length (j - i + 1) and update the maxLen if it's larger
                maxLen = Math.max(maxLen, j - i + 1);
            }
            
            // Move the right pointer 'j' to the next position to expand the window
            j++;
        }
        
        // Return the maximum length of the substring with exactly 'k' unique characters
        return maxLen;
    }
    public static void main(String[] args) {
        int ans = Kunique("aabacbebebe", 3);       
        System.out.println(ans);  // Expected Output: 7
    }

}
