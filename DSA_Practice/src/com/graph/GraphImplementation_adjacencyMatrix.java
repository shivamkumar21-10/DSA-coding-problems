package com.graph;

import java.util.*;

public class GraphImplementation_adjacencyMatrix {
	
	static void print_graph(int[][] adjacency_matrix) {
		for(int i=1; i<=4; i++) {
			System.out.print("Node: " + i + ", Neighbours: ");
			for(int j=1; j<=4; j++) {
				if(adjacency_matrix[i][j]==1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> edgeList = new ArrayList<>();
		edgeList.add(Arrays.asList(1,2));
		edgeList.add(Arrays.asList(2,3));
		edgeList.add(Arrays.asList(3,4));
		edgeList.add(Arrays.asList(4,2));
		edgeList.add(Arrays.asList(1,3));
		
		int n=5;
		
		int[][] adjacencyMatrix = new int[edgeList.size()][edgeList.size()];
		for(int i=0; i<edgeList.size(); i++) {
			int a = edgeList.get(i).get(0);
			int b = edgeList.get(i).get(1);
			
			adjacencyMatrix[a][b] = 1;
			adjacencyMatrix[b][a] = 1;
		}
		
		print_graph(adjacencyMatrix);
		
		
	}
}
