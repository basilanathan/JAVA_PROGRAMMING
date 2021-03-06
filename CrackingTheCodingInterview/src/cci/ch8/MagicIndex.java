package cci.ch8;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * A magic index in an array A[0... n-1] is defined to be an index
 * such that A[i] = i. Given a sorted array of distinct integers,
 * write a method to find a magic index, if one exits in Array A?
 * 
 * FOLLOW UP : What if the values are not distinct?
 * 
 * <br>
 *
 */

public class MagicIndex {
	
	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}
	
	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	public static int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magicFast(array, start, mid - 1);
		} else {
			return magicFast(array, mid + 1, end);
		}
	}
	
	public static int magicFast2(int[] array) {
		return magicFast2(array, 0, array.length);
	}

	private static int magicFast2(int[] array, int start, int end) {
		if (end < start) return -1;
		
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		
		//search left
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast2(array, start, leftIndex);
		if (left > 0) {
			return left;
		}
		
		//search right
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast2(array, rightIndex, end);
		return right;
	}

}
