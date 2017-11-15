package ds.graph;

import java.util.ArrayList;

public class Graph {
	private int vCount; //number of vertices
	private int eCount; // number of edges
		
	private ArrayList[] adjacents; // array of integer lists. each one of those slots is going to contain an array list
	
	public Graph (int vCount) {
		this.vCount = vCount;
		this.eCount = 0;
		adjacents = new ArrayList[vCount]; //initialize array
		
		for(int i = 0; i < vCount; i++) {
			adjacents[i] = new ArrayList(); //loop through vertices. every slot of the index we are throwing in an empty list
		}
	}
	public int getVertexCount() {
		return vCount;
	}
	
	public int getEdgeCount() {
		return eCount;
	}
	
	public void addEdge(int src, int dest) {
		adjacents[src].add(dest); //each on of the src slot contains a list, so we are adding to that lsit
		eCount++;
	}
	
	//method to show the adjacent of a given vertex
	public Object[] adj(int src) {
		return adjacents[src].toArray();
	}
	
	//Driver method
	
	public static void main(String[] args) {
		Graph myGraph = new Graph(5);
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 2);
		myGraph.addEdge(0, 3);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 1);
		myGraph.addEdge(4, 0);
		myGraph.addEdge(4, 3);
		
		Object [] values = myGraph.adj(4);
		for (Object val : values) {
			System.out.println(val);
		}

	}

}
