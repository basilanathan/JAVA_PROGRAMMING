package fb.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author basila
 * 
 * /*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.
For example
Given [[0, 30],[5, 10],[15, 20]],
return 2.
Tags: Heap Greedy Sort
Similar Problems: (H) Merge Intervals, (E) Meeting Rooms
*/


/*
 * We use the greedy method, starting from the first time period, selecting the 
 * next time period that is not conflicting. Then if there is time remaining, 
 * start with the second room schedule, select the earliest time period, 
 * then select the next most recent non-conflicting time period until there is no more, 
 * open up the third room if there are remaining periods , And so on. 
 * 
 * The trick here is 
 * that we do not have to iterate through so many times that we can actually record 
 * once we have traversed, such as the first time we put into room 1 and then the second 
 * time, if we end up with room 1 Time does not conflict, put into the room 1, or open 
 * up a room 2. Then for the third time period, if it does not conflict with the end time 
 * of room 1 or room 2, it will be put into room 1 or 2, otherwise open up a room 3, and so on, 
 * finally how many rooms have been opened up. For each room, we just record the end of the time on 
 * the line, where we find the room does not conflict, just find the end of the earliest room.
 * 
 * There's a trick here too. If we manage these rooms as List, each query takes O (N) time, 
 * and if we manage it with a heap, we can use logN time to find the earliest end of the room.
 * 
 * 
 * https://segmentfault.com/a/1190000003894670
 * */

public class MeetingRoomsII {
	
	//Time: O(N Log N)
	//Space: O(1)
	
	public int minMeetingRoome(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
		
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        //Heap to manage the endTimes of the room
        PriorityQueue<Integer> endTimes = new PriorityQueue<Integer>();
        
        endTimes.offer(intervals[0].end);
        for(int i = 1; i < intervals.length; i++) {

        	// If the start time of the current time period is greater than the earliest end time, the earliest end time can be updated as the end time of the current time period, and if it is less than, a new end time is added to indicate the new room
        		if(intervals[i].start >= endTimes.peek()) {
        			endTimes.poll(); //earliest end time being updated
        		}
        		endTimes.offer(intervals[i].end); //adding the new room
        }
        return endTimes.size();
	}

}
