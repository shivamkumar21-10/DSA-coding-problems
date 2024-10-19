package com.sliding_window;

import java.util.HashMap;

public class PickToys {
	
    public static int totalToys(String s) {
        int i = 0; // Left pointer (start of the sliding window)
        int j = 0; // Right pointer (end of the sliding window)
        int ans = 0; // Variable to store the maximum number of fruits we can collect
        HashMap<Character, Integer> map = new HashMap<>(); // Map to track the frequency of each type of fruit in the current window

        // Iterate through the array using the right pointer `j`
        while (j < s.length()) {
            // Add the current fruit at position 'j' to the map, increasing its count
        	Character c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // If we have more than 2 different types of fruits, shrink the window from the left
            while (map.size() > 2) {
                // Decrease the frequency of the fruit at position 'i' (left pointer)
            	Character p = s.charAt(i);
                map.put(p, map.get(p)- 1);
                
                // If the count of a fruit becomes zero, remove it from the map
                if (map.get(p) == 0) {
                    map.remove(p);
                }
                // Move the left pointer to the right to reduce the number of fruit types in the window
                i++;
            }

            // At this point, we have at most 2 types of fruits in the window
            // Update the maximum number of fruits we can collect by checking the size of the current valid window
            ans = Math.max(ans, j - i + 1);

            // Move the right pointer to expand the window
            j++;
        }

        // Return the maximum number of fruits we can collect in any valid window
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalToys("abaccab"));

	}

}
