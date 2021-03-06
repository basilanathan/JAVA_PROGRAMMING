import javax.print.attribute.Size2DSyntax;

public class DoublyLinkedList {
	
	private Link head;
	private int size;
	
	//CONSTRUCTOR
	public DoublyLinkedList() {
		head = null;
		size = 0;
	}
	//ADD NODE TO THE FRONT
	public void addFront(int data) {
		if (head == null) 
			head = new Link(null, data, null);
		 else {
			Link newLink = new Link(null, data, head);
			head.previous = newLink;
			head = newLink;
		}
		size++;
	}
	//ADD NODE TO THE BACK
	public void addRear(int data) {
		if (head == null) {
			head = new Link(null, data, null);
		} else {
			//traversing through the linked list
			Link current = head;
			while (current.next != null) {
				current = current.next;
			}
			Link newLink = new Link(current, data, null);
			current.next = newLink;
		}
		size++;
	}
	//DELETE FRONT NODE
	public void removeFront() {
		if (head == null) {
			return;
		} else {
			head = head.next; //moivng the head to the next node
			head.previous = null; //setting the new heads previous to null
			size--;
		}
	}
	//DELETE REAR NODE
	public void removeRear() {
		if (head == null) {
			return;
		} else {
			if (head.next == null) {
				head = null;
				size--;
				return;
			}
			//traversing from head to rear
			Link current = head;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
			size--;
		}
	}
	public void insertAt(int data, int index) {
		if (head == null) return;
		if (index < 1 || index > size) return;
		
		Link current = head;
		int i = 1;
		while (i < index) {
			current = current.next;
			i++;
		}
		if (current.previous == null) {
			Link newLink = new Link(null, data, current);
			current.previous = newLink;
			head = newLink;
		} else {
			//adding the node to the middle
			Link newLink = new Link(current.previous, data, current);
			current.previous.next = newLink;
			current.previous = newLink;
		}
		size++;
	}
	//REMOVE NODE AT INDEX
	public void removeAt(int index) {
		if (head == null) return;
		if (index < 1 || index > size) return;
		
		Link current = head;
		int i = 1;
		while (i < index) {
			current = current.next;
			i++;
		}
		//REMOVE LAST INDEX
		if (current.next == null) {
			current.previous.next = null;
			//REMOVE FIRST INDEX
		} else if (current.previous == null) {
			current = current.next;
			current.previous = null;
			head = current;
		} else {
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		size--;
	}
	//SIZE
	public int size() {
		return size;
	}
	//PRINT
	public void print() {
		Link current = head;
		while (current != null) {
			System.out.println(current.Data());
			current = current.next;
		}
	}
	public boolean isEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addFront(5);
		dll.addFront(10);
		dll.print();
		System.out.println("-----------------");
		dll.addRear(20);
		dll.print();
		System.out.println("Size: " + dll.size());

		System.out.println("-----------------");
		//dll.removeFront();
		//dll.removeRear();
		dll.insertAt(36, 3);
		dll.insertAt(45, 1);
		dll.print();
		System.out.println("Size: " + dll.size());
		System.out.println("-----------------");
		dll.removeAt(1);
		dll.print();
		System.out.println("Size: " + dll.size());
	}

}
