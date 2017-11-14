import java.util.Arrays;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inputArray[] = { 120, 810, 740, 43777, 1098888, 0, 8565, 9267, 17, 754, 912, 0, 6, 4 };
		quickSort(inputArray, 0, inputArray.length - 1);
		
		System.err.println(Arrays.toString(inputArray));

	}
	
	public static void quickSort(int inputArray[], int start, int end) {
		if (start < end) {
			int pp = partition(inputArray, start, end);
			quickSort(inputArray, start, pp-1);
			quickSort(inputArray, pp+1, end);
		}
	}
	
	public static int partition(int inputArray[], int start, int end) {
		int pivot = inputArray[end];
		
		int i = start - 1;
		for(int j = start; j <= end - 1; j++) {
			if (inputArray[j] < pivot) {
				i++;
				
				//swap
				int ival = inputArray[i];
				int jval = inputArray[j];
				inputArray[i] = jval;
				inputArray[j] = ival;
			}
		}
		
		int ival = inputArray[i + 1];
		inputArray[end] = ival;
		inputArray[i + 1] = pivot;
		
		return i+1;
	}

}
