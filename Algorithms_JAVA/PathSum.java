package fb.glassdoor;

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

/*
 * The basic idea is to subtract the value of current node from sum until it reaches a 
 * leaf node and the subtraction equals 0, then we know that we got a hit. Otherwise the 
 * subtraction at the end could not be 0.
 * */

public class PathSum {
	
	public boolean pathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null && sum - root.val == 0) return true;
		return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
	}

}
