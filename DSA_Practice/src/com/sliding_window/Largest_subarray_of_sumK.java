package com.sliding_window;

public class Largest_subarray_of_sumK {
	
	public static int subarraySum(int[] nums, int k) {
	    int i = 0; // Left pointer of the window
	    int j = 0; // Right pointer of the window
	    int sum = 0; // Tracks the cumulative sum of the current window
	    int maxLen = Integer.MIN_VALUE;

	    // Iterate through the array using the right pointer (j)
	    while (j < nums.length) {
	        // Add the current element to the cumulative sum
	        sum += nums[j];
	        
	        // While the cumulative sum is greater than k, shrink the window from the left (i)
	        while (sum > k && i <= j) {
	            sum -= nums[i]; // Remove the element at the left of the window
	            i++; // Move the left pointer to the right
	        }

	        // If the current window's sum equals k, increment the count
	        if (sum == k) 
	            maxLen = Math.max(j-i+1, maxLen);	        

	        // Move the right pointer to expand the window
	        j++;
	    }

	    // Return the total number of subarrays whose sum equals k
	    return maxLen;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {4,1,1,1,1,2,3,5};
		System.out.println(subarraySum(arr,5));
	}

}
