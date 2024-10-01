package com.binary_search;

public class leetcode875_koko_eating_bananas {

	    // Helper method to calculate the sum of division results
	    // The method takes an array of numbers and a divisor (n)
	    // For each element in the array, it computes the ceiling of division (to ensure that each pile is completely eaten)
	    private static int divisorSum(int[] nums, int n) {
	        int sum = 0;
	        for (int i = 0; i < nums.length; i++) {
	            sum += Math.ceil((double) nums[i] / (double) n);  // Calculate the ceiling of the division and accumulate
	        }
	        return sum;  // Return the total number of hours required
	    }

	    // Main method to find the minimum eating speed
	    public static  int minEatingSpeed(int[] piles, int h) {
	        int n = piles.length;

	        // Find the maximum pile size to set an upper limit for binary search
	        int maxi = -1;
	        for (int i = 0; i < n; i++) {
	            maxi = Math.max(piles[i], maxi);
	        }

	        // Set the range for binary search: from 1 to the maximum pile size
	        int low = 1;
	        int high = maxi;

	        // Perform binary search to find the optimal eating speed
	        while (low <= high) {
	            int mid = (low + high) / 2;  // Calculate the middle value as the current eating speed

	            int sum = divisorSum(piles, mid);  // Calculate the total hours needed if eating speed is mid

	            // If the total hours required is less than or equal to the available hours (h)
	            if (sum <= h) {
	                // We try to lower the eating speed to see if there's a smaller valid speed
	                high = mid - 1;
	            } else {
	                // If the total hours required is more than the available hours, increase the speed
	                low = mid + 1;
	            }
	        }
	        return low;  // The minimum valid eating speed found
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = new int[]{3,6,7,11};
		int h =8;
		System.out.println(minEatingSpeed(piles, h));

	}

}
