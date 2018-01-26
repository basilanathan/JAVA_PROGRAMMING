package fb.glassdoor;

import java.util.Stack;

/*
Flatten Binary Tree to Linked List 
Flatten a binary tree to a fake "linked list" in pre-order traversal.
Here we use the right pointer in TreeNode as the next pointer in ListNode.
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Note
Don't forget to mark the left child of each node to null. 
Or you will get Time Limit Exceeded or Memory Limit Exceeded.
Challenge
Do it in-place without any extra memory.
Tags Expand 
Binary Tree Depth First Search
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

/**
 * Move from root down,
 * for each node, 
 *  attach original right as the right child of the rigthmost node of left subtree,
 *  set original left as new right child.
 * repeat with next right child.
 */
public class FlattenBinaryTreeLinkedList {
	//Time: O(N) 
	//space: O(1)
	public void flatten(TreeNode root) {
	    TreeNode node = root;
	    while (node != null) {
	        TreeNode left = node.left;
	        TreeNode right = node.right;
	        if (left != null) {
	            TreeNode temp = left;
	            while (temp.right != null)
	                temp = temp.right;
	            temp.right = right;
	            node.right = left;
	            node.left = null;
	        }
	        node = node.right;
	    }
	}
	
	//Solution 2
	public void flattenRec(TreeNode root) {
	    if (root == null)
	        return;
	    TreeNode left = root.left;
	    TreeNode right = root.right;
	    if (left != null) {
	        TreeNode rightmost = getRightmost(left);
	        rightmost.right = right;
	        root.left = null; // CATCH: must set left to null explicitly
	        root.right = left;
	    }
	    flatten(root.right);
	}

	// return the rightmost node of a subtree;
	// node must not be null.
	private TreeNode getRightmost(TreeNode node) {
	    while (node.right != null)
	        node = node.right;
	    return node;
	}

	
	//space: O(log n)
	   public void flatten2(TreeNode root) {
	        if (root == null) return;
	        Stack<TreeNode> stk = new Stack<TreeNode>();
	        stk.push(root);
	        while (!stk.isEmpty()){
	            TreeNode curr = stk.pop();
	            if (curr.right!=null)  
	                 stk.push(curr.right);
	            if (curr.left!=null)  
	                 stk.push(curr.left);
	            if (!stk.isEmpty()) 
	                 curr.right = stk.peek();
	            curr.left = null;  // dont forget this!! 
	        }
	    }

}
