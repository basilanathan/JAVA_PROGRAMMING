package ds.betterStackLL;

public class LinkedList {
	Node head;
	
	public void append(int data) {
		
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		//add to the end
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public void preprend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(int data) {
		if(head == null) return;
		//if head needs to get deleted
		if(head.data == data) {
			head = head.next;
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public String toString() {
		String result = "{";
		Node current = head;
		
		while (current != null) {
			result += current.toString() + ", ";
			current = current.next;
		}
		
		result += "}";
		return result;
	}
	
	public static void main(String[] args) {
		LinkedList myLL = new LinkedList();
		
		myLL.append(4);
		myLL.append(7);
		myLL.append(9);
		myLL.append(10);
		myLL.append(12);
		System.out.println(myLL.toString());
		
		System.out.println("~~~~~~~~~~~~~~~~~");
		
		myLL.preprend(12);
		System.out.println(myLL.toString());
		
		System.out.println("~~~~~~~~~~~~~~~~~");
		
		myLL.deleteWithValue(9);
		System.out.println(myLL.toString());


		//System.out.println(myLL);

	}

}
