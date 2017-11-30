package cci.ch3;

import java.util.Stack;

class NodeWithMin {
	public int value;
	public int min;
	public NodeWithMin(int v, int min) {
		value = v;
		this.min = min;
	}
}

public class StackMin extends Stack<NodeWithMin> {
	public void push(int value) {
		int NewMin = Math.min(value, min());
		super.push(new NodeWithMin(value, NewMin));
	}
	
	public int min() {
		if(this.isEmpty()) {
			return Integer.MAX_VALUE; //error value
		} else {
			return peek().min;
		}
	}

}

