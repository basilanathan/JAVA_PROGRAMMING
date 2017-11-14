package ds.circularlinkedlist;

import ds.singlylinkedlist.Node;

public class CircularLinkedList {
	private Node first;
	private Node last;
	
	public CircularLinkedList() {
		first = null;
		last = null;
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			last = newNode;
		}
		newNode.next = first; //newNode is being assigned to the old first
		first = newNode; //newNode that we created is in first place
		
	}
	
	private boolean isEmpty() {
		return first == null;
	}
	
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode; //the next value of the last node will point to the new node
			last = newNode; //we make the new node we created be the last one on the list.
		}
	}
	public int deleteFirst() {
		int temp = first.data;
		if (first.next == null) {
			last = null;
		}
		first = first.next; //first will point to old's next value
		return temp;
	}
	public void displayList() {
		System.out.println("List (first --> last)");
		Node current = first;
		while (current != null) {
			current.disPlayNode();
			current = current.next;
		}
		System.out.println();
	}
	
}
