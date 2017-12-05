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
		LinkedList<Node> q = new LinkedList<Node>(); //create queue of nodes
		
		for(Node u : g.getNodes()) {
			u.state = State.Unvisited; //set all the nodes to unvisited
		}
		start.state = State.Visiting; //set start node to visiting
		q.add(start); //add start node to queue
		Node u;
		while(!q.isEmpty()) { 
			u = q.removeFirst(); //remove start node from the queue
			if(u != null) {
				for (Node v : u.getAdjacent()) { //get adjacent nodes
					if(v.state = State.Unvisited) {
						if(v == end) { //if one of them is the end return true
							return true;
						} else {
							v.state = State.Visiting; 
							q.add(v); //else add adjacent node to queue
						}
					}
				}
				u.state = State.Visited; //update start node to visited
			}
		}
		return false;
	}


}
