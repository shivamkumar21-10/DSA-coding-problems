package com.heap;

import java.util.*;

public class Leetcode658_FindKClosestElements {

	    // Define a helper class `Pair` to store:
	    // `first`: the absolute difference between each element and target `x`
	    // `second`: the actual element value from the array
	    class Pair {
	        int first;  // Absolute difference from x
	        int second; // Element value

	        // Constructor to initialize `first` and `second`
	        public Pair(int first, int second) {
	            this.first = first;
	            this.second = second;
	        }

	        // Getter methods for `first` and `second` attributes
	        public int getFirst() {
	            return first;
	        }

	        public int getSecond() {
	            return second;
	        }
	    }

	    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        // Initialize a list to store the result
	        List<Integer> lst = new ArrayList<>();

	        // Use a max-heap to store the closest `k` elements.
	        // The priority queue is ordered by the following rules:
	        // - Elements with a larger absolute difference from `x` have higher priority (higher in the heap).
	        // - For elements with the same absolute difference, the element with the larger value is prioritized.
	        PriorityQueue<Pair> pq = new PriorityQueue<>(
	                (a, b) -> {
	                    // Compare absolute differences from `x`
	                    if (b.getFirst() != a.getFirst()) {
	                        return Integer.compare(b.getFirst(), a.getFirst()); // Max-heap by absolute difference
	                    } else {
	                        return Integer.compare(b.getSecond(), a.getSecond()); // Secondary sort by element value
	                    }
	                });

	        // Iterate through each element in the array
	        for (int i = 0; i < arr.length; i++) {
	            // Calculate the absolute difference between current element and `x`
	            int absDiff = Math.abs(arr[i] - x);

	            // Add a new `Pair` to the priority queue representing:
	            // - `absDiff` as the distance from `x`
	            // - `arr[i]` as the value of the element itself
	            pq.add(new Pair(absDiff, arr[i]));

	            // Ensure the priority queue contains only the `k` closest elements
	            if (pq.size() > k) {
	                // Remove the root of the max-heap (element with the largest distance or largest value)
	                pq.poll();
	            }
	        }

	        // Priority queue now contains the `k` closest elements
	        System.out.println(pq);

	        // Extract all elements from the priority queue and store their values in `lst`
	        while (!pq.isEmpty()) {
	            // Get the actual element value and add it to the result list
	            lst.add(pq.poll().getSecond());
	        }

	        // Sort the result list in ascending order as required by the problem
	        Collections.sort(lst);
	        return lst; // Return the sorted list of the `k` closest elements
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
