package fb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * Problem
	Given a directed graph, design an algorithm to find out whether there is aroute between two nodes.
	
	Example
	Given graph:
	
	A----->B----->C
	 \     |
	  \    |
	   \   |
	    \  v
	     ->D----->E
	for s = B and t = E, return true
	
	for s = D and t = C, return false
 *
 * http://www.lintcode.com/en/problem/route-between-two-nodes-in-graph/
 * https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
 */

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	
	public DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}

/**
 * @param graph: A list of Directed graph node
 * @param s: the starting Directed graph node
 * @param t: the terminal Directed graph node
 * @return: a boolean value
 */

public class RouteBetweenTwoNodesGraph {
	
	//DFS SOLUTION
	
    public boolean hasRouteDFS(ArrayList<DirectedGraphNode> graph,
            DirectedGraphNode s, DirectedGraphNode t) {

		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		return dfs(graph, s, t, visited);
		
		}
		
		public boolean dfs(ArrayList<DirectedGraphNode> graph, 
				DirectedGraphNode s, DirectedGraphNode t, Set<DirectedGraphNode> visited) {
		
		if (s == t) {
			return true;
		} else {
			// corner cases
			if (s == null || t == null) return false;
			// flag visited node, avoid cylic
			visited.add(s);
			// compare unvisited neighbor nodes recursively
			if (s.neighbors.size() > 0) {
				for (DirectedGraphNode node : s.neighbors) {
					if (visited.contains(node)) continue;
					if (dfs(graph, node, t, visited)) return true;
				}
			}
		}
		
		return false;
	}

	//BFS SOLUTION
		
	public boolean hasRouteBFS(ArrayList<DirectedGraphNode> graph,
            DirectedGraphNode s, DirectedGraphNode t) {
		if(graph == null || s == null || t== null) return false;
		
		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		
		q.offer(s);
		while(!q.isEmpty()) {
			int qLen = q.size();
			for(int i = 0; i < qLen; i++) {
				DirectedGraphNode node = q.poll();
				visited.add(node);
				if (node == t) return true;
				
				//push neighbors into the queue
				if(node.neighbors.size() > 0) {
					for(DirectedGraphNode n : node.neighbors) {
						if (visited.contains(n)) continue;
						q.offer(n);
					}
				}
			}
		}
		return false;
	}
	
}
