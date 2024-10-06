package com.recursion;
import java.util.*;

public class Leetcode90_SubsetsII {
	


	    // Helper function to find all subsets, avoiding duplicates
	    public static List<List<Integer>> solve(List<Integer> nums, List<Integer> op, List<List<Integer>> result, HashMap<List<Integer>, String> map) {
	        // Base case: if there are no elements left in the input list 'nums'
	        if (nums.isEmpty()) {
	            // Check if the subset has already been added to avoid duplicates
	            if (map.containsKey(op)) {
	                return result; // Subset already exists, no need to add again
	            }

	            // Add the subset to the map and result list
	            map.put(op, "PRESENT");
	            result.add(new ArrayList<>(op)); // Add a copy of the current subset to the result
	            return result; // Return the updated result list
	        }

	        // Create two options: one without including the current element
	        List<Integer> op1 = new ArrayList<>(op);  
	        // Create another option including the current element
	        List<Integer> op2 = new ArrayList<>(op);
	        op2.add(nums.get(0)); // Add the first element from 'nums' to op2

	        // Remove the first element from 'nums' to consider the rest
	        List<Integer> remainingNums = new ArrayList<>(nums);
	        remainingNums.remove(0);

	        // Recurse without including the current element (op1)
	        solve(remainingNums, op1, result, map);
	        // Recurse including the current element (op2)
	        solve(remainingNums, op2, result, map);

	        return result; // Return the accumulated result
	    }

	    // Function to generate all subsets of the input array including duplicates, but only adding unique subsets
	    public static List<List<Integer>> subsetsWithDup(int[] nums) {
	        HashMap<List<Integer>, String> map = new HashMap<>(); // HashMap to track the unique subsets
	        Arrays.sort(nums); // Sort the array to easily manage duplicate elements
	        List<List<Integer>> res = new ArrayList<>(); // List to store the final subsets
	        List<Integer> num = new ArrayList<>(); // Convert input array to list
	        for (int i = 0; i < nums.length; i++) {
	            num.add(nums[i]);
	        }

	        List<Integer> op = new ArrayList<>(); // An empty list to hold current subset during recursion
	        return solve(num, op, res, map); // Call the helper function
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,2};
		System.out.println(subsetsWithDup(nums));

	}

}
