package com.heap;

import java.util.PriorityQueue;

public class GFG_Nearlysorted {

	    // This method sorts a nearly sorted array where each element is at most 'k' positions away from its target position.
	    // It modifies the input array 'arr' in-place to be fully sorted.
	    public void nearlySorted(int[] arr, int k) {
	        // Create a min-heap (priority queue) to hold elements within the range of 'k + 1'.
	        // This helps in sorting a nearly sorted array efficiently.
	        PriorityQueue<Integer> heap = new PriorityQueue<>();
	        
	        // Pointer 'p' to keep track of the position in 'arr' where the next sorted element should be placed.
	        int p = 0;
	        
	        // Step 1: Iterate through each element in the array.
	        for (int i = 0; i < arr.length; i++) {
	            // Add the current element from 'arr' to the min-heap.
	            heap.add(arr[i]);
	            
	            // Step 2: Check if the heap size exceeds 'k + 1'.
	            // If the size is greater than 'k + 1', the smallest element in the heap
	            // (the one at the root of the min-heap) is guaranteed to be in its final sorted position.
	            if (heap.size() == k + 1) {
	                // Remove the smallest element from the heap and place it at the position 'p' in 'arr'.
	                // This operation fixes one element in its correct sorted position within the array.
	                arr[p] = heap.peek();
	                heap.remove();
	                
	                // Move the pointer 'p' to the next position in 'arr' for the next sorted element.
	                p++;
	            }
	        }
	        
	        // Step 3: After finishing the main loop, there may still be elements left in the heap.
	        // These elements are in ascending order but need to be placed in the remaining positions in 'arr'.
	        while (!heap.isEmpty()) {
	            // Continuously remove the smallest element from the heap and place it in 'arr' at the current position 'p'.
	            // This step ensures that the remaining elements in 'arr' are sorted.
	            arr[p] = heap.peek();
	            heap.remove();
	            
	            // Move the pointer 'p' to the next position in 'arr' for the next sorted element.
	            p++;
	        }
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
