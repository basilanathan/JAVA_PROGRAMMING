package fb.careercup;

/**
 * 
 * @author basila
 * 
 * Find Largest sum of subarray with size K
 * 
 * http://www.ideserve.co.in/learn/maximum-average-subarray
 *
 */

public class LargestSumSubarraySizeK {
	
	public int largestSum(int[] array, int k) {
		int sum = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < array.length - k; i++) {
			sum = 0;
			for(int j = i; j < i + k; j++) {
				sum += array[j];
			}
			if (sum > max) {
				max = sum;
			}
		}
		
		return max;
	}
	
	/*
	 * An Efficient Solution is based on the fact that sum of a subarray (or window) of size k can 
	 * be obtained in O(1) time using sum of previous subarray (or window) of size k. Except first 
	 * subarray of size k, for other subarrays, we compute sum by removing first element of last 
	 * window and adding last element of current window.
	 * 
	 * */
	//Time: O(N)
	//Space: O(1)
	public int largestSum2(int[] array, int k) {
		if(k > array.length) return -1;
		
		int result = 0;
		for(int i = 0; i < k; i++) {
			result += array[i];
		}
		
		int currentSum = result;
		for(int i = k; i < array.length; i++) {
			currentSum += array[i] - array[i - k];
			result = Math.max(result, currentSum);
		}
		return result;
	}
	
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
		LargestSumSubarraySizeK test = new LargestSumSubarraySizeK();
		
		int arr[] = {11, -8, 16, -7, 24, -2, 3};
		
		System.out.println(test.largestSum(arr, 3));
		System.out.println(test.largestSum2(arr, 3));
		System.out.println(test.maxSumSubArray(arr, 3));
		
	}

}
