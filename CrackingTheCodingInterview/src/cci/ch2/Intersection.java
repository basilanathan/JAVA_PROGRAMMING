package cci.ch2;

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

public class Intersection {
	
	public static class Result {
		public Node tail;
		public int size;
		public Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	
	public static Node getIntersection(Node list1, Node list2) {
		if(list1 == null || list2 == null) return null;
		
		//get tail and sizes
		
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		
		//if different tail nodes then theres no intersection
		if(result1.tail != result2.tail) {
			return null;
		}
		
		//set pointers to the start of each linked list
		Node shorter = result1.size < result2.size ? list1 : list2;
		Node longer = result1.size < result2.size ? list2 : list1;
		
		//advance the pointer for the longer linked list by difference in length
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		//move both pointers until you have a collision
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		//return either one
		return longer;
	}
	
	public static Result getTailAndSize(Node list) {
		if(list == null) return null;
		
		int size = 1;
		Node current = list;
		while(current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}
	
	public static Node getKthNode(Node head, int k) {
		Node current = head;
		while(k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
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
            System.out.print("->" + currNode.data);
            currNode=currNode.next;
        }
    }
    
    public static void main(String[] args) {
		Intersection list = new Intersection();
		
		int[] lista = {3, 1, 5, 9, 7, 2, 1};
		Node h1 = list.buildList(lista);
		int[] listb = {4, 6, 7, 2, 1};
		Node h2 = list.buildList(listb);
		
		h2.next.next = h1.next.next.next.next;
		
		list.display(h1);
		list.display(h2);
		
		Node intersect = list.getIntersection(h1, h2);
		System.out.println();
		System.out.println("intersection is : " + intersect.data);


		
//		//first linked list
//		Node h1 = new Node(3);
//		h1.next = new Node(1);
//		h1.next.next = new Node(5);
//		h1.next.next.next = new Node(9);
//		h1.next.next.next.next = new Node(7);
//		h1.next.next.next.next.next = new Node(2);
//		h1.next.next.next.next.next.next = new Node(1);
//
//		//second linked list
//		Node h2 = new Node(4);
//		h2.next = new Node(6);
//		h2.next.next = new Node(7);
//		h2.next.next.next = new Node(2);
//		h2.next.next.next.next = new Node(1);
//		
//		h2.next.next = h1.next.next.next.next;
//		list.display(h1);
//		list.display(h2);
//
//		Node intersect = list.getIntersection(h1, h2);
//		System.out.println();
//		System.out.println(intersect.data);
		
	}

}
