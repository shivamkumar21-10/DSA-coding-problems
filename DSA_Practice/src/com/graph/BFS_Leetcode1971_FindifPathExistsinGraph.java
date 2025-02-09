package com.graph;
import java.util.*;

public class BFS_Leetcode1971_FindifPathExistsinGraph {
	


	class Solution {

	    /**
	     * Intuition:
	     * The problem requires checking if there is a path between two nodes in an undirected graph.
	     * This can be solved using **Graph Traversal** techniques like **BFS (Breadth-First Search)** or **DFS (Depth-First Search)**.
	     * BFS is ideal because it explores all neighbors level by level, ensuring we reach the shortest path efficiently.
	     * 
	     * Example:
	     * Suppose we have n = 6 and the following edges:
	     * edges = [[0,1], [0,2], [3,5], [5,4], [4,3]]
	     * 
	     * Graph Representation:
	     *     0 -- 1
	     *     |
	     *     2
	     * 
	     *     3 -- 4
	     *     |    |
	     *     5 ---
	     * 
	     * If the source = 0 and destination = 5, there is no path between them.
	     * If the source = 3 and destination = 4, there is a path (3 → 4).
	     * 
	     * Approach:
	     * - First, we **construct an adjacency list** from the given edge list.
	     * - Then, we perform **BFS traversal** to explore nodes.
	     * - If we reach the `destination` node, return `true`; otherwise, return `false`.
	     */

	    // Function to build an adjacency list representation of the graph
	    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
	        Map<Integer, List<Integer>> graph = new HashMap<>();

	        // Iterate through all edges to populate the adjacency list
	        for (int i = 0; i < edges.length; i++) {
	            int a = edges[i][0]; // First node in the edge
	            int b = edges[i][1]; // Second node in the edge

	            // Add an undirected edge between 'a' and 'b'
	            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
	            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
	        }
	        return graph;
	    }

	    /**
	     * Function to determine if a path exists between source and destination.
	     * @param n - Number of nodes
	     * @param edges - List of edges in the graph
	     * @param source - Start node
	     * @param destination - Target node
	     * @return true if a path exists, otherwise false
	     */
	    public boolean validPath(int n, int[][] edges, int source, int destination) {
	        // Build the adjacency list representation of the graph
	        Map<Integer, List<Integer>> graph = buildGraph(edges);

	        // Perform BFS traversal to check if a path exists
	        return BFS(source, graph, destination);
	    }

	    /**
	     * Performs Breadth-First Search (BFS) traversal.
	     * @param source - The starting node
	     * @param graph - The adjacency list representation of the graph
	     * @param dest - The destination node
	     * @return true if a path exists, otherwise false
	     */
	    boolean BFS(int source, Map<Integer, List<Integer>> graph, int dest) {
	        Set<Integer> isVisited = new HashSet<>(); // Tracks visited nodes
	        Queue<Integer> q = new LinkedList<>(); // Queue for BFS traversal

	        // Initialize BFS with the source node
	        isVisited.add(source);
	        q.add(source);
	        
	        // BFS Traversal
	        while (!q.isEmpty()) {
	            int front = q.poll(); // Dequeue the front node
	            
	            // If we reach the destination, return true
	            if (front == dest) return true;

	            // Traverse all neighboring nodes
	            for (int nbr : graph.getOrDefault(front, new ArrayList<>())) {
	                if (!isVisited.contains(nbr)) {
	                    isVisited.add(nbr); // Mark the node as visited
	                    q.add(nbr); // Enqueue the node for further exploration
	                }
	            }
	        }
	        return false; // If BFS completes without finding the destination, return false
	    }
	}


}
