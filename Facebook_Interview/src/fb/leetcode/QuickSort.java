package fb.leetcode;

import java.util.Arrays;

//http://www.jiuzhang.com/solutions/sort-integers-ii/

/*
 * pick a pivot value
 * have left and right pointer
 * everything smaller than pivot should be on the left
 * everything bigger than pivot should be on the right
 * */

public class QuickSort {
	
    public static void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private static void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2: every time you compare left & right, it should be 
        // left <= right not left < right
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
	
	public static void main(String[] args) {
		int[] array = {42, 79, 46, 23, 96, 100};
		sortIntegers2(array);
		System.out.println(Arrays.toString(array));
	}

}
