package fb.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerNumbers {
	
	public static List<Integer> prevSmallerNumber(int[] a) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < a.length; i++) {
			while(!stack.isEmpty() && stack.peek() >= a[i]) stack.pop();
			if (stack.isEmpty()) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			stack.push(a[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 6, 4, 10, 2, 5};
		System.out.println(prevSmallerNumber(a));
	}

}
