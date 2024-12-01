package com.recursion;

import java.util.Stack;

public class ReverseStack {
    // Function to reverse the entire stack using recursion
    public static void reverse(Stack<Integer> s) {
        // Base case: If stack has only one element, it is already reversed
        if (s.size() == 1) {
            return;
        }

        // Recursive case: Remove the top element and reverse the rest of the stack
        int temp = s.pop();  // Store the top element
        reverse(s);  // Recursively reverse the remaining stack
        insert(s, temp);  // Insert the removed element back at the correct position in reversed stack
    }

    // Helper function to insert an element at the bottom of the stack
    private static void insert(Stack<Integer> s, int temp) {
        // Base case: If stack is empty, push the element to the bottom
        if (s.size() == 0) {
            s.push(temp);  // Push the element when the stack is empty
            return;
        }

        // Recursive case: Pop the top element, insert 'temp' at the bottom, and then push the popped element back
        int last = s.pop();  // Store the top element
        insert(s, temp);  // Recursively insert 'temp' in the smaller stack
        s.push(last);  // Push the last element back to the top after 'temp' is inserted at the bottom
    }

    public static void main(String[] args) {
        // Create a stack and push elements onto it
        Stack<Integer> s = new Stack<>();
        // Pushing elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);        
        // Printing the original stack
        System.out.println("Original Stack: " + s);
        // Call the reverse function to reverse the stack
        reverse(s);        
        // Print the reversed stack
        System.out.println("Reversed Stack: " + s);
    }
}
