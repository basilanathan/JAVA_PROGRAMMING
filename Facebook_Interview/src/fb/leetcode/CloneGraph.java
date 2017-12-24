package fb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
	
	
	OJ's undirected graph serialization:
	Nodes are labeled uniquely.
	
	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	
	The graph has a total of three nodes, and therefore contains three parts as separated by #.
	
	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	Second node is labeled as 1. Connect node 1 to node 2.
	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	Visually, the graph looks like the following:
	
	       1
	      / \
	     /   \
	    0 --- 2
	         / \
	         \_/
 *
 */

class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
public class CloneGraph {
	//SOLUTION 1
	public HashMap<Integer, UndirectedGraphNode> map = new HashMap();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	    if (node == null) return null;
	    if (map.containsKey(node.label)) 
	        return map.get(node.label);
	    UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
	    map.put(cloned.label, cloned);
	    for(UndirectedGraphNode neighbor: node.neighbors){
	        cloned.neighbors.add(cloneGraph(neighbor));
	    }
	    return cloned;
	}
	
	//SOLUTION 2
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
	    HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
	    return dfs(node,map);
	}
	private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> map) {
	    if (node == null) return null;
	    if (map.containsKey(node.label)) {
	        return map.get(node.label);
	    } else {
	        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
	        map.put(node.label,clone);
	        for (int i = 0; i < node.neighbors.size(); i++) {
	            clone.neighbors.add(dfs(node.neighbors.get(i), map));
	        }
	        return clone;
	    }
	}
	

}
