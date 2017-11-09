
public class MyQueue {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.push(11);
		queue.push(13);
		queue.push(7);
		System.out.println(queue.pop());
		queue.push(9);
		System.out.println(queue.pop());
	}

}
