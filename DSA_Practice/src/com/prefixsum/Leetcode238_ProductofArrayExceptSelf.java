package com.prefixsum;

public class Leetcode238_ProductofArrayExceptSelf {
	
	    public int[] productExceptSelf(int[] nums) {
	        int n = nums.length;
	        
	        // Initialize arrays to store left and right products.
	        int[] lProd = new int[n]; // Stores product of all elements to the left of the current element.
	        int[] rProd = new int[n]; // Stores product of all elements to the right of the current element.
	        int[] ans = new int[n];   // Final result array where each element is the product of all elements except itself.

	        // Base case for left and right product arrays.
	        lProd[0] = 1;       // No elements to the left of the first element.
	        rProd[n - 1] = 1;   // No elements to the right of the last element.

	        // **Building the left product array:**
	        // For each element, calculate the product of all elements to its left.
	        for (int i = 1; i < n; i++) {
	            lProd[i] = lProd[i - 1] * nums[i - 1];
	        }

	        // **Building the right product array:**
	        // For each element, calculate the product of all elements to its right.
	        for (int i = n - 2; i >= 0; i--) {
	            rProd[i] = rProd[i + 1] * nums[i + 1];
	        }

	        // **Combining left and right products to get the result:**
	        // Each element in the result array is the product of its corresponding
	        // left product and right product.
	        for (int i = 0; i < n; i++) {
	            ans[i] = lProd[i] * rProd[i];
	        }

	        // Return the result array.
	        return ans;
	    }
	


}
