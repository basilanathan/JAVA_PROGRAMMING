package fb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 *       1. visit all start points and all end points in order;
    2. when visiting a point, we need to know whether it is a start point or a
      end point, based on which we can add a height or delete a height from
      our data structure;
To achieve this, his implementation:

  1. use a int[][] to collect all [start point, - height] and [end point, height]
      for every building;
  2. sort it, firstly based on the first value, then use the second to break
      ties;
Thus,

  1. we can visit all points in order;
  2. when points have the same value, higher height will shadow the lower one;
  3. we know whether current point is a start point or a end point based on the
      sign of its height;
 * 
 * */

/*
 * Buildings
 * b[0] -> left, b[1] -> right, b[2] -> height
 * 
 * 1, 3, s -
 * 2, 4, s -
 * 3, 3, e +
 * 4, 4, e +
 * 5, 2, s -
 * 6, 4, s -
 * 7, 4, e +
 * 8, 4, s -
 * 8, 2, e +
 * 9, 4, e +
 * 
 * ouput:
 * 
 * 1, 3
 * 2, 4
 * 4, 0
 * 5, 2
 * 6, 4
 * 7, 2
 * 8, 4
 * 9, 0
 * 
 * */

public class TheSkylineProblem {
	
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]}); 
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // visit all points in order
        for(int[] h:height) {
            if(h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // current max height;

            // compare current max height with previous max height, update result and 
            // previous max height if necessary
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

}
