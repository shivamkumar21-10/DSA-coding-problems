package com.binary_search;
import java.util.Arrays;

public class Leetcode475_Heater {
	
	

	    /**
	     * This method checks if it is possible to cover all the houses with a given radius 'mid'.
	     *
	     * Explanation:
	     * - For each heater, we calculate its effective range using the radius 'mid'.
	     * - A heater can cover houses within the range [heater - mid, heater + mid].
	     * - Using a while loop, we check if the current heater can cover houses one by one.
	     * - If all houses are covered by the end of the loop, we return true. Otherwise, false.
	     *
	     * @param mid     the radius being tested
	     * @param houses  array of house positions
	     * @param heaters array of heater positions
	     * @return true if all houses can be covered with the given radius, false otherwise
	     */
	    public boolean isPossible(int mid, int[] houses, int[] heaters) {
	        int house = 0; // Pointer to track the current house in the 'houses' array

	        // Iterate through each heater
	        for (int i = 0; i < heaters.length; i++) {
	            // Calculate the range that this heater can cover
	            int left = heaters[i] - mid;   // Left boundary of the heater's range
	            int right = heaters[i] + mid; // Right boundary of the heater's range

	            // Use the while loop to check if the current heater covers houses within its range
	            while (house < houses.length && left <= houses[house] && houses[house] <= right) {
	                house++; // Move to the next house if it's within the range
	            }
	        }

	        // If we have covered all houses, return true; otherwise, false
	        return house >= houses.length;
	    }

	    /**
	     * This method finds the minimum radius required for heaters to cover all houses.
	     *
	     * Explanation:
	     * - The radius must be at least 0 and can go up to the maximum position of houses or heaters.
	     * - We use binary search to find the smallest radius:
	     *   1. Start with 'low' as 0 and 'high' as the maximum position.
	     *   2. For each 'mid' value (potential radius), use 'isPossible' to check if all houses can be covered.
	     *   3. If it's possible, reduce the radius by moving 'high' to mid - 1.
	     *   4. If not, increase the radius by moving 'low' to mid + 1.
	     * - The answer is stored in 'ans', which holds the smallest radius that works.
	     *
	     * @param houses  array of house positions
	     * @param heaters array of heater positions
	     * @return the minimum radius required to cover all houses
	     */
	    public int findRadius(int[] houses, int[] heaters) {
	        // Sort both arrays to make it easier to determine which heater covers which house
	        Arrays.sort(houses);
	        Arrays.sort(heaters);

	        int low = 0; // Minimum possible radius
	        int high = Math.max(
	            Arrays.stream(houses).max().getAsInt(),
	            Arrays.stream(heaters).max().getAsInt()
	        ); // Maximum possible radius, based on the farthest house or heater

	        int ans = 0; // Variable to store the result (smallest valid radius)

	        // Binary search for the smallest radius
	        while (low <= high) {
	            int mid = (low + high) / 2; // Middle point (potential radius)

	            // Check if all houses can be covered with the radius 'mid'
	            if (isPossible(mid, houses, heaters)) {
	                ans = mid;     // Update the answer since this radius works
	                high = mid - 1; // Try to find a smaller radius
	            } else {
	                low = mid + 1; // Increase the radius if it's not sufficient
	            }
	        }
	        return ans; // Return the smallest radius that works
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
