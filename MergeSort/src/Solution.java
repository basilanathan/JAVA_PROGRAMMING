
public class Solution {

	public static void mergesort(int[] array) {
		//sort left sort the right and merge the two.
		mergesort(array, new int [array.length], 0, array.length - 1);
	}
	public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int middle = (leftStart + rightEnd) / 2;
		mergesort(array, temp, leftStart, middle);
		mergesort(array, temp, middle + 1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd);
	}
	
	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		//need temp array. create one temp array to use the entire time
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size); //copy everything from temp back into array.
	}
    /* A utility function to print array of size n */
    static void printArray(int[] array)
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        int[] array = {12, 11, 13, 5, 6, 7};
 
        System.out.println("Given Array");
        printArray(array);
 
        Solution ob = new Solution();
        ob.mergesort(array);
 
        System.out.println("\nSorted array");
        printArray(array);
    }

}
