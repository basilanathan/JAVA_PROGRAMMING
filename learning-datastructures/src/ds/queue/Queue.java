package ds.queue;

public class Queue {
	//variables to maintain the state of the queue data stricture
	private int maxSize; //initializes the set number of slots
	private long[] queueArray; //slots to maintain the data
	private int front; //index position for the element in the front
	private int rear; //this is also going to be in the index poosition for the lelemnt at the back of the line
	private int nItems; //counter to mainain the number of item sin the queue
	
	public Queue(int size) {
		this.maxSize = size;
		this.queueArray = new long[size];
		front = 0; //index posiiton of the first slot of the array
		rear = -1; //there is no item in the array yet to be considered as the last item
		nItems = 0; //we dont have elements in the array yet
	}
	
	public void insert(long j) {
		if (rear == maxSize - 1) { //will over write what ever was in the 0th position CIRCULAR QUEUE
			rear = -1;
		}
		rear++;
		queueArray[rear] = j;
		nItems++;
	}
	public long remove() { //get removed from the front of the queue
		long temp = queueArray[front]; //get the front value
		front++; //increment, point to the next thing in the line
		if (front == maxSize) {
			front = 0; //can set front back to the 0th index so we can utilize the entire array again.
		}
		nItems--;
		return temp;
		
	}
	
	public long peekFront() {
		return queueArray[front];
	}
	
	public boolean isEmpty() {
		return(nItems == 0);
	}
	
	public boolean isFull() {
		return(nItems == maxSize);
	}
	
	public void view() {
		System.out.print("[ ");
		for (int i = 0; i < queueArray.length; i++) {
			System.out.print(queueArray[i]+ " ");
		}
		System.out.print("]");
	}
}
