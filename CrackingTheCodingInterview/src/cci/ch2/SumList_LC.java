package cci.ch2;


//class Node {
//	public int data;
//	public Node next;
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class SumList_LC {
	public static Node addTwoNumbers(Node l1, Node l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		int carry = 0;
		
		Node dummy = new Node(0);
		Node cur = dummy;
		
		while(l1 != null || l2 != null) {
			int a = l1 == null ? 0 : l1.data;
			int b = l2 == null ? 0 : l2.data;
			int sum = (a + b + carry) % 10;
			carry = (a + b + carry) / 10;
			cur.next = new Node(sum);
			cur = cur.next;
			
			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
		}
		if(carry != 0) cur.next = new Node(carry);
		return dummy.next;
	}
	

}
