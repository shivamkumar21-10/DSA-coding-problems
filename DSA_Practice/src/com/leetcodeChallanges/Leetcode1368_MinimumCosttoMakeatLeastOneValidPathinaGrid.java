package com.leetcodeChallanges;

import java.util.*;

public class Leetcode1368_MinimumCosttoMakeatLeastOneValidPathinaGrid {
	

	    // Directions to move: right, left, down, up.
	    // Used to calculate the next cell's position.
	    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	    public int minCost(int[][] grid) {
	        int rows = grid.length, cols = grid[0].length;

	        // Array to keep track of the minimum cost to reach each cell.
	        int[][] minCost = new int[rows][cols];
	        for (int row = 0; row < rows; row++) {
	            // Initialize all cells with a very large value as we are looking for the minimum cost.
	            Arrays.fill(minCost[row], Integer.MAX_VALUE);
	        }

	        // Priority Queue to process cells in increasing order of cost.
	        // Each element in the queue is an array: {currentCost, row, col}.
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

	        // Start from the top-left corner (0,0) with cost 0.
	        pq.offer(new int[] { 0, 0, 0 });
	        minCost[0][0] = 0; // Minimum cost to reach the starting cell is 0.

	        // Process cells in the priority queue.
	        while (!pq.isEmpty()) {
	            int[] curr = pq.poll(); // Get the cell with the smallest cost.
	            int cost = curr[0], row = curr[1], col = curr[2];

	            // Skip this cell if we've already found a cheaper way to reach it.
	            if (minCost[row][col] < cost) continue;

	            // Explore all 4 possible directions (right, left, down, up).
	            for (int dir = 0; dir < 4; dir++) {
	                int nextRow = row + dirs[dir][0];
	                int nextCol = col + dirs[dir][1];

	                // Check if the next cell is within grid bounds.
	                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
	                    // Calculate the cost to move to the next cell.
	                    // If the current direction matches the grid's arrow, no additional cost (0).
	                    // Otherwise, add a cost of 1.
	                    int nextCellCost = (dir + 1 == grid[row][col]) ? 0 : 1;
	                    int newCost = cost + nextCellCost;

	                    // If we've found a cheaper way to reach the next cell, update its cost.
	                    if (newCost < minCost[nextRow][nextCol]) {
	                        minCost[nextRow][nextCol] = newCost; // Update the minimum cost for this cell.
	                        pq.offer(new int[] { newCost, nextRow, nextCol }); // Add the cell to the priority queue.
	                    }
	                }
	            }
	        }

	        // Return the minimum cost to reach the bottom-right corner of the grid.
	        return minCost[rows - 1][cols - 1];
	    }
	


}
