package fb.careercup;

/**
 * 
 * @author basila
 * 
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 */

//Time: O(N)
public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
			int max = Integer.MIN_VALUE, sum = 0;
			
			for(int i = 0; i < nums.length; i++) {
				//takes care of the negative numbers
				if (sum < 0) {
					sum = nums[i];
				} else {
					sum += nums[i];
				}
				if(sum > max) {
					max = sum;
				}
			}
			return max;
		}
	
	public int maxSubArray2(int[] nums) {
	    int currMax=nums[0],max=nums[0];
	    for(int i=1;i<nums.length;i++){
	        currMax=Math.max(currMax+nums[i],nums[i]);
	        max=Math.max(max,currMax);
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		MaximumSubarray test = new MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(test.maxSubArray(nums));
		System.out.println(test.maxSubArray2(nums));
	}
}
