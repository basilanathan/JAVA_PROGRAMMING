package algosJava;

/**
 * 
 * @author basila
 * 
 * Description
 * Given three integer arrays sorted in ascending order, find the smallest number 
 * that is common in all three arrays.
 * 
 * Hints
	Take advantage of the sorted array to reduce complexity.
	Use three pointers.
	
	Solution
	Runtime Complexity
	Linear, O(n).
	
	Memory Complexity
	Constant, O(1).
	
	We should try to think of a way where we can take advantage of the fact that the arrays are sorted in ascending order.
	
	We will use 3 iterators simultaneously to traverse the arrays. 
	We can start off by traversing the arrays from the 0th index, which will be 
	the smallest value of each array.
	
	If the values of the array indices pointed by the 3 iterators are:
	
	Equal: that's the result. We'll just return the value.
	Otherwise, we'll advance the iterator that's pointing to the smallest number among the three.
	If any of the iterators has reached the end of the array while we haven't found the 
	common number, we'll return -1.
 *
 * https://www.educative.io/collection/page/5642554087309312/5679846214598656/10003
 */

public class FindSmallestCommonNumber {
	
	static int find_least_common_number(int[] arr1, int[] arr2, int[] arr3) {
		
		int i=0, j=0, k=0;
		
		while(i < arr1.length && j < arr2.length && k < arr3.length) {
			
			// Found the smallest common number
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
			return arr1[i];
			}
			
			// Let's advance the iterator
			// for the smallest value.
			
			if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
				i++;
			}
			
			else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
				j++;
			}
			
			else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
				k++;
			}
		
		}
		
		return -1;
	}

}
