package com.heap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347_TopKFrequentElements {

	    // Helper class `Pair` to store frequency (`first`) and element value (`second`)
	    class Pair {
	        int first;  // Frequency of the element
	        int second; // Element value

	        // Constructor to initialize frequency and element value
	        public Pair(int first, int second) {
	            this.first = first;
	            this.second = second;
	        }

	        // Getter method for frequency
	        public int getFirst() {
	            return first;
	        }

	        // Getter method for element value
	        public int getSecond() {
	            return second;
	        }
	    }

	    public int[] topKFrequent(int[] nums, int k) {
	        // Step 1: Frequency Map Construction
	        // `mp` stores the frequency of each element in `nums`
	        HashMap<Integer, Integer> mp = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            // Increment the count for each element in `nums`
	            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
	        }

	        // Step 2: Priority Queue (Min-Heap) Setup
	        // PriorityQueue `pq` is a min-heap, keeping the `k` most frequent elements at the end
	        // The comparator is defined as follows:
	        // - Primary sort by frequency in ascending order (min-heap by frequency)
	        // - Secondary sort by element value in ascending order if frequencies are equal
	        PriorityQueue<Pair> pq = new PriorityQueue<>(
	                (a, b) -> {
	                    if (a.getFirst() != b.getFirst()) {
	                        return Integer.compare(a.getFirst(), b.getFirst()); // Min-heap by frequency
	                    } else {
	                        return Integer.compare(a.getSecond(), b.getSecond()); // Secondary sort by element value
	                    }
	                });

	        // Step 3: Populate Priority Queue with Frequencies
	        // Iterate over each entry in `mp` (element-value pairs) and add each as a Pair to `pq`
	        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
	            int frequency = entry.getValue();
	            int element = entry.getKey();
	            pq.add(new Pair(frequency, element));

	            // Keep only the `k` most frequent elements in the priority queue
	            // If the size exceeds `k`, remove the element with the smallest frequency
	            if (pq.size() > k) {
	                pq.poll();
	            }
	        }

	        // Step 4: Extract Top `k` Elements
	        // Initialize an array to store the `k` most frequent elements
	        int[] res = new int[k];
	        for (int i = 0; i < k; i++) {
	            // Poll the elements from the heap which are in ascending order of frequency
	            // Since we need `k` most frequent elements, they are stored in `res` by polling from `pq`
	            res[i] = pq.poll().getSecond();
	        }

	        // Return the final array of `k` most frequent elements
	        return res;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
