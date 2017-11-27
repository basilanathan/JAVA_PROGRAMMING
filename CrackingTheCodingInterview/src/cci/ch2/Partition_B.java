package cci.ch2;

public class Partition_B {
	
	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while(node!= null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				//insert node at head
				node.next = head;
				head = node;
			} else {
				//insert node at tail
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
}
