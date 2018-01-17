package algosJava;

/**
 * 
 * @author basila
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from nums2. The number of elements initialized in nums1 
 * and nums2 are m and n respectively.
 * 
 * Given enough space in nums1, and given size of the two array, we can start labling the 
 * last element, since it's empty-safe indexes anyway.
 * 
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays/
 * https://leetcode.com/problems/merge-sorted-array/description/
 * 
 * Time: O(N + M)
 * Size: O(1)
 *
 */

public class MergeSortedArray {
	
	/*
	Thinking process:
	1. start from the end, track back. End index = m + n;
	2. when ever check a position, need to do index-1, because index=m+n is the size of array.
	3. Make sure to clean up the second array B.
	*/
	
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int index = m + n;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[--index] = A[--m];
            } else {
                A[--index] = B[--n];
            }
        }//While
        
        while (n > 0) {
            A[--index] = B[--n];
        }
    }
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return;
		
		int position1 = m - 1;
		int position2 = n - 1;
		
		for(int i = m + n - 1; i >= 0; i--) {
			//Handle remaining of nums1 or nums2
			if (position1 < 0 || position2 < 0) {
                nums1[i] = position1 < 0 ? nums2[position2--] : nums1[position1--];
            } else {
	            	if(nums1[position1] >= nums2[position2]) {
	            		nums1[i] = nums1[position1--];
	            	} else {
	            		nums1[i] = nums2[position2--];
	            	}
            }
		}
	}

}
