package com.graph;

import java.util.*;

public class GeeksVillageAndWells {

    // Custom Pair class to hold coordinates in the grid
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * Intuition:
     * - We are given a grid with Wells (W), Houses (H), Empty land ('.'), and Trees (T).
     * - Water can spread from wells to houses only via empty land ('.').
     * - We want to find the minimum time it takes to reach each house from the *nearest* well.
     * - All wells act as simultaneous starting points — making this a perfect use case for **Multi-source BFS**.
     *
     * Key Observations:
     * 1. BFS ensures the shortest path is always found first.
     * 2. The cost of reaching a house is 2 * distance from the well.
     * 3. Trees are blockers and should not be visited.
     * 4. Empty lands are used only to traverse, not to be included in result (value 0).
     * 5. Non-house and non-well cells will eventually be marked as 0 in the result.
     *
     * Logic:
     * - Initialize a result array to store final distances.
     * - Add all wells to the queue and mark them with 0.
     * - Perform BFS to explore the grid level-by-level.
     * - Track the time (or BFS level) to calculate time to reach each house (2 * level).
     * - Empty lands are visited to enable reaching houses but are not part of the answer.
     *
     * @param c The input grid representing the village
     * @param n Number of rows
     * @param m Number of columns
     * @return 2D array with time taken to reach each house from nearest well or 0 for non-house cells
     */
    int[][] villageAndWells(List<List<Character>> c, int n, int m) {

        // Directions for movement: down, up, right, left
        List<List<Integer>> direction = Arrays.asList(
                Arrays.asList(1, 0),
                Arrays.asList(-1, 0),
                Arrays.asList(0, 1),
                Arrays.asList(0, -1)
        );

        // Result array initialized with -1 meaning 'not visited yet'
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }

        // Queue for BFS traversal
        Queue<Pair> q = new LinkedList<>();

        // Step 1: Add all wells ('W') as BFS starting points
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c.get(i).get(j) == 'W') {
                    q.add(new Pair(i, j));
                    result[i][j] = 0; // Distance from well to itself is 0
                }
            }
        }

        int counter = 1; // Represents the current BFS level or distance from well in steps

        // Step 2: BFS to expand water flow from all wells simultaneously
        while (!q.isEmpty()) {
            int size = q.size(); // Number of cells to process at current BFS level
            while (size > 0) {
                Pair front = q.poll();
                int row = front.first;
                int col = front.second;

                // Check all 4 possible directions from the current cell
                for (List<Integer> dir : direction) {
                    int newRow = row + dir.get(0);
                    int newCol = col + dir.get(1);

                    // Make sure the cell is inside the grid
                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                        char cell = c.get(newRow).get(newCol);

                        // Case 1: If the cell is a house and has not been visited
                        if (cell == 'H' && result[newRow][newCol] == -1) {
                            result[newRow][newCol] = counter * 2; // Each move takes 2 units of time
                            q.add(new Pair(newRow, newCol)); // Add to BFS queue for further traversal
                        }
                        // Case 2: If the cell is empty land and unvisited
                        else if (cell == '.' && result[newRow][newCol] == -1) {
                            result[newRow][newCol] = 0; // Mark visited to avoid reprocessing
                            q.add(new Pair(newRow, newCol));
                        }
                    }
                }
                size--; // Move to next cell in the current level
            }
            counter++; // Increase BFS level
        }

        // Step 3: Final cleanup — reset non-house and non-well cells to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c.get(i).get(j) != 'H' && c.get(i).get(j) != 'W') {
                    result[i][j] = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Dry Run Example:
        // Input Grid:
        // [ ['W', '.', 'H'],
        //   ['.', 'H', '.'],
        //   ['.', '.', 'H'] ]

        // Step-by-step traversal:
        // BFS Level 0:
        //   Start from (0,0) → Well → result[0][0] = 0
        // BFS Level 1:
        //   Explore (0,1) and (1,0) → Empty cells → mark visited
        // BFS Level 2:
        //   From (0,1) and (1,0) explore:
        //     (1,1) is 'H' → result[1][1] = 4
        // BFS Level 3:
        //   From (1,1) explore:
        //     (0,2) is 'H' → result[0][2] = 6
        //     (2,1) is '.' → visited
        // BFS Level 4:
        //   From (2,1) explore:
        //     (2,2) is 'H' → result[2][2] = 8

        // Summary:
        // House at (1,1) reached in 2 steps → 2 * 2 = 4
        // House at (0,2) reached in 3 steps → 3 * 2 = 6
        // House at (2,2) reached in 4 steps → 4 * 2 = 8

        // In actual testing, you can prepare List<List<Character>> and call villageAndWells()
    }
}
