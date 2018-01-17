package algosJava;

import java.util.Arrays;

import helpers.AssortedMethods;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * In an array of integers, a "peak" is an element which
 * is greater then or equal to the adjacent integers and
 * a "valley" is an element which is less then or equal
 * to the adjacent integers. For example in the array,
 * {5, 8, 6, 2, 3, 4, 6}, {8, 6} are the peaks and {5, 2}
 * are the valleys. Given an array of integers, sort the
 * array into an alternating sequence of peaks and valleys.
 * 
 * Example : 
 * Input : {5, 3, 1, 2, 3}
 * Output : {5, 1, 3, 2, 3}
 * 
 * </br>
 * 
 * Time: O(N log N)
 * Optimized Time: O(N)
 * 
 */

public class PeaksAndValleys {
	
	static void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		for(int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}

	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	static void sortValleyPeakOptimized(int[] array) {
		for(int i = 1; i < array.length; i += 2) {
			int biggestIndex = maxIndex(array, i - 1, i, i + 1);
			if(i != biggestIndex) {
				swap(array, i, biggestIndex);
			}
		}
	}
	
	private static int maxIndex(int[] array, int a, int b, int c) {
		int len = array.length;
		int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
		int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
		int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;
		
		int max = Math.max(aValue, Math.max(bValue, cValue));
		if(aValue == max) return a;
		else if(bValue == max) return b;
		else return c;
	}

	public static void main(String[] args) {
		int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
		System.out.println(AssortedMethods.arrayToString(array));
		//sortValleyPeak(array);
		sortValleyPeakOptimized(array);
		System.out.println(AssortedMethods.arrayToString(array));
		//System.out.println(Tester.confirmValleyPeak(array));
		
	}

}
