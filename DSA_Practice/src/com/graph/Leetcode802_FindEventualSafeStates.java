package com.graph;
import java.util.ArrayList;
import java.util.List;

public class Leetcode802_FindEventualSafeStates {
	


	static class  Solution {

	    /**
	     * Performs DFS to detect cycles in a directed graph.
	     * Uses `curr_path` to track nodes in the current DFS traversal.
	     *
	     * @param adj        Adjacency list of the graph
	     * @param src        Current node in DFS traversal
	     * @param vis        Boolean array to mark visited nodes
	     * @param curr_path  Boolean array to track nodes in the current DFS path
	     * @return           True if a cycle is detected, false otherwise
	     *
	     * Intuition:
	     * - The `curr_path` array helps in detecting cycles by tracking nodes in the current DFS recursion stack.
	     * - If a node is encountered that is already in `curr_path`, a cycle is detected, making all nodes in this cycle unsafe.
	     * - Backtracking (removing from `curr_path`) ensures that once we finish processing a node, it is no longer part of the recursion.
	     */
	    public boolean dfs(List<List<Integer>> adj, int src, boolean[] vis, boolean[] curr_path) {
	        vis[src] = true;       // Mark current node as visited
	        curr_path[src] = true; // Mark node as part of current DFS path

	        for (int x : adj.get(src)) {  // Traverse all adjacent nodes
	            if (!vis[x] && dfs(adj, x, vis, curr_path)) { 
	                // If the neighbor is unvisited, perform DFS on it
	                // If DFS detects a cycle in the deeper recursion, return true
	                return true;
	            } else if (curr_path[x]) { 
	                // If the neighbor is already in the current DFS path, a cycle exists
	                return true;
	            }
	        }
	        
	        curr_path[src] = false; // Backtrack: Remove the node from the current DFS path
	        return false; // No cycle found in this DFS call
	    }

	    /**
	     * Finds all eventual safe nodes (nodes not part of any cycle).
	     * A node is safe if it does not belong to a cycle.
	     *
	     * @param graph  Input graph represented as adjacency list
	     * @return       List of nodes that are eventual safe nodes
	     *
	     * Intuition:
	     * - We perform DFS on all unvisited nodes and mark nodes in cycles using `curr_path`.
	     * - Any node that is still `true` in `curr_path` is part of a cycle and is unsafe.
	     * - Nodes that are not part of a cycle will always lead to terminal nodes, making them safe.
	     */
	    public List<Integer> eventualSafeNodes(int[][] graph) {
	        int n = graph.length;
	        List<List<Integer>> adj = new ArrayList<>();

	        // Convert input adjacency matrix to an adjacency list
	        for (int i = 0; i < n; i++) {
	            List<Integer> list = new ArrayList<>();
	            for (int j = 0; j < graph[i].length; j++) {
	                list.add(graph[i][j]);
	            }
	            adj.add(list);
	        }

	        boolean[] vis = new boolean[n];      // Array to mark visited nodes
	        boolean[] curr_path = new boolean[n]; // Array to track nodes in the current DFS path

	        // Run DFS on all unvisited nodes
	        for (int i = 0; i < n; i++) {
	            if (!vis[i]) {
	                dfs(adj, i, vis, curr_path);
	            }
	        }

	        // Collect all safe nodes (nodes that are not part of a cycle)
	        List<Integer> ans = new ArrayList<>();
	        for (int i = 0; i < curr_path.length; i++) {
	            if (!curr_path[i]) { // Nodes not in a cycle are safe
	                ans.add(i);
	            }
	        }

	        return ans; // Return the list of safe nodes
	    }
	}

	    public static void main(String[] args) {
	        Solution sol = new Solution();
	        int[][] graph = {
	            {1,2}, {2,3}, {5}, {0}, {5}, {}, {}
	        };

	        System.out.println("Safe nodes: " + sol.eventualSafeNodes(graph));
	    }
}

	/**
	 * Dry Run:
	 * 
	 * Input Graph (Adjacency List):
	 * 0 -> {1,2}
	 * 1 -> {2,3}
	 * 2 -> {5}
	 * 3 -> {0}
	 * 4 -> {5}
	 * 5 -> {}
	 * 6 -> {}
	 * 
	 * Execution:
	 * 
	 * Step 1: Start DFS from node 0:
	 * - `curr_path[0] = true`, move to 1.
	 * - `curr_path[1] = true`, move to 2.
	 * - `curr_path[2] = true`, move to 5.
	 * - `curr_path[5] = true`, no more neighbors, backtrack.
	 * - `curr_path[2] = false`, backtrack to 1.
	 * - `curr_path[1] = false`, backtrack to 0.
	 * - `curr_path[0] = false`, backtrack completed.
	 * 
	 * Step 2: Start DFS from node 3:
	 * - `curr_path[3] = true`, move to 0.
	 * - `curr_path[0]` is already visited but not in `curr_path`, no cycle detected.
	 * - Backtrack: `curr_path[3] = false`
	 * 
	 * Step 3: Start DFS from node 4:
	 * - `curr_path[4] = true`, move to 5.
	 * - `curr_path[5] = true`, no more neighbors, backtrack.
	 * - `curr_path[4] = false`
	 * 
	 * Step 4: Nodes 5 and 6 are already terminal nodes.
	 * 
	 * Result:
	 * - Nodes not in any cycle: [2, 4, 5, 6]
	 * - Output: [2, 4, 5, 6]
	 */


