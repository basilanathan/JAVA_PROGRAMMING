package fb.careercup;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author basila
 * 
 * Given an array of integers and a number k, find maximum sum of a subarray of size k.
 * 
 * Time: O(N)
 * Space: O(1)
 * 
 * http://www.ideserve.co.in/learn/maximum-average-subarray
 *
 */

public class MaxSumSubsetSikzeK {
	
	// Time: O(N Log N)
	//Space: O(k)
	
	public int kLargest(int[] array, int k) {
		Arrays.sort(array);
		
		int sum = 0;
		for(int i = array.length - 1; i > k; i--) {
			sum += array[i];
		}
		return sum;
	}
	
	/*
	 * 1) Build a Max Heap tree in O(n)
	 * 2) Use Extract Max k times to get k maximum elements from the Max Heap O(klogn)
	 * Time complexity: O(n + klogn)
	 * */
	//Find K largest elements using a max heap. and extract max k times
	//Time : O(N log K)
	//Space: O(K)

	public int maxHeapSubset(int[] array, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer a, Integer b) {
		        return b - a; 
		    }
		});
		
		for(int val : array) {
			maxHeap.offer(val);
		}
		int sum = 0;
		while (maxHeap.size() > k + 1) {
			sum += maxHeap.poll();
		}
		
		return sum;
		
		
	}
	
	//SUBSET using max heap
//	public int maxSumSubsetSizeK(int[] array, int k) {
//	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
//	    int sum = 0;
//	    for(int val : array) {
//	        pq.offer(val);
//
//	        if(pq.size() > k) {
//	            pq.poll();
//	        }
//	        //int sum = 0;
//	        while(pq.size() > 0) {
//	        		sum += pq.poll();
//	        }
//	    }
//		return sum;
//	}
	
	//SUBARRAY
	public int maxSumSubArray(int[] input, int k) {
		int n = input.length;
		if(k > n || k == n) return 0;
		
		int sum = input[0];
		for(int i = 1; i < k; i++) {
			sum += input[i];
		}
		
		int maxSum = sum;
		//int maxSumIndex = 0;
		
		for(int i = k; i < n; i++) {
			sum = sum - input[i - k] + input[i];
			if(sum > maxSum) {
				maxSum = sum;
				//maxSumIndex = i - k;
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		MaxSumSubsetSikzeK test = new MaxSumSubsetSikzeK();
		
		int[] input = {11, -8, 16, -7, 24, -2, 3};
		int[] array = {-2, 2, 3, -4, 6, 4, 5};
		int[] array1 = {1, 23, 12, 9, 30, 2, 50};
		
		System.out.println(test.kLargest(array1, 3)); //good
		System.out.println(test.maxHeapSubset(array1, 3)); //good
		
		System.out.println(test.maxSumSubArray(input, 3)); //good
		
		//System.out.println(test.maxSumSubsetSizeK(array1, 3));
	}

}
