package fb.leetcode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
	
	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		val = x;
	}
}
/**
 * move pre back to dummyHead in order to get ready for the next level (or not if there is no more level). 
 * Basically you move pre back to dummyHead and you move root to dummyHead.next (which is the left most of 
 * the current level), so that when you go back to the beginning of the while loop, pre will go to the most 
 * left node of the next level (root.left)
 * 
 */

//Time: O(N)
//Space: O(1)
public class PopulatingNextRightPointersEachNodeII {
	
	public void connect(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0); //think of this as head of linkedlist
		TreeLinkNode pre = dummyHead;
		
		while(root != null) {
			if(root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if(root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			
			/*
			 * when root == null, it means that this is the last node in this layer. 
			 * Currently you can think dummyHead is a head of a LinkedList, dummyHead.next is the 
			 * starting node of next layer.
			 * So, when we come to the last node, we need to shift to next layer, that’s why we need to 
			 * have root = dummyHead.next.
			 * we need to reset our helper pointer pre to dummyHead. And finally, cut off all the 
			 * previous node because it does not belong to this layer.
			 * 
			 * */
			
			if(root == null) {
				pre = dummyHead;
				root = dummyHead.next;
				dummyHead.next = null;
			}
		}
	}

}
