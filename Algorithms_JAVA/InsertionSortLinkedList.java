package fb.coderust;

/*
Sort a linked list using insertion sort.
Example
Given 1->3->2->0->null, return 0->1->2->3->null.
Tags Expand 
Sort Linked List
*/


/*
    Recap. 12.10.2015
    http://www.cnblogs.com/springfor/p/3862468.html
    Assumed we have a sorted list: now we pick each element and insert into that sorted list.
    This is insertion.
    
    If we are constly picking from (o ~ n) of this list itself, it becomes Insertion sort.
    
    1. make a sortedList, Now we need to have pre,curr,next for wapping, whenever we find the correct curr
    2. a pre node pointer [used to store the list each time to check where to insert curr], 
    3. curr is the node being check very round  
    4. next is simply used for wapping, not much other usage
*/

/*
 * Hints
	Maintain two lists i.e. sorted and un-sorted.
	Solution
	Runtime Complexity
	Polynomial, O(n2).
	
	 Memory complexity
	 Constant, O(1)
	
	Concept of Insertion Sort is very simple. We'll maintain two linked lists:
	
	Original list (given to us as input).
	Sorted list (initially empty).
	Here is how the algorithm works.
	While Original list is not empty:
	   Remove an element (say 'X') from the Original list.
	   Insert 'X' at correct sorted position in the Sorted list.
	
	In order to insert a node in Sorted linked list we may need to scan the whole sorted list depending upon 
	the node being inserted.
 * 
 * https://www.educative.io/collection/page/5642554087309312/5679846214598656/280002
 * https://github.com/awangdev/LintCode/blob/master/Java/Insertion%20Sort%20List.java
 * 
 * */

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class InsertionSortLinkedList {
	public ListNode insertionSort(ListNode head) {
		if(head == null) return head;
		
		ListNode sortedHead = new ListNode(0); //dummyhead
		ListNode prev, curr, next;
		curr = head;
		
		while(curr != null) {// insert every single curr into sorted list
			next = curr.next; //prepare for insertion && swapping.
			prev = sortedHead; //the list to scan
			while(prev.next != null && prev.next.val <= curr.val) {
				//as long as pre and its front are sorted ascending, keep going
				prev = prev.next;
			}
			//when pre.next == null , or curr is less than a node in pre.next, we want to insert curr before that pre.next node
			curr.next = prev.next;
			prev.next = curr;
			
			curr = next;//use the original next, instead of the new curr.next
		} //end while
		return sortedHead;
	}

}
