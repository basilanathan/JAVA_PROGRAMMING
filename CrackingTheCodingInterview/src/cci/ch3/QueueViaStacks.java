package cci.ch3;

import java.util.Stack;

/**
 * 
 * @author basila
 * Description: Implement a queue using two stacks
 * Time O(1) Space O(1) 
 * @param <T>
 */

public class QueueViaStacks<T> {
	Stack<T> stackNewest;
	Stack<T> stackOldest;
	
	public QueueViaStacks() {
		stackNewest= new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public boolean isEmpty() {
		if(stackOldest.isEmpty() && stackNewest.isEmpty())
			return true;
		else
			return false;
	}
	
	public void add(T value) {
		//push onto the new stack
		stackNewest.push(value);
	}
	
	// if you want to dequeue and the old stack is empty. move elements from the
	//stackNewest into stackOldest.and pop from stackOldest
	
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek(); //get the oldes item from the queue
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop(); //pop the oldest item
	}
	
	public static void main(String[] args) {
		QueueViaStacks<Integer> my_queue = new QueueViaStacks<Integer>();
		
		System.out.println("is the queue empty " + my_queue.isEmpty());
		
		for(int i = 1; i < 6; ++i) {
			my_queue.add(i * 10);
			System.out.println("Enqueued " + i * 10 + " into the queue");
		}
		
		int Size = my_queue.size();

		for(int i = 0; i < Size; ++i) {
			System.out.println("dequeued " + my_queue.remove() + " from queue");
		}
	}

}
