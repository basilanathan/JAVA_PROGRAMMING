package pkg4;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertHead(5);
		list.insertHead(10);
		list.insertHead(2);
		list.insertHead(12);
		list.insertHead(19);
		list.insertHead(20);
		
		list.deleteFromHead();
		
		System.out.println(list);
		System.out.println("Length: " + list.length());
		System.out.println("Found: " + list.find(12));

	}

}
