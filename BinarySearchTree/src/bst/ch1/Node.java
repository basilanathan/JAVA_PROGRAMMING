package bst.ch1;

public class Node<T> {
	
	private T data; //generic data becuase we want to use it for strings, floats, doubles, etc
	private Node<T> leftChild;
	private Node<T> rightChild;
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	

}
