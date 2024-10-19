package com.sliding_window;

import java.util.*;

public class Leetcode239_SlidingWindowMaximum {
	
	    public static int[] maxSlidingWindow(int[] nums, int k) {
	        // Initialize two pointers i and j for the sliding window
	        int i = 0;
	        int j = 0;
	        
	        // List to store the maximum values for each window
	        List<Integer> lst = new ArrayList<>();
	        
	        // Deque to store elements of the window in descending order
	        // The deque will store indices of elements, not the elements themselves
	        Deque<Integer> deque = new ArrayDeque<>();

	        // Start iterating through the array
	        while (j < nums.length) {
	            
	            // Maintain a decreasing order in the deque
	            // Remove elements from the deque if they are smaller than the current element nums[j]
	            // This ensures the deque contains the maximum element at the front
	            while (deque.size() > 0 && deque.getLast() < nums[j]) {
	                deque.removeLast();  // Remove smaller elements from the back of the deque
	            }
	            
	            // Add the current element to the deque (at the back)
	            deque.addLast(nums[j]);

	            // Once we have processed 'k' elements, we have a valid window
	            if (j + 1 >= k) {
	                
	                // The front of the deque is the largest element for the current window
	                lst.add(deque.getFirst());

	                // Check if the element leaving the window is the one at the front of the deque
	                // If so, remove it since it's no longer in the window
	                if (deque.getFirst() == nums[i]) {
	                    deque.removeFirst();  // Remove the front element
	                }

	                // Move the left pointer (i) to shrink the window
	                i++;
	            }
	            
	            // Move the right pointer (j) to expand the window
	            j++;
	        }

	        // Convert the result list to an array and return
	        int[] res = new int[lst.size()];
	        for (int p = 0; p < lst.size(); p++) {
	            res[p] = lst.get(p);
	        }
	        
	        return res;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] q = new int[] {1,3,-1,-3,5,3,6,7};
		int[] ans = maxSlidingWindow(q,3);
        for (int p = 0; p < ans.length; p++) {
            System.out.print(ans[p] + " ");
        }

	}

}
