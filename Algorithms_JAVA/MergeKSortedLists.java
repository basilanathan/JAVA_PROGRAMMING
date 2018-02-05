package fb.glassdoor;

import java.util.List;

/**
 * 
 * @author basila
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * 
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
 *
 */

//public class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) {
//		val = x;
//	}
//}

public class MergeKSortedLists {
	
	/*
	 * FIRST SOLUTION
	 * 
	 * */
	
	//O(nlogk), merge takes O(n) time and partition takes O(logk) time
	//Space: O(1)
	
	public ListNode mergeKLists2(ListNode[] lists) {
		if(lists.length == 0) return null;
		return helper(lists, 0, lists.length - 1);
	}

	private ListNode helper(ListNode[] lists, int start, int end) {
		if(start == end) return lists[start];
		int mid = start + (end - start) / 2;
		ListNode a = helper(lists, start, mid);
		ListNode b = helper(lists, mid + 1, end);
		return merge(a, b);
	}
	
    /*
    1-2-3
    3-4-5
     */

	private ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		
		while(a != null && b != null) {
			if (a.val < b.val) {
				current.next = a;
				a = a.next;
			} else {
				current.next = b;
				b = b.next;
			}
			current = current.next;
		}
		if(a != null) current.next = a;
		if(b != null) current.next = b;
		return dummy.next;
	}
	
	/*	PRIORITY QUEUE
	 * Complexity Analysis

Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.

The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
There are NN nodes in the final linked list.
Space complexity :

O(n)O(n) Creating a new linked list costs O(n)O(n) space.
O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations).
	 * */
	

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
	        if (lists == null || lists.length == 0) {
	            return null;
	        }
	        // Initialize the priority queue with customized comparator
	        final PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
	            public int compare (final ListNode a, final ListNode b) {
	                return a.val - b.val;
	            }
	        });
	        for (int i = 0; i < lists.length; i++) {
	            if (lists[i] != null) {
	                queue.offer(lists[i]);
	            }
	        }

	        if (queue.isEmpty()) {
	            return null;
	        }
	        // Append the priority queue with all items
	        ListNode dummy = new ListNode(0);
	        ListNode head = dummy;
	        while (!queue.isEmpty()) {
	            ListNode node = queue.poll();
	            if (node.next != null) {
	                queue.offer(node.next);
	            }
	            head.next = node;
	            head = head.next;
	        }
	        return dummy.next;
	    }
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */


	/*
	    12.10.2015 recap
	    Use queue to store the head of k lists. 
	    First init with all heads.
	    Because the ListNode always has a link to its next sibiling, so it's easy to add that sibling back to queue.
	    time: m * Log(k)
	*/
	public class Solution {
	    public ListNode mergeKLists(List<ListNode> lists) {  
	        if (lists == null || lists.size() == 0) {
	            return null;
	        }
	        PriorityQueue<ListNode> queue = 
	        new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
	            public int compare(ListNode a, ListNode b){
	                return a.val - b.val;
	            }
	        });
	        
	        //populate queue with k lists' header
	        for (int i = 0; i < lists.size(); i++) {
	            if (lists.get(i) != null) {
	                queue.offer(lists.get(i));
	            }
	        }
	        
	        ListNode dummy = new ListNode(0);
	        ListNode node = dummy;
	        while (!queue.isEmpty()) {
	            ListNode curr = queue.poll();
	            node.next = curr;
	            
	            if (curr.next != null) {
	                queue.offer(curr.next);
	            }
	             
	            node = node.next;   
	        }
	        
	        return dummy.next;
	    }
	}
	
	/*
	 * IN PLACE SOLUTION
	 * 
	 * Merge with Divide And Conquer [Accepted]
		Intuition & Algorithm
		
		This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly
		
		Pair up \text{k}k lists and merge each pair.
		
		After the first pairing, \text{k}k lists are merged into k/2k/2 lists with average 2N/k2N/k length, then k/4k/4, k/8k/8 and so on.
		
		Repeat this procedure until we get the final sorted linked list.
		
		Thus, we'll traverse almost NN nodes per pairing and merging, and repeat this procedure about \log_{2}{k}log
		​2
		​​ k times.

	 * Complexity Analysis

		Time complexity : O(Nlogk) where k is the number of linked lists.
		
		We can merge two sorted linked list in O(n) time where n is the total number of nodes in two lists.
		Sum up the merge process and we can get O(Nlogk)
		Space complexity : O(1)
		
		We can merge two sorted linked lists in O(1) space.
	 * 
	 * O(nlogk) and not using heap or priority queue, n means the total elements and k means the size of list.
	 * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head=null;
        ListNode former=null;
        while (l1!=null&&l2!=null) {
            if (l1.val>l2.val) {
                if (former==null) former=l2; else former.next=l2;
                if (head==null) head=former; else former=former.next;
                l2=l2.next;
            } else {
                if (former==null) former=l1; else former.next=l1;
                if (head==null) head=former; else former=former.next;
                l1=l1.next;
            }
        }
        if (l2!=null) l1=l2;
        former.next=l1;
        return head;
        
    }
    
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size()==0) return null;
        if (lists.size()==1) return lists.get(0);
        if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));
        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)), 
            mergeKLists(lists.subList(lists.size()/2, lists.size())));
    }
	
	/*
	 * SECOND SOLUTION
	 * 
	 * */
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		return mergeList(lists, 0, lists.length - 1);
	}

	private ListNode mergeList(ListNode[] lists, int start, int end) {
		if(end < start) return null;
		if(end = start) return end;
		
		int mid = (start + end) / 2;
		
		ListNode aListNode = mergeList(lists, start, mid);
		ListNode bListNode = mergeList(lists, mid + 1, end);
		
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		
		while(aListNode != null && bListNode != null) {
			if (aListNode < bListNode) {
				current.next = aListNode;
				aListNode = aListNode.next;
			} else {
				current.next = bListNode;
				bListNode = bListNode.next;
			}
			current = current.next;
		}
		current.next = (aListNode != null) ? aListNode : bListNode;
		return dummyHead.next;
	}
}
