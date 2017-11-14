package algo.mergesort;

public class MergeSort {
	 
    public static void sort(int[] inputArray){
 
        sort(inputArray, 0, inputArray.length-1);
    }
 
    public static void sort(int[] inputArray, int start, int end){
 
        if(end <= start){
            return;   // we're done traversing the array
        }
        int mid = (start + end)/2;   // get the mid point
        sort(inputArray, start, mid);  // sort left half
        sort(inputArray, mid+1, end);  // sort right half
        merge(inputArray, start, mid, end);
 
    }
 
    public static void merge(int[] inputArray,int start, int mid, int end) {
 
    	//to manage the sorted values
        int[] tempArray = new int[end - start + 1];  // since array starts from 0 to length -1;
 
        int leftSlot = start;  // index counter of the first slot on the left side of the array
        int rightSlot = mid + 1; // index counter of the first slot on the right side of the array
 
        int k = 0;   // variable to increment
 
        while (leftSlot <= mid && rightSlot <= end) {
            if (inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[k] = inputArray[leftSlot];   // save the sorted array and good to go to move on to next position
                leftSlot++;
            } else {
                tempArray[k] = inputArray[rightSlot];
                // rightSlot++;
                rightSlot++;
            }
            k++;
        }
 
 
        /*
        *   When it get's to here, implies that above loop has been completed.
        *   So both the right and the left side of sub array can br
        *   considered sorted.
        * */
 
        if (leftSlot <= mid) {  // consider right side done being sorted, left must be sorted already
            while (leftSlot <= mid) {  // left already sorted
                tempArray[k] = inputArray[leftSlot];
                leftSlot = leftSlot + 1;
                k++;
            }
 
 
        } else if (rightSlot <= end) {  // consider left side done being sorted, right must be sorted already
            while (rightSlot <= end) {
                tempArray[k] = inputArray[rightSlot];
                rightSlot = rightSlot + 1;
                k= k+1;
            }
        }
        // copy over the temp array into appropriate slots
        for (int i = 0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }
    }
}
