package com.leetcodeChallanges;

public class Leetcode2429_MinimizeXOR {
	class Solution {
	    public int minimizeXor(int num1, int num2) {
	        // Step 1: Count the number of set bits in num2
	        // `Integer.bitCount(num2)` efficiently calculates the number of 1s in the binary representation of num2.
	        int setBits = Integer.bitCount(num2);

	        // Step 2: Initialize the answer
	        // We start with an empty result (`ans = 0`) and will progressively set bits in it.
	        int ans = 0;

	        // Step 3: Copy set bits from num1 into ans, starting from the most significant bit (MSB)
	        // Iterate over all 32 bits of num1 from MSB to LSB.
	        for (int i = 31; i >= 0 && setBits > 0; i--) {
	            // Check if the i-th bit in num1 is set
	            if ((num1 & (1 << i)) != 0) { 
	                ans |= (1 << i);        // Set the same bit in ans
	                setBits--;             // Decrease the number of required set bits
	            }
	        }

	        // Step 4: If there are still set bits left, set the lowest unset bits in ans
	        // This ensures we add remaining set bits in positions that minimize the XOR value.
	        for (int i = 0; i < 32 && setBits > 0; i++) {
	            // Check if the i-th bit in ans is unset
	            if ((ans & (1 << i)) == 0) { 
	                ans |= (1 << i);       // Set this bit in ans
	                setBits--;             // Decrease the number of required set bits
	            }
	        }

	        // Step 5: Return the final minimized XOR value
	        return ans;
	    }
	}


}
