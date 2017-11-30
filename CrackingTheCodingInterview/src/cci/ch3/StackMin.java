package cci.ch3;

import java.util.Stack;

//Issue: if there is a large stack, we waste a lot of space by keeping track of the min
//for every single element.

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

//using an additional stack which keeps track of the mins
public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int value) {
		if(value <= min) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if(value == min) {
			s2.pop();
		}
		return value;
	}
	
	public int min() {
		if(s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}

