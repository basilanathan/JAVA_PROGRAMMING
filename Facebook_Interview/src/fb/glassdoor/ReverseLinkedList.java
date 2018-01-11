package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/reverse-linked-list/submissions/1
 * 
 * iterative
 * https://www.youtube.com/watch?v=D7y_hoT_YZI
 * https://www.geeksforgeeks.org/reverse-a-linked-list/
 * 
 * recursive
 * https://www.youtube.com/watch?v=KYH83T4q6Vs
 * https://www.geeksforgeeks.org/reverse-a-linked-list/
 * 
 * both iterative and recursive
 * Time: O(N)
 * Space: O(1)
 *
 */

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
	}
}


public class ReverseLinkedList {
	
	//ITERATIVE
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	//RECURSIVE
	
	public ListNode reverseListRecursive(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode current = head;
		ListNode post = head.next;
		ListNode reverse = reverseListRecursive(head.next);
		
		post.next = current;
		current.next = null;
		
		return reverse;
	}
	
	public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ReverseLinkedList test = new ReverseLinkedList();
		
		System.out.println("Given Linked list");
		test.printList(head);
		ListNode reverse = test.reverseList(head);
		System.out.println();
		System.out.println("Reversed Linked list");
		test.printList(reverse);
		
	}

}
