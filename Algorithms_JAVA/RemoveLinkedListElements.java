package algosJava;

/*
Remove all elements from a linked list of integers that have value val.
Have you met this question in a real interview? Yes
Example
Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
Tags Expand 
Linked List
*/

/*
Thoughts:
While loop through. Maintain a parent, so it can be used to skip current node.
*/

/*
 * Hints
Keep track of previous pointer

Solution
Runtime Complexity
Linear, O(n)

Memory Complexity
Constant, O(1)

First, we have to find the key in the linked list. We'll keep two pointers: current and previous as we 
iterate the linked list. If the key is found in the linked list, then current pointer would be pointing 
to the node containing key to be deleted and previous should be pointing to the node before the key node. 
It can be done in a linear scan and we can simply update current and previous pointers, as we iterate 
through the linked list. 
 * */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveLinkedListElements {
	
	public ListNode removeLinkedListElement(ListNode head, int val) {
		if(head == null) return head;
		
		ListNode parent = new ListNode(0);
		parent.next = head;
		ListNode dummy = parent;
		
		while(head != null) {
			if(head.val == val) {
				parent.next = head.next;
			} else {
				parent = parent.next;
			}
			head = head.next;
		}
		return dummy.next;
	}

}
