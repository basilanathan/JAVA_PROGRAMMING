package fb.glassdoor;

import java.util.ArrayList;

/**
 * 
 * @author basila
 * 
 * Merge two given sorted integer array A and B into a new sorted integer array.
	Example
	A=[1,2,3,4]
	B=[2,4,5,6]
	return [1,2,2,3,4,4,5,6]
	Challenge
	How can you optimize your algorithm if one array is very large and the other is very small?

 *	https://algorithm.yuanbin.me/zh-hans/integer_array/remove_duplicates_from_sorted_array.html
 *
 */

public class MergeSortedArrayII {
	
	/*
	 * Since the 2 list A,B are fixed, just add everyting into it.
	 * Basic implementation
	 * */
	
	public int[] mergeSortedArray(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) {
			return nums1 == null ? nums2 : nums1;
		}
		
		int[] result = new int[nums1.length + nums2.length];
		int position1 = nums1.length - 1;
		int position2 = nums2.length - 1;
		int mainIndex = result.length - 1;
		
		while(position1 >= 0 && position2 >= 0) {
			if(nums1[position1] <= nums2[position2]) {
				result[mainIndex--] = nums2[position2--];
			} else {
				result[mainIndex--] = nums1[position1--];
			}
		}
		
		while(position1 >= 0) {
			result[mainIndex--] = nums1[position1--];
		}
		while(position2 >= 0) {
			result[mainIndex--] = nums2[position2--];
		}
		return result;
	}
	
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
	
	/*
	 * Attemp1: Regular O(m+n) approach. optimized
	 * */

    public ArrayList<Integer> mergeSortedArray2(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || A.isEmpty()) return B;
        if (B == null || B.isEmpty()) return A;

        ArrayList<Integer> C = new ArrayList<Integer>();
        int aLen = A.size(), bLen = B.size();
        int i = 0, j = 0;
        while (i < aLen && j < bLen) { //optimization
            if (A.get(i) < B.get(j)) {
                C.add(A.get(i));
                i++;
            } else {
                C.add(B.get(j));
                j++;
            }
        }

        // A has elements left
        while (i < aLen) {
            C.add(A.get(i));
            i++;
        }

        // B has elements left
        while (j < bLen) {
            C.add(B.get(j));
            j++;
        }

        return C;
    }

}
