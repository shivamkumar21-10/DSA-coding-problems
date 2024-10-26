package com.sliding_window;

public class Leetcode2653_SlidingSubarrayBeauty {
	
	    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
	        int i = 0; // Left boundary of the sliding window
	        int j = 0; // Right boundary of the sliding window
	        int p = 0; // Position in the answer array
	        int[] freq = new int[51]; // Frequency array to count negative numbers (0 to -50 only)
	        
	        int[] ans = new int[nums.length - k + 1]; // Result array to store the "beauty" of each subarray

	        while (j < nums.length) {
	            // Step 1: Update frequency for the current negative number in the window
	            if (nums[j] < 0) {
	                freq[Math.abs(nums[j])]++;
	            }

	            // Step 2: When the window size reaches `k`, calculate the beauty of the subarray
	            if (j - i + 1 == k) {
	                int count = 0; // Counter to track the number of negatives encountered in descending order
	                
	                // Traverse the frequency array from high to low, looking for the `x`th smallest negative
	                for (int z = 50; z >= 0; z--) {
	                    count += freq[z]; // Add the count of current negative number (-z)
	                    if (count >= x) { // If we reach the `x`th negative, set the beauty as -z
	                        ans[p] = -z;
	                        break;
	                    }
	                }
	                
	                // If there are fewer than `x` negative numbers, beauty is 0
	                if (count < x) {
	                    ans[p] = 0;
	                }
	                
	                // Move to the next position in the answer array
	                p++;

	                // Step 3: Slide the window by removing the effect of the number at `i` (left boundary)
	                if (nums[i] < 0) {
	                    freq[Math.abs(nums[i])]--; // Decrement the frequency of the outgoing negative number
	                }
	                
	                // Move the left boundary to the right
	                i++;
	            }
	            // Step 4: Move the right boundary to expand the window
	            j++;
	        }
	        
	        return ans; // Return the array containing the beauty values of each subarray
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
