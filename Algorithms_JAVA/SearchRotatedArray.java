package algosJava;

/**
 * 
 * @author basila
 * 
 * Description
 * Search a given number in a sorted array that has been rotated by some arbitrary number. 
 * Return -1 if the number does not exist.
 * 
 * Hints
	Linear search is not an acceptable solution
	Think modified binary search
	
	Solution
	Runtime Complexity
	Logarithmic, O(logn).
	
	Memory Complexity
	Logarithmic, O(logn).
	We can make the search iterative to get constant memory complexity.
	
	The solution is essentially binary search with some modifications. If we look at the array 
	in example closely, we notice that at least one half of the array is always sorted. 
	We can use this property to our advantage. If the number n lies within the sorted half 
	of the array then our problem is basic binary search. Otherwise discard the sorted half 
	and keep examining the unsorted part. Since we are partitioning array in half at each 
	step this gives us O(logn) runtime complexity.
 *
 *https://www.educative.io/collection/page/5642554087309312/5679846214598656/100002
 */

public class SearchRotatedArray {
	
	static int binary_search_rotated(int[] arr, int key) {
		  return binary_search(arr, 0, arr.length-1, key);
		}
	
	public static int binary_search(int[] arr, int st, int end, int key) {
		  // assuming all the keys are unique.
		  
		  if (st > end) {
		    return -1;
		  }

		  int mid = st + (end-st)/2;

		  if (arr[mid] == key) {
		    return mid;
		  }
		  
		  //left is sorted 
		  if (arr[st] < arr[mid] && 
		      key < arr[mid] && key >= arr[st]) {
		    return binary_search(
		              arr, st, mid-1, key);
		  }
		  //right is sorted
		  else if (arr[mid] < arr[end] && 
		           key > arr[mid] && key <= arr[end]) {
		    return binary_search(
		                arr, mid+1, end, key);
		  }
		  
		  else if (arr[st] > arr[mid]) {
		    return binary_search(
		                arr, st, mid-1, key);
		  }
		  
		  else if (arr[end] < arr[mid]) {
		    return binary_search(
		                arr, mid+1, end, key);
		  }

		  return -1;
		}
		
		public static void main(String[] args) {
			int[] arr = {176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162};
			System.out.println(binary_search_rotated(arr, 75));
		}

}
