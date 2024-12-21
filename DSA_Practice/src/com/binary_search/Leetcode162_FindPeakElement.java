package com.binary_search;

public class Leetcode162_FindPeakElement {
		    /**
	     * Function to find a peak element in the array.
	     * A peak element is defined as an element that is strictly greater than its neighbors.
	     * 
	     * @param nums The input array of integers.
	     * @return The index of any one peak element.
	     */
	    public int findPeakElement(int[] nums) {
	        int n = nums.length; // Length of the input array.

	        // **Edge Case 1**: If the array contains only one element, that element is trivially a peak.
	        if (n == 1)
	            return 0;

	        // **Edge Case 2**: Check if the first element is a peak.
	        // The first element is a peak if it's greater than the second element.
	        if (nums[0] > nums[1])
	            return 0;

	        // **Edge Case 3**: Check if the last element is a peak.
	        // The last element is a peak if it's greater than the second-to-last element.
	        if (nums[n - 1] > nums[n - 2])
	            return n - 1;

	        // **Binary Search Initialization**:
	        // We only need to check the middle part of the array since the edges are already handled.
	        // Start the binary search between index 1 and n-2 (inclusive), as the first and last elements are excluded.
	        int low = 1;
	        int high = n - 2;

	        // **Binary Search Loop**:
	        // The loop continues until the `low` pointer crosses the `high` pointer.
	        while (low <= high) {
	            // Calculate the middle index.
	            int mid = (low + high) / 2;

	            /**
	             * **Case 1**: The middle element is a peak.
	             * - This happens if the element at `mid` is strictly greater than both its neighbors:
	             *   `nums[mid] > nums[mid - 1]` and `nums[mid] > nums[mid + 1]`.
	             * - If this condition is true, return the `mid` index as the peak element.
	             */
	            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
	                return mid;
	            }

	            /**
	             * **Case 2**: The right neighbor of `mid` is greater than `nums[mid]`.
	             * - If `nums[mid + 1] > nums[mid]`, it means there is a potential peak on the right side.
	             * - Move the `low` pointer to `mid + 1` to search in the right half of the array.
	             * - This works because if the slope is increasing, there must be a peak eventually.
	             */
	            if (nums[mid + 1] > nums[mid]) {
	                low = mid + 1;
	            }

	            /**
	             * **Case 3**: The left neighbor of `mid` is greater than `nums[mid]`.
	             * - If `nums[mid - 1] > nums[mid]`, it means there is a potential peak on the left side.
	             * - Move the `high` pointer to `mid - 1` to search in the left half of the array.
	             * - This works because if the slope is decreasing, there must be a peak eventually.
	             */
	            else if (nums[mid - 1] > nums[mid]) {
	                high = mid - 1;
	            }
	        }

	        // Return -1 if no peak is found (this case should never occur as the input is guaranteed to have a peak).
	        return -1;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
