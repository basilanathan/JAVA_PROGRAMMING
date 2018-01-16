package fb.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
determine if a person could attend all meetings.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
Hide Company Tags Facebook
Hide Tags Sort
Hide Similar Problems (H) Merge Intervals (M) Meeting Rooms II
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
Thoughts:
Cannot have overlap -> sort by the interval.start using priority queue
*/

class Interval {
	int start;
	int end;
	public Interval() {
		start = 0;
		end = 0;
	}
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MeetingRooms {
	//Time: O(N log N)
	//Space: O(1)
	public boolean canAttend(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start; //sort start times in ascending order
            }
        });
        
        int end = intervals[0].end;
        
        for(int i = 1; i < intervals.length; i++) {
        		if(intervals[i].start < end) return false;
        		end = Math.max(end, intervals[i].end);
        }
        return true;
	}

}
