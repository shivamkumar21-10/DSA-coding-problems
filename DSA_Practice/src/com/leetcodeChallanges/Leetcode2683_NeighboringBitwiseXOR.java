package com.leetcodeChallanges;

public class Leetcode2683_NeighboringBitwiseXOR {
	
	    public boolean doesValidArrayExist(int[] derived) {
	        // Flag to indicate whether a valid array exists or not.
	        boolean flag = true;
	        
	        // Length of the input derived array.
	        int n = derived.length;

	        // Create the original array with the same size as derived.
	        int[] orig = new int[n];

	        // Assume the first element of the original array is derived[0].
	        orig[0] = derived[0];

	        // Iterate over the derived array to reconstruct the original array.
	        for (int i = 0; i < n - 1; i++) {
	            // Logic for reconstructing orig[i+1] based on derived[i] and orig[i]:
	            // If derived[i] == 1, the XOR of orig[i] and orig[i+1] must be 1.
	            // If derived[i] == 0, the XOR of orig[i] and orig[i+1] must be 0.
	            if (derived[i] == 1 && orig[i] == 0) {
	                orig[i + 1] = 1; // orig[i+1] must be 1 to satisfy XOR = 1.
	            } else if (derived[i] == 1 && orig[i] == 1) {
	                orig[i + 1] = 0; // orig[i+1] must be 0 to satisfy XOR = 1.
	            } else if (derived[i] == 0 && orig[i] == 1) {
	                orig[i + 1] = 1; // orig[i+1] must be 1 to satisfy XOR = 0.
	            } else if (derived[i] == 0 && orig[i] == 0) {
	                orig[i + 1] = 0; // orig[i+1] must be 0 to satisfy XOR = 0.
	            }
	        }

	        // Check the cyclic XOR condition:
	        // If XOR of the first and last elements in `orig` doesn't match the last element in `derived`,
	        // the reconstruction is invalid.
	        if ((orig[0] ^ orig[n - 1]) != (derived[n - 1] == 1 ? 1 : 0)) {
	            flag = false;
	        }

	        return flag; // Return whether a valid original array exists.
	    }

	        public boolean doesValidArrayExist(int[] derived) {
	            // Initialize a variable to store the XOR of all elements in the derived array.
	            int xr = 0;

	            // Iterate through each element in the derived array.
	            for (int x : derived) {
	                // Calculate the cumulative XOR of all elements.
	                xr = xr ^ x;
	            }

	            // **Logic behind the return statement:**
	            // If the XOR of all elements in the derived array is 0, it means the cyclic relationship
	            // of the derived array can lead to a valid original array.
	            // Here's why:
	            // 1. In the derived array, derived[i] = orig[i] ^ orig[i+1].
	            // 2. When we XOR all elements of the derived array, i.e.,
	            //    derived[0] ^ derived[1] ^ ... ^ derived[n-1], the terms in the original array
	            //    (orig[0], orig[1], ..., orig[n-1]) will pair up due to the XOR property:
	            //      (orig[0] ^ orig[1]) ^ (orig[1] ^ orig[2]) ^ ... ^ (orig[n-1] ^ orig[0]).
	            // 3. All intermediate terms cancel out because of the XOR property:
	            //      x ^ x = 0.
	            //    This leaves us with:
	            //      orig[0] ^ orig[0] = 0.
	            // 4. If the XOR of the derived array is 0, it ensures that the original array
	            //    satisfies this cyclic XOR property and thus exists.

	            // Return true if XOR is 0, otherwise return false.
	            return xr == 0;
	        }

}
