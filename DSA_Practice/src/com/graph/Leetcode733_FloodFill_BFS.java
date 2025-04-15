package com.graph;

import java.util.*;

public class Leetcode733_FloodFill_BFS {
	
	class Solution {

	    // Direction arrays to move in four possible directions: right, left, down, and up
	    int[] dx = new int[]{0, 0, 1, -1}; // Row movement (no change, no change, +1, -1)
	    int[] dy = new int[]{1, -1, 0, 0}; // Column movement (+1, -1, no change, no change)

	    int r; // Number of rows in the image
	    int c; // Number of columns in the image

	    /**
	     * A helper class representing a coordinate (row, column) in the grid.
	     */
	    class Pair {
	        int first;  // Row index
	        int second; // Column index

	        public Pair(int first, int second) {
	            this.first = first;
	            this.second = second;
	        }
	    }

	    /**
	     * Implements BFS (Breadth-First Search) to replace all connected pixels of the original color
	     * with the new color.
	     *
	     * @param sr         Starting row index
	     * @param sc         Starting column index
	     * @param image      2D image matrix
	     * @param orig_color The original color that needs to be replaced
	     * @param color      The new color to be filled
	     */
	    public void bfs(int sr, int sc, int[][] image, int orig_color, int color) {
	        Queue<Pair> q = new LinkedList<>(); // Queue for BFS traversal
	        q.add(new Pair(sr, sc)); // Add the starting pixel to the queue

	        // Change the color of the starting pixel
	        image[sr][sc] = color;

	        // Perform BFS
	        while (!q.isEmpty()) {
	            Pair front = q.poll(); // Remove the front element from the queue

	            int i = front.first;  // Current row
	            int j = front.second; // Current column

	            // Explore all four possible directions using the dx, dy arrays
	            for (int k = 0; k <= 3; k++) {
	                int ii = i + dx[k]; // New row index
	                int jj = j + dy[k]; // New column index

	                // If the new position is out of bounds or already processed, continue
	                if (ii < 0 || jj < 0 || ii >= r || jj >= c || image[ii][jj] != orig_color)
	                    continue;

	                // Add the new position to the queue
	                q.add(new Pair(ii, jj));

	                // Change the color of the new position
	                image[ii][jj] = color;
	            }
	        }
	    }

	    /**
	     * Implements the flood fill algorithm to replace all connected components of the
	     * starting pixel’s color with the given color using BFS.
	     *
	     * @param image 2D array representing the image
	     * @param sr    Row index of the starting pixel
	     * @param sc    Column index of the starting pixel
	     * @param color New color to be filled
	     * @return Modified image with the flood fill applied
	     */
	    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
	        // Store dimensions of the image
	        r = image.length;
	        c = image[0].length;

	        // Get the original color of the starting pixel
	        int orig_color = image[sr][sc];

	        // If the original color is already the target color, return the image as is (to prevent unnecessary processing)
	        if (orig_color == color)
	            return image;

	        // Start BFS from the given starting pixel
	        bfs(sr, sc, image, orig_color, color);
	        
	        // Return the modified image
	        return image;
	    }
	}

	/**
	 * Intuition:
	 * - The flood fill algorithm works like a "paint bucket" tool in an image editing program.
	 * - Given a starting pixel, we replace all **connected pixels** of the same color with a new color.
	 * - The connection is **4-directional (up, down, left, right)**, meaning diagonal pixels are **not** considered connected.
	 *
	 * Observations:
	 * - The algorithm stops at boundaries where pixels do not match the starting pixel’s color.
	 * - If the starting pixel's color is already the target color, we do nothing (prevents unnecessary processing).
	 * - Using BFS ensures that we process all connected pixels **level by level** in a queue-based manner.
	 *
	 * Logic:
	 * - Store the original color of the starting pixel.
	 * - If the original color is already the target color, return the image as is.
	 * - Otherwise, apply BFS to spread the new color to all connected pixels.
	 * - Each BFS iteration processes one pixel and enqueues its valid neighbors.
	 *
	 * Dry Run:
	 * ----------------------------------------
	 * Example Input:
	 * image = [[1,1,1],
	 *          [1,1,0],
	 *          [1,0,1]]
	 * sr = 1, sc = 1, color = 2
	 *
	 * Initial image:
	 * 1  1  1
	 * 1 [1] 0  <-- Start from (1,1)
	 * 1  0  1
	 *
	 * Steps:
	 * - Starting pixel (1,1) is **1**, so we change it to **2**.
	 * - Add (1,1) to queue.
	 * - Process (1,1):
	 *   - Move **right** to (1,2): **0** (different from original color), stop.
	 *   - Move **left** to (1,0): **1** → Change to **2** → Add to queue.
	 *   - Move **up** to (0,1): **1** → Change to **2** → Add to queue.
	 *   - Move **down** to (2,1): **0** (different from original color), stop.
	 * - Process (1,0) next, then (0,1), updating connected pixels similarly.
	 *
	 * Final image:
	 * 2  2  2
	 * 2  2  0
	 * 2  0  1
	 *
	 * Output: [[2,2,2],[2,2,0],[2,0,1]]
	 *
	 * Time Complexity:
	 * - In the worst case, we visit every pixel once: **O(m × n)**
	 *
	 * Space Complexity:
	 * - In the worst case (if all pixels are the same), the queue stores all pixels: **O(m × n)**
	 * - But typically, it's **O(1)** if the flood area is small.
	 */

}
