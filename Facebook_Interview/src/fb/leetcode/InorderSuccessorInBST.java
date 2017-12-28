package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree.
 *
 * Time: O(H) where h is the depth of the result node
 * - Only in a balanced BST O(h) = O(log n). In the worst case h can be as large as n.
 * Space: O(1)
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}

public class InorderSuccessorInBST {
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode successor = null;
		
		while(root != null) {
			if(p.val < root.val) {
				successor = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return successor;
	}
	
	//RECURSIVE SOLUTION
	public TreeNode successor(TreeNode root, TreeNode p) {
		  if (root == null)
		    return null;

		  if (root.val <= p.val) {
		    return successor(root.right, p);
		  } else {
		    TreeNode left = successor(root.left, p);
		    return (left != null) ? left : root;
		  }
		}

}
