package com.prefixsum;

public class Leetcode1588_SumofAllOddLengthSubarrays {
    
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] pSum = new int[n]; // Prefix sum array to store cumulative sums of elements
        int sum = 0;

        // Step 1: Calculate the prefix sum
        // The prefix sum array allows us to quickly calculate the sum of any subarray
        // by subtracting the cumulative sum at specific indices.
        for (int i = 0; i < n; i++) {
            sum += arr[i]; // Keep adding the current element to the cumulative sum
            pSum[i] = sum; // Store the cumulative sum at index `i`
        }

        // At this point, `pSum[i]` contains the sum of elements from index 0 to `i`.
        // Example: If arr = [1, 4, 2, 5, 3], then pSum = [1, 5, 7, 12, 15].

        // Initialize the total sum with all single-element subarrays
        // (odd-length subarrays of size 1).
        int totalSum = sum; 
        // All single elements contribute directly to the sum, so we add them initially.

        // Step 2: Add contributions of odd-length subarrays greater than size 1
        // We only consider subarray lengths that are odd, starting from 3, 5, etc.
        for (int length = 3; length <= n; length += 2) { // Increment by 2 for odd lengths
            // Iterate through all starting points of subarrays of the current length
            for (int i = 0; i <= n - length; i++) {
                // Calculate the ending index of the current subarray
                int end = i + length - 1;
                
                // Calculate the sum of the current subarray using prefix sum:
                // If the subarray starts at `i` and ends at `end`:
                // - Use `pSum[end]` for the cumulative sum up to `end`
                // - Subtract `pSum[i-1]` if `i > 0` to remove the sum of elements before index `i`
                int subarraySum = pSum[end] - (i > 0 ? pSum[i - 1] : 0);
                
                // Add the sum of the current subarray to the total sum
                totalSum += subarraySum;
            }
        }

        // At the end of this loop:
        // - We have considered all odd-length subarrays of size 3, 5, 7, etc.
        // - Their sums are added to the `totalSum`.

        return totalSum; // Return the final total sum of all odd-length subarrays
    }
}
