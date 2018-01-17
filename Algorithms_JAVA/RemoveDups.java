package algosJava;

import java.util.HashSet;
import cci.ch2.LinkedListNode;

/**
 * 
 * @author basila
 * @date 11/26/2017
 * 
 * Write code to remove duplicates from unsorted linked list
 * 
 * FOLLOW UP : How would you solve this problem 
 * if temporary buffer is not allowed.
 *
 */

public class RemoveDups {
	
//	class LinkedListNode {
//		LinkedListNode next = null;
//		int data;
//		
//		public LinkedListNode(int d) {
//			this.data = d;
//		}
//	}
	
	/**
	 * Method to remove duplicates from a linked list
	 * when additional buffer is allowed
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity : O(n)
	 * 
	 * @param head
	 */
	
	private static LinkedListNode head;
	
	/* If head is null, stop processing */
	public static void deleteDups(LinkedListNode n) {
		if(head == null) {
			return;
		}
		/* We need just one pointer here i.e previous to keep track of
		 * previous node, because if we find duplicate, we have to remove 
		 * current node and point previous to next */
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode current = head;
		LinkedListNode previous = null;
		/* Check until current is not null, we will be incrementing current */

		while(current != null) {
			/* If value doesn't exist in set, add it
			 * and move the pointer else just move the pointer */
			if(set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
	}
	
	/**
	 * Method to remove duplicates from Linked list
	 * when no additional buffer is allowed.
	 * 
	 * Time Complexity : O(n^2)
	 * Space Complexity : O(1)
	 * 
	 * @param head
	 */
	
	public void deleteDupsWithoutBuffer(LinkedListNode n) {
		if(head == null) {
			return;
		}
		/* We will need two pointers here i.e current and runner.
		 * When current is pointing to a node, move runner through
		 * rest of the list, checking for duplicates */
		LinkedListNode current = head;
		while(current != null) {
			/* Have runner point to current node */
			LinkedListNode runner = current;
			while(runner.next != null) {
				/* If it is duplicate, jump runner over the node */
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
//	public static void deleteDups(LinkedListNode n) {
//		HashSet<Integer> set = new HashSet<Integer>();
//		LinkedListNode previous = null;
//		while (n != null) {
//			if (set.contains(n.data)) {
//				previous.next = n.next;
//			} else {
//				set.add(n.data);
//				previous = n;
//			}
//			n = n.next;
//		}
//	}
//	public static void main(String[] args) {	
//		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
//		LinkedListNode head = first;
//		LinkedListNode second = first;
//		for (int i = 1; i < 8; i++) {
//			second = new LinkedListNode(i % 2, null, null);
//			first.setNext(second);
//			second.setPrevious(first);
//			first = second;
//		}
//		System.out.println(head.printForward());
//		deleteDups(head);
//		System.out.println(head.printForward());
//	}
}
