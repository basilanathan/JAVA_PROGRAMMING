package pkg4;

public class DoublyLinkedListDemo {
	public static void main(String[] args) {
		DoublyLinkedList google = new DoublyLinkedList();
		
		google.insertAtHead(5);
		google.insertAtHead(10);
		google.insertAtHead(2);
		google.insertAtHead(12);
		google.insertAtHead(19);
		google.insertAtHead(20);
		
		System.out.println(google);

	}

}
