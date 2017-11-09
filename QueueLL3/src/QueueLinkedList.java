class Node {
	int val;
	Node next;
	
	public Node(int x) {
		val = x;
		next = null;
	}
}
public class QueueLinkedList {
	Node first, last;
	
	public void enqueue(Node n) {
		if (first == null) {
			first = n;
			last = first;
		} else {
			last.next = n;
			last = n;
		}
	}
	
	public Node dequeue() {
		if (first == null) {
			return null;
		} else {
			Node temp = new Node(first.val);
			first = first.next;
			return temp;
		}
	}
	
	public static void main(String[] args) {
		QueueLinkedList queue = new QueueLinkedList();
		
		queue.enqueue(6, 7);
		queue.enqueue(6);
		queue.enqueue(6);
		queue.enqueue(6);
		queue.enqueue(6);
		queue.enqueue(6);
		queue.enqueue(6);

	}

}
