package com.stack;

import java.util.*;

// Main class to calculate Stock Span
public class StockSpan {

    // Static inner class to represent a key-value pair (price, index)
    public static class Pair<E, T> {
        E key;     // The key (price of the stock)
        T value;   // The value (index of the stock price)

        public Pair(E key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    // Method to calculate the stock span for each day in the price array
    static List<Integer> span(int[] arr) {
        List<Integer> idx = new ArrayList<>();  // To store indices of the nearest greater values to the left
        List<Integer> res = new ArrayList<>();  // To store the final span result for each day

        Stack<Pair<Integer, Integer>> stk = new Stack<>();  // Stack to keep track of prices and their indices

        // Traverse each element in the array to calculate its span
        for (int i = 0; i < arr.length; i++) {
            // If stack is empty, no greater element on the left
            if (stk.empty()) {
                idx.add(-1);  // Add -1 for no greater element to the left
            }
            // If the top element of the stack has a greater price
            else if (stk.peek().key > arr[i]) {
                idx.add(stk.peek().value);  // Store the index of the greater element on the left
            }
            // If the top element of the stack is less than or equal to the current price
            else if (stk.peek().key <= arr[i]) {
                // Pop elements until we find a greater element or the stack becomes empty
                while (!stk.isEmpty() && stk.peek().key <= arr[i]) {
                    stk.pop();
                }
                // After the loop, check if stack is empty (no greater element)
                if (stk.isEmpty()) {
                    idx.add(-1);  // No greater element found on the left
                } else {
                    idx.add(stk.peek().value);  // Add the index of the greater element
                }
            }
            // Push the current element and its index onto the stack
            Pair<Integer, Integer> p = new Pair<>(arr[i], i);
            stk.add(p);
        }

        // Calculate the span for each day based on the stored indices
        for (int i = 0; i < idx.size(); i++) {
            res.add(i - idx.get(i));  // Span is the difference in indices
        }
        return res;  // Return the calculated span for each day
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = new int[] {100, 80, 60, 70, 60, 75, 85};  // Input stock prices
        System.out.println(span(arr));  // Call span function and print results
    }
}
