package fb.leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*

Use two pointers, walker and runner.
walker moves step by step. runner moves two steps at time.
if the Linked List has a cycle walker and runner will meet at some
point.

*/

public class LinkedListCycle {
	
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }

}
