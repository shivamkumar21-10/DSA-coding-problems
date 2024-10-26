package com.stack;

import java.util.*;

public class NGR {
    
    // Method to find the next greater element for each element in the array
    static List<Integer> nextGreaterRight(int[] arr) {
        List<Integer> res = new ArrayList<>(); // List to store the result
        Stack<Integer> stk = new Stack<>(); // Stack to keep track of elements
        
        // Traverse the array from the end to the beginning
        for (int i = arr.length - 1; i >= 0; i--) {
            
            // If the stack is empty, no greater element exists to the right
            if (stk.isEmpty()) {
                res.add(-1);
            }
            // If the top of the stack is greater than the current element
            else if (!stk.isEmpty() && stk.peek() > arr[i]) {
                res.add(stk.peek()); // The top of the stack is the next greater element
            }
            // If the top of the stack is less than or equal to the current element
            else if (!stk.isEmpty() && stk.peek() <= arr[i]) {
                
                // Pop elements from the stack until we find a greater element or stack is empty
                while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                    stk.pop();
                }
                
                // If stack is empty, no greater element exists to the right
                if (stk.isEmpty()) {
                    res.add(-1);
                } else {
                    res.add(stk.peek()); // The top of the stack is now the next greater element
                }
            }
            
            // Push the current element to the stack for future comparisons
            stk.add(arr[i]);
        }
        
        // Reverse the result list to match the original array's left-to-right order
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] inp = new int[] {1, 3, 2, 4};
        System.out.println(nextGreaterRight(inp)); // Expected output: [3, 4, 4, -1]
    }
}
