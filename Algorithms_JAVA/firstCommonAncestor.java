package algosJava;

import helpers.TreeNode;

/**
 * 
 * @author basila
 * 
 * Design an algorithm and write code to find the fist common
 * ancestor of two nodes in a binary tree. Avoid storing additional
 * nodes in a data structure.
 * Note : This is not necessarily a BST
 *
 */

public class firstCommonAncestor {
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		//if root or any of the given node is null, return null
		if(root == null || node1 == null || node2 == null) {
			return null;
		}
		
		//find parent of each node and keep going up untip parent matches
		TreeNode parentOfNode1 = findParent(node1.data, root, null);
		TreeNode parentOfNode2 = findParent(node2.data, root, null);
		
		while (parentOfNode1 != parentOfNode2) {
			parentOfNode1 = findParent(parentOfNode1.data, root, null);
			parentOfNode2 = findParent(parentOfNode2.data, root, null);
		}
		/* Return parent of any node */
		return parentOfNode1;

	}
	
	public static TreeNode findParent(int data, TreeNode root, TreeNode parent) {
		//if root is null no parent exists
		if(root == null) {
			return null;
		}
		
		//if root doesn't match the data, check for parent in left tree
		if (!root.data.equals(data)) {
			parent = findParent(data, root.left, root);
			//if parent doesn't exist in left subtree, check in right
			if(parent == null) {
				parent = findParent(data, root.right, root);
			}
		}
		return parent;
	}

}
