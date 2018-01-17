package algosJava;

import helpers.TreeNode;

/**
 * 
 * @author basila
 * @date 12/5/2017
 * 
 * Write an algorithm to find the next node i.e
 * (in-order successor) of a given node in a BST.
 * You may assume that each node has a link to 
 * it's parent.
 * 
 * 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
 * Go to right subtree and return the node with minimum key value in right subtree.
 * 2) If right sbtree of node is NULL, then start from root and us search like technique. Do following.
 * Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
 * 
 * Time: O(H) where h is height of tree
 * 
 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 *
 */

public class Successor {
	
	public static TreeNode inorderSucc(TreeNode root, TreeNode n) {
		if (n == null) return null;
		
		if (n.right != null) {
			return minValue(n.right);
		}
		
		TreeNode succ = null;
		
		while(root != null) {
			if (n.data < root.data) {
				succ = root;
				root = root.left;
			} else if (n.data > root.data) {
				root = root.right;
			} else
				break;
		}
		return succ;
	}
	
	public static TreeNode minValue(TreeNode n) {
		if (n == null) {
			return null;
		}
		while(n.left != null) {
			n= n.left;
		}
		return n;
	}
	
	//second solution using a parent pointer
	
	public static TreeNode findSucc(TreeNode node) {
		if (node == null) {
			return null;
		}
		
		//if right node is not null, successor will be minimum value in right subtree
		if (node.right != null) {
			return minValue(node.right);
		}
		
		//create current node as temp and get its parent
		TreeNode temp = node;
		TreeNode parent = temp.parent;
		
		//keep traversing up until we reach the root of the tree.
		while(parent != null && temp == parent.right) {
			temp = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	public static void main(String[] args) {
		int[] array = {4, 8, 10, 12, 14, 20, 22};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode n = root.find(array[i]);
			//TreeNode next = findSucc(node);
			TreeNode next = inorderSucc(root, n);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
