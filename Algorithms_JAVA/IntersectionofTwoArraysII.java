package fb.glassdoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 * 
	 Example:
	 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	 
 * @param nums1
 * @param nums2
 * @return
 */

public class IntersectionofTwoArraysII {
	
    // HashMap, time : O(n), space : O(n);
	public static int[] intersection1(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> tempResult = new ArrayList<>();
		for(int i = 0; i < nums1.length; i++) {
			if(map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		
		for(int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i])) {
				if(map.get(nums2[i]) > 0) {
					tempResult.add(nums2[i]);
					map.put(nums2[i], map.get(nums2[i]) - 1);
				}
			}
		}
		
		int[] result = new int[tempResult.size()];
		int k = 0;
		for(Integer num : tempResult) {
			result[k++] = num;
		}
		return result;
	}
	
	
	
    // Arrays.sort time : O(nlogn) space : O(n);
	public static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> tempResult = new ArrayList<>();
		int i = 0;
		int j = 0;
		
		while(i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if(nums1[i] > nums2[j]) {
				j++;
			} else {
				tempResult.add(nums1[i]);
				i++;
				j++;
			}
		}
		
		int[] result = new int[tempResult.size()];
		int k = 0;
		for(Integer num : result) {
			result[k++] = num;
		}
		return result;
	}

}
