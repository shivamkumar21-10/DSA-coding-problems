package com.recursion;

import java.util.Stack;
import java.util.Stack;

public class SortStack {
	
    // Function to insert an element into the Stack at the correct position in sorted order
    public static void insert(Stack<Integer> inp, int ele) {
        // Base case: If Stack is empty or the last element is less than or equal to the element to insert
        if (inp.size() == 0 || inp.get(inp.size() - 1) <= ele) {
            inp.push(ele);  // Insert the element at the end
            return;
        }
        
        // Recursive case: Remove the last element and try inserting 'ele' recursively
        int last = inp.pop();  // Store the last element and Remove the last element
        insert(inp, ele);  // Recursive call to insert 'ele' in the sorted part
        inp.push(last);  // After inserting, add the last element back to the Stack
    }

    // Function to sort the Stack using recursion
    public static void sort(Stack<Integer> inp) {
        // Base case: A Stack with 1 element is already sorted
        if (inp.size() == 1) {
            return;
        }
        
        // Recursive case: Remove the last element and sort the rest of the Stack
        int temp = inp.pop();  // Store the last element and Remove the last element
        sort(inp);  // Recursively sort the remaining part of the Stack
        insert(inp, temp);  // Insert the removed element back into its correct position
    }
	public static void main(String[] args) {
        // Create a Stack and add elements to it
        Stack<Integer> v = new Stack<>();
        v.push(1);
        v.push(5);
        v.push(0);
        v.push(2);

        // Call the sort function to sort the Stack
        sort(v);
        
        // Print the sorted Stack
        System.out.println(v.pop());  // Output will be: [0, 1, 2, 5]

	}

}
