package com.binary_search;

public class Leetcode81_SearchinRotatedSortedArrayII {
	
	class Solution {
	    public boolean search(int[] nums, int k) {
	        int start = 0;
	        int end = nums.length - 1;

	        while (start <= end) {
	            int mid = (start + end) / 2;

	            // Check if the middle element is equal to the target 'k'.
	            // If yes, we've found the target and return true.
	            if (nums[mid] == k) {
	                return true;
	            }

	            // If the elements at 'start', 'mid', and 'end' are the same,
	            // it indicates that we cannot determine the sorted half clearly.
	            // In such a case, increment 'start' and decrement 'end' to
	            // reduce the ambiguity without breaking the logic.
	            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
	                start = start + 1;
	                end = end - 1;
	                continue; // Skip to the next iteration since no more checks can be made.
	            }

	            // Check if the left half (from 'start' to 'mid') is sorted.
	            // This condition is true if the element at 'start' is less than or equal to the element at 'mid'.
	            if (nums[start] <= nums[mid]) {
	                // If the target 'k' lies within this sorted left half,
	                // update 'end' to search only in this range.
	                if (nums[start] <= k && k <= nums[mid]) {
	                    end = mid - 1;
	                } else {
	                    // Otherwise, move the 'start' pointer to search in the other half.
	                    start = mid + 1;
	                }
	            } 
	            // If the left half is not sorted, it means the right half (from 'mid' to 'end') must be sorted.
	            else if (nums[mid] <= nums[end]) {
	                // Check if the target 'k' lies within this sorted right half.
	                // If yes, update 'start' to search only in this range.
	                if (nums[mid] <= k && k <= nums[end]) {
	                    start = mid + 1;
	                } else {
	                    // Otherwise, move the 'end' pointer to search in the other half.
	                    end = mid - 1;
	                }
	            }
	        }

	        // If the loop exits without returning, it means the target 'k'
	        // is not present in the array. Return false in this case.
	        return false;
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
