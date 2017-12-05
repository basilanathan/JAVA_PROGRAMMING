package cci.ch4;

import java.io.*;
import java.util.*;

/**
 * 
 * @author basila
 * 
 * You are given a list of project and list of dependencies (which
 * is a list of pairs of projects, where second project is dependent
 * on the first project). All of the project's dependencies must be
 * build before project is built. Find the build order that will 
 * allow projects to be built. If there is no valid build order,
 * return an error.
 * 
 * Time: O(V + E) V are the verticea and E are the edges
 * 
 * http://www.geeksforgeeks.org/topological-sorting/
 *
 */
//modified DFS
public class BuildOrder {
		private int V; //number of vertices
		private LinkedList<Integer> adj[]; //adjacency list
		
		//constructor
		public BuildOrder(int v) {
			V = v;
			adj = new LinkedList[v];
			for(int i = 0; i < v; ++i) 
				adj[i] = new LinkedList();
		}
		
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}
		
		public void topologicalSortUtil(int v, boolean visited[], Stack stack) {
			//mark the current node as visited
			visited[v] = true;
			
			Integer i;
			
			//make a recursive call for its unvisited neightboring vertices
			Iterator<Integer> it = adj[v].iterator();
			while(it.hasNext()) {
				i = it.next();
				if (!visited[i]) 
					topologicalSortUtil(i, visited, stack);
			}
			//push current vertec to stack which stores result
			stack.push(new Integer(v));
		}
		
		public void topologicalSort() {
			Stack stack = new Stack(); //empty stack
			
			//mark all vertices as not visited
			boolean visited[] = new boolean[V];
			for(int i = 0; i < V; i++)
				visited[i] = false;
			
			//call recursive helper function to store topological sort
			//starting from all vertices one by one
			
			//this forloop will give the unvisited vertex
			for(int i = 0; i < V; i++)
				if (visited[i] == false)
					topologicalSortUtil(i, visited, stack); //this function will be called with the unvisited vertex
										//unvisited vertex, visited array, empty stack
			//print contents of stack
			while(stack.empty() == false)
				System.out.println(stack.pop() + " ");
		}
		
		public static void main(String[] args) {
			BuildOrder g = new BuildOrder(6);
	        g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);
	        
	        System.out.println("Following is a Topological " +
                    "sort of the given graph");
	        g.topologicalSort();
		}

}
