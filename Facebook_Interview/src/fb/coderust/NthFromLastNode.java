package fb.coderust;

import java.util.PrimitiveIterator.OfDouble;

/*
Find the nth to last element of a singly linked list. 
The minimum number of nodes in list is n.
Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
Tags Expand 
Cracking The Coding Interview Linked List
Thinking process:
1. Find nth node in normal order.
2. Have a head at index0.
3. Move both head and nth node. WHen nth node hit null/end, then the moving head is the nth to last node in list.
*/

/*
 * Hints
	Move two pointers which are n nodes apart.
	Solution
	Runtime Complexity
	Linear, O(n)
	
	Memory Complexity
	Constant, O(1)
	
	https://www.educative.io/collection/page/5642554087309312/5679846214598656/70004
 * */

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class NthFromLastNode {
	
	public ListNode nthLastNode(ListNode head, int n) {
		if(head == null || n < 0) return null; 
		
		ListNode p1 = head;
		ListNode p2 = head;
		
		for(int i = 0; i < n; i++) {
			if(p1 == null) break;
			p1 = p1.next;
		}
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

}
