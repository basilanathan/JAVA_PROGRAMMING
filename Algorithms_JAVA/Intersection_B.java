package algosJava;

/**
 * 
 * @author basila
 * @date 11/27/2017
 * Time O(m+n)
 * Space O(1)
 */

//class Node {
//	public int data;
//	public Node next;
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class Intersection_B {
	static Node head1, head2;
	//get the length of the list
	public static int getLength(Node node) {
		Node current = node;
		int count = 0;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	//function to get intersection point of two linked lists
	public static int getNode() {
		int c1 = getLength(head1);
		int c2 = getLength(head2);
		int d;
		
		if(c1 > c2) {
			d = c1 - c2;
			return getIntersection(d, head1, head2);
		} else {
			d = c2 - c1;
			return getIntersection(d, head2, head1);
		}
	}
	
	public static int getIntersection(int d, Node node1, Node node2) {
		int i;
		Node current1 = node1;
		Node current2 = node2;
		for(i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}
		while(current1 != null && current2 != null) {
			if(current1.data == current2.data) {
				return current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Intersection_B list = new Intersection_B();

		// creating first linked list
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(15);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);

		// creating second linked list
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);

		System.out.println("The node of intersection is " + list.getNode());

	}
	

}
