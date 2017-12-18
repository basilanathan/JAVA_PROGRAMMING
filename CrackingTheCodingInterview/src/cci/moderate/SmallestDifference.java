package cci.moderate;

import java.util.Arrays;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Smallest Difference: Given two arrays of integers, compute the pair of values
 * (one value in each array) with the smallest(non-negative) difference. Return the difference.
 * 
 * </br>
 * 
 * Time: O(AB)
 * Time: O(A log A + B log B) to sort and O(A + B) to fin min.
 *
 */

public class SmallestDifference {
	
	//brute force = iterate through all pairs , compute the difference and compare it to the
	//current min difference
	public static int findSmallestDiff(int[] array1, int[] array2) {
		if(array1.length == 0 || array2.length == 0) return -1;
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (Math.abs(array1[i] - array2[j]) < min) {
					min = Math.abs(array1[i] - array2[j]);
				}
			}
		}
		return min;
	}
	
	//optimized = sort both the arrays
	
	public static int findSmallestDiffOp(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int a = 0;
		int b = 0;
		int min = Integer.MAX_VALUE;
		while (a < array1.length && b < array2.length) {
			if (Math.abs(array1[a] - array2[b]) < min) {
				min = Math.abs(array1[a] - array2[b]);
				if (min == 0) return min;
			}
			if (array1[a] < array2[b]) {
				a++;
			} else {
				b++;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int difference = findSmallestDiff(array1, array2);
		int difference2 = findSmallestDiffOp(array1, array2);
		System.out.println(difference);
		System.out.println(difference2);
	}

}
