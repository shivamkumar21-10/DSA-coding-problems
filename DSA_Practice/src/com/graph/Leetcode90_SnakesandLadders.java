package com.graph;

import java.util.*;

public class Leetcode90_SnakesandLadders {
	
	class Solution {
	    public int snakesAndLadders(int[][] board) {
	        int n = board.length;

	        // --------------------- Intuition and Observations ---------------------
	        // Goal: Reach from square 1 to square n*n using minimum dice throws.
	        // Treat board as a graph: each square is a node, and dice rolls are edges.
	        // If a square has a snake/ladder (i.e., board[i][j] != -1), you must move to that destination.

	        // --------------------- Dry Run Example ---------------------
	        // Let's consider a 3x3 board as an example:
	        // board = [
	        //  {-1, -1, -1},   <- row 0 (top)
	        //  {-1, 9,  8},    <- row 1
	        //  {-1, -1, -1}    <- row 2 (bottom)
	        // ]
	        // Flattened (zigzag order) = [dummy_0, -1, -1, -1, 8, 9, -1, -1, -1]
	        // Index:                   =  0        1   2   3   4  5  6   7   8

	        // If you're at square 1:
	        // Dice throws allow you to go to 2,3,4,5,6,7
	        // - 2,3 => no snake/ladder → go to 2,3
	        // - 4 → has ladder to 8 → go to 8
	        // - 5 → has ladder to 9 → go to 9
	        // - 6,7 → no ladder/snake → go to 6,7
	        // So from 1, neighbors are [2,3,8,9,6,7]
	        // Continue BFS from those nodes.

	        // --------------------- Step 1: Flatten the board ---------------------

	        boolean flag = true; // True: left to right, False: right to left for zigzag
	        List<Integer> connections = new ArrayList<>();

	        connections.add(0); // Add dummy to make 1-indexing easier

	        int node = 1; // Square number

	        for (int i = n - 1; i >= 0; i--) {
	            if (flag) {
	                for (int j = 0; j < n; j++) {
	                    connections.add(board[i][j]);
	                    node++;
	                }
	            } else {
	                for (int j = n - 1; j >= 0; j--) {
	                    connections.add(board[i][j]);
	                    node++;
	                }
	            }
	            flag = !flag;
	        }

	        // --------------------- Step 2: Build the Graph ---------------------

	        Map<Integer, List<Integer>> graph = new HashMap<>();

	        for (int i = 1; i < n * n; i++) { // For each square from 1 to n*n - 1
	            for (int count = 1; count <= 6; count++) { // Dice throw 1 to 6
	                int nbr = i + count;
	                if (nbr <= n * n) {
	                    // If there's a ladder/snake at 'nbr', go to that destination
	                    int dest = connections.get(nbr) != -1 ? connections.get(nbr) : nbr;
	                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(dest);
	                }
	            }
	        }

	        // --------------------- Step 3: BFS to find minimum number of dice throws ---------------------

	        int level = 0; // Number of dice throws
	        Set<Integer> visited = new HashSet<>();
	        Queue<Integer> q = new LinkedList<>();

	        q.add(1); // Start from square 1
	        visited.add(1);

	        while (!q.isEmpty()) {
	            int sz = q.size(); // Nodes at current level (same dice throw count)
	            while (sz > 0) {
	                int pos = q.poll(); // Current square

	                // Dry Run Example (continued):
	                // Let's say we reach 9 (final square), return level
	                if (pos == n * n) return level;

	                for (int nbr : graph.getOrDefault(pos, new ArrayList<>())) {
	                    if (!visited.contains(nbr)) {
	                        visited.add(nbr);
	                        q.add(nbr);
	                    }
	                }

	                sz--;
	            }

	            level += 1; // Increment dice throw count after each level
	        }

	        return -1; // If we can't reach the end
	    }
	}


}
