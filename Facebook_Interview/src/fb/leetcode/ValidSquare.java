package fb.leetcode;

import java.util.Arrays;

/**
 * 
 * @author basila
 * 
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.
 *
 */

/*
 * Time complexity : O(1). Sorting 4 points takes constant time.
 * Space complexity : O(1). Constant space is required.
 * */

public class ValidSquare {
	
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		
		int[] arr = {dis(p1, p2), dis(p1, p3), dis(p1, p4), dis(p2, p3), dis(p2, p4), dis(p3, p4)};
		Arrays.sort(arr);
		
		return arr[0] > 0 && arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3] && arr[4] == arr[5];
    }
		//find distance
		int dis(int[] a, int[] b) {
			return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
		}
	}

