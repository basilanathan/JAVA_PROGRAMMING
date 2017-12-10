package bst.ch1;

public class App {
	
	public static void main(String[] args) {
		Tree<Integer> bst = new BinarySearchTree<>();
		Tree<String> bstString = new BinarySearchTree<>();

		
		bst.insert(10);
		bst.insert(-1);
		bst.insert(1);
		bst.insert(0);
		bst.insert(1000);
		bst.insert(-22);
		
		bstString.insert("Adam");
		bstString.insert("Dylan");
		bstString.insert("Amy");
		bstString.insert("Static");
		bstString.insert("Superman");

		
		System.out.println(bst.getMaxValue());
		System.out.println(bst.getMinValue());
		
		bst.traversal();
		System.out.println();
		bstString.traversal();


	}

}
