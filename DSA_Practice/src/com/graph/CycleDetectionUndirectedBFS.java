package com.graph;

import java.util.*;

public class CycleDetectionUndirectedBFS {

    /**
     * Function to detect a cycle in an undirected graph using BFS
     * @param source The starting node for BFS traversal
     * @param graph Adjacency list representation of the graph
     * @param isVisited Set to keep track of visited nodes
     * @param parent Array to store the parent of each node
     * @return true if a cycle is detected, false otherwise
     */
    static boolean BFSCycleDetection(int source, Map<Integer, List<Integer>> graph, Set<Integer> isVisited,
                                     int[] parent) {
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS traversal
        q.add(source);
        isVisited.add(source);
        parent[source] = -1; // Mark the source as having no parent

        // BFS traversal
        while (!q.isEmpty()) {
            int front = q.poll(); // Dequeue the front element

            // Traverse all its neighbors
            for (int nbr : graph.getOrDefault(front, new ArrayList<>())) {
                if (!isVisited.contains(nbr)) {
                    // If the neighbor is not visited, mark it and set parent
                    isVisited.add(nbr);
                    q.add(nbr);
                    parent[nbr] = front;
                } else {
                    // If the neighbor is already visited and is not the parent, cycle exists
                    if (parent[front] != nbr) {
                        return true; // Cycle detected
                    }
                }
            }
        }
        return false; // No cycle found
    }

    public static void main(String[] args) {
        // Edge list representation of the graph
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0, 1));
        edgeList.add(Arrays.asList(1, 2));
        edgeList.add(Arrays.asList(2, 4));
        edgeList.add(Arrays.asList(3, 4));
        edgeList.add(Arrays.asList(3, 0));

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = 0; // Variable to store the maximum node index

        // Construct the adjacency list
        for (List<Integer> edge : edgeList) {
            int a = edge.get(0);
            int b = edge.get(1);
            n = Math.max(n, Math.max(a, b)); // Find the largest node value

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        n++; // Adjust n to be the number of nodes

        Set<Integer> isVisited = new HashSet<>(); // Set to track visited nodes
        int[] parent = new int[n]; // Parent array to maintain parent-child relationship
        Arrays.fill(parent, -1); // Initialize parent array with -1

        boolean cycleExists = false;
        for (int node : graph.keySet()) {
            if (!isVisited.contains(node)) {
                // Perform BFS from each unvisited node (handles disconnected components)
                if (BFSCycleDetection(node, graph, isVisited, parent)) {
                    cycleExists = true;
                    break;
                }
            }
        }

        System.out.println("Cycle Exists: " + cycleExists);

        /**
         * -------------- DRY RUN --------------
         * Given edge list:
         *  0 -- 1 -- 2 -- 4
         *  |         /
         *  3 ------- 
         * 
         * Step-by-step execution:
         * 1. Start BFS from node 0.
         * 2. Visit 1 and mark 0 as parent.
         * 3. Visit 3 and mark 0 as parent.
         * 4. Visit 2 from 1 and mark 1 as parent.
         * 5. Visit 4 from 2 and mark 2 as parent.
         * 6. Visit 3 from 4, but 3's parent is 0, so cycle is detected.
         * 
         * Output: Cycle Exists: true
         */
    }
}
