package fb.glassdoor;

import java.util.Arrays;

/*
 * Thoughts
 * 
 * Given a set of intervals, how do we find the maximum number of intervals overlapping at any point of time.

For example – { (0,2), (3, 7), (4,6), (7,8), (1,5) }. The maximum number of intervals overlapped is 3 during (4,5).

A very simple solution would be check the ranges pairwise. This is certainly very inefficient. Can we do better? We can try sort! Notice that if there is no overlap then we will always see difference in number of start and number of end is equal to zero. So, if an interval starts and if we increment a counter during a start and decrement the counter during an end then if there is no interval overlapped to this count is always zero. This signals us a way to solve this problem i.e. sort the start and end points as separate arrays and count the overlaps by doing a merge operation on the two sorted arrays.

let’s consider all the start and end point as separate arrays.

Sort starting points and ending points in ascending order separately. For example, s=[0, 1, 3, 4, 7] and end=[2, 5, 6, 7, 8].
Do merge of start and end by maintaining two pointers i and j respectively in the two arrays.
Keep track of the current overlap and maximum overlap we have seen so far during merge.
Two cases
If start[i] < end[i] : we know that a new range begins. So increment the current counter and update value of max counter. For example, we take first 2 starts , s=0,1 until we see an end, e = 2. so count=2.
Otherwise : It’s an end point of a range so we decrement the counter. For example, when we see end point, e= 2 we update count = 2-1 = 1. And so on.
At the end of this process, we have the answer in max counter.
Here is a simple implementation of this approach in O(nlgn) time.
 * 
 * */

public class MaximumOverlappingIntervals {
	
	public static int maxOverlapIntervalCount(int[] start, int[] end){
		int maxOverlap = 0;
		int currentOverlap = 0;
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		int i = 0;
		int j = 0;
		int m=start.length,n=end.length;
		while(i< m && j < n){
			if(start[i] < end[j]){
				currentOverlap++;
				maxOverlap = Math.max(maxOverlap, currentOverlap);
				i++;
			}
			else{
				currentOverlap--;
				j++;
			}
		}
		
		return maxOverlap;
	}

}
