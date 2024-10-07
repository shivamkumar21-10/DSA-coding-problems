package com.recursion;
import java.util.ArrayList;
import java.util.List;

public class Leetcode39_CombinationSum {


	    // Recursive method to find all combinations that sum up to the target
	    public static List<List<Integer>> solve(int idx, List<Integer> arr, int target, List<Integer> ds, List<List<Integer>> ans) {
	        // Base case: if the target is 0, we found a valid combination
	        if (target == 0) {
	            // Add the current combination (ds) to the result
	            ans.add(new ArrayList<>(ds));
	            return ans; // Return to backtrack and explore other combinations
	        }

	        // If the index exceeds the array size or the target becomes negative, return
	        if (idx >= arr.size() || target < 0) {
	            return ans; // No valid combination can be formed
	        }

	        // Include the current element if it does not exceed the target
	        if (arr.get(idx) <= target) {
	            ds.add(arr.get(idx)); // Choose the current element to include in the combination
	            // Recur with the updated target and the same index (allowing duplicates)
	            solve(idx, arr, target - arr.get(idx), ds, ans);
	            // Backtrack: remove the last added element to explore other combinations
	            ds.remove(ds.size() - 1);
	        }

	        // Exclude the current element and move to the next element
	        solve(idx + 1, arr, target, ds, ans);
	        
	        return ans; // Return the list of valid combinations found
	    }

	    // Method to initiate the combination sum process
	    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<Integer> ip = new ArrayList<>(); // To hold the candidates as a list
	        List<Integer> ds = new ArrayList<>(); // To hold the current combination
	        List<List<Integer>> ans = new ArrayList<>(); // To hold all valid combinations
	        
	        // Convert the array of candidates into a List for easier manipulation
	        for (int i = 0; i < candidates.length; i++) {
	            ip.add(candidates[i]);
	        }

	        // Start the recursive process from index 0 with the target value
	        return solve(0, ip, target, ds, ans);
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp = new int[] {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(inp,target));

	}

}
