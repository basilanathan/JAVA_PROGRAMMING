package fb.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 
 * @author basila
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
	For example,
	Given [3,2,1,5,6,4] and k = 2, return 5.
	
	Note: 
	You may assume k is always valid, 1 ≤ k ≤ array's length.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/
 */

public class KthLargestElementInAnArray {
	
	/*
	 * O(N lg N) running time + O(1) memory
	 * The simplest approach is to sort the entire input array and then 
	 * access the element by it’s index (which is O(1)) operation:
	 * 
	 * */
	
	public int findKthLargestBF(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
	}
	
	/*
	 * O(N lg K) running time + O(K) memory
	 * use a min oriented priority queue that will store the K-th largest values. The algorithm iterates over the 
	 * whole input and maintains the size of priority queue.
	 * 
	 * */
	public int findKthLargestPQ(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
	
	/*
	 * O(N) best case / O(N^2) worst case running time + O(1) memory
	 * use the selection algorithm (based on the partion method - the same one as used in quicksort).
	 * 
	 * */
	public static int findKthLargest(int[] nums, int k) {
		if(nums == null || k > nums.length || k < 1) {
			return -1;
		}
		
		return quickSelect(nums, 0, nums.length - 1, nums.length - k);
	}

	private static int quickSelect(int[] nums, int start, int end, int k) {
		if(start == end) {
			return nums[start];
		}
		
		int p = nums[start + (end - start) / 2];
		int i = start;
		int j = end;
		
		while(i <= j) {
			while(i <= j && nums[i] < p) {
				i++;
			}
			while(i <= j && nums[j] > p) {
				j--;
			}
			if(i <= j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		if (k <= j) {
			return quickSelect(nums, start, j, k);
		} else if (k >= i) {
			return quickSelect(nums, i, end, k);
		}
		return nums[k];
	}
	
	public static void main(String[] args) {
		int[] nums = new int[20];
		Random myRandom = new Random();
		
		System.out.println("Numbers: ");
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = myRandom.nextInt(100);
			System.out.print(nums[i] + ", ");
		}
		
		System.out.println();
		
		System.out.println("10th largest number: " + findKthLargest(nums, 10));
		
		System.out.println("after finding: ");
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
		
	}

}
