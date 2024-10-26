package com.sliding_window;

public class Leetcode1248_CountNumberofNiceSubarrays {
	
	/*Logic
	 * If the number of odd numbers in the window is exactly k, we start counting subarrays. 
	 * At least one valid subarray exists, which is from i to j. The countPrefix is set to 1.
	 * 
	 * We then check for even numbers at the start of the window (moving temp from i forward) and count how many valid subarrays 
	 * can be formed that include these even numbers.
	 * Each additional even number at the beginning of the window allows for another valid subarray to be formed that ends at j.
	 * 
	 */
	
	    public int numberOfSubarrays(int[] nums, int k) {
	        int odd = 0; // This will track the number of odd numbers in the current window
	        int i = 0;   // Left pointer for the sliding window
	        int ans = 0; // To store the total count of 'nice' subarrays
	        int countPrefix = 0; // To track how many valid subarrays we can form after reaching exactly k odd numbers

	        // Iterate through the array using the right pointer `j`
	        for (int j = 0; j < nums.length; j++) {
	            // If the current number is odd, increase the count of odd numbers
	            if (nums[j] % 2 != 0) {
	                odd++;
	            }

	            // When the count of odd numbers exceeds `k`, adjust the left pointer `i`
	            while (odd > k) {
	                // If the number at `i` is odd, decrease the odd count since we are moving `i` forward
	                if (nums[i] % 2 != 0) {
	                    odd--;
	                }
	                // Move the left pointer `i` forward
	                i++;
	            }

	            // When we have exactly `k` odd numbers in the current window
	            if (odd == k) {
	                countPrefix = 1; // Start counting valid subarrays. At least the current subarray is valid

	                int temp = i; // We use a temporary pointer `temp` to count how many even numbers are before the subarray
	                // For each even number at the beginning of the window, it forms additional valid subarrays
	                while (temp < nums.length && nums[temp] % 2 == 0) {
	                    countPrefix++; // Increase the count for each even number at the start
	                    temp++;
	                }

	                // Add the number of valid subarrays formed from the current window to the total answer
	                ans += countPrefix;
	            }
	        }

	        // Return the total count of 'nice' subarrays
	        return ans;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
