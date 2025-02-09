package com.prefixsum;
import java.util.*;

public class Leetcode_523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store the remainder when the cumulative sum is divided by k and the first index where this remainder occurred
        // Key: remainder, Value: index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Variables to track the cumulative sum and its remainder when divided by k
        int rem = 0; // Remainder
        int sum = 0; // Cumulative sum

        /**
         * Intuition:
         * - We use prefix sum and remainder properties to identify if a subarray sum is divisible by k.
         * - If two prefix sums have the same remainder when divided by k, then the sum of the subarray
         *   between them must be a multiple of k.
         * - Example:
         *   Consider an array [23, 2, 4, 6, 7] with k = 6.
         *   Prefix sum: [23, 25, 29, 35, 42]
         *   Remainders when divided by 6: [5, 1, 5, 5, 0]
         *   Here, remainder 5 repeats at index 0 and 2, meaning subarray (2, 4) is a valid subarray.
         */

//        Mathematical Justification
//        Let’s define:
//
//        prefixSum[i] as the sum of elements from 0 to i
//        prefixSum[j] as the sum of elements from 0 to j
//        If:
//
//        prefixSum[i] mod k = prefixSum[j] mod k
//
//        Then:
//
//        (prefixSum[j]−prefixSum[i]) mod k = 0
//        This implies the sum of the subarray between indices i+1 and j is divisible by k.
//
//        In our example:
//
//        prefixSum[2] % 6 = 5
//        prefixSum[0] % 6 = 5
//        So, prefixSum[2] - prefixSum[0] = (29 - 23) = 6, which is divisible by 6.
//        Therefore, the subarray {2, 4} is a valid answer.
        // Iterate through the array
        
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the cumulative sum
            sum += nums[i];

            // Compute the remainder when the cumulative sum is divided by k
            rem = sum % k;

            // Handle negative remainders:
            // If rem is negative, make it positive by adding k (as remainder should always be non-negative)
            if (rem < 0) {
                rem += k;
            }

            // Check if the remainder is 0 and there are at least two elements in the subarray
            // This means the sum of the subarray from the start to the current index is divisible by k
            if (rem == 0 && i > 0) {
                return true; // Valid subarray found
            }

            // Check if the current remainder has been seen before
            if (map.containsKey(rem)) {
                // Get the index where this remainder was first encountered
                int prevIndex = map.get(rem);

                // If the subarray length (i - prevIndex) is greater than 1, it is a valid subarray
                // The sum of elements between these indices is divisible by k
                if (i - prevIndex > 1) {
                    return true;
                }
            }

            // If the remainder is not already in the map, store it along with the current index
            // We store only the first occurrence of the remainder to ensure we check the longest subarray possible
            if (!map.containsKey(rem)) {
                map.put(rem, i);
            }
        }

        // If no valid subarray is found, return false
        return false;
    }

    public static void main(String[] args) {
        Leetcode_523ContinuousSubarraySum obj = new Leetcode_523ContinuousSubarraySum();
        
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(obj.checkSubarraySum(nums1, k1)); // Output: true
        
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(obj.checkSubarraySum(nums2, k2)); // Output: true
        
        int[] nums3 = {1, 2, 3};
        int k3 = 5;
        System.out.println(obj.checkSubarraySum(nums3, k3)); // Output: false
    }
}
