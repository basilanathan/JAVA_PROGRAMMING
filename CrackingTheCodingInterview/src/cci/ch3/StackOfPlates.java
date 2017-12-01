package cci.ch3;

import java.util.ArrayList;

public class StackOfPlates {
	ArrayList<Stack> stacks = new ArrayList<Stack>(); //array of stacks
	public int capacity;
	
	public StackOfPlates(int capacity) {
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		if(stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1); //get the last stack
	}
	
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	//push needs to be called on the last stack in the array of stacks.
	//if the last stack is at capacity, we need to create a new stack.
	public void push(int v) {
		Stack last = getLastStack();
		if(last != null && !last.isFull()) { //add to last stack
			last.push(v);
		} else { //create a new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		if(last == null) System.out.println("stack is empty");
		int v = last.pop(); //save the pop value
		if(last.size == 0) {
			stacks.remove(stacks.size() - 1); //remove the last stack
		}
		return v;
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if(removeTop) removed_item = stack.pop();
		else removed_item = stack.removeBottom();
		if(stack.isEmpty()) {
			stacks.remove(index);
		} else if(stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
	

}
