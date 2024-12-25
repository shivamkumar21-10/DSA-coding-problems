package com.greedy;

import java.util.*;

public class Leetcode2410_MaximumMatchingofPlayersWithTrainers {
	

	    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
	        // Sort both players and trainers arrays in ascending order
	        // Sorting ensures we can use a greedy approach to find the best match
	        Arrays.sort(players);
	        Arrays.sort(trainers);

	        // Initialize two pointers for players and trainers
	        int i = 0, j = 0;


	        // Iterate through both arrays as long as we haven't exhausted one of them
	        while (i < players.length && j < trainers.length) {
	            // If the current trainer's capacity can satisfy the current player's requirement
	            if (players[i] <= trainers[j]) {
	                // A match is found, increment both pointers to check the next player and trainer
	                i++;
	                j++;
	            } else {
	                // If the current trainer can't satisfy the player's requirement,
	                // move to the next trainer (because trainers are sorted and 
	                // the next one might have a higher capacity)
	                j++;
	            }
	        }

	        // Return the total number of successful matches
	        return i;
	        
	      //overall time complexity - O(NlogN + MlogM + M) - N length of players array, M - length of trainers array
	        //space complexity - O(1)
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
