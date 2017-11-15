package ds.StackLL;

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
	
	private int top; //when top = -1 stack is empty
	
	public StackLinkedList() {
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void push(int value) {
		//insert at head
		Node temp = new Node(value);
		temp.next = head;
		head = temp;
		top++;
		
	}
	
	public int pop() {
		//delete the head element
		
		if (head != null) {
			Node temp = head;
			head = head.next;
			--top;
			return temp.data;
		} else {
			System.out.println("no items in stack");
			return -1;
		}
	}
	
	public int peek() {
		return head.data;
	}
	
	

}
