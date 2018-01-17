package algosJava;

/**
 * 
 * @author basila
 * Time O(N)
 * Space O(N) if Function Call Stack size is considered, otherwise O(1).
 */

//class Node {
//	public int data;
//	public Node next;
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class Palindrome_Recursive {
	
	public static class Result {
		public Node node;
		public boolean result;
		public Result(Node n, boolean res) {
			node = n;
			result = res;
		}
	}
	
	public static Result isPalindromeRecurse(Node head, int length) {
		if(head == null || length <= 0) { //even number of nodes
			return new Result(head, true);
		} else if(length == 1) { //odd number of nodes
			return new Result(head.next, true);
		}
		//recurse on sublist
		Result res = isPalindromeRecurse(head.next, length - 2);
		
		//if child calls are not a palindrome, pass back up
		if(!res.result || res.node == null) {
			return res;
		}
		//check if matches corresponding node on other side.
		res.result = (head.data == res.node.data);
		//return corresponding node
		res.node = res.node.next;
		return res;
	}
	
	public static boolean isPalindrome(Node head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
		
	}
	
	public static int lengthOfList(Node n) {
		int length = 0;
		while(n != null) {
			length++;
			n = n.next;
		}
		return length;
	}
	
    public void display(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.data);
            currNode=currNode.next;
        }
    }
    
    public static Node buildList(int[] a) {
    		if(a == null || a.length == 0) return null;
    		Node n = new Node(a[0]);
    		Node head = n;
    		for(int i = 1; i < a.length; ++i) {
    			n.next = new Node(a[i]);
    			n = n.next;
    		}
    		return head;
    	
    }
    
    public static void main(String[] args) {
		Palindrome_Recursive l = new Palindrome_Recursive();
//		Node h1 = new Node(0);
//		h1.next = new Node(1);
//		h1.next.next = new Node(2);
//		h1.next.next.next = new Node(3);
//		h1.next.next.next.next = new Node(2);
//		h1.next.next.next.next.next = new Node(1);
//		h1.next.next.next.next.next.next = new Node(0);
		
		int[] list = {0, 1, 2, 3, 2, 1, 0};
		Node h1 = l.buildList(list);
		
		System.out.println("Original List");
		l.display(h1);
		System.out.println();
		System.out.println("Is Palindrome : "+ l.isPalindrome(h1));

	}

}
