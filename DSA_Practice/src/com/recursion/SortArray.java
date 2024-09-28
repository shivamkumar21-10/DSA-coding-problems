package com.recursion;
import java.util.Vector;

public class SortArray {
    
    // Function to insert an element into the vector at the correct position in sorted order
    public static void insert(Vector<Integer> inp, int ele) {
        // Base case: If vector is empty or the last element is less than or equal to the element to insert
        if (inp.size() == 0 || inp.get(inp.size() - 1) <= ele) {
            inp.add(ele);  // Insert the element at the end
            return;
        }
        
        // Recursive case: Remove the last element and try inserting 'ele' recursively
        int last = inp.get(inp.size() - 1);  // Store the last element
        inp.remove(inp.size() - 1);  // Remove the last element
        insert(inp, ele);  // Recursive call to insert 'ele' in the sorted part
        inp.add(last);  // After inserting, add the last element back to the vector
    }

    // Function to sort the vector using recursion
    public static void sort(Vector<Integer> inp) {
        // Base case: A vector with 1 element is already sorted
        if (inp.size() == 1) {
            return;
        }
        
        // Recursive case: Remove the last element and sort the rest of the vector
        int temp = inp.get(inp.size() - 1);  // Store the last element
        inp.remove(inp.size() - 1);  // Remove the last element
        sort(inp);  // Recursively sort the remaining part of the vector
        insert(inp, temp);  // Insert the removed element back into its correct position
    }

    public static void main(String[] args) {
        // Create a vector and add elements to it
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(5);
        v.add(0);
        v.add(2);

        // Call the sort function to sort the vector
        sort(v);
        
        // Print the sorted vector
        System.out.println(v);  // Output will be: [0, 1, 2, 5]
    }
}

