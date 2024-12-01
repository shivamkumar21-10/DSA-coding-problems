package com.sliding_window;

public class Leetcode1343_NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold {

	    /**
	     * numOfSubarrays: Finds the count of subarrays of length 'k' with an average
	     * greater than or equal to a given threshold.
	     * 
	     * Approach:
	     * - Uses a sliding window technique to maintain a subarray sum of fixed size 'k'.
	     * - As the window slides over the array, it calculates the average of elements in the window
	     *   and checks if it meets the threshold condition.
	     * 
	     * @param arr       The input array of integers.
	     * @param k         The fixed length of the subarrays to consider.
	     * @param threshold The minimum average value for a valid subarray.
	     * @return The count of subarrays of length 'k' with an average >= threshold.
	     */
	    public int numOfSubarrays(int[] arr, int k, int threshold) {
	        int i = 0;          // Start of the sliding window
	        int j = 0;          // End of the sliding window
	        int ans = 0;        // Variable to store the count of valid subarrays
	        int sum = 0;        // Variable to maintain the sum of the current window

	        // Traverse through the array with the sliding window
	        while (j < arr.length) {
	            // Add the current element to the sum to include it in the window
	            sum += arr[j];

	            // Check if the current window size is equal to 'k'
	            if (j - i + 1 == k) {  // Window size reached
	                // Check if the average of the current window meets the threshold
	                if (sum / k >= threshold) {
	                    ans++;  // Increment count if the condition is satisfied
	                }

	                // Remove the element at the start of the window from 'sum'
	                // to slide the window forward
	                sum -= arr[i];
	                
	                // Move the start of the window forward by one position
	                i++;
	            }
	            // Move the end of the window forward by one position
	            j++;
	        }
	        return ans;  // Return the total count of valid subarrays
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
