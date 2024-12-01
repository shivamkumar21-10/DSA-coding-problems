package com.bit_manipualtion;

public class Leetcode191_Numberof1Bits {
	
	    public int hammingWeight(int n) {
	        /*
	         * Initialize a counter variable 'cnt' to zero.
	         * This variable will keep track of the number of '1' bits (set bits) in the binary representation of the input integer 'n'.
	         */
	        int cnt = 0;

	        /*
	         * Use a while loop to iterate through the bits of the number 'n'.
	         * The condition 'n != 0' ensures the loop continues until all bits of 'n' have been processed.
	         * As we process each bit, 'n' will be modified (right-shifted), and eventually, it will become 0, terminating the loop.
	         */
	        while (n != 0) {
	            /*
	             * Perform a bitwise AND operation between 'n' and 1: (n & 1).
	             * This operation isolates the rightmost bit of 'n' (least significant bit, or LSB).
	             * If the result of (n & 1) is 1, it means the LSB is a '1' (set bit), and we increment the counter 'cnt'.
	             * If the result is 0, it means the LSB is '0', and we do not increment 'cnt'.
	             *
	             * Example:
	             * - If n = 5 (binary: 101):
	             *   - First iteration: (5 & 1) = 1 → increment 'cnt' to 1.
	             * - If n = 4 (binary: 100):
	             *   - First iteration: (4 & 1) = 0 → 'cnt' remains unchanged.
	             */
	            if ((n & 1) == 1) {
	                cnt++;
	            }

	            /*
	             * Perform a right shift on 'n' using the '>>' operator: (n = n >> 1).
	             * This operation shifts all bits of 'n' one position to the right.
	             * The LSB is discarded, and a new bit (0 for positive numbers, or the sign bit for negative numbers) is added on the left.
	             *
	             * Example:
	             * - If n = 5 (binary: 101):
	             *   - After the shift: n becomes 2 (binary: 10).
	             * - If n = 2 (binary: 10):
	             *   - After the shift: n becomes 1 (binary: 1).
	             * - If n = 1 (binary: 1):
	             *   - After the shift: n becomes 0 (binary: 0), terminating the loop.
	             *
	             * This process ensures that we eventually process all the bits of 'n'.
	             */
	            n = n >> 1;
	        }

	        /*
	         * After the while loop ends, the counter 'cnt' holds the total number of '1' bits (set bits) in the binary representation of the original input 'n'.
	         * Return this value as the result.
	         */
	        return cnt;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
