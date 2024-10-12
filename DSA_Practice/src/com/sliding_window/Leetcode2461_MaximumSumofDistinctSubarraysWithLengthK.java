package com.sliding_window;
import java.util.HashSet;
public class Leetcode2461_MaximumSumofDistinctSubarraysWithLengthK {
	

	    // Function to find the maximum sum of a subarray of size 'k' with all unique elements
	    public static long maximumSubarraySum(int[] nums, int k) {
	        // Edge case: if the array has fewer elements than 'k', return 0
	        if (nums.length < k) return 0;

	        // i and j are two pointers representing the window
	        int i = 0, j = 0;
	        
	        // Variables to keep track of the current window sum and maximum sum found so far
	        long sum = 0, maxSum = 0;
	        
	        // A set to track unique elements in the current window
	        HashSet<Integer> set = new HashSet<>();

	        // Use a sliding window to iterate through the array
	        while (j < nums.length) {
	            // If the current element is not a duplicate in the window
	            if (!set.contains(nums[j])) {
	                // Add the current element to the set and to the sum
	                set.add(nums[j]);
	                sum += nums[j];

	                // Check if the window has reached size 'k'
	                if (j - i + 1 == k) {
	                    // Update the maximum sum if the current window sum is larger
	                    maxSum = Math.max(maxSum, sum);

	                    // Slide the window forward: remove the element at the start of the window
	                    sum -= nums[i];
	                    set.remove(nums[i]);
	                    i++;  // Move the start of the window forward
	                }
	                // Move the end of the window forward
	                j++;
	            } 
	            // If the current element is a duplicate
	            else {
	                // We move the start of the window forward to remove elements until the duplicate is removed
	                set.remove(nums[i]); // Remove the start element
	                sum -= nums[i];      // Subtract it from the sum
	                i++;                 // Move the start of the window forward
	            }
	        }

	        // Return the maximum sum found for any subarray of size 'k' with unique elements
	        return maxSum;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,5,4,2,9,9,9};
		System.out.println(maximumSubarraySum(arr,3));

	}

}
