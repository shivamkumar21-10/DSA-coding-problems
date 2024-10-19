package com.sliding_window;

import java.util.HashMap;

public class PickToys {
    
    // Method to find the maximum number of toys (represented as characters) that can be picked, 
    // with the condition that only 2 types of toys can be picked at once.
    public static int totalToys(String s) {
        int i = 0; // Left pointer to define the start of the sliding window
        int j = 0; // Right pointer to define the end of the sliding window
        int ans = 0; // Variable to store the maximum length of valid window (maximum number of toys picked)
        HashMap<Character, Integer> map = new HashMap<>(); // Map to track the frequency of each toy type in the current window

        // Iterate through the string using the right pointer `j`
        while (j < s.length()) {
            // Get the current character (toy) at position `j` and update its frequency in the map
            Character c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // If the window contains more than 2 types of toys, shrink it from the left
            while (map.size() > 2) {
                // Get the character at position `i` (left pointer) and decrease its frequency
                Character p = s.charAt(i);
                map.put(p, map.get(p) - 1);
                
                // If the frequency of a toy becomes zero, remove it from the map
                if (map.get(p) == 0) {
                    map.remove(p);
                }
                // Move the left pointer to the right to shrink the window
                i++;
            }

            // At this point, the window contains at most 2 types of toys
            // Calculate the size of the current valid window and update `ans` if it's larger
            ans = Math.max(ans, j - i + 1);

            // Move the right pointer to expand the window
            j++;
        }

        // Return the maximum number of toys (i.e., the length of the longest valid window)
        return ans;
    }

    public static void main(String[] args) {
        // Example test case: find the maximum number of toys that can be picked from the string
        System.out.println(totalToys("abaccab")); // Output: 4
    }

}
