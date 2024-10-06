package com.binary_search;

public class Leetcoe1011_CapacityToShipPackagesWithinDDays {
	
	    // Helper function to calculate the number of days required
	    // to ship the packages if the ship has a capacity of 'mid'
	    public static int possible(int[] weight, int mid) {
	        int day = 1; // Start with 1 day
	        int load = 0; // Load carried on the current day
	        int n = weight.length;

	        for (int i = 0; i < n; i++) {
	            // If adding the current weight exceeds the capacity, move to the next day
	            if (load + weight[i] > mid) {
	                day += 1; // Increment the number of days required
	                load = weight[i]; // Start a new load with the current weight
	            } else {
	                load += weight[i]; // Add current weight to the current load
	            }
	        }

	        return day; // Return the total number of days needed
	    }

	    // Function to find the minimum ship capacity to ship all weights within 'days'
	    public static int shipWithinDays(int[] weights, int days) {
	        // Initialize the binary search boundaries
	        int start = Integer.MIN_VALUE; // Start should be at least as large as the heaviest package
	        int end = 0; // End will be the sum of all weights

	        // Calculate initial values for start and end
	        for (int i = 0; i < weights.length; i++) {
	            end += weights[i]; // End is the total weight
	            start = Math.max(start, weights[i]); // Start is the heaviest weight in the array
	        }

	        // Binary search to find the minimum capacity
	        while (start <= end) {
	            int mid = (start + end) / 2; // Calculate the mid capacity
	            int day = possible(weights, mid); // Determine the number of days needed for this capacity

	            // If the current capacity can ship within the allowed days, try a smaller capacity
	            if (day <= days) {
	                end = mid - 1; // Decrease the capacity to see if there's a smaller valid solution
	            } else {
	                // Otherwise, increase the capacity
	                start = mid + 1;
	            }
	        }

	        return start; // 'start' will hold the minimum valid ship capacity
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(shipWithinDays(w,5));
	}

}
