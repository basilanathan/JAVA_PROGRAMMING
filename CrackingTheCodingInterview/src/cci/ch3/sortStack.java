package cci.ch3;

import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Description:write a program to sort a stack such that the smallest items are on the top
 * 
 * Time O(N^2)
 * Space O(N)
 *
 */

public class sortStack {
	
	public static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s1.isEmpty()) {
			int temp = s1.pop();
			while(!s2.isEmpty() && s2.peek() > temp) {
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		//copy everything from the buffer stack to the original stack
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 1; i < 10; i++) {
			int r = sortStack.randomIntInRange(0, 1000);
			s.push(r);
		}
		sort(s);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

}
