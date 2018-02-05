package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 *
 */

/*
Just 1 binary search: this is the better solution
//Observation: 
//1. There is only one break point
//2. There has to be a side that's continous, either first section or second section.
//3. Need to locate that continous section, then check if target is part of the continous section
*/

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/

//Time: O(long N)
//Space: O(1)
public class SearchRotatedSortedArray {
	
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		int start = 0, end = nums.length - 1;
		
		while(start < end) {
			int mid = start + (end - start) / 2;
			//1 2 3 4 5 6
			//3 4 5 6 1 2
			if(nums[mid] > nums[end]) {
				if(target > nums[mid] || target < nums[end]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			} else {
				//5 6 1 2 3 4
				if(target < nums[mid] || target < nums[end]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
		}
		if(start == end && target != nums[start]) return -1;
		return start;
	}

}
