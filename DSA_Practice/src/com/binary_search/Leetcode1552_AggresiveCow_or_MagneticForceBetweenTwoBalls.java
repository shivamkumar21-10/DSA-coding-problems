package com.binary_search;

import java.util.Arrays;

public class Leetcode1552_AggresiveCow_or_MagneticForceBetweenTwoBalls {

	    // Helper method to determine if it's possible to place 'balls' with at least 'dist' distance between each
	    public static boolean possible(int[] nums, int dist, int balls) {
	        int currpos = nums[0]; // Place the first ball at the first position in the array
	        int cnt = 1; // We have placed one ball so far

	        // Iterate through the positions array to try and place the remaining balls
	        for (int i = 1; i < nums.length; i++) {
	            // If the distance between current position and last placed ball position is >= 'dist'
	            if (nums[i] - currpos >= dist) {
	                cnt++; // Place a ball at this position
	                currpos = nums[i]; // Update the last placed position
	            }

	            // If we have placed enough balls, return true
	            if (cnt >= balls) {
	                return true;
	            }
	        }

	        // If not able to place all balls, return false
	        return false;
	    }

	    // Main method to find the maximum possible minimum distance between balls
	    public static int maxDistance(int[] nums, int k) {
	        Arrays.sort(nums); // Sort the positions array to apply binary search logic

	        int low = 0; // Minimum possible distance between any two balls
	        int high = nums[nums.length - 1]; // Maximum possible distance based on sorted array
	        int ans = -1; // Variable to store the final answer

	        // Binary search to find the largest minimum distance
	        while (low <= high) {
	            int mid = (low + high) / 2; // Calculate the middle distance

	            // Check if it's possible to place all 'k' balls with at least 'mid' distance between them
	            if (possible(nums, mid, k)) {
	                ans = mid; // Update the answer
	                low = mid + 1; // Try for a larger minimum distance
	            } else {
	                high = mid - 1; // Try for a smaller minimum distance
	            }
	        }

	        return high; // Return the largest possible minimum distance
	    }
	    
	    public static void main(String[] args) {
			int [] nums = new int[] {0, 3, 4, 7, 10, 9};
			System.out.println(maxDistance(nums,4));
	    }
}

