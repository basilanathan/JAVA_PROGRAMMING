import javax.xml.soap.Node;

public class StackLinkedList {
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	private int top;
	
	public StackLinkedList() {
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void push(int value) {
		//Always insert at head
		Node temp = new Node(value);
		temp.next = head;
		head = temp;
		top++;
	}
	
	public int pop() {
		//delete the head element
		if (head != null) {
			Node temp = head; //use temp to return the data of the deleted item.
			head = head.next;
			--top;
			return temp.data;
		} else {
			System.out.println("Underflow = no item stack");
			return -1;
		}
	}
	
	public int peek() {
		return head.data;
	}
	
	public static void main(String[] args) {
		StackLinkedList stack = new StackLinkedList();
		stack.push(10);
		stack.push(13);
		stack.push(9);
		stack.push(87);
		stack.push(21);
		stack.push(2);
		
		stack.push(38);
		System.out.println("topmost item is = " + stack.peek());
		
		while (!stack.isEmpty()) {
			int value = stack.pop();
			System.out.println("Deleted value is = " + value);
			
		}

	}

}
