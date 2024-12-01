package com.heap;

import java.util.PriorityQueue;

public class Leetcode215_KthLargestElementinanArray {

	    public int findKthLargest(int[] nums, int k) {
	        // Step 1: Initialize a min-heap (priority queue) to keep track of the k largest elements.
	        // The default behavior of PriorityQueue in Java is to function as a min-heap,
	        // where the smallest element is always at the root.
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	        // Step 2: Iterate through each element in the array 'nums'.
	        for (int i = 0; i < nums.length; i++) {
	            // Add the current element (nums[i]) to the min-heap.
	            // This will insert nums[i] in the correct position within the heap to maintain order.
	            minHeap.add(nums[i]);
	            
	            // Step 3: Check if the heap size exceeds 'k'.
	            // If the heap contains more than k elements, it means we have extra elements that are not
	            // among the k largest elements.
	            if (minHeap.size() > k) {
	                // Remove the smallest element from the heap.
	                // By removing the smallest element, we ensure that only the k largest elements remain in the heap.
	                // Since it's a min-heap, calling 'remove()' without arguments removes the smallest element.
	                minHeap.remove();
	            }
	        }

	        // Step 4: After processing all elements, the min-heap contains exactly k elements, which are the k largest elements in the array.
	        // The smallest element among these k largest elements is at the root of the min-heap.
	        // Therefore, we return 'minHeap.peek()', which gives us the kth largest element.
	        return minHeap.peek();
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
