package ds.stack;

public class Stack {
	public int maxSize;
	private long stackArray[];
	private int top;
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new long[maxSize];
		this.top = -1;
	}
	
	public void push(long j) {
		if(isFull()) {
			//System.out.println("stack is full");
			doubleCapacity();
		} 
		top++;
		stackArray[top] = j;
		
	}
	
	private void doubleCapacity() {
		int newCapacity = 2 * stackArray.length;
		long newStack[] = new long[newCapacity];
		
		for(int i = 0; i < stackArray.length; i++) {
			newStack[i] = stackArray[i];
		}
		stackArray = newStack;
	}
	
	public long pull() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		} else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	}
	
	public long peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (maxSize - 1 == top);
	}
	
	//driver method
	
	public static void main(String[] args) {
		Stack myStack = new Stack(5);
		myStack.push(4);
		myStack.push(3);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		myStack.push(10);

		
		while (!myStack.isEmpty() ) {
			long value = myStack.pull();
			System.out.println(value);
		}

	}

}
