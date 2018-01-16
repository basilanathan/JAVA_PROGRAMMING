package fb.leetcode;

/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Example
        4
    /     \
  3         7
          /     \
        5         6
For 3 and 5, the LCA is 4.
For 5 and 6, the LCA is 7.
For 6 and 7, the LCA is 7.
Tags Expand 
Binary Tree LintCode Copyright
*/

/*
  Thoughts:
  Revisit this on 12.11.2015.
  To correctly understand this approach when there is not 'parent' atribute available in node.
  We divide and coquer (in this case DFS) into 2 branches, and we are actually asking each node to check:
    Do I have a leaf child of nodeA (could be futher down in the tree)?
    Do I have a leaf child of nodeB (could be futher down in the tree)?
  1. If I have leaf child of A && B, then i'm the deepest parent in line! Return.
  2. If I only have A, or B: mark myself as an ancestor of A or B.
  3. If I don't have leaf child of A nor B, I'm not an ancestor, failed, return null.
  After the common ancestor is found at any deep level, and returned itself to parent level,
    we can assume other branches must be null (because they are not ancestor, since we are),
    then the this common ancestor node will be passed to highest level.
  However, with one problem:
  When review the problem, calling the recursive functions of the 'lowestCommonAncestor' is just 
  confusing. It's not easy to see the relationship between leef child and ancestor candidates.
  
 
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

/*
 *         4
	    /     \
	  3         7
	          /     \
	        5         6
 * 
 * lCA(3, 3, 7)
 * 	null
 * left = 3
 * lCA(7, 3, 7)
 * 	lCA(6, 3, 7)
 * 	null
 * right = 7
 * 
 * return root -> 4
 * 
 * */

/*
 * Time complexity of above solution is O(h) where h is height of tree. Also, the above 
 * solution requires O(h) extra space in function call stack for recursive function calls. 
 * We can avoid extra space using iterative solution.
 * */

public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if(root == null || root == A || root == B) return root;
		
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		
		if(left != null && right != null) {
			return root;
		} else if(left != null || right != null) {
			return left != null ? left : right;
		} else {
			return null;
		}
	}
	
	

}
