package fb.glassdoor;

import java.util.Stack;


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinarySearchTreeIterator {
	
	Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext() {
		return stack.isEmpty() ? false : true;
	}
	
	public int nextSmallest() {
		TreeNode nextSmallest = stack.pop();
		TreeNode addToStack = nextSmallest.right;
		
		while(addToStack != null) {
			stack.push(addToStack);
			addToStack = addToStack.left;
		}
		return nextSmallest.val;
	}

}
