package com.recursion;

public class TowerOfHanoi {

    // Recursive method to solve the Tower of Hanoi problem
    // Parameters:
    // n: The number of disks to move
    // src: The source rod where disks are initially placed
    // helper: The auxiliary rod used for moving disks
    // dest: The destination rod where disks need to be moved
    public static void solve(int n, String src, String helper, String dest) {
        // Base case: If there is only one disk, we can directly move it to the destination
        if (n == 1) {
            System.out.println("Moved plate from " + src + " to " + dest);
            return; // Exit the function after the move
        }
        
        // Recursive case:
        // Step 1: Move the top (n-1) disks from the source rod to the helper rod, using the destination as a temporary rod.
        solve(n - 1, src, dest, helper);
        
        // Step 2: Move the nth (largest) disk from the source rod to the destination rod.
        System.out.println("Moved plate from " + src + " to " + dest);
        
        // Step 3: Move the (n-1) disks from the helper rod to the destination rod, using the source as a temporary rod.
        solve(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        // Example: Solve the Tower of Hanoi problem with 3 disks
        int n = 3; // Number of disks
        // Initial rods: A (source), B (helper), C (destination)
        solve(n, "A", "B", "C"); // Solve the problem by moving all disks from A to C
    }
}
