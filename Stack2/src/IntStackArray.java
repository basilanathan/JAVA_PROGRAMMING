import java.util.Arrays;
import java.util.Stack;

public class IntStackArray {
	private int[] stack;
	private int size;
	private static final int INITIAL_SIZE = 10;
	
	public IntStackArray() {
		stack = new int[INITIAL_SIZE];
		size = 0;
	}
	
	public void push(int value) {
		if (size == stack.length) {
			doubleCapacity();
		}
		stack[size] = value;
		size++;
	}
	
	public int pop() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int result = stack[size - 1];
		stack[size - 1] = 0;
		
		size--;
		
		return result;
	}
	//returns the value on top of the stack
	public int peek() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int result = stack[size - 1];
		return result;
	}
	//returns the size of the stack
	public int size() {
		return size;
	}
	//retuns the size of the underlying array.
	public int capacity() {
		return stack.length;
	}
	//retuns the number of cells in the underlying array
	public int capacityRemaining() {
		int result = stack.length - size;
		return result;
	}
	//empties the stack of all vavlues
	public void empty() {
		for (int i = 0; i < stack.length; i++) {
			stack[i] = 0;
		}
		size = 0;
	}
	
	//modify the array so that the capacity = to its size. there are no unused cells
	public void compress() {
		if (size < stack.length) {
			int newCapacity = size;
			
			int[] newStack = new int[newCapacity];
			for (int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
	}
	
	private void doubleCapacity() {
		int newCapacity = 2 * stack.length; //double the size
		
		int [] newStack = new int[newCapacity]; //instantiate new array, with new size
		
		for (int i = 0; i < stack.length; i++) { //use forloop to copy the values over
			newStack[i] = stack[i];
		}
		stack = newStack; //assign stack
	}
	

		
	public static void main(String[] args) {
		IntStackArray myStackArray = new IntStackArray();
		myStackArray.push(5);
		myStackArray.push(7);
		myStackArray.push(9);
		myStackArray.push(11);
		myStackArray.push(13);
		//System.out.println(myStackArray.pop());
		//myStackArray.push(20);
		//System.out.println(myStackArray.pop());


	}

}
