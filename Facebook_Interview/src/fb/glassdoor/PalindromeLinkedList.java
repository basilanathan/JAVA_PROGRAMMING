package fb.glassdoor;

/*
 * This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].
	
	In the beginning, set two pointers fast and slow starting at the head.
	
	1 -> 1 -> 2 -> 1 -> null 
	sf
	(1) Move: fast pointer goes to the end, and slow goes to the middle.
	
	1 -> 1 -> 2 -> 1 -> null 
	          s          f
	(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
	
	1 -> 1    null <- 2 <- 1           
	h                      s
	(3) Compare: run the two pointers head and slow together and compare.
	
	1 -> 1    null <- 2 <- 1             
	     h            s
 * 
 * https://discuss.leetcode.com/topic/33376/java-easy-to-understand/10
 * 
 * Time: O(N)
 * Space: O(1)
 * 
 * 
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class PalindromeLinkedList {
	
	public boolean isPalinfrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null) { // odd nodes: let right half smaller
			slow = slow.next;
		}
		
		slow = reverse(slow);
		fast = head;
		
		while(slow != null) {
			if(fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
