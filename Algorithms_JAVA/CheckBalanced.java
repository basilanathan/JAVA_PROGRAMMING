package algosJava;

import helpers.TreeNode;

/**
 * 
 * @author basila
 *
 * Implement a function to check if a binary tree is balanced.
 * For the purpose of this question, a balanced tree is defined
 * to be a tree such that height of left sub tree and right 
 * sub tree of any given node never differs by one.
 * 
 * Time: O(N)
 * Space: O(H) H is the height of the tree
 */

public class CheckBalanced {
	
	public static int checkHeight(TreeNode root) {
		//if node is null
		if(root == null) {
			return -1;
		}
		
		//find height of left and right recursively
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		} else {
			//whichever is greater add 1 to it
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}

}
