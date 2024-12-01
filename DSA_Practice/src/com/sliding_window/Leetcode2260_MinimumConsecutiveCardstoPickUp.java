package com.sliding_window;

import java.util.HashMap;

public class Leetcode2260_MinimumConsecutiveCardstoPickUp {
	
	    public int minimumCardPickup(int[] cards) {
	        // Initialize the answer variable with a very large value (infinity equivalent).
	        // This is to ensure that any valid result (smaller than infinity) will replace it.
	        int ans = Integer.MAX_VALUE;
	        
	        // Use a HashMap to store the last seen index of each card.
	        // The key is the card value, and the value is the last index where the card was found.
	        HashMap<Integer, Integer> map = new HashMap<>();

	        // Iterate through the array of cards using index `j`.
	        for (int j = 0; j < cards.length; j++) {
	            // Check if the current card (cards[j]) has been seen before by looking it up in the map.
	            if (map.containsKey(cards[j])) {
	                // If the card has been seen before, calculate the window size.
	                // This is done by subtracting the index of the last occurrence (from the map) 
	                // from the current index `j` and adding 1 (since the range is inclusive).
	                ans = Math.min(ans, j - map.get(cards[j]) + 1);
	                // Update `ans` to hold the minimum value between itself and the current window size.
	            }
	            
	            // Update or insert the current card's last seen index in the map.
	            // This ensures that the map always reflects the most recent occurrence of the card.
	            map.put(cards[j], j);
	        }

	        // If no duplicates were found (i.e., ans is still Integer.MAX_VALUE), return -1.
	        // Otherwise, return the minimum window size stored in `ans`.
	        return ans == Integer.MAX_VALUE ? -1 : ans;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
