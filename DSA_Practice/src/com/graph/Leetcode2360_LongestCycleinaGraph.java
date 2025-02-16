package com.graph;

public class Leetcode2360_LongestCycleinaGraph {
	
	class Solution {
	    int LongestCycleLen; // Stores the maximum cycle length found

	    /**
	     * Intuition:
	     * -----------
	     * Given a directed graph where each node has at most one outgoing edge, it forms a set of chains or cycles.
	     * If a node is already visited, we do not need to process it again. If we find a cycle, we can compute
	     * its length using the difference of entry times stored in `current_path`.
	     * 
	     * Idea:
	     * ------
	     * 1. Perform DFS traversal on all unvisited nodes.
	     * 2. Maintain a `current_path` array to track the order of visits within a single DFS call.
	     * 3. If we encounter a node already in `current_path`, we detect a cycle and calculate its length.
	     * 4. If no cycle exists, return -1.
	     */

	    /**
	     * Performs DFS to detect cycles and compute the longest cycle length.
	     *
	     * @param cycleLen      The length of the current path being explored.
	     * @param source        The current node being visited.
	     * @param graph         The adjacency list representation of the graph.
	     * @param isVisited     A boolean array to track visited nodes.
	     * @param current_path  Stores the entry time in DFS to track cycles.
	     */
	    void dfs(int cycleLen, int source, int[] graph, boolean[] isVisited, int[] current_path) {
	        cycleLen++; // Increase the cycle length for the current path
	        isVisited[source] = true; // Mark current node as visited
	        current_path[source] = cycleLen; // Store entry time of node

	        int nbr = graph[source]; // Get the next node in the directed graph
	        
	        if (nbr != -1) { // If the node has an outgoing edge
	            if (!isVisited[nbr]) {  
	                // If the neighbor is unvisited, continue DFS
	                dfs(cycleLen, nbr, graph, isVisited, current_path);
	            } else if (current_path[nbr] != 0) {  
	                /**
	                 * Cycle Detected:
	                 * ----------------
	                 * If we encounter a node that is already in `current_path`, it means we have a cycle.
	                 * The cycle length can be determined by subtracting the entry time of `nbr` from
	                 * the current node's entry time and adding 1.
	                 */
	                int currCycleLen = current_path[source] - current_path[nbr] + 1;
	                LongestCycleLen = Math.max(LongestCycleLen, currCycleLen);
	            }
	        }

	        // Backtracking: Remove node from the current path after exploring all neighbors
	        current_path[source] = 0;
	    }

	    /**
	     * Finds the longest cycle in a directed graph where each node has at most one outgoing edge.
	     *
	     * @param edges Array representing the directed graph.
	     * @return Length of the longest cycle found, or -1 if no cycle exists.
	     */
	    public int longestCycle(int[] edges) {
	        LongestCycleLen = -1; // Initialize with -1 to represent no cycle found
	        
	        int n = edges.length;

	        boolean[] vis = new boolean[n];    
		    int[] curr_path = new int[n];

	        // Start DFS from all unvisited nodes to cover all components
	        for (int i = 0; i < n; i++) {
		        if (!vis[i]) {
		            dfs(0, i, edges, vis, curr_path);
		        }
		    }
	        return LongestCycleLen;
	    }

	    /**
	     * Dry Run:
	     * -------------------------
	     * Input:
	     * int[] edges = {1, 2, 3, 4, 2};  
	     *
	     * Graph Representation:
	     *  0 → 1 → 2 → 3 → 4
	     *         ↑       ↓
	     *         └-------┘
	     *
	     * Execution Steps:
	     * 1. Start DFS from node 0
	     *    - current_path = [1, 0, 0, 0, 0]
	     * 2. Move to node 1
	     *    - current_path = [1, 2, 0, 0, 0]
	     * 3. Move to node 2
	     *    - current_path = [1, 2, 3, 0, 0]
	     * 4. Move to node 3
	     *    - current_path = [1, 2, 3, 4, 0]
	     * 5. Move to node 4
	     *    - current_path = [1, 2, 3, 4, 5]
	     * 6. Node 4 points back to node 2 (Cycle Detected)
	     *    - Cycle Length = current_path[4] - current_path[2] + 1
	     *    - Cycle Length = 5 - 3 + 1 = 3
	     *    - LongestCycleLen = 3
	     * 7. Backtrack and continue DFS on other components if any.
	     * 
	     * Final Output: 3
	     */
	}



}
