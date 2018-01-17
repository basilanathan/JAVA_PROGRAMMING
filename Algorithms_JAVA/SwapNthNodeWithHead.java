package algosJava;

/*
 * Hints
	Find (N-1)th node.
	Solution
	Runtime Complexity
	Linear, O(n).
	
	Memory Complexity
	Constant, O(1).
	
	We don't want to swap the values as that is inefficient for custom types. To swap the Nth node 
	with head, let's find the (N-1)th node as we need node '(N-1)->next' to become the new head. 
	We will iterate the list till current points to the Nth node. 'prev' follows current and will 
	be pointing to (N-1)th node. We'll return current as the new head of the linked list. 
	
	Let's use the above example to demonstrate this where we are swapping the head with the 4th node 
	in the linked list.
 * 
 * */

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class SwapNthNodeWithHead {
	
	public ListNode swapNodes(ListNode head, int n) {
		if(head == null || n <= 0) return null;
		if(n == 1) return head;
		
		ListNode prev = null;
		ListNode  current = head;
		
		for(int i = 1; i < n; ++i) {
			prev = current;
			current = current.next;
		}
		
		prev.next = head;
		ListNode temp = head.next;
		head.next = current.next;
		current.next = temp;
		
		return current;
	}
	
    public void display(ListNode head){
        ListNode currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.val);
            currNode=currNode.next;
        }
    }
	
	public static void main(String[] args) {
		SwapNthNodeWithHead test = new SwapNthNodeWithHead();
		
		ListNode list1 = new ListNode(7);
		list1.next = new ListNode(14);
		list1.next.next = new ListNode(21);
		list1.next.next.next = new ListNode(28);
		list1.next.next.next.next = new ListNode(35);
		list1.next.next.next.next.next = new ListNode(42);
		
		test.display(list1);
		
		ListNode afterSwap = test.swapNodes(list1, 4);
		System.out.println();
		System.out.println("After Swap: ");
		test.display(afterSwap);
	}
	
	

}
