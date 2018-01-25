package fb.glassdoor;

/*
	Binary Tree Maximum Path Sum II
	Given a binary tree, find the maximum path sum from root.
	The path may end at any node in the tree and contain at least one node in it.
	Example
	Given the below binary tree:
	  1
	 / \
	2   3
	return 4. (1->3)
	Tags Expand 
	Binary Tree
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class MaxPathSumFromRoot {
	
	public int maxPathSumII(TreeNode root) {
		if(root == null) return 0;
		
		int left = maxPathSumII(root.left); //-> 2
		int right = maxPathSumII(root.right); // -> 3
		
		return Math.max(0, Math.max(left, right)) + root.val;
	}

}
