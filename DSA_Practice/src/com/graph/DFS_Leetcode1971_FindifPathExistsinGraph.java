package com.graph;
import java.util.*;

public class DFS_Leetcode1971_FindifPathExistsinGraph {
	
	

	class Solution {

	    /**
	     * Intuition:
	     * The problem is asking to check if there's a path between two nodes in an undirected graph.
	     * This can be done through **Graph Traversal** using **DFS (Depth-First Search)**.
	     * DFS explores a node and then recursively explores its neighbors. If it reaches the destination node, it returns true.
	     * 
	     * Example:
	     * Suppose we have n = 6 nodes and the following edges:
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
	     * If source = 0 and destination = 5, there is no path between them.
	     * If source = 3 and destination = 4, there is a path: (3 → 4).
	     * 
	     * Approach:
	     * - First, we **build the graph** using an adjacency list.
	     * - Then, we perform a **DFS traversal** to search for a path between the source and destination nodes.
	     * - If we find the destination node during traversal, we return true; otherwise, we return false.
	     */

	    // Function to build an adjacency list from the edge list
	    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
	        Map<Integer, List<Integer>> graph = new HashMap<>();

	        // Populate the graph with undirected edges
	        for (int i = 0; i < edges.length; i++) {
	            int a = edges[i][0]; // First node in the edge
	            int b = edges[i][1]; // Second node in the edge

	            // Add the edge in both directions (a -> b and b -> a)
	            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
	            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
	        }
	        return graph;
	    }

	    /**
	     * Function to determine if there is a path between the source and destination nodes.
	     * @param n - Number of nodes
	     * @param edges - List of edges forming the graph
	     * @param source - Starting node
	     * @param destination - Target node
	     * @return true if a path exists, otherwise false
	     */
	    public boolean validPath(int n, int[][] edges, int source, int destination) {
	        Set<Integer> isVisited = new HashSet<>(); // Set to track visited nodes
	        Map<Integer, List<Integer>> graph = buildGraph(edges); // Build the graph from edges
	        
	        // Perform DFS to check if there's a path from source to destination
	        return DFS(source, graph, isVisited, destination);
	    }

	    /**
	     * Depth-First Search (DFS) to check if a path exists from source to destination.
	     * @param source - The current node being explored
	     * @param graph - The adjacency list representing the graph
	     * @param isVisited - Set of visited nodes
	     * @param dest - The target destination node
	     * @return true if a path exists to destination, otherwise false
	     */
	    boolean DFS(int source, Map<Integer, List<Integer>> graph, Set<Integer> isVisited, int dest) {
	        // Base Case: If the current node is the destination, return true
	        if (source == dest) return true;

	        // Mark the current node as visited
	        isVisited.add(source);

	        // Explore all the neighbors of the current node
	        for (int nbr : graph.getOrDefault(source, new ArrayList<>())) {
	            // If the neighbor has not been visited, explore it
	            if (!isVisited.contains(nbr)) {
	                // Recursively perform DFS on the neighbor node
	                if (DFS(nbr, graph, isVisited, dest)) {
	                    return true; // If the destination is found, return true
	                }
	            }
	        }

	        // If no valid path to destination is found, return false
	        return false;
	    }
	}


}
