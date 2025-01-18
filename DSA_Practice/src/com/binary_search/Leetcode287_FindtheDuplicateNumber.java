package com.binary_search;

public class Leetcode287_FindtheDuplicateNumber {

	    public int findDuplicate(int[] nums) {
	        int n = nums.length; // Length of the input array, which is n + 1 (since numbers are in [1, n])
	        
	        // Define the search space for binary search: [low, high]
	        int low = 0; // Start of the range
	        int high = n - 1; // End of the range (n-1 because nums has n+1 elements)
	        int cnt; // Variable to store the count of elements <= mid in the array

	        // Perform binary search
	        while (low <= high) {
	            // Find the middle point of the current search space
	            int mid = (low + high) / 2;

	            // Count the numbers in the array that are less than or equal to mid
	            cnt = 0;
	            for (int num : nums) {
	                if (num <= mid) {
	                    cnt++;
	                }
	            }

	            /*
	             * Intuition:
	             * - If there were no duplicates, the count of numbers <= mid should be at most mid.
	             * - If count (cnt) > mid, it means more numbers than expected are in the range [1, mid],
	             *   so the duplicate must be in this range. Adjust the high pointer to mid - 1.
	             * - Otherwise, if count <= mid, the duplicate must be in the range [mid + 1, n].
	             */
	            if (cnt <= mid) {
	                low = mid + 1; // Move to the right half
	            } else {
	                high = mid - 1; // Move to the left half
	            }
	        }

	        /*
	         * At the end of the loop, the low pointer will converge to the duplicate number.
	         * This is because we narrow down the range where the duplicate exists in every iteration.
	         */
	        return low; // Return the duplicate number
	    }
	


}
