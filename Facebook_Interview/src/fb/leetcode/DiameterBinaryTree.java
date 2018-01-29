package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 */

/*
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path 
 * between two leaves in the tree. 
 * 
 * For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its 
 * right subtree.
 * 
 * We want to compare all diameters among all subtrees.
 * Then this can be done when we DFS traverse the root.
 * We just need to record the maximum one in a variable.
 * 
 * In this post, the variable is the int max.
 * max = Math.max(max, left + right) is to compare whether the diameter of this subtree is max or not, 
 * if it is, record it.
 * And the remaining part in the maxDepth is just the normal height counting.
 * 
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

public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}

//withough global variable

public class DiameterBinaryTree {
	
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];        
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

}
