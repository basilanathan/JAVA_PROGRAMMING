package fb.coderust;

/*

Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.
Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

Thinking process:
Create a dummyHead
User a pointer node to run through the list
Similar to Remove Duplicates from Sorted List I, but checking next and next.next
If there is a match on head.next && head.next.next, delete head.next node and link to next ones until a different node appear
return dummyHead.next
*/


/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class RemoveDuplicatesFromSortedListII {
	
	public ListNode deleteDups(ListNode head) {
		if(head == null) return head;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode node = dummyHead;
		
		while(node.next != null && node.next.next != null) {
			if(node.next.val == node.next.next.val) {
				int duplicateVal = node.next.val;
				while(node.next != null && node.next.val == duplicateVal) {
					node.next = node.next.next;
				}
			} else {
				node = node.next;
			}
		}
		return dummyHead.next;
	}

}
