package com.stack;

import java.util.*;

public class Leetcode85_MaximalRectangle {
	

	    // Pair class: a generic helper class used to store a key-value pair
	    // - In this problem, 'key' represents the value of the element (height of the bar)
	    // - 'value' represents the index of the element in the histogram
	    class Pair<E, T> {
	        E key;    // Value of the histogram bar (height)
	        T value;  // Index of the histogram bar

	        public Pair(E key, T value) {
	            this.key = key;
	            this.value = value;
	        }
	    }

	    /**
	     * NSL (Nearest Smaller to Left)
	     * - This method finds the nearest smaller element to the left of each element in an array.
	     * - It helps determine the left boundary for each bar in the histogram.
	     * 
	     * Process:
	     * - For each element, the method checks elements to its left to find the nearest one smaller than it.
	     * - Uses a stack to maintain elements in decreasing order. Each element is paired with its index.
	     * 
	     * @param arr The heights array representing the histogram bars.
	     * @return A list of indices representing the nearest smaller elements to the left.
	     */
	    public List<Integer> NSL(int[] arr) {
	        List<Integer> res = new ArrayList<>();   // To store indices of the nearest smaller elements
	        Stack<Pair<Integer, Integer>> s = new Stack<>();   // Stack for maintaining values with indices

	        // Traverse from left to right through the array
	        for (int i = 0; i < arr.length; i++) {
	            // If stack is empty, no smaller element on the left exists, so we add -1
	            if (s.isEmpty()) {
	                res.add(-1);
	            }
	            // If the top element in stack is smaller than the current element
	            else if (s.peek().key < arr[i]) {
	                res.add(s.peek().value);  // Add the index of this smaller element
	            }
	            // If the top element in stack is greater than or equal to the current element
	            else if (s.peek().key >= arr[i]) {
	                // Pop elements from the stack until finding a smaller element
	                while (!s.isEmpty() && s.peek().key >= arr[i]) {
	                    s.pop();
	                }
	                // If stack becomes empty after popping, no smaller element exists; add -1
	                if (s.isEmpty()) {
	                    res.add(-1);
	                } else {
	                    res.add(s.peek().value);  // Add index of the smaller element
	                }
	            }
	            // Push the current element and its index onto the stack
	            Pair<Integer, Integer> p = new Pair<>(arr[i], i);
	            s.add(p);
	        }
	        return res;  // List of indices of nearest smaller elements to the left
	    }

	    /**
	     * NSR (Nearest Smaller to Right)
	     * - Finds the nearest smaller element to the right of each element in the array.
	     * - Helps determine the right boundary for each bar in the histogram.
	     * 
	     * Process:
	     * - Uses a stack similar to NSL, but traverses the array from right to left.
	     * - Pairs elements with indices and checks for smaller elements on the right.
	     * 
	     * @param arr The heights array representing the histogram bars.
	     * @return A list of indices of the nearest smaller elements to the right.
	     */
	    public List<Integer> NSR(int[] arr) {
	        List<Integer> res = new ArrayList<>();   // Result list for right boundary indices
	        Stack<Pair<Integer, Integer>> s = new Stack<>();   // Stack for maintaining values with indices

	        // Traverse from right to left through the array
	        for (int i = arr.length - 1; i >= 0; i--) {
	            // If stack is empty, no smaller element on the right exists, so add array length
	            if (s.isEmpty()) {
	                res.add(arr.length);
	            }
	            // If the top element in stack is smaller than the current element
	            else if (s.peek().key < arr[i]) {
	                res.add(s.peek().value);  // Add index of this smaller element
	            }
	            // If the top element in stack is greater than or equal to the current element
	            else if (s.peek().key >= arr[i]) {
	                // Pop elements until finding a smaller element
	                while (!s.isEmpty() && s.peek().key >= arr[i]) {
	                    s.pop();
	                }
	                // If stack is empty, no smaller element exists; add array length
	                if (s.isEmpty()) {
	                    res.add(arr.length);
	                } else {
	                    res.add(s.peek().value);  // Add index of the smaller element
	                }
	            }
	            // Push the current element and its index onto the stack
	            Pair<Integer, Integer> p = new Pair<>(arr[i], i);
	            s.add(p);
	        }
	        
	        // Reverse the result list to maintain correct order
	        Collections.reverse(res);
	        return res;
	    }

	    /**
	     * largestRectangleArea
	     * - Calculates the maximum rectangular area that can be formed in the histogram.
	     * - Uses NSL and NSR to find the left and right boundaries, calculating width and area for each bar.
	     * 
	     * @param heights An array of integers representing heights of histogram bars.
	     * @return Maximum rectangular area possible in the histogram.
	     */
	    public int largestRectangleArea(int[] heights) {
	        List<Integer> left = NSL(heights);    // Indices of nearest smaller elements on the left
	        List<Integer> right = NSR(heights);   // Indices of nearest smaller elements on the right
	        int ans = -1;  // Variable to track the maximum area

	        // Calculate width for each bar based on left and right boundaries
	        List<Integer> width = new ArrayList<>();
	        for (int i = 0; i < left.size(); i++) {
	            width.add(right.get(i) - left.get(i) - 1);
	        }

	        // Calculate area for each bar and update the maximum area found
	        for (int i = 0; i < width.size(); i++) {
	            ans = Math.max(ans, width.get(i) * heights[i]);
	        }
	        return ans;  // Maximum rectangle area possible in the histogram
	    }

	    /**
	     * maximalRectangle
	     * - Calculates the maximum rectangular area of 1's that can be formed in a binary matrix.
	     * - Transforms each row of the matrix into a histogram and applies largestRectangleArea.
	     * 
	     * Process:
	     * - Each row is treated as a base row in a histogram, where:
	     *   - Height of a bar at column 'j' is the count of consecutive 1's from row 0 to row 'i'.
	     * - For each row:
	     *   - If matrix[i][j] is 0, reset the height for that column to 0.
	     *   - Otherwise, increment the height of the histogram bar.
	     * 
	     * @param matrix Binary matrix where '1' represents the bar, and '0' represents no bar.
	     * @return Maximum rectangular area of 1's that can be formed in the matrix.
	     */
	    public int maximalRectangle(char[][] matrix) {
	        // Initialize heights array based on the first row of the matrix
	        int[] h = new int[matrix[0].length];
	        for (int j = 0; j < matrix[0].length; j++) {
	            h[j] = matrix[0][j] - '0';  // Initialize height based on binary values (0 or 1)
	        }

	        // Use the first row's histogram as the initial maximum area
	        int ans = largestRectangleArea(h);

	        // Traverse each remaining row in the matrix
	        for (int i = 1; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                // If matrix[i][j] is '0', reset the height at that column to 0
	                if (matrix[i][j] - '0' == 0) {
	                    h[j] = 0;
	                } else {
	                    // If matrix[i][j] is '1', increment the height for that column
	                    h[j] = h[j] + (matrix[i][j] - '0');
	                }
	            }
	            // Calculate max area with updated histogram and update the answer
	            ans = Math.max(ans, largestRectangleArea(h));
	        }
	        return ans;  // Return the maximum rectangular area of 1's in the matrix
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
