package pkg4;

public class LinkedList {
	//contains one node which is head element
	//insert new node at the head, newno0de to  be inserted becomes the ehad element of ll
	//inserting head is a constant time operation O(1)
	private Node head;
	
	//insert at head method
	
	public void insertHead(int data) {
		//Allocate the Node & Put in the data
		Node newNode = new Node(data);
		//Make next of new Node as head
		newNode.setNextNode(this.head);
		//Move the head to point to new Node
		this.head = newNode;
	}
	
	public int length() {
		int length = 0;
		Node current = this.head;
		
		while (current != null) {
			length ++;
			current = current.getNextNode();
		}
		return length;
	}
	
	public void deleteFromHead() {
		this.head = this.head.getNextNode();
	}
	
	//searching is a linear time operation
	//worst case is O(n) if we increase the size of the link list the time to go through each link list also increases.
	public Node find(int data) {
		Node current = this.head;
		
		while (current != null) {
			if (current.getData() == data) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	public String toString() {
		String result = "{";
		Node current = this.head;
		
		while (current != null) {
			result += current.toString() + ",";
			current = current.getNextNode();
		}
		
		result += "}";
		return result;
	}

}

//create a new node
//connect the next node refference of the new node to the eexisting head element of the linked list.
//make the head of the link list point to the new node.
