package algosJava;

import java.util.List;

/**
 * 
 * @author basila
 * 
 * Hints
	Binary search.
	
	Solution 1
	Runtime Complexity
	Since we are using binary search the runtime complexity is Logarithmic, O(logn). 
	We actually do binary search twice but asymptotic runtime complexity is still O(logn).
	
	Memory Complexity
	Constant, O(1). No extra storage is being used. Note however that if the binary 
	search was implemented recursively there would be implicit O(logn) memory usage on 
	the function call stack. We however, focus on an iterative solution here. 
	
	Linearly scanning the sorted array for low and high indices is highly inefficient 
	since our array size is in millions. Instead, we will use slightly modified binary 
	search to find the low and high indices of a given key. We need to do binary search twice; 
	once for finding the low index and once for finding the high index.
 *
 */

public class FindLowHighIndex {
	
	/*
	 * At every step, consider the array between low and high indices
	 * Calculate the mid index.
	 * If element at mid index is less than the key, low becomes mid + 1 (to move towards start of range)
	 * If element at mid is greater or equal to the key, high becomes mid - 1. Index at low remains the same.
	 * When low is greater than high, low would be pointing to the first occurrence of the key.
	 * If element at low does not match the key, return -1.
	 * */
	
	static int find_low_index(List<Integer> arr, int key) {

		  int low = 0;
		  int high = arr.size()-1;
		  int mid = high/2;

		  while (low <= high) {

		    int mid_elem = arr.get(mid);

		    if (mid_elem < key) {
		      low = mid+1;
		    }
		    else {
		      high = mid-1;
		    }

		    mid = low + (high-low)/2;
		  }

		  if (arr.get(low) == key) {
		    return low;
		  }

		  return -1;
		}

		static int find_high_index(List<Integer> arr, int key) {
		  
		  int low = 0;
		  int high = arr.size()-1;
		  int mid = high/2;

		  while (low <= high) {

		    int mid_elem = arr.get(mid);

		    if (mid_elem <= key) {
		      low = mid+1;
		    }
		    else {
		      high = mid-1;
		    }

		    mid = low + (high-low)/2;
		  }

		  if (arr.get(high) == key) {
		    return high;
		  }

		  return -1;
		}

}
