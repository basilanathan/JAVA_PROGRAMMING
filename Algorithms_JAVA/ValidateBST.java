package algosJava;

import helpers.TreeNode;

/**
 * 
 * @author basila
 * @date 12/5/2017
 * 
 * Implement a function to check if a binary tree is BST
 * 
 * Time: O(N) N is the number of nodes in the tree
 * Space: O(log N) there are up to O log N recursive 
 * calls on the stack since we may recurse up to the depth of the tree.
 *
 */

public class ValidateBST {
	
	public static boolean isBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	//method to validate a binart search tree
	
	private static boolean validate(TreeNode root, Integer min, Integer max) {
		//BST can have just one node
		if(root == null) {
			return true;
		}
		
		//if root's value is less than min or greater than equal to max return false
		if (root.data < min || root.data >= max) {
			return false;
		}
		
		//validate left and right subtree recursively
		return validate(root.left, min, root.data) && validate(root.right, root.data, max);
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 79};
		TreeNode root = TreeNode.createMinimalBST(array);
		
		System.out.println("is a valid BST: " + isBST(root));
	}

}
