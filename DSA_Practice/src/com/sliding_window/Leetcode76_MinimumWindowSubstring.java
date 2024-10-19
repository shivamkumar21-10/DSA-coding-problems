package com.sliding_window;

import java.util.HashMap;

public class Leetcode76_MinimumWindowSubstring {
	
	    public static String minWindow(String s, String t) {
	        int i = 0; // Left pointer for the sliding window
	        int j = 0; // Right pointer for the sliding window
	        int ans = Integer.MAX_VALUE; // Variable to store the length of the smallest valid window
	        String res = ""; // Variable to store the result (the minimum window substring)
	        HashMap<Character, Integer> map = new HashMap<>(); // HashMap to track the required character frequencies from `t`
	        // Step 1: Initialize the frequency map with characters from `t`
	        // The map stores how many times each character from `t` must appear in the window
	        for (int z = 0; z < t.length(); z++) {
	            Character x = t.charAt(z);
	            map.put(x, map.getOrDefault(x, 0) + 1); // Add characters to the map or increment their count
	        }
	        int cnt = map.size(); // `cnt` stores the number of distinct characters that still need to be fully matched
	        // Step 2: Expand the sliding window by moving the right pointer `j`
	        while (j < s.length()) {
	            Character c = s.charAt(j);	            
	            // If the character at position `j` is in `t`, reduce its count in the map
	            if (map.containsKey(c)) {
	                map.put(c, map.get(c) - 1);	             
	                // Once the count of a character becomes 0, it means this character is fully matched
	                if (map.get(c) == 0) {
	                    cnt--; // Decrease `cnt` to indicate one less character needs to be matched
	                }
	            }
	            // Step 3: When all characters from `t` are matched (i.e., `cnt == 0`), try to shrink the window
	            while (cnt == 0) {
	                // If the current window size (j - i + 1) is smaller than the previously found window
	                // Update the result (`res`) and the minimum window length (`ans`)
	                if (j - i + 1 < ans) {
	                    ans = j - i + 1; // Update the minimum window length
	                    res = s.substring(i, j + 1); // Update the result with the current minimum window
	                }
	                // Step 4: Try to shrink the window from the left by moving the left pointer `i`
	                Character p = s.charAt(i);	                
	                // If the character at position `i` is in `t`, increase its count in the map
	                // since it is going out of the window
	                if (map.containsKey(p)) {
	                    map.put(p, map.get(p) + 1);	                    
	                    // If the count of a character becomes positive, it means the window no longer contains enough
	                    // of this character, so we need to expand the window again
	                    if (map.get(p) > 0) {
	                        cnt++; // Increase `cnt` because we need this character again
	                    }
	                }
	                // Move the left pointer to the right to shrink the window
	                i++;
	            }
	            // Move the right pointer to expand the window
	            j++;}
	        }

	        // Step 5: Return the result (the minimum window substring), or an empty string if no valid window is found
	        return res;
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC","ABC"));
	}

}
