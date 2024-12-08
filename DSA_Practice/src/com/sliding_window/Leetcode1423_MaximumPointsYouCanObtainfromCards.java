package com.sliding_window;

public class Leetcode1423_MaximumPointsYouCanObtainfromCards {
	

	    public int maxScore(int[] cardScore, int k) {
	        // Initialize three variables:
	        // lsum: This keeps track of the sum of elements from the left (beginning of the array).
	        // rsum: This keeps track of the sum of elements from the right (end of the array).
	        // msum: This stores the maximum score we can achieve by choosing k cards optimally.
	        int lsum = 0;
	        int rsum = 0;
	        int msum = 0;

	        // Step 1: Calculate the initial sum of the first k cards from the left.
	        // Since we're picking cards from either the left or right, we start by taking all k cards from the left.
	        // This will act as the initial maximum score (msum) because we haven't included cards from the right yet.
	        for (int i = 0; i < k; i++) {
	            lsum += cardScore[i]; // Add each of the first k elements to lsum.
	        }

	        // At this point, lsum contains the sum of the first k cards.
	        // Set msum to lsum as the starting point because it's the best score we have at this stage.
	        msum = lsum;

	        // Step 2: Use a sliding window approach to explore combinations of taking cards from the left and the right.
	        // We'll progressively replace cards from the left (reducing lsum) with cards from the right (increasing rsum)
	        // and update msum if the new sum (lsum + rsum) is larger.
	        int rightIndex = cardScore.length - 1; // Start from the last card for the right side.

	        // Loop backward through the first k cards. This ensures we progressively take fewer cards from the left.
	        for (int i = k - 1; i >= 0; i--) {
	            // Subtract the value of the current left-side card from lsum.
	            // This simulates "giving up" this card from the left side.
	            lsum -= cardScore[i];

	            // Add the value of the current right-side card to rsum.
	            // This simulates "adding" this card from the right side.
	            rsum += cardScore[rightIndex--]; // Decrement rightIndex to move toward the left.

	            // Calculate the total score from the current combination of left and right cards.
	            // Compare this score with the maximum score so far (msum) and update msum if this score is greater.
	            msum = Math.max(msum, lsum + rsum);
	        }

	        // Step 3: Return the maximum score obtained after exploring all possible combinations.
	        // By the end of the loop, msum will contain the highest possible score achievable by taking k cards
	        // from either end of the array.
	        return msum;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
