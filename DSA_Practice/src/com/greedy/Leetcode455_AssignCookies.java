package com.greedy;

import java.util.Arrays;

public class Leetcode455_AssignCookies {
	
	class Solution {
	    public int findContentChildren(int[] g, int[] s) {
	        // Sort the greed factors of the children (g) and the sizes of cookies (s) in ascending order
	        // Sorting ensures we can match the smallest greed factor with the smallest cookie size that satisfies it
	        Arrays.sort(g);  //NlogN
	        Arrays.sort(s);//MlogM

	        // Initialize two pointers
	        // 'i' tracks the current child, and 'j' tracks the current cookie
	        int i = 0, j = 0;

	        // Traverse both arrays using the two-pointer technique
	        // Continue until we have checked all children or all cookies
	        while (i < g.length && j < s.length) { // TC - M
	            // If the current cookie can satisfy the current child's greed factor
	            if (g[i] <= s[j]) {
	                // Move to the next child and the next cookie
	                i++;
	                j++;
	            } else {
	                // If the current cookie can't satisfy the current child,
	                // try the next cookie (as cookies are sorted, the next one might be larger)
	                j++;
	            }
	        }

	        // Return the count of satisfied children (tracked by 'i')
	        return i;
	        
	        
	        //overall time complexity - O(NlogN + MlogM + M) - N length of g array, M - length of s array
	        //space complexity - O(1)
	    }
	}


}
