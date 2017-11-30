package cci.ch3;

/**
 * 
 * @author basila
 * 
 * FIXED DIVISION
 * 
 * The problem with this method is inefficient use of array space. 
 * A stack push operation may result in stack overflow even if there is 
 * space available in arr[]. For example, say the array size is 6 and we push 3 
 * elements to stack1 and do not push anything to second stack2. When we push 4th 
 * element to stack1, there will be overflow even if we have space for 3 more elements in array.
 *
 */

public class ThreeInOne {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values; //array of values
	private int[] sizes; //size of each stack
	
	public ThreeInOne(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}
	
	//push values onto the stack
	public void push(int stackNum, int value) {
		//check if we have space
		if(isFull(stackNum)) {
			System.out.println("stack is full!!");
		}
		
		//increment stack pointer and update the top value
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	//pop items from a stack
	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			System.out.println("stack is empty");
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex]; //get top
		values[topIndex] = 0; //clear
		sizes[stackNum]--; //shrink
		return value;
	}
	
	//return top element
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			System.out.println("stack is empty");
		}
		return values[indexOfTop(stackNum)];
	}
	
	//return if stack is empty
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	//return if is stack is full
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	//returns index at the top of the stack
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size  - 1;
	}
	
	public int[] getValues() {
		return values;
	}
	
	public int[] getStackValues(int stackNum) {
		int[] items = new int[sizes[stackNum]];
		for (int i = 0; i < items.length; i++) {
			items[i] = values[stackNum * stackCapacity + i];
		}
		return items;
	}
	
	

}
