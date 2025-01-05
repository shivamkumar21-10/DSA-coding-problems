package com.leetcodeChallanges;

public class Leetcode2381_ShiftingLettersII {
	
	
		//Brute Force
	    public String shiftingLetters(String s, int[][] shifts) {
	        StringBuffer sb = new StringBuffer(s);

	        for(int i=0; i<shifts.length; i++){
	            int dir = shifts[i][2];
	            for(int j=shifts[i][0]; j<=shifts[i][1]; j++){
	                if(dir == 0){
	                    if(sb.charAt(j) == 'a') sb.setCharAt(j,'z');
	                    else sb.setCharAt(j,(char)(sb.charAt(j)-1));
	                }
	                else{
	                    if(sb.charAt(j) == 'z') sb.setCharAt(j,'a');
	                    else sb.setCharAt(j,(char)(sb.charAt(j)+1));
	                }
	            }
	        }
	        return sb.toString();
	    }
	    
	    //Using prefix sum 
	    class Solution {
	        public String shiftingLetters(String s, int[][] shifts) {
	            int n = s.length(); // Length of the input string
	            int[] shift = new int[n + 1]; // Prefix sum array to store net shifts for each character

	            // Step 1: Populate the `shift` array using the shift operations
	            for (int[] shiftOp : shifts) {
	                int start = shiftOp[0];   // Start index of the range
	                int end = shiftOp[1];     // End index of the range
	                int direction = shiftOp[2]; // Direction of the shift (1 for right, 0 for left)

	                // Add 1 for right shift and subtract 1 for left shift at the start index
	                shift[start] += (direction == 1 ? 1 : -1);

	                // Subtract 1 for right shift and add 1 for left shift after the end index
	                if (end + 1 < n) {
	                    shift[end + 1] -= (direction == 1 ? 1 : -1);
	                }
	            }

	            /*
	             * Logic: 
	             * The prefix sum array `shift` is used to calculate the net effect of all shifts
	             * at each character. By applying the changes at the `start` index and reverting 
	             * them at `end + 1`, we efficiently represent all range-based operations in O(n).
	             * This eliminates the need to process each shift operation individually.
	             */

	            // Step 2: Compute the prefix sum of the `shift` array to get the net shift at each index
	            int currentShift = 0;
	            for (int i = 0; i < n; ++i) {
	                currentShift += shift[i]; // Accumulate the shift value for the current index
	                shift[i] = currentShift; // Store the net shift value at index `i`
	            }

	            /*
	             * Logic:
	             * The prefix sum transforms the `shift` array into a representation where each 
	             * index contains the total cumulative shift required at that character.
	             * This allows us to handle overlapping ranges efficiently.
	             */

	            // Step 3: Apply the net shifts to each character in the string
	            StringBuilder result = new StringBuilder(s); // StringBuilder to modify the string
	            for (int i = 0; i < n; ++i) {
	                // Compute the net shift for the current character within the range of 26 (alphabet size)
	                int netShift = (shift[i] % 26 + 26) % 26;

	                /*
	                 * Logic:
	                 * `shift[i] % 26`: Reduces the shift to a valid range within the alphabet.
	                 * `(shift[i] % 26 + 26) % 26`: Handles negative shifts by ensuring the result is always positive.
	                 */

	                // Calculate the new character after applying the shift
	                result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
	            }

	            // Step 4: Return the modified string as the result
	            return result.toString();
	        }
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
