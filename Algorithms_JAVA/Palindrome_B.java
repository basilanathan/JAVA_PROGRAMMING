package algosJava;

import java.util.Stack;

/**
 * 
 * @author basila
 * Time O(N)
 * Space O(N)
 */

//class Node {
//	public int data;
//	public Node next;
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class Palindrome_B {
	public static boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		//push elements from the first half of the linked list onto the stack.
		//when fast runner which is moving 2x speed reahes the end of the linked list, we are at the middle
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		//has odd number of elements, skip the middle element
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			int top = stack.pop().intValue();
			
			//if values are different then its not a palindrome
			if(top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
    public void display(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.data);
            currNode=currNode.next;
        }
    }
	public static void main(String[] args) {
		Palindrome_B l = new Palindrome_B();
		Node h1 = new Node(0);
		h1.next = new Node(1);
		h1.next.next = new Node(2);
		h1.next.next.next = new Node(1);
		//h1.next.next.next.next = new Node(0);
		System.out.println("Original List");
		l.display(h1);
		System.out.println();
		System.out.println("Is Palindrome : "+ l.isPalindrome(h1));

	
	}

}
