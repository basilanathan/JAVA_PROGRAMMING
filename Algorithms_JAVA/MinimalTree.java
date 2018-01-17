package algosJava;

import helpers.TreeNode;

public class MinimalTree {
	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root: " + root.data);
		System.out.println("createBST: " + root.isBST());
		System.out.println("height: " + root.height());
	}

}
