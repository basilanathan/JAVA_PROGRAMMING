package ds.DoubleLL;

import ds.betterStackLL.LinkedList;

public class DLL {
	private Link head;
	private int size;
	
	//constructor 
	public DLL() {
		head = null;
		size = 0;
	}
	
	//add node to the front
	public void addFront(int data) {
		if(head == null)
			head = new Link(null, data, null);
		else {
			Link newLink = new Link(null, data, head);
			head.previous = newLink;
			head = newLink;
		}
		size++;
	}
	
	//add node to the back
	public void addBack(int data) {
		if(head == null)
			head = new Link(null, data, null);
		else {
			//traverse through the linked lsit
			Link current = head;
			while(current.next != null) {
				current = current.next;
			}
			Link newLink = new Link(current, data, null);
			current.next = newLink;
		}
		size++;
	}
	
	//delete front node
	public void removeFront() {
		if(head == null) return;
		head = head.next;
		head.previous = null;
		size--;
	}
	
	//delete front node
	public void removeRear() {
		if(head == null) {
			return;
		} else {
			if (head.next == null) {
				head = null;
				size--;
				return;
			}
			
			//traverse for head to rear
			Link current = head;
			while(current.next.next != null) {
				current = current.next;
			}
			current.next = null;
			size--;
		}
		
	}
	//insert at a given index
	public void insertAt(int data, int index) {
		if(head == null) return;
		if(index < 1 || index > size) return;
		
		Link current = head;
		int i = 1;
		while(i < index) {
			current = current.next;
			i++;
		}
		
		if(current.previous == null) {
			Link newLink = new Link(null, data, current);
			current.previous = newLink;
			head = newLink;
			
		} else {
			Link newLink = new Link(current.previous, data, current);
			current.previous.next = newLink;
			current.previous = newLink;
		}
		size++;
	}
	
	//remove node at a given index
	

}
