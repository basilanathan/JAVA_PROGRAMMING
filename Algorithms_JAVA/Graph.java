package fb.leetcode;

import java.util.LinkedList;

/**
 * 
 * @author basila
 * 
 * An adjacency list represents a graph as an array of linked list.
 * 
 * The index of the array represents a vertex and each element in its 
 * linked list represents the other vertices that form an edge with the 
 * vertex.
 *
 */

public class Graph {
	
	int numVertices;
	LinkedList<Integer> adjList[];
	
	public Graph(int vertices) {
		numVertices = vertices;
		adjList = new LinkedList[vertices];
		
		for(int i = 0; i < vertices; i++) 
			adjList[i] = new LinkedList();
		
	}
	
	void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		
		 g.addEdge(0, 1);
         g.addEdge(0, 2);
         g.addEdge(1, 2);
         g.addEdge(2, 3);
	}

}
