package ds.stack;

public class Stack {
	private int maxSize; //store the size of the stack
	private char[] stackArray; //container which will store the list of items
	private int top; //represent the index position of the last item that was placced on top of the stack
	
	//initialize sstack array
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new char[maxSize];
		this.top = -1; //first item will be at the 0 index of the array
		
	}
	
	//support push and pop opertaions
	
	public void push(char j) {
		if (isFull()) {
			System.out.println("this stack is full");
		} else {
			top++;
			stackArray[top] = j;
		}
	}
	public char pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return '0';
		} else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return(top == -1);
	}
	
	public boolean isFull() {
		return (maxSize - 1 == top);
	}

}
