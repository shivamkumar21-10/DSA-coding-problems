package com.sliding_window;

import java.util.*;

public class FirstNegativeInSubarrayOfSizeK {

    // Function to print the first negative number in each subarray of size 'k'
    static void printNegative(int[] arr, int k) {
        // Initialize pointers for the window's start (i) and end (j)
        int i = 0; 
        int j = 0;
        
        // List to store the elements of the current window
        List<Integer> lst = new ArrayList<>();
        
        // Loop until the end pointer 'j' reaches the end of the array
        while (j < arr.length) {
            
            // Add the current element to the list representing the window
            lst.add(arr[j]);
            
            // If the current window size is less than 'k', expand the window by moving 'j'
            if (j - i + 1 < k) {
                j++;
            }
            // If the window size is exactly 'k', process the window
            else if (j - i + 1 == k) {
                
                // Loop through the window to find the first negative number
                for (int p = 0; p < k; p++) {
                    if (lst.get(p) < 0) {
                        // Print the current window and the first negative number
                        System.out.println("Window " + lst + "  " + lst.get(p));
                        break; // Exit the loop after finding the first negative number
                    }
                }
                
                // Remove the element at the start (i) from the list to slide the window
                lst.remove(Integer.valueOf(arr[i]));
                
                // Slide the window forward by incrementing both 'i' and 'j'
                i++;
                j++;
            }
        }
    }
    

        // Function to print the first negative number in each subarray of size 'k'
        static void FirstNegative(int[] arr, int k) {
            // Initialize pointers for the window's start (i) and end (j)
            int i = 0; 
            int j = 0;
            
            // List to store negative elements of the current window
            List<Integer> lst = new ArrayList<>();
            
            // Loop until the end pointer 'j' reaches the end of the array
            while (j < arr.length) {
                
                // Add the current element to the list only if it's negative
                if (arr[j] < 0) {
                    lst.add(arr[j]);
                }
                
                // If the current window size is less than 'k', expand the window by moving 'j'
                if (j - i + 1 < k) {
                    j++;
                }
                // When the window size becomes exactly 'k', process the window
                else if (j - i + 1 == k) {
                    
                    // If there are any negative numbers in the list, print the first one
                    if (lst.size() > 0) {
                        System.out.println(lst.get(0));  // Print the first negative number in the window
                    } else {
                        System.out.println("No negative number in this window");
                    }

                    // Before sliding the window, remove the element at index 'i' if it is negative
                    if (arr[i] < 0 && lst.size() > 0) {
                        lst.remove(0);  // Remove the first element from the list if it's the element being slid out
                    }
                    
                    // Slide the window forward by incrementing both 'i' and 'j'
                    i++;
                    j++;
                }
            }
        }

        public static void main(String[] args) {
            // Test the FirstNegative function with a sample array and window size
            int arr[] = new int[] {12, -1, -7, 8, -15, 30, 16, 28, -9};
            FirstNegative(arr, 3);  // Output the first negative number in each subarray of size 3
        }
    }
