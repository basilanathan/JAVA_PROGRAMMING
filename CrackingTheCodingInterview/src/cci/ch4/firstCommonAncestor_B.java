package cci.ch4;

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
 * a node is the common ancestor, if the nodes are on opposite sides from some parent
 * if they are on opposite sites, return the root node
 * otherwise, recursively call on side they are both on
 * 
 * Time: O(d) where d is the depth
 *
 */

public class firstCommonAncestor_B {
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q ) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if(covers(p, q)) {
			return p;
		} else if(covers(q, p)) {
			return q;
		}
		
		//traverse upwards until you find a node that covers q
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.parent;
		
		while(!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}
	
	public static boolean covers(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	
	public static TreeNode getSibling(TreeNode node) {
		if(node == null || node.parent == null) {
			return null;
		}
		TreeNode parent = node.parent;
		
		return parent.left == node ? parent.right : parent.left;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}
	

}
