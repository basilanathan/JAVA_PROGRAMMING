package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

	Example:
	
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
 * 
 * Complexity Analysis
 * 
 * Time complexity : O(n + m)
 * Because exactly one of l1 and l2 is incremented on each loop iteration, the while loop 
 * runs for a number of iterations equal to the sum of the lengths of the two lists. 
 * All other work is constant, so the overall complexity is linear.
 * 
 * 
 * Space complexity : O(1)
 * The iterative approach only allocates a few pointers, so it has a constant 
 * overall memory footprint.
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/solution/
 *
 */

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null

Thinking process:
1. Merge sorted list, compare before add to node.next
2. when any of l1 or l2 is null, break out.
3. add the non-null list at the end of node.
4. return dummy.next.
*/
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

public class MergeTwoLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		
		ListNode current = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			
			current = current.next;
		}
		
		current.next = l1 == null ? l2 : l1;
		
		return dummy.next;
	}

}
