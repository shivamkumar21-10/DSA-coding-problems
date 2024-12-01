package com.bit_manipualtion;

public class Leetcode338_CountingBits {

	    public int[] countBits(int n) {
	        // Initialize the result array `ans` with size `n+1`.
	        // This array will store the count of set bits (1s) for each number from 0 to n.
	        int[] ans = new int[n + 1];
	        
	        // Base case: The number 0 has 0 set bits, so `ans[0]` is initialized to 0.
	        ans[0] = 0;

	        // Variable `j` is used to track the current index in the `ans` array.
	        // It starts at 1 since `ans[0]` is already initialized.
	        int j = 1;

	        // Loop through all integers from 1 to `n`.
	        for (int i = 1; i <= n; i++) {
	            // Store the current number in a variable `number`.
	            // This variable will be used to calculate the count of set bits for `i`.
	            int number = i;

	            // Initialize a counter `cnt` to store the number of set bits (1s) in the binary representation of `number`.
	            int cnt = 0;

	            // Use a while loop to count the set bits in `number`.
	            // The loop runs until `number` becomes 0 (i.e., all bits have been processed).
	            while (number != 0) {
	                // Check if the least significant bit (LSB) of `number` is set (1).
	                // This is done using the bitwise AND operation: `number & 1`.
	                // If the result is 1, it means the LSB is set, so increment the counter `cnt`.
	                if ((number & 1) == 1) {
	                    cnt++;
	                }

	                // Right shift the bits of `number` by 1 using the `>>` operator.
	                // This removes the least significant bit (LSB) and moves the remaining bits one position to the right.
	                // Effectively, this divides the number by 2 (ignoring the remainder).
	                number = number >> 1;
	            }

	            // After exiting the while loop, the variable `cnt` holds the count of set bits in `i`.
	            // Store this count in the result array `ans` at the current index `j`.
	            ans[j] = cnt;

	            // Increment `j` to move to the next index in the result array.
	            j++;
	        }

	        // After processing all numbers from 0 to `n`, return the result array `ans`.
	        return ans;
	    }
	
	    public static void main(String[] args) {
			
		}

}
