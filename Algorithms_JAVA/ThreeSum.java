package fb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
	
	/*
	 * The idea is to sort an input array and then run through all indices of a possible 
	 * first element of a triplet. For each possible first element we make a standard bi-directional 
	 * 2Sum sweep of the remaining part of the array. Also we want to skip equal elements to avoid 
	 * duplicates in the answer without making a set or smth like that.
	 * 
	 *  Time: O(N^2)
	 *  Space: O(1)
	 * 
	 * */
	
	public List<List<Integer>> threeSum2(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++; //skip duplicates on the left
	                    while (lo < hi && num[hi] == num[hi-1]) hi--; //skip duplicates on the right
	                    lo++; 
	                    hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
	
	public static List<List<Integer>> threeSumOptimized2(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
        	
            if(i > 0 && nums[i] == nums[i - 1]) { //avoid duplicates
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                	
                		result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    ArrayList<Integer> temp = new ArrayList<Integer>();
//                    
//                    temp.add(nums[i]);
//                    temp.add(nums[j]);
//                    temp.add(nums[k]);
//                    
//                    result.add(temp);
                    
                    j++;
                    k--;
                    
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
        
                }
                else if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return result;
	}
	
	public static List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 8) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 8) while(nums[j] == nums[++j] && j < k); //"Avoided duplicate; j now at " + (j+1)
                if(sum >= 8) while(nums[k--] == nums[k] && j < k); //"Avoided duplicate; k now at " + (k-1)
            }
            while(nums[i] == nums[++i] && i < nums.length - 2); //Avoided duplicate; i now at " + (i+1)
        }
        return result;
	}
	
//	public static List<List<Integer>> threeSumOptimized(int[] nums) {
//		List<List<Integer>> result = new ArrayList<>();
//		
//		if(nums.length < 3) return result;
//		
//		Arrays.sort(nums);
//		
//		for(int i = 0; i < nums.length - 2; i++) {
//			int l = i + 1;
//			int r = nums.length - 1;
//			
//			while(l < r) {
//				if(nums[i] + nums[l] + nums[r] == 0) {
//					result.add(Arrays.asList(nums[i], nums[l], nums[r]));
//					l++;
//					r--;
//				}
//				else if(nums[i] + nums[l] + nums[r] < 0) {
//					l++;
//				} else {
//					r--;
//				}
//			}
//			while(nums[i] == nums[++i] && i < nums.length - 2); //to avoid duplicates
//		}
//
//		return result;
//	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1,-1,0,1,2};
		//int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, -2, -8, -5, -9, -4, -1};

		
		System.out.println("Brute Force numbers add up to 0 " +threeSum(nums));
		//System.out.println("Optimized numbers add up to 8 " + threeSumOptimized(nums));
		System.out.println("Optimized numbers add up to 0 " + threeSumOptimized2(nums));
	}
}
