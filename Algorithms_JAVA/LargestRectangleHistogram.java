package fb.leetcode;

import java.util.Stack;

/**
 * 
 * Video link https://youtu.be/ZmnqCZp9bBs
 * 
 * Given an array representing height of bar in bar graph, find max histogram
 * area in the bar graph. Max histogram will be max rectangular area in the
 * graph.
 * 
 * Maintain a stack
 * 
 * If stack is empty or value at index of stack is less than or equal to value at current 
 * index, push this into stack.
 * Otherwise keep removing values from stack till value at index at top of stack is 
 * less than value at current index.
 * While removing value from stack calculate area
 * if stack is empty 
 * it means that till this point value just removed has to be smallest element
 * so area = input[top] * i
 * if stack is not empty then this value at index top is less than or equal to 
 * everything from stack top + 1 till i. So area will
 * area = input[top] * (i - stack.peek() - 1);
 * Finally maxArea is area if area is greater than maxArea.
 * 
 * 
 * Time complexity is O(n)
 * Space complexity is O(n)
 * 
 * References:
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */

/*
 * n the stack, we store height index which heights are ascending order.
 * For example, When we proceed to the index with height 2, the stack stores 1, 5, 6, 
 * then we pop the elements one by one.
 * After we pop the element out, we compute the area which height is this pop height.
 * For height with 6, the area is (i - stack.peek() - 1) * 6(i is current index, index of height 2; 
 * stack.peek() is index of height 5)
 * */

//https://leetcode.com/problems/largest-rectangle-in-histogram/description/

public class LargestRectangleHistogram {
	
	public int largestRectangle(int[] heights) {
		int len = heights.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		
		for(int i = 0; i < len; i++) {
			int h = (i == len ? 0 : heights[i]); //last height as size 0 to collect all other bars
			while(!stack.isEmpty() && h < heights[stack.peek()]) {
				int currentHeight = heights[stack.pop()];
				//maxArea = Math.max(maxArea, currentHeight * (stack.isEmpty() ? i : i - 1 - stack.peek()));
				int area = currentHeight * (stack.isEmpty() ? i : i - 1 - stack.peek());
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		return maxArea;
	}

}
