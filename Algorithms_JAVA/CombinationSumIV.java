package fb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author basila
 * 
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

	Example:
	
	nums = [1, 2, 3]
	target = 4
	
	The possible combination ways are:
	(1, 1, 1, 1)
	(1, 1, 2)
	(1, 2, 1)
	(1, 3)
	(2, 1, 1)
	(2, 2)
	(3, 1)
	
	Note that different sequences are counted as different combinations.
	
	Therefore the output is 7.
	Follow up:
	What if negative numbers are allowed in the given array?
	How does it change the problem?
	What limitation we need to add to the question to allow negative numbers?
 * 
 * 
 * Time: O(nums.length*target)
 * Space: O(N)
 *
 */

//comb[4] = comb[4-1] + comb[4 - 2] + comb[4 - 3] + comb[4-4]
//nums = [1, 2, 3]
public class CombinationSumIV {
	//RECURSIVE SOLUTION
	public int combinationSum4(int[] nums, int target) {
		if(target == 0) return 1;
		
		int result = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(target >= nums[i]) {
				result += combinationSum4(nums, target - nums[i]);
			}
		}
		return result;
		
	}
	
	//RECUSION WITH MEMOIZATION
	
	public static int combinationSum4M(int[] nums, int target) {
		if(nums.length == 0) return 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		return dfs(nums, target, map);
	}

	private static int dfs(int[] nums, int target, Map<Integer, Integer> map) {
		if(target == 0) return 1;
		
		if(target < 0) return 0;
		if (map.containsKey(target)) {
			return map.get(target);
		}
		
		int result = 0;
		
		for(int i = 0; i < nums.length; i++) {
			result += dfs(nums, target - nums[i], map);
		}
		map.put(target, result);
		return result;
	}
	
	//MEMOIZATION SOLUTION 2
    public static int combinationSum4M2(int[] nums, int target) {
    		Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target ==0 ) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num: nums){
            count += combinationSum4M2(nums, target-num);
        }
        map.put(target, count);
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		
		System.out.println(combinationSum4M(nums, 4));
		System.out.println(combinationSum4M2(nums, 4));
	}

}
