package cci.ch2;


/**
 * 
 * @author basila
 * 
 * Time Complexity: O(m+n) where m and n are the sizes of given two linked lists.
 * 
 *Approach:

 *Get the length of both the lists.
 *If lengths are not equal, make them equal by adding nodes with value 0 in front of shorter linked list.

 *Cre­ate a global vari­able carry=0.
 *Cre­ate a new­Head = null;
 *new­Head will be the start­ing node of our result linked list and curr node will the ref­er­ence to the cur­rent node on which we are work­ing in our result linked list.
 *Now using recur­sion travel in both the list till the end.
 *So now nodes are stores in a stack
 *Now while com­ing back, each node will pop out from the stack in reverse order
 *Take node data from both the lists add them along with carry.
 *if sum is >=10 , then make carry as 1 and cre­ate a new node with sum-10
 *Else just cre­ate a new Node with sum.
 *Add the newly cre­ated node to the result linked list with the help of newHead.
 */
//class Node {
//	public int data;
//	public Node next;
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class PartialSumForward_B {
	public int carry = 0;
	public Node newHead = null;
	
	public Node add(Node h1, Node h2) {
		//first make sure that both the linked lists had same number of nodes
		//if not, append 0 in front of the shorter list
		
		int h1Len = getLength(h1);
		int h2Len = getLength(h2);
		
		if(h1Len > h2Len) {
			int diff = h1Len - h2Len;
			while(diff > 0) {
				Node n = new Node(0);
				n.next = h2;
				h2 = n;
				diff--;
			}
		}
		if(h1Len < h2Len) {
			int diff = h2Len - h1Len;
			while(diff > 0) {
				Node n = new Node(0);
				n.next = h1;
				h1 = n;
				diff--;
			}
		}
		
		Node newHead = addBackRecursion(h1, h2);
		
		//check for the carry forward, if not 0 then we need to create another node for the end
		//example adding 1 -> 1 and 9 -> 9 the recursive function will return 0 -> 0 and carry = 1
		if(carry != 0) {
			Node n = new Node(carry);
			n.next = newHead;
			newHead = n;
		}
		return newHead;
		
	}
	
	public Node addBackRecursion(Node h1, Node h2) {
		if(h1 == null && h2 == null) {
			return null;
		}
		
		addBackRecursion(h1.next, h2.next);
		int a = h1.data + h2.data + carry;
		carry = 0;
		
		if(a >= 10) { // a = 12
			carry = 1; // carry = 1
			a = a % 10; // a = 2
		}
		Node n = new Node(a);
		if(newHead == null) {
			newHead = n;
		} else {
			n.next = newHead;
			newHead = n;
		}
		//carry = 0
		return newHead;
	}
	
	public int getLength(Node head) {
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
	
    public void display(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.data);
            currNode=currNode.next;
        }
        
    }
    
    public static void main(String args[]){
    	PartialSumForward_B l = new PartialSumForward_B();
        Node h1 = new Node(1);
        h1.next= new Node(1);
        h1.next.next = new Node(1);
        h1.next.next.next = new Node(7);
        System.out.print("First Number : ");
        l.display(h1);
        Node h2 = new Node(9);
        h2.next= new Node(9);
        h2.next.next = new Node(9);
        //h2.next.next.next = new Node(9);
        System.out.print("\n Second Number : ");
        l.display(h2);
        Node x = l.add(h1, h2);
        System.out.print("\n Addition : ");
        l.display(x);
    }

}
