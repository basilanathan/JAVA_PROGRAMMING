package fb.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*Thoughts:
 * 
 * Runtime Complexity
Linear, O(n).

Memory Complexity
Constant, O(1).

Algorithmically it is a simple problem, but writing code for this is a bit trickier as it involves to keep track of a few pointers. Logically we break down the list to sub-lists each of size 'k'. We'll use the below pointers:

reversed: it points to the head of the output list.
current_head: head of the sub-list of size 'k' currently being worked upon.
current_tail: tail of the sub-list of size 'k' currently being worked upon.
prev_tail: tail of the already processesed linked list (where sub-lists of size 'k' have been reversed).
We'll work upon a sub-list of size 'k' at a time. Once that sub-list is reversed, we have its head and tail in current_head and current_tail respectively. If it was the first sub-list of size 'k', its head (i.e. current_head) is the head (i.e. reversed) of the output linked list. We'll point 'reversed' to current_head of the first sub-list. If it is the 2nd or higher sub-list, we'll connect tail of the previous sub-list to head of the current sub-list i.e. update next pointer of tail of previous sub-list with head pointer of current sub-list to join the two sub-lists.

Let's apply this algorithm on the following list with 7 elements and k=5.

Initially all pointers will be null (except head which is pointing to the head of input linked list.) We'll reverse the first sub-list of k = 5 nodes. current_head and current_tail will be updated accordingly. We'll use the head pointer to keep track of the remaining list. As reversed is null after the first sub-list is reversed, so it will be updated with current_head. It will be the head of final output list. prev_tail will be updated with current_tail. Then we'll reverse the next sub-list of size 2 and update current_head and current_tail pointers accordingly. head will become null as there will be no remaining list. We'll connect previous tail with the current head in the end.
 * 
 * */

public class ReverseKElements {
	
	public ListNode reverseNodes(ListNode head, int k) {
		if(k <= 1 || head == null) return head;
		
		ListNode reversed = null;
		ListNode prevTail = null;
		
		while(head != null && k > 0) {
			ListNode currentHead = null;
			ListNode currentTail = head;
			
			int n = k;
			
			while(head != null && n > 0) {
				ListNode temp = head.next;
				head.next = currentHead;
				currentHead = head;
				head = temp;
				n--;
				
			}
			
			if (reversed == null) {
				reversed = currentHead;
			}
			
			if (prevTail != null) {
				prevTail.next = currentHead;
			}
			prevTail = currentTail;
		}
		return reversed;
	}
	
	//solution 2 recursivev
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group: 
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list 
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

}
