package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 */


//O(n) time, O(1) space
/*
Basically this solution runs two pointers from two sides to the middle, and the maxLeft and 
maxRight is used to record the height of the elevation within a certain range, max height can 
only increase (or remain the same) from two sides to the middle. If the current pointer is 
pointing at a number that is less than the current max height, the difference between max height and 
the number would be the amount of water trapped. Otherwise, no water is trapped.
*/

public class TrappingRainWater {
	
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0, maxleft = 0, maxright = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft) {
                    maxleft = height[left];
                } else {
                    res += maxleft - height[left];
                }
                left++;
            }
            else {
               if (height[right] >= maxright) {
                   maxright = height[right];
               } else {
                   res += maxright - height[right];
               }
                right--;
            }
        }
        return res;
    }

}
