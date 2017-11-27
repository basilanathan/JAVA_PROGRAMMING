package cci.ch2;

/**
 * 
 * @author basila
 * @date 11/27/2017
 * 
 * Time O(N)
 * Space O(1)
 *
 */

public class KthToLast {
	
	private static class Node {
		Node next = null;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
		
		void add(int data) {
			Node endNode = new Node(data);
			Node n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = endNode;
		}
	}
	
	public static int nthToLast(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		
		//Move p1 k nodes into the linked list
		for(int i = 0; i < k; i++) {
			if(p1 == null) break;
			p1 = p1.next;
		}
		
		//move them at the same pace. when p1 reaches the end, p2 will be kth node from the end
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2.data;
	}
	
	private static void printList(Node head) {
		Node n = head;
		while(n.next != null) {
			System.out.printf("%d ->", n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	
	public static void main(String[] args) {
		
		Node linked = new Node(5);
		linked.add(45);
		linked.add(2);
		linked.add(3);
		linked.add(2);
		linked.add(7);
		linked.add(6);
		//printList(linked);
		System.out.println(nthToLast(linked, 4));


	}

}
