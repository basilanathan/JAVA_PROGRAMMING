package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Question: Given a sequence of positive integers A and an integer T, return whether there is a continuous sequence of A that sums up to exactly T
	Example
	[23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20
	[1, 3, 5, 23, 2], 8. Return True because 3 + 5 = 8
	[1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7
 *
 *	Time: O(N)
 *	Space: O(1)
 *
 *	https://discuss.leetcode.com/topic/153/continuous-sequence-against-target-number/20?page=1
 */

public class ContinuousSequenceAddToTarget {
	
	/*
	 * My solution used sliding window. The window expands to the right when current sum is 
	 * less than K, it shrinks from left when sum is greater than K and algorithm return true 
	 * in case current sum is K.
	 * */
	
	public boolean hasSequence(int[] nums, int K) {
		if(K <= 0) return false;
		if(nums.length == 0 || nums == null) return false;
		
		int i = 0;
		int start = 0;
		int sum = 0;
		
		while(i < nums.length) {
			if(sum + nums[i] < K)
				sum += nums[i];
			else if(sum + nums[i] == K)
				return true;
			else {
				sum += nums[i];
				while(sum > K) {
					sum -= nums[start];
					start++;
				}
				if(sum == K)
					return true;
			}
			i++;
		}
		return false;
	}
	
	//Java solution using prefix sum to finish it with O(n) time complexity
	
	  public boolean hasSequence2(int[] nums, int target){
		    if(nums == null || nums.length == 0){
		      return false;
		    }
		    int n = nums.length;
		    int[] sums = new int[n + 1];
		    
		    for(int i = 1; i <= n; i++){
		      sums[i] = sums[i - 1] + nums[i - 1]; 
		    }
		    /*{1, 3, 5, 23, 2}
		     * 0 1 2 3 4 5 arr index
		     *   1 4 9 32 34
		     * */
		    int i = 0, j = 1;
		    while(j <= n){
		      if((sums[j] - sums[i]) < target){
		        j++;
		      } else if ((sums[j] - sums[i]) > target){
		        i++;
		      } else {
		        return true;
		      }
		    }
		    return false;
		  }
	
	public static void main(String[] args) {
		ContinuousSequenceAddToTarget test = new ContinuousSequenceAddToTarget();
		int[] nums = {6,1,2,3,3,7};
		int[] nums2 = {1, 3, 5, 23, 2};
		System.out.println(test.hasSequence(nums, 12));
		System.out.println(test.hasSequence(nums2, 7));
	}

}
