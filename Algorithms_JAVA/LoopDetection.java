package algosJava;

/**
 * 
 * @author basila
 * @date 11/27/2017
 * 
 * Time O(N) n is number of nodes
 * Space O(1)
 */

//class Node {
//	public int data;
//	public Node next;
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class LoopDetection {
	
	public static Node findBeginning(Node head) {
		//create two pointers
		Node fast = head;
		Node slow = head;
		
		//move fast pointer at a rate of 2 steps and slow at a rate of 1 step
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		
		//no meeting point = no loop
		if(fast == null || fast.next == null) {
			return null;
		}
		
		//after they colloide move slow to head and keep fast where it is. they are both k steps
		//away from the meeting point
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		//both are pointing to the start of the loop
		return fast;
	}
	
	public static void main(String[] args) {
		LoopDetection list = new LoopDetection();
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
        
        Node beg = list.findBeginning(head);
        System.out.println(beg.data);
	}

	

}
