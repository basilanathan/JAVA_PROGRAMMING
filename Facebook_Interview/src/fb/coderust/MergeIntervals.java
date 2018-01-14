package fb.coderust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * Time complexity : O(nlgn)
 * Other than the sort invocation, we do a simple linear scan of the list, so the runtime 
 * is dominated by the O(nlgn) complexity of sorting.
 * Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
 * 
 * Space complexity : O(1)(or O(n))
 * we can sort intervals in place, we do not need more than constant additional space. 
 * Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 *
 */

class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {
	
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) {
            
            return intervals;
            
        }
        
         // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for(Interval interval : intervals) {
        	
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        	
        }
        return merged;
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		
		MergeIntervals test = new MergeIntervals();
		List<Interval> testList = new ArrayList<>();
		testList.add(i1);
		testList.add(i2);
		testList.add(i3);
		testList.add(i4);
		
		List<Interval> mergedInterval = test.merge(testList);
		for(Interval interval : mergedInterval) {
			System.out.println(interval.start + " , " + interval.end);
		}
	}

}
