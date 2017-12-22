package fb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * <br>
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 *	[
 *	  [-1, 0, 1],
 *	  [-1, -1, 2]
 *	]
 * 
 * <br>
 * 
 * Time: O(N^2)
 * Space: O(1)
 *
 */

public class ThreeSum {
	//brute force O(N^3)
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultMain = new ArrayList<>();
		for(int i = 0; i < nums.length - 2; i++) {
			for(int j = i + 1; j < nums.length - 1; j++) {
				for(int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> result = new ArrayList<Integer>();
						result.add(nums[i]);
						result.add(nums[j]);
						result.add(nums[k]);
						
						resultMain.add(result);
					}
				}
			}
		}
		return resultMain;
	}
	
	public static List<List<Integer>> threeSumOptimized(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		if(nums.length < 3) return result;
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 2; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			
			while(l < r) {
				if(nums[i] + nums[l] + nums[r] == 8) {
					result.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
					
				}
				else if(nums[i] + nums[l] + nums[r] < 8) {
					l++;
				} else {
					r--;
				}
			}
			while(nums[i] == nums[++i] && i < nums.length - 2); //to avoid duplicates
		}

		return result;
	}
	
	public static void main(String[] args) {
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1,-1,0,1,2};
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, -2, -8, -5, -9, -4, -1};

		
		System.out.println("Brute Force numbers add up to 0 " +threeSum(nums));
		System.out.println("Optimized numbers add up to 8 " + threeSumOptimized(nums));
	}
}
