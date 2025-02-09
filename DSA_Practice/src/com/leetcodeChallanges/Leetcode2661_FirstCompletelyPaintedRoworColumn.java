package com.leetcodeChallanges;
import java.util.*;

public class Leetcode2661_FirstCompletelyPaintedRoworColumn {
	
//	    Intuition and Logic:
//		Mapping the Matrix:
//
//		The matrix mat contains unique values, and we need to determine the first row or column that is completely marked by the sequence arr.
//		Using a map, we associate each value in mat with its position (row, column) for quick lookups.
//		Tracking Unmarked Cells:
//
//		countRow[i] keeps track of how many unmarked cells are left in the i-th row.
//		countCol[j] keeps track of how many unmarked cells are left in the j-th column.
//		Initially, all rows and columns are unmarked, so:
//		countRow[i] = col (number of columns in each row).
//		countCol[j] = row (number of rows in each column).
//		Processing arr:
//
//		Iterate through the array arr (the order in which cells are marked).
//		For each value in arr:
//		Use the map to get its (row, column) position in the matrix.
//		Decrement the count of unmarked cells for the corresponding row and column.
//		Checking Completion:
//
//		After marking a cell, check if the row (countRow[pos[0]]) or column (countCol[pos[1]]) becomes 0.
//		If either becomes 0, it means that the row or column is completely marked, and we return the current index i.
//		Return Result:
//
//		If the loop completes without finding a completely marked row or column, return -1.
	
	class Solution {
	    public int firstCompleteIndex(int[] arr, int[][] mat) {
	        int row = mat.length; // Total number of rows in the matrix
	        int col = mat[0].length; // Total number of columns in the matrix

	        // A map to store the position (row and column) of each element in the matrix.
	        // Key: Matrix element, Value: Array containing row and column indices of the element
	        Map<Integer, int[]> map = new HashMap<>();

	        // Arrays to track the number of unmarked cells remaining in each row and column.
	        int[] countRow = new int[row]; // For rows: Keeps track of how many unmarked cells are left in each row.
	        int[] countCol = new int[col]; // For columns: Keeps track of how many unmarked cells are left in each column.

	        // Initialize the counters for rows and columns.
	        // Initially, all cells in a row are unmarked, so countRow[i] = number of columns (col).
	        // Similarly, countCol[j] = number of rows (row) for all columns.
	        Arrays.fill(countRow, col); 
	        Arrays.fill(countCol, row);

	        // Populate the map with the position of each matrix element.
	        // The map will allow O(1) access to the position of any matrix element.
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                map.put(mat[i][j], new int[] { i, j }); // Store the row and column indices for the element `mat[i][j]`.
	            }
	        }

	        // Process the elements of the array `arr` in the given order.
	        // This simulates marking elements in the matrix as we encounter them in `arr`.
	        for (int i = 0; i < arr.length; i++) {
	            // Get the position (row and column) of the current element from the map.
	            int[] pos = map.get(arr[i]);
	            
	            // Decrement the count of unmarked cells in the corresponding row and column.
	            // `--countRow[pos[0]]`: Decrease the count of unmarked cells in the row.
	            // `--countCol[pos[1]]`: Decrease the count of unmarked cells in the column.
	            if (--countRow[pos[0]] == 0 || --countCol[pos[1]] == 0) {
	                // If after decrementing, any row or column becomes fully marked (i.e., count reaches 0),
	                // return the current index `i` as this is the first complete row/column.
	                return i;
	            }
	        }

	        // If no row or column is completely marked after processing all elements in `arr`, return -1.
	        return -1;
	    }
	}


}
