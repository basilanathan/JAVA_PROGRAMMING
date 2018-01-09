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

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

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
	
	/*
	 * IN PLACE SOLUTION
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
