package fb.leetcode;

import java.util.HashSet;

/*
Thoughts:
Try to get upper-level parent, store in hashMap.
First time when the node duplicate in map, that will be the first common parent.
*/

/*
 * Time Complexity : O(h) where h is height of Binary Tree if we use hash table to implement the 
 * solution (Note that the above solution uses map which takes O(Log h) time to insert and find). 
 * So the time complexity of above implementation is O(h Log h).
 * 
 * Auxiliary Space : O(h)
 * 
 * */

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */

class ParentTreeNode {
	public ParentTreeNode parent, left, right;
}

public class LowestCommonAncestorParentPointer {
	
	public ParentTreeNode lowestCommonAncestor(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
	    	if (root == null || (A == null && B == null)) {
	    		return null;
	    	} else if (A == null || B == null) {
	    		return A == null ? B : A;
	    	}
	
	    	HashSet<ParentTreeNode> set = new HashSet<ParentTreeNode>();
	    	while (A != null || B != null) {
	    		if (A != null) {
	    			if (set.contains(A)) {
	    				return A;
	    			}
	    			set.add(A);
	    			A = A.parent;
	    		}
	    		if (B != null) {
	    			if (set.contains(B)) {
	    				return B;
	    			}
	    			set.add(B);
	    			B = B.parent;
	    		}
	    	}
	 		return root;
	 }
	
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
	
	//Time: O(H)
	//Space: O(1)
	//get Depth
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        if (A == root || B == root) {
            return root;
        }
        
        int depthA = getDepth(A);
        int depthB = getDepth(B);
        
        if (depthB > depthA) {
            ParentTreeNode tmp = B;
            B = A;
            A = tmp;
        }
        
        int diff = Math.abs(depthA - depthB);
        while (diff-- > 0) {
            A = A.parent;
        }
        
        while(A != B) {
            A = A.parent;
            B = B.parent;
        }
        return A;
    }
    
    public int getDepth(ParentTreeNode node) {
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }
}


