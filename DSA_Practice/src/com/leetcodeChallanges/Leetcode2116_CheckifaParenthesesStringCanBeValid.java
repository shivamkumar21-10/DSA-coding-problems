package com.leetcodeChallanges;

public class Leetcode2116_CheckifaParenthesesStringCanBeValid {
	class Solution {
	    /**
	     * This method checks if the given string of parentheses can be valid
	     * after considering the flexibility of some positions (based on `lockStatus`).
	     *
	     * Logic:
	     * 1. A valid parentheses string has equal numbers of '(' and ')' in the correct order.
	     *    Flexible positions (where `lockStatus[i] == '0'`) can be treated as either '(' or ')'.
	     * 2. The method performs two passes:
	     *    a. **Left-to-Right Pass**:
	     *       - Tracks balance using `balanceCount`.
	     *       - Increment balance when encountering '(' or a flexible position (`lockStatus[i] == '0'`).
	     *       - Decrement balance when encountering ')'.
	     *       - If `balanceCount` ever becomes negative, there are unmatched ')' at that point, so return `false`.
	     *    b. **Right-to-Left Pass**:
	     *       - Tracks balance using `balanceCount` again but checks the reverse order.
	     *       - Increment balance when encountering ')' or a flexible position (`lockStatus[i] == '0'`).
	     *       - Decrement balance when encountering '('.
	     *       - If `balanceCount` ever becomes negative, there are unmatched '(' at that point, so return `false`.
	     * 3. If both passes are valid (i.e., `balanceCount >= 0` throughout), the string can be made valid.
	     *
	     * Time Complexity: O(n), where n is the length of the string.
	     * Space Complexity: O(1), since we only use a few variables.
	     *
	     * @param inputString - The string containing parentheses ('(' and ')').
	     * @param lockStatus - A string of the same length, where:
	     *                   - '1' indicates the character is locked (cannot change).
	     *                   - '0' indicates the character is flexible (can be '(' or ')').
	     * @return true if the string can be valid; false otherwise.
	     */
	    public boolean canBeValid(String inputString, String lockStatus) {
	        if (inputString.length() % 2 != 0) 
	            return false;

	        // Left-to-Right Pass
	        int balanceCount = 0;
	        for (int i = 0; i < inputString.length(); i++) {
	            if (lockStatus.charAt(i) == '0' || inputString.charAt(i) == '(') 
	                balanceCount++;
	            else 
	                balanceCount--;
	            if (balanceCount < 0) 
	                return false; // Unmatched ')' found
	        }

	        // Right-to-Left Pass
	        balanceCount = 0;
	        for (int i = inputString.length() - 1; i >= 0; i--) {
	            if (lockStatus.charAt(i) == '0' || inputString.charAt(i) == ')') 
	                balanceCount++;
	            else 
	                balanceCount--;
	            if (balanceCount < 0) 
	                return false; // Unmatched '(' found
	        }

	        return true;
	    }
	}


}
