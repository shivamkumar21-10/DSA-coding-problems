package com.binary_search;

public class Leetcode275_HIndexII {
	
	    public int hIndex(int[] citations) {

	        // The total number of papers
	        int n = citations.length;

	        // Initialize the search range: 
	        // 'start' points to the beginning of the array
	        // 'end' points to the end of the array
	        int start = 0;
	        int end = n - 1;
	        
	        // Perform binary search
	        while (start <= end) {
	            // Find the middle index of the current range
	            int mid = (start + end) / 2;

	            // Calculate the number of papers that have at least `citations[mid]` citations
	            int papersWithAtLeastMidCitations = n - mid;

	            /**
	             * If the number of papers with at least `citations[mid]` citations 
	             * equals `citations[mid]`, we have found the h-index and can return it.
	             */
	            if (papersWithAtLeastMidCitations == citations[mid]) {
	                return citations[mid]; // Found the exact h-index
	            }

	            /**
	             * If the number of papers with at least `citations[mid]` citations 
	             * is greater than `citations[mid]`, we need to look for a larger h-index.
	             * So, move the `start` pointer to `mid + 1` to search in the right half.
	             */
	            if (papersWithAtLeastMidCitations > citations[mid]) {
	                start = mid + 1;
	            } 
	            /**
	             * Otherwise, if `papersWithAtLeastMidCitations` is less than `citations[mid]`,
	             * this means `citations[mid]` is too large to be the h-index.
	             * Move the `end` pointer to `mid - 1` to search in the left half.
	             */
	            else {
	                end = mid - 1;
	            }
	        }

	        /**
	         * At this point, the binary search has completed without finding an exact match
	         * where `citations[mid] == papersWithAtLeastMidCitations`.
	         * 
	         * In this case, the h-index is determined by the number of papers with at least
	         * `citations[start]` citations. This is calculated as `n - start`:
	         * 
	         * Explanation of `n - start`:
	         * - `start` is the index where the condition `citations[start]` would match 
	         *   the h-index if we could extend the logic.
	         * - `n - start` gives the count of papers from index `start` to the end of the array.
	         * - This count represents the number of papers that have at least `citations[start]` 
	         *   citations, which is the closest approximation to the h-index when no exact match exists.
	         */
	        return n - start;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
