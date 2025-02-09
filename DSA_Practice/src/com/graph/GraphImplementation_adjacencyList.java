package com.graph;

import java.util.*;

public class GraphImplementation_adjacencyList {
	
	static void print_graph(Map<Integer, List<Integer>> graph) {
		for(int key : graph.keySet()) {
			System.out.print("Node: " + key + ", Neighbours: " + graph.get(key));
//			for(List<Integer> value : graph.values()) {
//				System.out.print(value);
//			}
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
		
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for(int i=0; i<edgeList.size(); i++) {
			int a = edgeList.get(i).get(0);
			int b = edgeList.get(i).get(1);
			
			graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
			graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
		}
		
		print_graph(graph);

	}

}
