package fb.leetcode;

import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be 
 * initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
 *
 */

/*
Previous correct implementation, O(h) space.
Thoughts:http://blog.csdn.net/u014748614/article/details/46800891
Put all left nodes into stack. Then top of stack must be the first element in in-order-traversal.
We never add right node into stack directly, but ever time before returnning the rst node, we take care of rst.right right away.
    That is, find next() when rst.right as root.
very smart use of a 'currnt' node.
It's like a pointer on the tree, but only operates when that current node is not null, and under condition of having left child.
*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}

public class BinarySearchTreeIterator {
    
    Stack<TreeNode> stack;

    public void BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty() ? false : true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextSmallest = stack.pop();
        TreeNode addToStack = nextSmallest.right;
        while(addToStack != null) {
            stack.add(addToStack);
            addToStack = addToStack.left;
        }
        return nextSmallest.val;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */