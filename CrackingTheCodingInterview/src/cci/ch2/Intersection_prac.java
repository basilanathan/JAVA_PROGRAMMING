package cci.ch2;

import cci.ch2.Intersection.Result;

//class Node {
//	public int data;
//	public Node next;
//	
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

//class Result {
//	public int size;
//	public Node tail;
//	
//	public Result(Node tail, int size) {
//		this.tail = tail;
//		this.size = size;
//	}
//}

//get tail and size of both lists (Result class that return tail and size)
//if tails are different return null
//if sizes are different, assign short and long pointers. get the diff and move the long pointer

public class Intersection_prac {
	
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
		Intersection_prac list = new Intersection_prac();
		
		int[] lista = {3, 1, 5, 9, 7, 2, 1};
		Node h1 = list.buildList(lista);
		int[] listb = {4, 6, 7, 2, 1};
		Node h2 = list.buildList(listb);
		
		h2.next.next = h1.next.next.next.next;
		
		list.display(h1);
		System.out.println();
		list.display(h2);
		
		Node intersect = list.getIntersection(h1, h2);
		System.out.println();
		System.out.println("intersection is : " + intersect.data);

	}

}
