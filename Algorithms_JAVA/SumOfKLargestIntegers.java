package algosJava;

import java.util.PriorityQueue;

/**
 * 
 * @author basila
 * 
 * - Given an array of integers find the sum of k largest integers in that array.
 * look at KthLargestElementInAnArray problem
 *
 */

public class SumOfKLargestIntegers {
	
	/*
	 * O(N lg K) running time + O(K) memory
	 * use a min oriented priority queue that will store the K-th largest values. The algorithm iterates over the 
	 * whole input and maintains the size of priority queue.
	 * 
	 * */
	
	public int findSum(int[] nums, int k) {
		int sum = 0;
		final PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int val : nums) {
			pq.offer(val);
			
			if(pq.size() > k) {
				pq.poll();
			}
		}
		while(!pq.isEmpty()) {
			int temp = pq.poll();
			sum += temp;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		SumOfKLargestIntegers test = new SumOfKLargestIntegers();
		
		int[] nums = {4, 7, 7, 7, 2, 3, 0, 1};
		System.out.println(test.findSum(nums, 4));
	}

}
