package com.leetcodeChallanges;
import java.util.*;

public class Leetcode1079_LetterTilePossibilities {
	

	class Solution {
	    /**
	     * Recursive function to generate all unique sequences using backtracking.
	     *
	     * Intuition:
	     * - We generate all possible sequences by picking characters one by one.
	     * - We use a HashSet to store unique sequences and avoid duplicate counting.
	     * - Each recursive call removes one character from `inp` and adds it to `op`.
	     *
	     * Key Observations:
	     * - If we consider all permutations of the given characters, some will be duplicates.
	     * - Using a Set ensures that we count only unique sequences.
	     * - Since we can form sequences of different lengths, we should add every `op` (except empty ones) to the set.
	     *
	     * Dry Run Example:
	     * Input: "AAB"
	     * 
	     * Step-by-step recursion:
	     * 1. Start with: inp = "AAB", op = ""
	     * 2. Pick 'A': newInp = "AB", newOp = "A"
	     * 3. Pick 'A': newInp = "B", newOp = "AA"
	     * 4. Pick 'B': newInp = "", newOp = "AAB" -> Add "AAB" to set
	     * 5. Backtrack: Choose 'B' before second 'A': newOp = "AB" -> Add "AB" to set
	     * 6. Pick remaining 'A': newOp = "ABA" -> Add "ABA" to set
	     * 7. Start with 'B' first: newOp = "B" -> Add "B" to set
	     * 8. Pick 'A': newOp = "BA" -> Add "BA" to set
	     * 9. Pick second 'A': newOp = "BAA" -> Add "BAA" to set
	     * 
	     * Unique Sequences Generated: {"A", "AA", "AAB", "AB", "ABA", "B", "BA", "BAA"}
	     * Answer: 8
	     */
	    private void solve(String inp, String op, Set<String> set) {
	        // Base case: When a non-empty sequence is formed, add it to the set.
	        if (!op.isEmpty()) {
	            set.add(op);
	        }

	        // Iterate through each character in the input string
	        for (int i = 0; i < inp.length(); i++) {
	            // Form a new input string by removing the selected character
	            String newInp = inp.substring(0, i) + inp.substring(i + 1);
	            // Append the selected character to the current sequence
	            String newOp = op + inp.charAt(i);
	            // Recursive call with updated input and output
	            solve(newInp, newOp, set);
	        }
	    }

	    /**
	     * Counts the number of unique sequences that can be formed using the given tiles.
	     *
	     * Approach:
	     * - Uses backtracking to generate all possible sequences.
	     * - Stores sequences in a HashSet to remove duplicates.
	     *
	     * Complexity Analysis:
	     * - O(n!) in the worst case, as it generates all permutations.
	     * - O(n²) extra space due to substring operations.
	     */
	    public int numTilePossibilities(String tiles) {
	        Set<String> set = new HashSet<>();
	        solve(tiles, "", set);
	        return set.size();
	    }
	}


}
