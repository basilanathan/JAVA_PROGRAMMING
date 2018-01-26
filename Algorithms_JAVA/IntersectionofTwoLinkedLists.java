package fb.leetcode;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.
Example
The following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Note
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Challenge
Your code should preferably run in O(n) time and use only O(1) memory.
Tags Expand 
Linked List
*/

/*
	Thoughts:
	If a and b share some part, if cut off the extra header of b (seen in above example), they should start at same index and touch c1 at same time.
	So traverse a, b, and calculate countA, countB => dif = countB - countA.
	cut off the extra, then start iterating to find c1.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
 * 1, Get the length of the two lists.
	
	2, Align them to the same start point.
	
	3, Move them together until finding the intersection point, or the end null
 * */

public class IntersectionofTwoLinkedLists {
	
    //with length
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    int lenA = length(headA), lenB = length(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    return headA;
	}
	
	private int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}

}

public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
    		return null;
    	}
    	int countA = 0;
    	int countB = 0;
    	int diff = 0;
    	ListNode node = headA;
    	while (node != null) {
    		countA++;
    		node = node.next;
    	}
    	node = headB;
    	while (node != null) {
    		countB++;
    		node = node.next;
    	}
    	diff = Math.abs(countA - countB);
    	node = (countA > countB) ? headA : headB;
    	while (diff != 0) {
    		diff--;
    		node = node.next;
    	}
    	ListNode nodeA = (countA > countB) ? node : headA;
    	ListNode nodeB = (countA > countB) ? headB : node;
    	while (nodeA != null && nodeB != null) {
    		if (nodeA == nodeB) {
    			return nodeA;
    		}
    		nodeA = nodeA.next;
    		nodeB = nodeB.next;
    	}
    	
    	return null;
    }  
}
