package fb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author basila
 * 
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
	
	Note:
	The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
	
	Example 1:
	Given nums = [1, -1, 5, -2, 3], k = 3,
	return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
	
	Example 2:
	Given nums = [-2, -1, 2, 1], k = 1,
	return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
	
	Follow Up:
	Can you do it in O(n) time?
 *
 */

/*
 * On average it's o(1). Please see this: http://stackoverflow.com/questions/8923251/what-is-the-time-complexity-of-hashmap-containskey-in-java
	I think the worst case rarely happens. 
 * 
 * Time : O(N)
 * */

public class MaxSizeSubarraySumEqualsK {
	
	public int maxSubArrayLen(int[] nums, int k) {
	    int sum = 0, max = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //initalize hashmap
	    for (int i = 0; i < nums.length; i++) {
	        sum = sum + nums[i]; //cummulative sum
	        if (sum == k) max = i + 1;
	        else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k)); //get the index to calc window
	        if (!map.containsKey(sum)) map.put(sum, i); //put sum and index
	    }
	    return max;
	}
	
    public int maxSubArrayLen2(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int result = 0, sum = 0;
        hm.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) result = Math.max(i - hm.get(sum - k), result); //calculate max window
            if (!hm.containsKey(sum)) hm.put(sum, i);
        }
        return result;
    }

}
