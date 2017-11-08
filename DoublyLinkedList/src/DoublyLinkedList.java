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
		System.out.println("-----------------");
		//dll.removeFront();
		dll.removeRear();
		dll.print();
	}

}
