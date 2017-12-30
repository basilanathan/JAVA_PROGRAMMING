package fb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * Find the number connected component in the undirected graph. Each node in thegraph contains a label and a list of its neighbors. (a connected component (orjust component) of an undirected graph is a subgraph in which any two verticesare connected to each other by paths, and which is connected to no additionalvertices in the supergraph.)

	Example
	Given graph:
	
	A------B  C
	 \     |  |
	  \    |  |
	   \   |  |
	    \  |  |
	      D   E
	Return {A,B,D}, {C,E}. Since there are two connected component which is{A,B,D}, {C,E}
 *
 */

class UnidirectedGraphNode {
	int label;
	ArrayList<UnidirectedGraphNode> neighbors;
	
	public UnidirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UnidirectedGraphNode>();
	}
	
}

public class ConnectedComponentUndirectedGraph {
	
	//DFS SOLUTION
	
	public List<List<Integer>> connectedSetDFS(ArrayList<UnidirectedGraphNode> nodes) {
		if(nodes == null || nodes.size() < 0) return null;
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<UnidirectedGraphNode> visited = new HashSet<UnidirectedGraphNode>();
		
		for(UnidirectedGraphNode node : nodes) {
			if (visited.contains(node)) continue;
			List<Integer> temp = new ArrayList<Integer>();
			dfs(node, visited, temp);
			Collections.sort(temp);
			result.add(temp);
		}
		return result;
	}

	private void dfs(UnidirectedGraphNode node, Set<UnidirectedGraphNode> visited, List<Integer> result) {
		
		//add node into result
		result.add(node.label);
		visited.add(node);
		
		//node is not connected, exclude by for iteration
		if (node.neighbors.size() == 0) return;
		
		for(UnidirectedGraphNode neighbor : node.neighbors) {
			if(visited.contains(neighbor)) continue;
			dfs(neighbor, visited, result);
		}
		
	}
	
	//BFS SOLUTION
	
	public List<List<Integer>> connectedSetBFS(ArrayList<UnidirectedGraphNode> nodes) {
		if(nodes == null || nodes.size() < 0) return null;
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		//Log visited node before push into queue
		Set<UnidirectedGraphNode> visited = new HashSet<UnidirectedGraphNode>();
		for(UnidirectedGraphNode node : nodes) {
			if(visited.contains(node)) continue;
			List<Integer> temp = bfs(node, visited);
			result.add(temp);
		}
		return result;
	}

	private List<Integer> bfs(UnidirectedGraphNode node, Set<UnidirectedGraphNode> visited) {
		
		List<Integer> temp = new ArrayList<Integer>();
		Queue<UnidirectedGraphNode> queue = new LinkedList<UnidirectedGraphNode>();
		queue.offer(node);
		visited.add(node);
		
		while(!queue.isEmpty()) {
			UnidirectedGraphNode qNode = queue.poll();
			temp.add(qNode.label);
			
			for(UnidirectedGraphNode neighbor : qNode.neighbors) {
				if(visited.contains(neighbor)) continue;
				queue.offer(neighbor);
				visited.add(neighbor);
			}
		}
		Collections.sort(temp);
		return temp;
	}

}
