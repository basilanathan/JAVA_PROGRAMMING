package fb.glassdoor;

import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
	
	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	Example 1:
	    2
	   / \
	  1   3
	Binary tree [2,1,3], return true.
	Example 2:
	    1
	   / \
	  2   3
	Binary tree [1,2,3], return false.
 * 
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 */

/*
 * If you use a recursive approach, then at each stage, you have to make a recursive call. 
 * That means leaving the current invocation on the stack, and calling a new one. 
 * When you're k levels deep, you've got k lots of stack frame, so the space complexity 
 * ends up being proportional to the depth you have to search.
 * */

/* Class containing left and right child of current
node and key value*/
class TreeNode {
   int val;
   TreeNode left, right;

   public TreeNode(int x)
   {
       val = x;
       left = right = null;
   }
}

public class IsBST {
	
	TreeNode root;
	/*
	 * Time Complexity: O(n)
	 * Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
	 * */
	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(TreeNode node, int minValue, int maxValue) {
		if(node == null) return true;
		
		if(node.val < minValue || node.val > maxValue) return false;
		
		/* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBST(node.left, minValue, node.val-1) &&
                isBST(node.right, node.val+1, maxValue));
	}
	
	//SECOND solution
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	
	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if(root == null) return true;
		if(root.val >= maxValue || root.val <= minValue) return false;
		return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
	}
	
	//ITERATIVE INORDER TRAVERSAL
	public boolean isValidBST2(TreeNode root) {
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

	//DRIVER METHOD
	public static void main(String[] args) {
		IsBST tree = new IsBST();
		
		tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
	}
	
	

}
