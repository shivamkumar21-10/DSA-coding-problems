package com.greedy;

import java.util.*;

public class Leetcode45_JumpGameII {
	


	    // Recursive function with memoization to find the minimum jumps
	    int minJump(int[] nums, int idx, int[] t) {
	        // Base Case: If we reach or exceed the last index, no further jumps are needed
	        if (idx >= nums.length - 1) {
	            return 0; // Already at the end or beyond, no jumps needed
	        }

	        // If this index has already been computed, return the memoized value
	        if (t[idx] != -1) {
	            return t[idx]; // Avoid recomputation by returning stored result
	        }

	        // If nums[idx] == 0, it means we can't jump further from this index
	        if (nums[idx] == 0) {
	            return Integer.MAX_VALUE; // No valid path, return infinity
	        }

	        // Initialize the minimum jumps to a very large value (infinity)
	        int mini = Integer.MAX_VALUE;

	        // Loop to explore all possible jumps from the current index
	        // We can jump up to `nums[idx]` steps from the current index
	        for (int i = 1; i <= nums[idx]; i++) {
	            // Recursively calculate the minimum jumps required from the next position
	            int jumps = minJump(nums, idx + i, t);

	            // Only consider valid paths (jumps != Integer.MAX_VALUE)
	            if (jumps != Integer.MAX_VALUE) {
	                mini = Math.min(mini, 1 + jumps); // Add 1 for the current jump
	            }
	        }

	        // Store the computed result in the memoization table
	        return t[idx] = mini;
	    }

	    public int jump(int[] nums) {
	        int n = nums.length;

	        // Create a memoization table initialized with -1
	        // `t[i]` will store the minimum jumps required to reach the end from index `i`
	        int[] t = new int[n];
	        Arrays.fill(t, -1); // Initialize all values to -1 (indicating uncomputed)

	        // Start the recursive function from the first index (idx = 0)
	        return minJump(nums, 0, t);
	    }
	


}
