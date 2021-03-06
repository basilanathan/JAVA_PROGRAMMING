package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 *
 */
public class MaximumAverageSubarrayI {
	
	public int findMaxAverage(int[] nums, int k) {
		if(nums == null || nums.length == 0) return 0;
		
		int sum = 0;
		for(int i = 0; i < k; i++) {
			sum += nums[i];
		}
		
		int max = sum;
		
		for(int i = k; i < nums.length; i++) {
			sum = sum - nums[i - k] + nums[i];
			max = Math.max(max, sum);
		}
		
		//Math.max(max, sum);
		return max / k;
	}

}
