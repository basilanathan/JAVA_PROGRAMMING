package fb.coderust;

import java.util.Arrays;

/**
 * 
 * @author basila
 * 
 * Hints
	Divide and conquer
	Solution
	Runtime Complexity
	Linearithmic, O(nlogn).
	
	Memory Complexity
	Logarithmic, O(logn).
	
	Recursive solution has O(logn) memory complexity as it will consume memory on the stack.
 *
 */

public class QuickSort {

	public static void main(String[] args) {
		int inputArray[] = { 12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4 };
		quickSort(inputArray, 0, inputArray.length - 1);
		
		System.out.println(Arrays.toString(inputArray));

	}
	
	/*12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4 i = -1 j = 0
	 * 0, 81, 74, 43, 1098, 12, 8, 92, 17, 754, 912, 0, 6, 4 i = 0, j = 5
	 * 0, 0, 74, 43, 1098, 12, 8, 92, 17, 754, 912, 81, 6, 4 i = 1, j = 11
	 * 0, 0, 4, 43, 1098, 12, 8, 92, 17, 754, 912, 81, 6, 74 return i + 1 -> 2
	 * quick sort -> 0, 0
	 * quick sort -> 43, 1098, 12, 8, 92, 17, 754, 912, 81, 6, 74
	 * 
	 * 
	 * */
	
	public static void quickSort(int inputArray[], int start, int end) {
		if (start < end) { //still traversing the array
			int pp = partition(inputArray, start, end); //index position fo the correctly placed pivot value
			quickSort(inputArray, start, pp-1); //sorts the left half of the range
			quickSort(inputArray, pp+1, end); //sorts the right half of the given range
			
		}
	}
	public static int partition(int inputArray[], int start, int end) {
		int pivot = inputArray[end]; //last slot of the given range
		
		int i = start - 1;
		for(int j = start; j <= end - 1; j++) {
			if (inputArray[j] <= pivot) {
				i++;
				int ival = inputArray[i];
				int jval = inputArray[j];
				
				//swapping
				inputArray[i] = jval;
				inputArray[j] = ival;
			}
		}
		//put the pivot value in the correct slot next
		
		int ival = inputArray[i + 1];
		inputArray[end] = ival;
		inputArray[i + 1] = pivot; //here pivot value is placed in the correct slot of the array
		
		return i+1; //position for q
		
	}

}
