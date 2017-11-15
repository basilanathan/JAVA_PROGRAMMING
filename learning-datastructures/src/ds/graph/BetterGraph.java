package ds.graph;

public class BetterGraph {
	
	Vertex[] arrayOfLists;
	int indexCounter = 0;
	boolean unidirected = true;
	
	class Node {
		public int vertexItdx; //represent adjacent vertexes slot position in the array
		public Node next;
		public Node(int vertexIdx, Node node) {
			this.vertexItdx = vertexIdx;
			next = node;
		}
	}
	
	class Vertex {
		String name;
		Node adjList; //list of nodes
		Vertex(String name, Node aNode) {
			this.name = name;
			this.adjList = aNode;
		}
	}
	
	public BetterGraph(int vCount, String graphType) {
		if (graphType.equals("directed")) {
			unidirected = false;
		}
		arrayOfLists = new Vertex[vCount];
	}
	
	public void addVertex(String vertexName) { //name that is passed is used to instantiate a vertex object
		arrayOfLists[indexCounter] = new Vertex(vertexName, null);
		indexCounter++;
	}
	
	public void addEdge(String srcVertexName, String destVertexName) {
		int v1idx = indexForName(srcVertexName); //loop through the array and find theindex posiiton of the given name
		int v2idx = indexForName(destVertexName);
		arrayOfLists[v1idx].adjList = new Node(v2idx, arrayOfLists[v1idx].adjList); //assignng to a list of nodes a new node
		if (unidirected) {
			arrayOfLists[v2idx].adjList = new Node(v1idx, arrayOfLists[v2idx].adjList);
		}
	}
	
	int indexForName(String name) {
		for(int v = 0; v < arrayOfLists.length; v++) {
			if (arrayOfLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}
	
	public void print() {
		System.out.println();
		for (int v = 0; v < arrayOfLists.length; v++) {
			System.out.println(arrayOfLists[v].name);
			for (Node aNode = arrayOfLists[v].adjList; aNode != null; aNode = aNode.next) {
				System.out.println("--->" + arrayOfLists[aNode.vertexItdx].name);
			}
			System.out.println(" ");
		}
	}
	
	//Driver method
	
	public static void main(String[] args) {
		BetterGraph myGraph = new BetterGraph(5, "directed");
		myGraph.addVertex("State");
		myGraph.addVertex("Avene");
		myGraph.addVertex("Elm");
		myGraph.addVertex("Pocono");
		myGraph.addVertex("William");
		
		myGraph.addEdge("Avene", "Pocono");
		myGraph.addEdge("State", "Elm");
		myGraph.addEdge("Elm", "Avene");
		myGraph.addEdge("Elm", "William");
		myGraph.addEdge("William", "State");
		myGraph.addEdge("William", "Pocono");
		myGraph.addEdge("Pocono", "Elm");
		myGraph.addEdge("State", "Avene");
		
		myGraph.print();


	}

}
