package algosJava;

public class DeleteMiddleNode {
	
	public static class Node {
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
	
	public static void printList(Node head) {
	    Node n = head;
	    while (n.next != null)
	    {
	      System.out.printf("%d -> ", n.data);
	      n = n.next;
	    }
	    System.out.println(n.data);
	}
	
	public static boolean deleteNode(Node n) {
		if(n == null || n.next == null) {
			return false;
		} else {
			Node next = n.next;
			n.data = next.data;
			n.next = next.next;
			return true;
		}
	}
	
	public static void main(String[] args) {
		Node linked = new Node(5);
		linked.add(2);
		linked.add(3);
		linked.add(2);
		linked.add(7);
		printList(linked);
		deleteNode(linked.next.next);
		printList(linked);

	}

}
