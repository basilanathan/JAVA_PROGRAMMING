package algosJava;


/*
Write a program to find the node at which the intersection of two singly linked lists begins.
Example
The following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Note
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Challenge
Your code should preferably run in O(n) time and use only O(1) memory.
Tags Expand 
Linked List
*/

/*
	Thoughts:
	If a and b share some part, if cut off the extra header of b (seen in above example), they should start at same index and touch c1 at same time.
	So traverse a, b, and calculate countA, countB => dif = countB - countA.
	cut off the extra, then start iterating to find c1.
	
	https://www.educative.io/collection/page/5642554087309312/5679846214598656/70005
	https://github.com/awangdev/LintCode/blob/master/Java/Intersection%20of%20Two%20Linked%20Lists.java
*/

/*
 * Hints
	Find length of both linked lists.
	
	Solution
	Runtime Complexity
	Linear, O(m + n).
	
	where m is the length of first linked list and n is the length of second linked list.
	
	Memory Complexity
	Constant, O(1).
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */

public class IntersectionPointOfTwoLists {
	
	public ListNode intersectionPoint(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		
		int l1Length = getLength(headA);
		int l2Length = getLength(headB);
		
		int diff = Math.abs(l1Length - l2Length);
		ListNode node = (l1Length > l2Length) ? headA : headB;
		while(diff != 0) {
			diff--;
			node = node.next;
		}
		ListNode nodeA = (l1Length > l2Length) ? node : headA;
		ListNode nodeB = (l1Length > l2Length) ? headB : node;
		
		while(nodeA != null && nodeB != null) {
			if(nodeA == nodeB) {
				return nodeA;
			}
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		return null;
	}

	private int getLength(ListNode head) {
		int length = 0;
		while(head != null) {
			head = head.next;
			length++;
		}
		return length;
	}
	
    public void display(ListNode head){
        ListNode currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.val);
            currNode=currNode.next;
        }
    }
	
	public static void main(String[] args) {
		IntersectionPointOfTwoLists test = new IntersectionPointOfTwoLists();
		//0 -> 2 -> 3 -> 10 -> 9 -> 7
		ListNode list1 = new ListNode(0);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(3);
		list1.next.next.next = new ListNode(10);
		list1.next.next.next.next = new ListNode(9);
		list1.next.next.next.next.next = new ListNode(7);
		
		//4 -> 10 -> 6 -> 89 
		ListNode list2 = new ListNode(4);
		list2.next = new ListNode(10);
		list2.next.next = new ListNode(6);
		list2.next.next.next = new ListNode(89);
//		list1.next.next.next.next = new ListNode(9);
//		list1.next.next.next.next.next = new ListNode(7);
		
		list2.next = list1.next.next.next;
		
		test.display(list1);
		System.out.println();
		test.display(list2);
		
		ListNode intersect = test.intersectionPoint(list1, list2);
		System.out.println();
		System.out.println("intersection is : " + intersect.val);
		
		//System.out.println(test.intersectionPoint(list1, list2));
	}

}
