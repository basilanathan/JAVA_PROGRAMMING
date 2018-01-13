package fb.glassdoor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
	 Example:
	 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 
	 Note:
	 Each element in the result must be unique.
	 The result can be in any order.
	 
	 time : O(n);
	 space : O(n);
	 
	 https://leetcode.com/problems/intersection-of-two-arrays/description/
 */

public class IntersectionofTwoArrays {
	
	/*
	 * Thoughts:
	 * Sol1: Use hashSet and add common item to result.
	 * 
	 * time : O(n) space : O(n);
	 * 
	 * */

    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ret = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }
        for (Integer num : nums2) {
            if (set.contains(num)) {
                ret.add(num);
            }
        }
        int k = 0;
        int[] res = new int[ret.size()];
        for (Integer num : ret) {
            res[k++] = num;
        }
        return res;
    }
    
    // Arrays.sort time : O(nlogn) space : O(n);
    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int k = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[k++] = num;
        }
        return res;
    }
    
    /*
    Sol2: Binary search each item of nums1 from nums2. The runtime will be nlog(n)
    binary search time : O(nlogn) space : O(n)
    */
    
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Arrays.sort(nums1);// nLog(n)
        final Set<Integer> resultSet = new HashSet<>();
        for (final int num: nums2) { // nLog(m)
            if(binarySearch(nums1, num)) {
                resultSet.add(num);
            }
        }
        int i = 0;
        final int[] result = new int[resultSet.size()];
        for (final int num: resultSet) {
            result[i++] = num;
        }
        return result;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		IntersectionofTwoArrays test = new IntersectionofTwoArrays();
		
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		
		int[] array = test.intersection1(nums1, nums2);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
