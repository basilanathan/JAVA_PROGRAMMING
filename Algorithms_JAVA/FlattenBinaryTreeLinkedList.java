package algosJava;

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
public class FlattenBinaryTreeLinkedList {
	//Time: O(N) 
	//space: O(1)
	public void flatten(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode last = cur.left;
				while (last.right != null) last = last.right;
				last.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
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
