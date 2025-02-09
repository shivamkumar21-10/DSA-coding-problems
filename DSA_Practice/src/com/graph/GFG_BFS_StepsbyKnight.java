package com.graph;
import java.util.*;
public class GFG_BFS_StepsbyKnight {

	    // Define all 8 possible moves of a knight
	    static List<List<Integer>> moves = Arrays.asList(
	        Arrays.asList(-1, -2), Arrays.asList(-1, 2),
	        Arrays.asList(1, -2), Arrays.asList(1, 2),
	        Arrays.asList(-2, -1), Arrays.asList(-2, 1),
	        Arrays.asList(2, -1), Arrays.asList(2, 1)
	    );

	    /**
	     * Performs BFS to find the shortest path from the knight's position to the target.
	     * 
	     * @param src_x     The starting row of the knight (0-based index)
	     * @param src_y     The starting column of the knight (0-based index)
	     * @param target_x  The target row (0-based index)
	     * @param target_y  The target column (0-based index)
	     * @param n         The size of the chessboard (N x N)
	     * @return Minimum number of steps required to reach the target position
	     */
	    static int bfs(int src_x, int src_y, int target_x, int target_y, int n) {
	        // If already at the target, no moves needed
	        if (src_x == target_x && src_y == target_y) return 0;

	        // Queue to store (x, y) positions for BFS traversal
	        Queue<List<Integer>> queue = new LinkedList<>();

	        // Visited array to mark positions we have already explored
	        boolean[][] visited = new boolean[n][n];

	        // Start BFS from the knight's position
	        queue.add(Arrays.asList(src_x, src_y));
	        visited[src_x][src_y] = true;

	        int steps = 0;  // Step counter

	        // BFS traversal
	        while (!queue.isEmpty()) {
	            int size = queue.size(); // Nodes at the current level

	            // Process all positions at the current step level
	            while (size > 0) {
	                List<Integer> front = queue.poll();
	                int x = front.get(0);
	                int y = front.get(1);

	                // If we reach the target position, return the number of steps taken
	                if (x == target_x && y == target_y) {
	                    return steps;
	                }

	                // Explore all 8 possible moves of the knight
	                for (int k = 0; k < moves.size(); k++) {
	                    int new_x = x + moves.get(k).get(0);
	                    int new_y = y + moves.get(k).get(1);

	                    // Check if the new position is within bounds and not visited
	                    if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < n && !visited[new_x][new_y]) {
	                        visited[new_x][new_y] = true;  // Mark position as visited
	                        queue.add(Arrays.asList(new_x, new_y));  // Add new position to queue
	                    }
	                }
	                size--; // Decrement nodes left to process in this level
	            }
	            steps++; // Increase step count after completing all moves at the current level
	        }

	        return -1; // If BFS completes without finding the target, return -1
	    }

	    /**
	     * Function to find the minimum number of steps a knight needs to reach the target position.
	     *
	     * @param KnightPos  The knight's initial position (1-based index)
	     * @param TargetPos  The target position to reach (1-based index)
	     * @param N          The size of the chessboard (N x N)
	     * @return Minimum steps required for the knight to reach the target position
	     */
	    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
	        // Convert 1-based input to 0-based for easier array indexing
	        int src_x = KnightPos[1] - 1;  // Column index
	        int src_y = KnightPos[0] - 1;  // Row index
	        int target_x = TargetPos[1] - 1;
	        int target_y = TargetPos[0] - 1;

	        return bfs(src_x, src_y, target_x, target_y, N);
	    }

	    public static void main(String[] args) {
	        

	        // Example 1:
	        int KnightPos[] = {4, 5};   // (row=4, col=5)
	        int TargetPos[] = {1, 1};   // (row=1, col=1)
	        int N = 6;  // 6x6 Chessboard

	        // Expected output: 3
	        System.out.println(minStepToReachTarget(KnightPos, TargetPos, N));
	    }
	


}
