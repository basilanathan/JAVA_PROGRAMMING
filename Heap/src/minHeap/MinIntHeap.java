package minHeap;

import java.util.Arrays;

public class MinIntHeap {
	private int capacity = 5;
	private int size = 0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex) {
		return 2* parentIndex + 1;
	}
	private int getRightChildIndex(int parentIndex) {
		return 2* parentIndex + 2;
	}
	private int getParentIndex(int childIndex) {
		return (childIndex-1) / 2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	private int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
		
	}
	
	public int poll() {
		if (size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		//System.out.println(item);
		return item;
	}
	
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
		
	}
	
	//when added
	public void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	//when deleted
	public void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index); //set left child to small
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) { //if there is a right child and it's even smaller than left child
				smallerChildIndex = getRightChildIndex(index); //set small to right child
			}
			
			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
	
	public void print() {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
	}
	
	public static void main(String[] args) {
		MinIntHeap test = new MinIntHeap();
		
		//int items[] = {10, 15, 20, 17, 25};
		
		//System.out.println(Arrays.toString(items));
		test.add(10);
		test.add(15);
		test.add(20);
		test.add(17);
		test.add(25);
		//test.add(20);

		test.print();
		System.out.println("~~~~~~~~~~~~~~~~~~");
		//System.out.println(test.poll());

		test.poll();
		test.print();


		
	}
	
	
	

}
