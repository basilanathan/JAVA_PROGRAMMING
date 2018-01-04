package fb.leetcode;

import java.util.HashMap;

/**
 * 
 * @author basila
 * 
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

	Example 1:
	Input:nums = [1,1,1], k = 2
	Output: 2
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 */

public class SubarraySumEqualsK {
	//Time O(N^2)
	public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            if(sum==k){
                count++;
            }
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
	
	/*sum is the presum for first i+1 numbers in the array, for example, sum of first 1 number is nums[0].
	 * preSum.put(0,1); because the sum of first 0 number is 0 and this is an empty array[], which is also 
	 * a subarray for nums. In other words, the number of time sum = 0 exists is 1.
	 * then we loop through the array, calculate the presum for first i+1 number and check if the map 
	 * contains key (sum - k) , if it is, we increase the result by the number of (sum - k) we get from hash map.
	 * We also need to put all sum in the map, that’s what this line of code does: 
	 * preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
	 * 
	 * */
	// we just need to go through the array, calculate the current sum and save number of 
	//all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).
	
	//Time complexity : O(n). The entire nums array is traversed only once.
	//Space complexity : O(n). Hashmap map can contain upto nn distinct entries in the worst case.
    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    
    public static void main(String[] args) {
		SubarraySumEqualsK test = new SubarraySumEqualsK();
		int[] array = {6, 5, 3, 2, 1, 7};
		System.out.println(test.subarraySum2(array, 10));
	}

}
