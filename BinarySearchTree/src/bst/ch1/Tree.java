package bst.ch1;

//binary search tree is going to implement methods from the tree interface
//instantiate binary search tree as a tree
public interface Tree<T> {
	
	public void traversal();
	public void insert(T data);
	public void delete(T data);
	public T getMaxValue();
	public T getMinValue();

}
