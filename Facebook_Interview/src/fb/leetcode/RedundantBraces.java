package fb.leetcode;

import java.util.Stack;

public class RedundantBraces {
	
	public int braces(String A) {
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		
		while(index < A.length()) {
			char c = A.charAt(index);
			if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.peek() == '(') {
					return 1;
				} else {
					while(!stack.isEmpty() && stack.peek() != '(') {
						stack.pop();
					}
					stack.pop();
				}
			}
			index++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		RedundantBraces test = new RedundantBraces();
		String teString = "((a + b))";
		System.out.println(test.braces(teString));
	}

}
