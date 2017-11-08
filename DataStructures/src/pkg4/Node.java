package pkg4;

public class Node {
	
	//private variables
	private int data;
	private Node nextNode;
	
	//constructor
	public Node (int data) {
		this.data = data;
	}
	
	//methods
	public int getData() {
		return this.data;
	}
	
	public Node getNextNode() {
		return this.nextNode;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public String toString() {
		return "Data: " + this.data;
	}

}
