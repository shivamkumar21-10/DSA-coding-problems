package com.graph;

public class Leetcode733_FloodFill_DFS {
	
	class Solution {

	    // Direction arrays to move in four possible directions: right, left, down, and up
	    int[] dx = new int[]{0, 0, 1, -1}; // Row movement (no change, no change, +1, -1)
	    int[] dy = new int[]{1, -1, 0, 0}; // Column movement (+1, -1, no change, no change)

	    int r; // Number of rows in the image
	    int c; // Number of columns in the image

	    /**
	     * Performs a Depth-First Search (DFS) to replace all connected pixels of the original color
	     * with the new color.
	     *
	     * @param i          Current row index
	     * @param j          Current column index
	     * @param image      2D image matrix
	     * @param orig_color The original color that needs to be replaced
	     * @param color      The new color to be filled
	     */
	    public void dfs(int i, int j, int[][] image, int orig_color, int color) {
	        // Base case: If the current cell is out of bounds or does not have the original color, return
	        if (i < 0 || j < 0 || i >= r || j >= c || image[i][j] != orig_color) return;

	        // Change the color of the current cell
	        image[i][j] = color;

	        // Explore all four possible directions using the dx, dy arrays
	        for (int k = 0; k <= 3; k++) {
	            int ii = i + dx[k]; // New row index
	            int jj = j + dy[k]; // New column index

	            // Recursive call to process the adjacent cell
	            dfs(ii, jj, image, orig_color, color);
	        }
	    }

	    /**
	     * Implements the flood fill algorithm to replace all connected components of the
	     * starting pixel’s color with the given color.
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

	        // If the original color is the same as the new color, return the image as is (to prevent infinite recursion)
	        if (orig_color == color) return image;

	        // Start DFS from the given starting pixel
	        dfs(sr, sc, image, orig_color, color);
	        
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
	 * - If the starting pixel's color is already the target color, we do nothing (prevents unnecessary recursion).
	 * - Using DFS ensures that all connected pixels are explored and updated recursively.
	 *
	 * Logic:
	 * - Store the original color of the starting pixel.
	 * - If the original color is already the target color, return the image as is.
	 * - Otherwise, apply DFS to spread the new color to all connected pixels.
	 * - Each DFS call checks four directions and replaces the color recursively.
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
	 * - Move **right** to (1,2): **0** (different from original color), stop.
	 * - Move **left** to (1,0): **1** → Change to **2** → Continue DFS.
	 * - Move **up** to (0,1): **1** → Change to **2** → Continue DFS.
	 * - Move **down** to (2,1): **0** (different from original color), stop.
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
	 * - In the worst case (if all pixels are the same), the recursion depth is **O(m × n)**
	 * - But typically, it's **O(1)** if the flood area is small.
	 */


}
