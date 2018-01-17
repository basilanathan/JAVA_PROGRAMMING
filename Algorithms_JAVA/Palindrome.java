package algosJava;

/**
 * 
 * @author basila
 * Time O(N)
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

public class Palindrome {
	
	public static boolean isPalindrome(Node head) {
		Node reversed = reverseAndClone(head);
		return isEqual(head, reversed);
		
	}
	public static Node reverseAndClone(Node node) {
		Node head = null;
		while(node != null) {
			Node n = new Node(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}
	
	public static boolean isEqual(Node one, Node two) {
		while(one != null && two != null) {
			if(one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
	
    public void display(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.data);
            currNode=currNode.next;
        }
    }
	
	public static void main(String[] args) {
		Palindrome l = new Palindrome();
		Node h1 = new Node(0);
		 h1.next= new Node(1);
	     h1.next.next = new Node(2);
	     h1.next.next.next = new Node(1);
	     h1.next.next.next.next = new Node(0);
	     //h1.next.next.next.next.next = new Node(1);
	     System.out.println("Original List");
	     l.display(h1);
	     System.out.println();
	     System.out.println("Reversed List");
	     Node h2 = l.reverseAndClone(h1);
	     l.display(h2);
	     System.out.println();
	     System.out.println("is palindrom" + ": " + isEqual(h1, h2));

		
	}

}
