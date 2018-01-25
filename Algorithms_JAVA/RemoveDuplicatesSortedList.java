package fb.coderust;

/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Thinking process:
check head null
Use dummy node to reserve head
while everything when head.next is not null
compare head.val == head.next.val? 
If so, head.next = head.next.next
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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
Thoughts:
1. Check head.
2. Remove next if next != null && next.val == node.val
3. Use node to move

Time: O(N)
Space: O(1)
*/

public class RemoveDuplicatesSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		
		ListNode node = head;
		while(node != null) {
			while(node.next != null && node.val == node.next.val) {
				node.next = node.next.next;
			}
			node = node.next;
		}
		return head;
	}
	
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates2(ListNode head) { 
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

}
