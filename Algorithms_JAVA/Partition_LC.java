package algosJava;

/**
 * 
 * @author basila
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before 
 * nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */

//class Node {
//	public int data;
//	public Node next;
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class Partition_LC {
	
	public static Node partition(Node head, int x) {
		if(head == null) return head;
		Node l1 = new Node(0);
		Node l2 = new Node(0);
		
		Node small = l1;
		Node big = l2;
		
		while(head != null) {
			if(head.data < x) {
				small = small.next = head;
			} else {
				big = big.next = head;
			}
			head = head.next;
		}
		//merge
		small.next = l2.next;
		big.next = null;
		
		return l1.next;
	}
	
    public static Node buildList(int[] a) {
		if(a == null || a.length == 0) return null;
		Node n = new Node(a[0]);
		Node head = n;
		for(int i = 1; i < a.length; ++i) {
			n.next = new Node(a[i]);
			n = n.next;
		}
		return head;
	
    }
    public void display(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data + " ->");
            currNode=currNode.next;
        }
    }
	
	public static void main(String[] args) {
		Partition_LC list = new Partition_LC();
		
		int[] lista = {3, 1, 5, 9, 7, 2, 1};
		Node h1 = list.buildList(lista);
		list.display(h1);
		System.out.println();
		Node part = partition(h1, 5);
		list.display(part);

		
	}

}
