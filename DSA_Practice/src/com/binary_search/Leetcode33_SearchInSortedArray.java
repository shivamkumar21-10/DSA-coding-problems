package com.binary_search;

public class Leetcode33_SearchInSortedArray {
	
	    public static int search(int[] nums, int k) {
	        int start = 0;  // Start of the search range
	        int end = nums.length - 1;  // End of the search range

	        // Binary search to find the target value 'k'
	        while (start <= end) {
	            int mid = (start + end) / 2;  // Calculate mid index

	            // If the middle element is equal to the target, return its index
	            if (nums[mid] == k) {
	                return mid;
	            }

	            // Determine which half of the array is sorted
	            // Case 1: The left half (from start to mid) is sorted
	            if (nums[start] <= nums[mid]) {
	                // Check if 'k' lies within the sorted left half
	                if (nums[start] <= k && k <= nums[mid]) {
	                    end = mid - 1;  // Target must be in the left half, adjust end
	                } else {
	                    start = mid + 1;  // Target must be in the right half, adjust start
	                }
	            }
	            // Case 2: The right half (from mid to end) is sorted
	            else if (nums[mid] <= nums[end]) {
	                // Check if 'k' lies within the sorted right half
	                if (nums[mid] <= k && k <= nums[end]) {
	                    start = mid + 1;  // Target must be in the right half, adjust start
	                } else {
	                    end = mid - 1;  // Target must be in the left half, adjust end
	                }
	            }
	        }
	        // If we exit the loop, it means 'k' was not found
	        return -1;
	    }
	    
	    public static void main(String[] args) {
			int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
			System.out.println(search(nums,0));
		}
}


