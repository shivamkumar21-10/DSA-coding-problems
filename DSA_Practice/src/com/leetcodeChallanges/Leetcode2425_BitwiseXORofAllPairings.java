package com.leetcodeChallanges;

public class Leetcode2425_BitwiseXORofAllPairings {
	    public int xorAllNums(int[] nums1, int[] nums2) {
	        // Variables to store the XOR of all elements in nums1 and nums2
	        int x1 = 0, x2 = 0, ans = 0;

	        // Intuition: XOR all elements of nums1.
	        // The result, `x1`, represents the combined effect of all elements in nums1.
	        // Since XOR is commutative and associative, this allows us to combine the influence of nums1 efficiently.
	        for (int num : nums1) {
	            x1 ^= num;
	        }

	        // Intuition: XOR all elements of nums2.
	        // The result, `x2`, represents the combined effect of all elements in nums2.
	        for (int num : nums2) {
	            x2 ^= num;
	        }

	        // Intuition for next steps:
	        // Every element in nums1 contributes to the XOR result `nums2.length` times,
	        // and every element in nums2 contributes to the XOR result `nums1.length` times.
	        // If the length of the other array is odd, the contributions remain (odd count leads to no cancellation),
	        // but if the length is even, contributions cancel out due to the properties of XOR (even count cancels to 0).

	        // If nums1's length is odd, its elements' contributions do not cancel out.
	        // Therefore, XOR the result with `x2` (which represents nums2's combined effect).
	        if (nums1.length % 2 != 0) {
	            ans ^= x2; // Include nums2's contributions if nums1.length is odd.
	        }

	        // Similarly, if nums2's length is odd, its elements' contributions do not cancel out.
	        // Therefore, XOR the result with `x1` (which represents nums1's combined effect).
	        if (nums2.length % 2 != 0) {
	            ans ^= x1; // Include nums1's contributions if nums2.length is odd.
	        }

	        // Return the final XOR result
	        return ans;
	    }
	


}
