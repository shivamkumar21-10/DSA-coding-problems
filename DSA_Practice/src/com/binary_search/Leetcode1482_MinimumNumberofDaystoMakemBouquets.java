package com.binary_search;

public class Leetcode1482_MinimumNumberofDaystoMakemBouquets {

	    // Helper function to determine if it's possible to make 'm' bouquets with 'k' flowers each,
	    // given the maximum bloom day allowed is 'x'.
	    public static boolean possible(int[] nums, int x, int k, int m) {
	        int count = 0;  // Counter to track consecutive flowers available for a bouquet

	        // Iterate through the bloomDay array
	        for (int i = 0; i < nums.length; i++) {
	            // If the bloom day is within the allowed limit 'x', increase the count
	            if (nums[i] <= x) {
	                count++;
	            } else {
	                count = 0;  // Reset the count if the bloom day exceeds the limit
	            }

	            // If we have enough flowers for one bouquet (count == k)
	            if (count == k) {
	                m--;  // Decrease the number of bouquets we need to make
	                count = 0;  // Reset the count for the next bouquet
	            }

	            // If we have successfully made all required bouquets, return true
	            if (m == 0) {
	                return true;
	            }
	        }
	        // Return false if it's not possible to make 'm' bouquets
	        return false;
	    }

	    // Main function to find the minimum number of days required to make 'm' bouquets with 'k' flowers each
	    public static int minDays(int[] bloomDay, int m, int k) {
	        int n = bloomDay.length;

	        // If there are not enough flowers to make 'm' bouquets, return -1
	        if (n < (m * k)) return -1;

	        // Find the maximum bloom day to set the search range for binary search
	        int maxi = -1;
	        for (int i = 0; i < n; i++) {
	            maxi = Math.max(bloomDay[i], maxi);
	        }

	        // Set the range for binary search: from day 1 to the maximum bloom day
	        int low = 1;
	        int high = maxi;
	        int ans = -1;

	        // Binary search to find the minimum number of days needed
	        while (low <= high) {
	            int mid = (low + high) / 2;  // Calculate the middle value as the current number of days

	            // Check if it is possible to make 'm' bouquets in 'mid' days
	            if (possible(bloomDay, mid, k, m) == true) {
	                ans = mid;  // If possible, store the answer
	                high = mid - 1;  // Try to find a smaller number of days by reducing the range
	            } else {
	                low = mid + 1;  // If not possible, increase the number of days
	            }
	        }
	        return ans;  // Return the minimum number of days required
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {7, 7, 7, 7, 13, 11, 12, 7};
		int m = 2;
		int k = 3;
		
		System.out.println(minDays(nums,m,k));

	}

}
