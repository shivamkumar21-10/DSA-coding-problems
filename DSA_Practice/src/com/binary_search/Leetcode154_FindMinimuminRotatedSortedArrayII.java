package com.binary_search;

public class Leetcode154_FindMinimuminRotatedSortedArrayII {
	
	    public int findMin(int[] nums) {
	        // Initialize pointers for the binary search
	        int low = 0; // Start of the array
	        int high = nums.length - 1; // End of the array

	        // Perform binary search to find the minimum element
	        while (low < high) {
	            // Calculate the middle index to split the search space
	            int mid = low + (high - low) / 2;

	            /*
	             * Intuition:
	             * - The rotated sorted array has two parts:
	             *   (a) A strictly increasing left part.
	             *   (b) A rotated smaller right part.
	             * - The minimum element is always located in the unsorted or rotated portion.
	             * - By comparing nums[mid] with nums[high], we can determine which part contains the minimum:
	             *   (i) If nums[mid] < nums[high], it means the minimum is in the left part (including mid).
	             *   (ii) If nums[mid] > nums[high], the minimum is in the right part (excluding mid).
	             *   (iii) If nums[mid] == nums[high], we cannot determine the part, so reduce high to eliminate duplicates.
	             */

	            if (nums[mid] < nums[high]) {
	                // Case 1: The right half (from mid to high) is sorted, so the minimum must be in the left part.
	                high = mid; // Include mid in the next search
	            } 
	            else if (nums[mid] > nums[high]) {
	                // Case 2: The left half (from low to mid) is sorted, so the minimum must be in the right part.
	                low = mid + 1; // Exclude mid from the next search
	            } 
	            else {
	                // Case 3: nums[mid] == nums[high]
	                // This means duplicates exist, so we reduce high to shrink the search space.
	                high--;
	            }
	        }

	        /*
	         * At the end of the loop, low == high.
	         * Both pointers converge on the index of the minimum element.
	         */
	        return nums[low];
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
