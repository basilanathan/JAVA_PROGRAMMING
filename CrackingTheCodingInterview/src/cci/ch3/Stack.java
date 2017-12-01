package cci.ch3;

class Node {
	public Node above;
	public Node below;
	public int value;
	public Node(int value) {
		this.value = value;
	}
}

public class Stack {
	private int capacity;
	public Node top;
	public Node bottom;
	public int size = 0;
	
	public Stack(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull() {
		return capacity == size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void join(Node above, Node below) {
		if(below != null) below.above = above;
		if(above != null) above.below = below;
	}
	
	public boolean push(int v) {
		if(size >= capacity) return false;
		size++;
		Node n = new Node(v);
		if (size == 1) bottom = n;
		join(n, top);
		top = n;
		return true;
	}
	
	public int pop() {
		if(top == null) System.out.println("stack is empty");
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}
	
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if(bottom != null) bottom.below = null;
		size--;
		return b.value;
	}

}
