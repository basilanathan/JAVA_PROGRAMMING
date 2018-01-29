package fb.leetcode;

import java.util.Stack;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Example:
   2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
Tags Expand 
Divide and Conquer Recursion Binary Search Tree Binary Tree

https://leetcode.com/problems/validate-binary-search-tree/discuss/32112

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time O(H) -> H is the height of the tree
public class ValidateBinarySearchTree {
	
	public boolean isBST(TreeNode root) {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean isBST(TreeNode root, long minValue, long maxValue) {
		if(root == null) return true;
		if(root.val <= minValue || root.val >= maxValue) return false;
		
		return isBST(root.left, minValue, root.val) && isBST(root.right, root.val, maxValue);
	}
	
	/*
	 * Time Complexity: O(n)
	 * Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
	 * */
	public boolean isBST2(TreeNode root) {
		return isBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isBST2(TreeNode node, int minValue, int maxValue) {
		if(node == null) return true;
		
		if(node.val < minValue || node.val > maxValue) return false;
		
		/* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBST(node.left, minValue, node.val-1) &&
                isBST(node.right, node.val+1, maxValue));
	}
	
	//itterative solution Inorder traversal
	public boolean isValidBST(TreeNode root) {
		   if (root == null) return true;
		   Stack<TreeNode> stack = new Stack<>();
		   TreeNode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.val <= pre.val) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
		}

}
