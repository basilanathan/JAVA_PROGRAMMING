package algosJava;

import java.util.HashSet;

/**
 * 
 * @author basila
 * 
 * Description
	We are given a linked list of integers and we have to remove all the duplicate 
	nodes from it by keeping only the first occurrence of each duplicate. 
	The following example elaborates it further.
 * 
 * Hints
	Use hashset
	Solution
	Runtime Complexity
	Linear, O(n) - where 'n' is length of the linked list.
	
	Memory Complexity
	Linear, O(n) - to store visited nodes in hashset.
 *
 *
 *The interviewer might ask that we are not allowed to use any extra memory i.e. space complexity 
 *of our algorithm should be O(1). We can take these approaches based on the requirements:
	If we are allowed to change the order of the list, we can just sort the linked list in 
	O(n logn) time. After sorting, all duplicates must be adjacent and can be removed in a linear scan.
	For each node in the linked list do another scan of the preceding nodes to see if it 
	already exists or not. The time complexity of this algorithm is O(n^2) but it does not require any extra space.
 */

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
}

public class RemoveDuplicatesFromLinkedList {
	
	public ListNode removeDups(ListNode head) {
		if(head == null) return head;
		
		//track values using a hash table
		HashSet<Integer> dupSet = new HashSet<Integer>();
		ListNode current = head;
		dupSet.add(current);
		while(current.next != null) {
			if(!dupSet.contains(current.next.val)) {
				//Element not found in map, lets add it
				dupSet.add(current.next.val);
				current = current.next;
			} else {
				//Duplicate node found -> remove from list
				current.next = current.next.next;
			}
		}
		return head;
	}
	
	

}
