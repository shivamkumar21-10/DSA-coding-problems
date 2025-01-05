package com.recursion;

public class Leetcode231_PowerofTwo {
	
    /**
     * Method to check if a given number is a power of two.
     * 
     * @param n The input integer.
     * @return True if the number is a power of two, otherwise false.
     */
    public static boolean isPowerOfTwo(int n) {
        // Base Case 1: If n equals 1, it is a power of two (2^0 = 1).
        if (n == 1) {
            return true; // A single call returns true if n is exactly 1.
        }
        
        // Base Case 2: If n is less than or equal to 0, it cannot be a power of two.
        if (n <= 0) {
            return false; // Return false if n is negative or zero.
        }

        // Recursive Case:
        // Check if the number is divisible by 2 (n % 2 == 0) and make a recursive call
        // with n divided by 2 (n/2). 
        /*
         * Explanation:
         * 1. The number `n` must be divisible by 2 for it to qualify as a power of two.
         *    If n is odd, we immediately return false since powers of two are always even
         *    (except 2^0 = 1, which is handled in the base case).
         * 
         * 2. We then reduce the problem size by dividing `n` by 2 and recursively check
         *    if the smaller value (n/2) is a power of two.
         * 
         * 3. The recursion will continue until we either:
         *    - Reach n == 1, in which case we return true.
         *    - Encounter an odd value or reach a number <= 0, in which case we return false.
         */
        return n % 2 == 0 && isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        // Test the function with a positive example where n = 16 (2^4).
        System.out.println(isPowerOfTwo(16)); // Expected output: true
    }
}
