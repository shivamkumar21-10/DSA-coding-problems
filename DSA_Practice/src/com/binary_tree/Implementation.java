package com.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Implementation {

	class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			this.data = d;
			this.left = null;
			this.right = null;
		}

		Node buildTree(Node root) {
			System.out.println("Enter the data from node : ");
			Scanner sc = new Scanner(System.in);
			int data = sc.nextInt();

			root = new Node(data);

			if (data == -1)
				return null;

			System.out.println("Enter the data for inserting in left of " + data + " : ");
			root.left = buildTree(root.left);
			System.out.println("Enter the data for inserting in right of " + data + " : ");
			root.right = buildTree(root.right);
			return root;

		}
		
//		The null marker is used to separate levels during traversal.
//		When a null is encountered in the queue, it signifies the end of a level.
//		A newline is printed at this point to separate the current level visually.
//		After processing a null, another null is added if there are more nodes in the queue. This ensures that the next level will also have a null marker to terminate its processing.
		
//		******************Step-by-Step Execution*******************
//		Process 1
//
//		Print 1 → output: "1 "
//		Add 2 and 3 to the queue.
//		Queue: [null, 2, 3]
//		Encounter null
//
//		Print a newline (\n) → output: "1\n"
//		Add a new null marker since the queue still has nodes.
//		Queue: [2, 3, null]
//		Process 2
//
//		Print 2 → output: "1\n2 "
//		Add 4 and 5 to the queue.
//		Queue: [3, null, 4, 5]
//		Process 3
//
//		Print 3 → output: "1\n2 3 "
//		No children to add.
//		Queue: [null, 4, 5]
//		Encounter null
//
//		Print a newline (\n) → output: "1\n2 3\n"
//		Add a new null marker since the queue still has nodes.
//		Queue: [4, 5, null]
//		Process 4
//
//		Print 4 → output: "1\n2 3\n4 "
//		No children to add.
//		Queue: [5, null]
//		Process 5
//
//		Print 5 → output: "1\n2 3\n4 5 "
//		No children to add.
//		Queue: [null]
//		Encounter final null
//
//		Print a newline (\n) → output: "1\n2 3\n4 5\n"
//		Queue is now empty.
		
		void levelOrderTraversal(Node root) {
		    // Initialize a queue to process nodes level by level.
		    Queue<Node> q = new LinkedList<>();
		    // Add the root node and a null marker to indicate the end of the first level.
		    q.add(root);
		    q.add(null);

		    // Continue the traversal until the queue is empty.
		    while (!q.isEmpty()) {
		        // Retrieve the front node from the queue.
		        Node temp = q.peek();
		        q.poll();

		        // Check if the current node is a null marker.
		        if (temp == null) {
		            // If it's a null marker, print a newline to separate levels.
		            System.out.println();

		            // If the queue still contains more nodes, add another null marker
		            // to indicate the end of the next level.
		            if (!q.isEmpty()) {
		                q.add(null);
		            }
		        } else {
		            // If it's not a null marker, print the node's data (part of the current level).
		            System.out.print(temp.data + " ");

		            // Add the left child to the queue if it exists.
		            if (temp.left != null) {
		                q.add(temp.left);
		            }

		            // Add the right child to the queue if it exists.
		            if (temp.right != null) {
		                q.add(temp.right);
		            }
		        }
		    }
		}
		void inOrderTraversal(Node root) {
			if(root == null) {
				return;
			}
			
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
//			System.out.println(root.data);
		}

	}

	public static void main(String[] args) {
		Implementation tree = new Implementation();

		// Create an instance of the inner class Node
		Node root = tree.new Node(-1); // Dummy root node initialization

		// Build the tree using the inner class method
		// 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		root = root.buildTree(null);

		System.out.println("Binary tree successfully built!");

		// levelorder traversal
		root.levelOrderTraversal(root);
		
		root.inOrderTraversal(root);

	}

}
