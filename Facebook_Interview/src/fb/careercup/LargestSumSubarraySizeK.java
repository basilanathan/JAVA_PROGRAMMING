package fb.careercup;

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
	
	public static void main(String[] args) {
		LargestSumSubarraySizeK test = new LargestSumSubarraySizeK();
		
		int arr[] = {100, 200, 300, 400};
		
		System.out.println(test.largestSum(arr, 2));
		System.out.println(test.largestSum2(arr, 2));
		
	}

}
