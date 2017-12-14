package cci.ch10;

import helpers.*;

public class QuickSort {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void QuickSort(int[] arr, int left, int right) {
		if(arr == null || arr.length == 0) return;
		int partitionIndex = partition(arr, left, right);
		if (left < partitionIndex - 1) {
			QuickSort(arr, left, partitionIndex - 1);
		}
		if (partitionIndex < right) {
			QuickSort(arr, partitionIndex + 1, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		//get the pivot element from the middle of the list
		int pivot = arr[(left + right) / 2];
		//divide into two lists
		while(left <= right) {
			// If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
			while(arr[left] < pivot) left++;
			// If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
			while(arr[right] > pivot) right--;
			
			// If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase left and decrease right
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] arr = AssortedMethods.randomArray(20, 0, 6);
		AssortedMethods.printIntArray(arr);	
		QuickSort(arr, 0, arr.length - 1);
		AssortedMethods.printIntArray(arr);
	}

}
