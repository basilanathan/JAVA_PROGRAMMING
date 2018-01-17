package algosJava;

import java.util.Random;

/**
 * 
 * @author basila
 * @date 12/6/2017
 * 
 * <br> Problem Statement :
 * 
 * You are implementing a binary tree class from scratch,
 * which in addition to insert, find and delete, has a method
 * getRandomNode() which returns a random node from the tree.
 * All nodes should be equally likely to be chosen. Design and
 * implement an algorithm for getRandomNode(), and explain how
 * would you implement the rest of the method.
 * 
 * </br>
 * 
 * Time: O(log N) in a balanced tree
 *
 */

public class RandomNode {
	
	TreeNode root = null;
	
	public void insertInOrder(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insertInOrder(value);
		}
	}
	
	public int size() {
		return root == null ? 0 : root.size();
	}
	
	public TreeNode getRandomNode() {
		if (root == null) return null;
		
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
	
	public static void main(String[] args) {
		int[] counts = new int[10];
		for (int i = 0; i < 1000000; i++) {
			RandomNode tree = new RandomNode();
			int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array) {
				tree.insertInOrder(x);
			}
			int d = tree.getRandomNode().data;
			counts[d]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
		}
	}

}
