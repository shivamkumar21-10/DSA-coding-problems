package com.sliding_window;

public class MaximumSumSubarrayOfSizeK {

    // Function to calculate the maximum sum of a subarray of size 'k'
    static int maxSum(int[] arr, int k) {
        
        // Initialize pointers for the window's start (i) and end (j)
        int i = 0;
        int j = 0;
        
        // Initialize the sum of the current window and the maximum sum
        int sum = 0;
        int maxSum = Integer.MIN_VALUE; // Set maxSum to the smallest possible value initially
        
        // Loop until the end pointer 'j' reaches the end of the array
        while (j < arr.length) {
            
            // Add the current element to the sum
            sum += arr[j];
            
            // If the current window size is less than 'k', expand the window by moving 'j'
            if (j - i + 1 < k) {
                j++;
            } 
            // If the window size is exactly 'k', process the window
            else if (j - i + 1 == k) {
                
                // Update maxSum if the current window's sum is larger
                maxSum = Math.max(maxSum, sum);
                
                // Slide the window: subtract the element at the start (i) from the sum
                sum -= arr[i];
                
                // Move the window ahead by incrementing both 'i' and 'j'
                i++;
                j++;
            }
        }
        
        // Return the maximum sum found
        return maxSum;
    }

    public static void main(String[] args) {
        // Test the maxSum function with a sample array and window size
        int arr[] = new int[] {1, 5, 4, 2, 9, 9, 9};
        System.out.println(maxSum(arr, 3));  // Output the result for k=3
    }

}
