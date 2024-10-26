package com.sliding_window;

public class Leetcode209_MinimumSizeSubarraySum {
	
	    public static int minSubArrayLen(int target, int[] nums) {
	        int i = 0; // Left pointer (start of the sliding window)
	        int j = 0; // Right pointer (end of the sliding window)
	        int minLen = Integer.MAX_VALUE; // Variable to store the minimum length of the valid subarray
	        int sum = 0; // Variable to keep track of the current sum of elements in the window

	        // Loop through the array with the right pointer `j`
	        while (j < nums.length) {
	            // Add the current element to the sum as we expand the window
	            sum += nums[j];

	            // Shrink the window from the left while the sum is greater than or equal to the target
	            while (sum >= target) {
	                // Update the minimum length if the current window size is smaller
	                minLen = Math.min(minLen, j - i + 1);

	                // Subtract the element at index `i` (left pointer) from the sum to shrink the window
	                sum -= nums[i];

	                // Move the left pointer `i` to the right to further reduce the window size
	                i++;
	            }

	            // Move the right pointer `j` to the right to continue expanding the window
	            j++;
	        }

	        // If no valid subarray is found (minLen was never updated), return 0
	        // Otherwise, return the minimum length of the valid subarray
	        return minLen == Integer.MAX_VALUE ? 0 : minLen;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[] {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, arr));
	}

}
