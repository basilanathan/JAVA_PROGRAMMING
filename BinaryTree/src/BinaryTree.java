
public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key,  name);
		
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root; //set root as this node, start with root as we traverse throguh the tree
			Node parent;
			
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	public void preorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);

		}
	}
	
	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) 
				return null;
		}
		return focusNode;
	}
	
	public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root; //starting at the top of the binary tree
		
		boolean isItALeftChile = true;
		
		while (focusNode.key != key) {
			parent = focusNode;
			
			if (key < focusNode.key) {
				isItALeftChile = true;
				
				focusNode = focusNode.leftChild;
			} else {
				isItALeftChile = false;
				focusNode = focusNode.rightChild;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree thTree = new BinaryTree();
		thTree.addNode(50, "Boss");
		thTree.addNode(25, "Vice President");
		thTree.addNode(15, "Office Manager");
		thTree.addNode(30, "Secretary");
		thTree.addNode(75, "Sales Manager");
		thTree.addNode(85, "Salesman 1");
		
		//thTree.inOrderTraverseTree(thTree.root);
		//thTree.preorderTraverseTree(thTree.root);
		thTree.postOrderTraverseTree(thTree.root);
		
		System.out.println("search for 30");
		System.out.println(thTree.findNode(30));

	}

}

class Node {
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	public Node(int key, String name) {
		
		this.key = key;
		this.name = name;
	}
	
	public String toString()
	{
		return name + " has key " + key;
	}
}
