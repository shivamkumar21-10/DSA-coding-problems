package com.stack;

import java.util.*;

public class Leetcode84_LargestRectangleinHistogram {
	    
	    // Generic Pair class to store a key-value pair
	    class Pair<E, T> {
	        E key;    // Represents the element value
	        T value;  // Represents the index of the element

	        public Pair(E key, T value) {
	            this.key = key;
	            this.value = value;
	        }
	    }

	    /**
	     * Finds the index of the nearest smaller element to the left of each element in the array.
	     * This method is used to calculate the nearest left boundary for each bar in the histogram.
	     * 
	     * @param arr - input array representing the histogram heights
	     * @return List of indices of the nearest smaller element to the left for each element
	     */
	    public List<Integer> NSL(int[] arr) {
	        List<Integer> res = new ArrayList<>();   // Result list to store the nearest smaller indices
	        Stack<Pair<Integer, Integer>> s = new Stack<>();   // Stack to maintain values and their indices

	        // Traverse each element from left to right
	        for (int i = 0; i < arr.length; i++) {
	            // If stack is empty, no smaller element on the left, so add -1 as left boundary
	            if (s.isEmpty()) {
	                res.add(-1);
	            }
	            // If the top element in the stack is smaller than the current element
	            else if (s.peek().key < arr[i]) {
	                res.add(s.peek().value);  // Record the index of the smaller element
	            }
	            // If the top element in the stack is greater or equal to the current element
	            else if (s.peek().key >= arr[i]) {
	                // Pop elements until we find a smaller element or the stack becomes empty
	                while (!s.isEmpty() && s.peek().key >= arr[i]) {
	                    s.pop();
	                }
	                // If stack is empty after popping, no smaller element, so add -1
	                if (s.isEmpty()) {
	                    res.add(-1);
	                } else {
	                    res.add(s.peek().value);  // Record the index of the smaller element
	                }
	            }
	            // Push the current element and its index onto the stack
	            Pair<Integer, Integer> p = new Pair<>(arr[i], i);
	            s.add(p);
	        }
	        return res;  // Return the list of indices for nearest smaller elements on the left
	    }

	    /**
	     * Finds the index of the nearest smaller element to the right of each element in the array.
	     * This method is used to calculate the nearest right boundary for each bar in the histogram.
	     * 
	     * @param arr - input array representing the histogram heights
	     * @return List of indices of the nearest smaller element to the right for each element
	     */
	    public List<Integer> NSR(int[] arr) {
	        List<Integer> res = new ArrayList<>();   // Result list to store the nearest smaller indices
	        Stack<Pair<Integer, Integer>> s = new Stack<>();   // Stack to maintain values and their indices

	        // Traverse each element from right to left
	        for (int i = arr.length - 1; i >= 0; i--) {
	            // If stack is empty, no smaller element on the right, so add array length as right boundary
	            if (s.isEmpty()) {
	                res.add(arr.length);
	            }
	            // If the top element in the stack is smaller than the current element
	            else if (s.peek().key < arr[i]) {
	                res.add(s.peek().value);  // Record the index of the smaller element
	            }
	            // If the top element in the stack is greater or equal to the current element
	            else if (s.peek().key >= arr[i]) {
	                // Pop elements until we find a smaller element or the stack becomes empty
	                while (!s.isEmpty() && s.peek().key >= arr[i]) {
	                    s.pop();
	                }
	                // If stack is empty after popping, no smaller element, so add array length
	                if (s.isEmpty()) {
	                    res.add(arr.length);
	                } else {
	                    res.add(s.peek().value);  // Record the index of the smaller element
	                }
	            }
	            // Push the current element and its index onto the stack
	            Pair<Integer, Integer> p = new Pair<>(arr[i], i);
	            s.add(p);
	        }
	        
	        // Since we traversed from right to left, reverse the result for correct order
	        Collections.reverse(res);
	        return res;  // Return the list of indices for nearest smaller elements on the right
	    }

	    /**
	     * Calculates the maximum area of a rectangle that can be formed within a histogram.
	     * Uses the results of NSL (Nearest Smaller to Left) and NSR (Nearest Smaller to Right) methods
	     * to calculate the width and area for each bar in the histogram.
	     * 
	     * @param heights - input array representing the histogram heights
	     * @return The maximum rectangular area that can be formed in the histogram
	     */
	    public int largestRectangleArea(int[] heights) {
	        List<Integer> left = NSL(heights);    // Get nearest smaller elements to the left for each bar
	        List<Integer> right = NSR(heights);   // Get nearest smaller elements to the right for each bar
	        int ans = -1;  // Variable to store the maximum area

	        List<Integer> width = new ArrayList<>();  // List to store the width for each bar

	        // Calculate width for each bar using left and right boundaries
	        for (int i = 0; i < left.size(); i++) {
	            width.add(right.get(i) - left.get(i) - 1);
	        }

	        // Calculate area for each bar and find the maximum area
	        for (int i = 0; i < width.size(); i++) {
	            ans = Math.max(ans, width.get(i) * heights[i]);  // Update the maximum area
	        }
	        return ans;  // Return the maximum rectangular area
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
