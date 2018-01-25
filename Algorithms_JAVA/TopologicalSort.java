package fb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * Given an directed graph, a topological order of the graph nodes is defined as follow:

	For each directed edge A -> B in graph, A must before B in the order list.
	The first node in the order can be any node in the graph with no nodes direct to it.
	Find any topological order for the given graph.
 *
 * http://www.lintcode.com/en/problem/topological-sorting/
 */

public class TopologicalSort {
	//BFS
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        //for every neighbor, add neighbor and 1 to the map becasue it has
		//one indegree connection
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) { //doesn't have a indegree or incoming edges
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) { //when it reaches 0 doesn't have any other edges coming toward
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
	
	//DFS
	
    public ArrayList<DirectedGraphNode> topSortDFS(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        DirectedGraphNode root = null;
        while ((root = get0IndegreeNode(indegree)) != null) {
            result.add(root);
            dfs(result, indegree, root);
        }
        return result;
    }
    
    DirectedGraphNode get0IndegreeNode(Map<DirectedGraphNode, Integer> indegree) {
        for (Map.Entry<DirectedGraphNode, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    void dfs(List<DirectedGraphNode> result, Map<DirectedGraphNode, Integer> indegree, DirectedGraphNode root) {
        indegree.put(root, -1);
        for (DirectedGraphNode neighbor : root.neighbors) {
            indegree.put(neighbor, indegree.get(neighbor) - 1);
            if (indegree.get(neighbor) == 0) {
                result.add(neighbor);
                dfs(result, indegree, neighbor);
            }
        }
    }
	

}
