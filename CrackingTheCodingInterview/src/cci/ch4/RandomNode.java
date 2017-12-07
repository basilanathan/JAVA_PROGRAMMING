package cci.ch4;

import java.util.Random;

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
