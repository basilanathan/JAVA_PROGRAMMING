package ds.doublylinkedlist;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			last = newNode; //if empty last will become the new node
		} else {
			first.previous = newNode;
		}
		newNode.next = first; //new nodes next field will point to the old first
		this.first = newNode;
	}
	public void inserLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode; //assigning old last to new node
			newNode.previous = last; //old last will be the new nodes previous
		}
		last = newNode;//linked list last field should point to the new node
	}
	
	//assume non-empty list
	public Node deleteFirst() {
		Node temp = first;
		if (first.next == null) { //there is only one item in the list
			last = null;
		} else {
			first.next.previous = null; //the lists first node will point to null
		}
		first = first.next; //we are assigning the reference of the node following the old first node to the first field of the ll object
		return temp; //return the deleted old first node
	}
	
	//assume non empty list
	public Node deleteLast() {
		Node temp = last;
		if (first.next == null) { //only have one node in this list
			first = null;
		} else {
			last.previous.next = null; //the last nodes previous nodes next field will point to null
		}
		last = last.previous;
		return temp;
	}
	
	//assume a non empty list
	public boolean insertAfter(int key, int data) { //key is the data we are looking for in the list to insert after
		Node current = first; //start from the beginning of the list
		while (current.data != key) { //as long as we have not found the key in a particular node
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		
		Node newNode = new Node();
		newNode.data = data;
		
		if (current == last) {
			current.next = null;
			last = newNode;
		} else {
			newNode.next = current.next; //new nodes next field should point to the head of the current one
			current.next.previous = newNode; //the node ahead of current, it;s previous field should point to the new node
			
		}
		newNode.previous = current;
		current.next = newNode;
		
		return true;
	}
	
	//assume a non empty list
	public Node deleteKey(int key) {
		Node current = first;
		while (current.data != key) {
			current = current.next;
			if (current == null) {
				return null;
			}
		}
		
		//if we come down to here, we have found the node with the matching key
		if (current == first) {
			first = current.next;//make the first field point to the node following current since current is going to be deleted
			
		} else {
			current.previous.next = current.next;
		}
		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current;
	}
	public void displayForward() {
		System.out.print("List (first --> last):");
		Node current = first; //start from the beginning
		while (current != null) {
			current.displayNode(); //call the display method of the node
			current = current.next; // move to the next node
		}
		System.out.println();
	}
	public void displayBackward() {
		System.out.print("List (last --> first):");
		Node current = last; //start from the end
		while (current != null) {
			current.displayNode(); //call the display method of the node
			current = current.previous; // move to the next node
		}
		System.out.println();
	}
}
