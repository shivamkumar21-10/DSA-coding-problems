package com.graph;

import java.util.*;

public class Leetcode1319_NumberofOperationstoMakeNetworkConnected {
	
	class Solution {

	    /**
	     * DFS traversal to mark all nodes in the current connected component.
	     * This helps in counting how many disconnected components we have.
	     */
	    void DFStraversal(int source, Map<Integer, List<Integer>> graph, int n, Set<Integer> isVisited) {
	        isVisited.add(source); // Mark current node as visited

	        // Explore all its neighbors (if any)
	        for (int nbr : graph.getOrDefault(source, new ArrayList<>())) {
	            if (!isVisited.contains(nbr)) {
	                DFStraversal(nbr, graph, n, isVisited); // Recursive DFS
	            }
	        }
	    }

	    /**
	     * This method finds the minimum number of operations needed to connect all computers in a network.
	     * Each connection is like a wire between two computers.
	     *
	     * @param n Total number of computers (numbered from 0 to n-1)
	     * @param connections Existing direct connections between computers
	     * @return Minimum number of operations to make the network fully connected, or -1 if not possible
	     */
	    public int makeConnected(int n, int[][] connections) {

	        /**
	         * 🔍 Intuition:
	         * - We need to connect all 'n' computers into one single network.
	         * - We can do this only if there are at least (n - 1) cables, otherwise it's impossible.
	         * - If enough cables are available, we can use DFS to find the number of disconnected components.
	         * - To connect 'k' disconnected components, we need (k - 1) cables.
	         */

	        /**
	         * 📌 Key Observations:
	         * 1. This is an undirected graph problem.
	         * 2. Each connection forms an edge between two computers.
	         * 3. We can count the number of connected components using DFS or BFS.
	         * 4. To fully connect all components, we need (components - 1) extra operations.
	         */

	        // Step 1: Build the graph (Adjacency List)
	        Map<Integer, List<Integer>> graph = new HashMap<>();

	        for (int[] conn : connections) {
	            int a = conn[0];
	            int b = conn[1];

	            // Add the edge in both directions (undirected graph)
	            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
	            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
	        }

	        // Step 2: Count number of connected components
	        int connComp = 0; // Number of connected components
	        Set<Integer> isVisited = new HashSet<>(); // To track visited computers

	        for (int i = 0; i < n; i++) {
	            if (!isVisited.contains(i)) {
	                // Start a new DFS if the node is not visited yet
	                DFStraversal(i, graph, n, isVisited);
	                connComp += 1; // One more disconnected component
	            }
	        }

	        // Step 3: Check if we have enough cables
	        if (connections.length < n - 1) {
	            // Not enough cables to connect all computers
	            return -1;
	        }

	        // Step 4: Return number of operations required to connect components
	        // We need (connComp - 1) cables to connect 'connComp' components
	        return connComp - 1;
	    }

	    /**
	     * 🧪 Dry Run Example:
	     * Input:
	     * n = 4, connections = [[0,1],[0,2],[1,2]]
	     *
	     * Build Graph:
	     * 0 -> [1,2]
	     * 1 -> [0,2]
	     * 2 -> [0,1]
	     * 3 -> [] (not in any connection)
	     *
	     * DFS:
	     * Start at 0 → visits 0, 1, 2
	     * Node 3 is still unvisited → new component
	     *
	     * Total components = 2
	     * Required connections = 2 - 1 = 1
	     *
	     * Result: 1 operation required
	     */
	}


}
