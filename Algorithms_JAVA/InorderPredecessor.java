package fb.leetcode;

/**
 * 
 * @author basila
 * 
 *  * Time: O(H) where h is the depth of the result node
 * - Only in a balanced BST O(h) = O(log n). In the worst case h can be as large as n.
 * Space: O(1)
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}

public class InorderPredecessor {
	
	public TreeNode inorderPredecesspr(TreeNode root, TreeNode p) {
		TreeNode pre = null;
		while(root != null) {
			if (root.val < p.val) {
				pre = root;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return pre;
	}

}
