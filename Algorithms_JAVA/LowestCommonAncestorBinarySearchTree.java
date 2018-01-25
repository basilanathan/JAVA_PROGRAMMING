package fb.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
between two nodes v and w as the lowest node in T that has both v and w as descendants 
(where we allow a node to be a descendant of itself).”
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Tags: Tree
Similar Problems: (M) Lowest Common Ancestor of a Binary Tree
*/

/*
Thoughts:
Based on the value of A and B, use BST to find the node, and store the visited nodes in two separate lists.
Find last common item in the list to return.
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

public class LowestCommonAncestorBinarySearchTree {
	//Iterative
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if(root == null || A == null || B == null) return root;
		
		List<TreeNode> listA = new ArrayList<>();
		List<TreeNode> listB = new ArrayList<>();
		
		findNode(root, A, listA);
		findNode(root, B, listB);
		
		int size = listA.size() > listB.size() ? listB.size() : listA.size(); //pick smaller one
		
		TreeNode parent = root;
		for(int i = 0; i < size; i++) {
			if(listA.get(i).val == listB.get(i).val) {
				parent = listA.get(i);
			} else {
				return parent;
			}
		}
		return parent;
	}

	private void findNode(TreeNode root, TreeNode target, List<TreeNode> list) {
		while(root != null) {
			list.add(root);
			if(root.val == target.val) {
				return;
			}
			if(root.val > target.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		
	}
	
	/*
	Thoughts:
	Besides the method of finding all ancestors, we can look at the problem in a greedy way.
	Move both p and q to find the ancestor:
	If the root is on the left of both p and q, that means the ancestor must be on right size of root; same applies to the other direction.
	This leads to a compact recursive solution.
	However, the iterative way might be more useful in real development where it utilize data struture
	*/
	
	//recursive

	    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null || p == null || q == null) {
	            return root;
	        }
	        if (root.val < p.val && root.val < q.val) {
	            return lowestCommonAncestor(root.right, p, q);
	        } else if (root.val > p.val && root.val > q.val) {
	            return lowestCommonAncestor(root.left, p, q);
	        }
	        return root;
	    }


	/*
	Thoughts:
	Create 2 path: l1, l2.
	First different node's parent, will be the LCA
	Do binary search to generate the path l1,l2
	Note:
	When one of the target is root, make sure parent = root, and return root at the end. This is because: the if statement (l1.get(i).val != l2.get(i).val) won't capture this case; instead, the for loop ends by i == size. So, be careful here.
	*/
	

}
