package fb.glassdoor;

/*
 * the complexity
 * Time: O (b ^ (h + 1) -1) or O(N)
 * space O (H) recursive stack space For binary tree b = 2
 * 
 * Ideas
 * 
 * First, let's analyze the largest path to a given node and what may be the case. 
 * The first is the path of the left subtree plus the current node, the second is the 
 * path of the right subtree plus the current node, and the third is the path of the left and 
 * right subtrees plus the current node (equivalent to a path spanning the current node Path), 
 * the fourth is only their own path. At first, it seems that recursion is done from the bottom up, 
 * but these four cases are only used to calculate the maximum path to the current node root. 
 * If there is a node above the current node, then its parent node can not be accumulated The third case. 
 * 
 * So we have to compute two maxima, one is the largest path sum under the current node and the other 
 * is the largest path sum if we want to connect to the parent node. We use the former to update the 
 * global maximum, use the latter to return the recursive value on the line.
 * 
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775
 * https://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeMaxPathSum {
	
	private int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if(root == null) return 0;
		int left = helper(root.left);
		int right = helper(root.right);

		// The maximum path connecting the parent node is one, two, four, the maximum of these three cases
		// largest path sum if we want to connect to the parent node
		//return the recursive value on the line.
		int currentSum = Math.max(Math.max(left + root.val, right + root.val), root.val);

		// The current node's maximum path is one, two, three, four, the maximum of these four cases
		//largest path sum under the current node
		//to update the global maximum
		int currentMax = Math.max(currentSum, left + root.val + right);

		// Update the global maximum with the current maximum
		max = Math.max(currentMax, max);
		
		return currentSum;
		
	}

}
