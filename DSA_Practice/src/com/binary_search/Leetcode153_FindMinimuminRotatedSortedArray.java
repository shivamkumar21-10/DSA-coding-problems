package com.binary_search;

import java.util.ArrayList;

public class Leetcode153_FindMinimuminRotatedSortedArray {
	
	public static int findMin(int[] nums) {
        int n = nums.length;  // Get the length of the array
        int low = 0;          // Initialize the low pointer
        int high = n - 1;     // Initialize the high pointer

        // Binary search to find the minimum element
        while(low <= high) {
            int mid = low + (high - low) / 2;  // Calculate the mid index to avoid overflow

            // Check if the mid element is the minimum
            // This condition checks if nums[mid] is smaller than both its neighbors
            if(nums[mid] < nums[(mid + 1) % n] && nums[mid] < nums[(mid + n - 1) % n]) {
                return nums[mid];  // nums[mid] is the minimum, return it
            }

            // If the left part of the array is sorted, the minimum must be on the right side
            if(nums[0] <= nums[mid]) {
                low = mid + 1;  // Move low pointer to the right half
            }
            // If the right part of the array is sorted, the minimum must be on the left side
            else if(nums[mid] <= nums[n - 1]) {
                high = mid - 1;  // Move high pointer to the left half
            }
        }
        
        // If the loop finishes without finding the minimum, it means the array was never rotated
        // In that case, the first element is the minimum
        return nums[0];
    }
	
	    // Function to find the minimum element in a rotated sorted array
	    public static int findMin(ArrayList<Integer> nums) {
	        int n = nums.size();  // Get the size of the input array (ArrayList)
	        int low = 0;          // Initialize the low pointer
	        int high = n - 1;     // Initialize the high pointer
	        int ans = Integer.MAX_VALUE;  // Initialize the minimum answer to the maximum possible value

	        // Perform binary search to find the minimum element
	        while (low <= high) {
	            int mid = (low + high) / 2;  // Calculate the mid index

	            // If the left part is sorted (from low to mid), the minimum is in this range
	            if (nums.get(low) <= nums.get(mid)) {
	                ans = Math.min(ans, nums.get(low));  // Update the minimum with the value at low
	                low = mid + 1;  // Move low pointer to the right half
	            }
	            // If the right part is sorted (from mid to high), the minimum is in this range
	            else {
	                ans = Math.min(ans, nums.get(mid));  // Update the minimum with the value at mid
	                high = mid - 1;  // Move high pointer to the left half
	            }
	        }

	        // Return the final minimum value found
	        return ans;
	    }
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {4,5,6,7,0,1,2};  
		ArrayList<Integer> lst = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			lst.add(arr[i]);
		}
		
		//solution in two ways
		System.out.println(findMin(arr));  
		System.out.println(findMin(lst));  
	}

		

}
