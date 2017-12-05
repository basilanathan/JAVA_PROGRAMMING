package cci.ch4;

import java.util.LinkedList;

/**
 * 
 * @author basila
 * @date 12/4/2017
 * 
 * Description: 
 * Route between two nodes. given a directed graph, design an algorithm to find 
 * out whether there is a route between two nodes.
 * 
 * https://www.youtube.com/watch?v=86g8jAQug04
 *
 */


public class RouteBetweenNodes {
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		
		for(Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()) {
			u = q.removeFirst();
			if(u != null) {
				for (Node v : u.getAdjacent()) {
					if(v.state = State.Unvisited) {
						if(v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}


}
