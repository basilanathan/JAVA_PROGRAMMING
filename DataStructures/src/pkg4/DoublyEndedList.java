package pkg4;

public class DoublyEndedList {
	private Node head;
	private Node tail;
	
	public void insertAtTail(int data) {
		
		Node newNode = new Node(data);
		//if the head is null the new node becomes the head
		if (this.head == null) {
			this.head = newNode;
		}
		// if tail equals not null
		//the new node becomes the current tails next node
		if (this.tail != null) 
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		
	}
	
	public String toString() {
		String result = "{ ";
		Node current = this.head;
		
		while (current != null) {
			result += current.toString() + ", ";
			current = current.getNextNode();
		}
		result += " }";
		return result;
	}

}
