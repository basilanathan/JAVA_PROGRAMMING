package algosJava;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null
Tags Expand 
Linked List
Thinking process:
1. Merge sorted list, compare before add to node.next
2. when any of l1 or l2 is null, break out.
3. add the non-null list at the end of node.
4. return dummy.next.
*/

/*
 * Hints
	Use two iterators to scan both lists.
	Solution
	Runtime Complexity
	Linear, O(m + n) where m and n are lengths of both linked lists.
	
	Memory complexity
	Constant, O(1)
 * 
 * https://www.educative.io/collection/page/5642554087309312/5679846214598656/160004
 * https://github.com/awangdev/LintCode/blob/master/Java/Merge%20Two%20Sorted%20Lists.java
 * */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeTwoSortedLists {
	
	public ListNode mergeLists(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) return null;
		
		ListNode head = new ListNode(0);
		ListNode node = head;
		
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		if(l1 != null) {
			node.next = l1;
		} else if(l2 != null) {
			node.next = l2;
		}
		return head.next;
	}

}
