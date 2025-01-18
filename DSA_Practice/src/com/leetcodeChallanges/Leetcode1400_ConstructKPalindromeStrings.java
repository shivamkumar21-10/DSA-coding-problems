package com.leetcodeChallanges;

import java.util.HashMap;

public class Leetcode1400_ConstructKPalindromeStrings {
	
	class Solution {
	    public boolean canConstruct(String s, int k) {
	        // Step 1: Create a HashMap to count the frequency of each character in the string
	        HashMap<Character, Integer> map = new HashMap<>();
	        // Variable to count the number of characters with odd frequencies
	        int cnt = 0;

	        // Step 2: If k is greater than the length of the string, it's impossible to create k palindromes
	        // Explanation: To create `k` palindromes, we need at least `k` characters. If the length of `s` is less than `k`,
	        // it means there aren't enough characters to divide into `k` separate strings. Thus, return false.
	        if (k > s.length()) return false;

	        // Step 3: Populate the frequency map
	        // Loop through each character in the string `s`
	        for (int i = 0; i < s.length(); i++) {
	            char ele = s.charAt(i); // Current character in the string
	            // Update the frequency of the character in the map
	            // If the character doesn't exist in the map, default its count to 0 and increment it by 1
	            map.put(ele, map.getOrDefault(ele, 0) + 1);
	        }

	        // Step 4: Count the number of characters with odd frequencies
	        // Explanation: For a string to be a palindrome, each character must appear an even number of times,
	        // except for at most one character (which can appear in the middle of the palindrome).
	        // For each character frequency, check if it is odd. If it is, increment the `cnt` variable.
	        for (Integer val : map.values()) {
	            if (val % 2 != 0) {
	                cnt++;
	            }
	        }

	        // Step 5: Check if the number of odd-frequency characters (cnt) is less than or equal to `k`
	        // Explanation: Each odd-frequency character requires its own palindrome (to appear in the middle).
	        // Therefore, the minimum number of palindromes required is equal to the number of odd-frequency characters (`cnt`).
	        // If `cnt` exceeds `k`, it means we can't split the string into `k` palindromes while satisfying the palindrome condition.
	        // Otherwise, it is possible to construct `k` palindrome strings.
	        return cnt <= k;
	    }
	}


}
