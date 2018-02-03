package fb.leetcode;

import java.util.Stack;


/*
 * We can apply the maximum in histogram in each row of the 2D matrix. What we need is to maintain an int array for each row, which represent for the height of the histogram.

	Please refer to https://leetcode.com/problems/largest-rectangle-in-histogram/ first.
	
	Suppose there is a 2D matrix like
	
	1 1 0 1 0 1
	
	0 1 0 0 1 1
	
	1 1 1 1 0 1
	
	1 1 1 1 0 1
	
	First initiate the height array as 1 1 0 1 0 1, which is just a copy of the first row. Then we can easily calculate the max area is 2.
	
	Then update the array. We scan the second row, when the matrix[1][i] is 0, set the height[i] to 0; else height[i] += 1, which means the height has increased by 1. So the height array again becomes 0 2 0 0 1 2. The max area now is also 2.
	
	Apply the same method until we scan the whole matrix. the last height arrays is 2 4 2 2 0 4, so the max area has been found as 2 * 4 = 8.
	
	Then reason we scan the whole matrix is that the maximum value may appear in any row of the height.
 * 
 * */

/*
 *  * Maintain a stack
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
 * */

//LOOK AT LARGEST RECTANGE FOR REFERENCE

//* Time complexity - O(rows*cols)
//* Space complexity - O(cols) - if number of cols is way higher than rows
//* then do this process for rows and not columns.


/**
 * 
 * Video link - https://youtu.be/2xvJ41-hsoE
 * 
 * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
 * in this matrix.
 * 
 * Maintain a temp array of same size as number of columns. 
 * Copy first row to this temp array and find largest rectangular area
 * for histogram. Then keep adding elements of next row to this temp
 * array if they are not zero. If they are zero then put zero there.
 * Every time calculate max area in histogram.
 * 
 * Time complexity - O(rows*cols)
 * Space complexity - O(cols) - if number of cols is way higher than rows
 * then do this process for rows and not columns.
 * 
 * References:
 * http://www.careercup.com/question?id=6299074475065344
 */

//https://leetcode.com/problems/maximal-rectangle/description/

public class MaximalRectangle {
	
	
	/* testing row -> 1 3 1 1 0 3
	 * i = 2
	 * h[] = 1 3 1
	 * stack ->  0 1
	 * 
	 * top = 
	 * area = 
	 * max = 
	 * */
	
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return -1;
        
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        
        // height array 
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;
        
        for (int row = 0; row < rLen; row++) {
            Stack<Integer> s = new Stack<Integer>();  //maintain a stack
            for (int i = 0; i< cLen + 1; i++) {
                if (i < cLen)
                    if(matrix[row][i] == '1')
                        h[i] += 1;
                    else h[i] = 0;
                
                if (s.isEmpty() || h[s.peek()] <= h[i]) //If stack is empty or value at index of stack is less than or equal to value at current 
                											//index, push this into stack
                    s.push(i); 
                else {
                    while(!s.isEmpty() && h[i] < h[s.peek()]){  //* Otherwise keep removing values from stack till value at index at top of stack is 
                    	 //* less than value at current index.
                        int top = s.pop();
                        int area = h[top] * (s.isEmpty() ? i : (i - s.peek() - 1)); // * While removing value from stack calculate area

                        if (area > max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}

