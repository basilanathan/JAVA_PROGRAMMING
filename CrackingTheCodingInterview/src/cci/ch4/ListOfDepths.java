package cci.ch4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import helpers.TreeNode;

public class ListOfDepths {
	//method to create a linked list at each depth
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedListAtEachDepth(TreeNode root) {
		//if root is null, no list can be created
		if(root == null) {
			return null;
		}
		//create a array list to hold results
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		//visit the root node and create node
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		
		//keep going until elements are there
		while(current.size() > 0) {
			//add current level and move to next level
			result.add(current);
			LinkedList<TreeNode> parents = current;
			
			//create a new linked list at each  level
			current = new LinkedList<>();
			
			//add children for each parent node
			for(TreeNode parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	
	/* Creates tree by mapping the array left to right, top to bottom. */
	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}

	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLinkedListAtEachDepth(root);
		printResult(list);
	}

}
