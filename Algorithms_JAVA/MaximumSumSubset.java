package algosJava;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author basila
 * 
 * Maximum sum subset using max heap.
 * 
 * Time: O(N log N)
 * Space: O(1)
 *
 */

public class MaximumSumSubset {
	
	public int maximumSumsubset(int[] array) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer a, Integer b) {
		        return b - a; 
		    }
		});
		
		for (int item : array) {
		    maxHeap.add(item);
		}
		
		int sum = 0;
		int size = maxHeap.size();
		while(size > 0) {
			int index = maxHeap.peek();
			if(index > 0) {
				int num = maxHeap.poll();
				sum += num;
			} else {
				break;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		MaximumSumSubset test = new MaximumSumSubset();
		
		int[] array = {5, 5, -2, -6, 4, -8, 16};
		
		System.out.println(test.maximumSumsubset(array));
	}
	

}
