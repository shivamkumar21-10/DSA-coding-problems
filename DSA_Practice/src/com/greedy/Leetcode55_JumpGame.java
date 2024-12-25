package com.greedy;

public class Leetcode55_JumpGame {
	

	    public boolean canJump(int[] nums) {

	        // Initialize a variable to keep track of the farthest index we can reach
	        int maxIdx = 0;

	        // Traverse through the array
	        for (int i = 0; i < nums.length; i++) {

	            // If the current index is greater than the farthest index we can reach,
	            // it means we cannot proceed further, so return false.
	            if (i > maxIdx) return false;

	            // Update the farthest index we can reach by taking the maximum of the current maxIdx
	            // and the sum of the current index and its jump value (nums[i]).
	            maxIdx = Math.max(maxIdx, i + nums[i]);
	        }

	        // If we successfully traverse through the loop without returning false,
	        // it means we can reach the last index. Return true.
	        return true;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
