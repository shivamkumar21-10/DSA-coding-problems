package com.misc;

public class Leetcode299_BullsandCows {
	class Solution {
	    public String getHint(String secret, String guess) {
	        // Frequency array to keep track of counts for digits (0-9) in both `secret` and `guess`.
	        int[] freq = new int[10]; 

	        // Initialize variables for counting bulls and cows.
	        int bulls = 0; 
	        int cows = 0;

	        // Loop through each character in the `secret` and `guess` strings.
	        for (int i = 0; i < guess.length(); i++) {
	            // Convert the characters from `secret` and `guess` at the current index to numeric values.
	            int s = Character.getNumericValue(secret.charAt(i));
	            int g = Character.getNumericValue(guess.charAt(i));

	            // If the current digit in `secret` matches the digit in `guess` at the same index:
	            if (s == g) {
	                // Increment the count of bulls (exact matches in both digit and position).
	                bulls++;
	            } else {
	                // If the current digit in `secret` was guessed previously but in a different position:
	                // This means the frequency of `s` in `freq` is negative, as it was decremented when encountered in `guess`.
	                if (freq[s] < 0) {
	                    cows++; // Increment cows as `s` is found as a valid match in `guess`.
	                }

	                // If the current digit in `guess` was found previously in `secret` but in a different position:
	                // This means the frequency of `g` in `freq` is positive, as it was incremented when encountered in `secret`.
	                if (freq[g] > 0) {
	                    cows++; // Increment cows as `g` is found as a valid match in `secret`.
	                }

	                // Update the frequency array:
	                // Increment the frequency of the digit `s` from `secret` (indicating it was seen but not matched yet).
	                freq[s]++;
	                // Decrement the frequency of the digit `g` from `guess` (indicating it was guessed but not matched yet).
	                freq[g]--;
	            }
	        }

	        // Construct the result string in the format "xAyB", where `x` is the number of bulls, and `y` is the number of cows.
	        return bulls + "A" + cows + "B";
	    }
	}


}
