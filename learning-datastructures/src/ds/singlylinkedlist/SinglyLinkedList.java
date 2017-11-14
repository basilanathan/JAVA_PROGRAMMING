package ds.singlylinkedlist;

//adt that will utilize the node class
public class SinglyLinkedList {
	private Node first;
	
	public SinglyLinkedList() {
		
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	//used to insert at the begiining of the list
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		newNode.next = first;
		first = newNode;
	}
	
	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
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
	
	//not efficient becuase we are traversing through the entire list.
	public void insertLast(int data) {
		Node current = first;
		while (current.next != null) {
			current = current.next; //loop unitl current.next is null
		}
		Node newNode = new Node();
		newNode.data = data;
		current.next = newNode;
	}

}
