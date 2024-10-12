package com.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//permutaion of strings without duplicates

public class PermutationOfStrings {
	
	// Recursive method to generate all unique permutations of the input string
	public static List<String> permutations(String inp, String op, List<String> res) {
		
		// Base case: if the input string is empty, add the result to the list
		if(inp.isEmpty()) {
			// You can use a map to remove duplicates, but it's commented out here
//			if(map.containsKey(op)) {
//				return res;
//			}
//			map.put(op, "PRESENT");
			
			// Add the generated permutation to the result list
			res.add(op);
			return res;
		}

		// HashMap used to prevent generating the same permutation multiple times
		HashMap<Character, String> map = new HashMap<>();

		// Loop through each character of the input string
		for(int i = 0; i < inp.length(); i++) {
			
			// If the character hasn't been used before, proceed with recursion
			if(!map.containsKey(inp.charAt(i))) {
				// Mark the character as used
				map.put(inp.charAt(i), "PRESENT");				
				// Create new input by removing the current character
				String newInp = inp.substring(0, i) + inp.substring(i + 1);		
				// Add the current character to the output string
				String newOp = op + inp.charAt(i);				
				// Recursive call with the updated input and output
				permutations(newInp, newOp, res);
			}
		}
		return res;  // Return the final list of permutations
	}

	public static void main(String[] args) {
		// Initialize the result list to store permutations
		List<String> res = new ArrayList<>();
		
		// Call the permutations method with input string and print the result
		System.out.println(permutations("aac", "", res));
	}
}
