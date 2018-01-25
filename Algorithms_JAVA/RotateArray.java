package fb.coderust;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * let a= [1,2,3,4,5,6,7]
	k = 3.
	
	we have to first reverse the whole array by swapping first element with the last one and so on…
	you will get[7,6,5,4,3,2,1]
	
	reverse the elements from 0 to k-1
	reverse the elements 7,6,5
	you will get [5,6,7,4,3,2,1]
	
	reverse the elements from k to n-1
	reverse the elements 4,3,2,1
	you will get[5,6,7,1,2,3,4]
 * 
 * https://www.educative.io/collection/page/5642554087309312/5679846214598656/210003
 */

public class RotateArray {
	
	/*
	 * Solution #1
		Runtime Complexity
		Linear, O(n).
		Memory Complexity
		Constant, O(1).
		Here is how the solution works.
		
		Reverse the elements of the original array.
		Reverse the elements from 0 -> N-1.
		Reverse the elements from N -> Length-1.
	 * 
	 * */
	public static void rotate_array_in_place(List<Integer> arr, int n) {

		  int len = arr.size();
		  //sometimes, n is larger than the length of array. For example nums = [1, 2, 3, 4, 5], n = 12, 
		  //this means we only need to rotate the last two numbers. k = k % nums.length = 2;
		  
		  // Let's normalize rotations
		  // if n > array size or n is negative.
		  n = n % len;
		  if (n < 0) {
		    // calculate the positive rotations needed.
		    n = n + len;
		  }

		  // Let's partition the array based on rotations 'n'.
		  // For example: 1, 2, 3, 4, 5 where n = 2.
		  // -> 5, 4, 3, 2, 1
		  // -> 4, 5, 3, 2, 1
		  // -> 4, 5, 1, 2, 3

		  reverse_array(arr, 0, len-1);
		  reverse_array(arr, 0, n-1);
		  reverse_array(arr, n, len-1);
		}
	
	public static void reverse_array(List<Integer> arr, int start, int end) {
		  while (start < end) {
		    int temp = arr.get(start);
		    arr.set(start, arr.get(end));
		    arr.set(end, temp);
		    start++;
		    end--;
		  }
		}
	
	//solution 2
	public static void rotate(int[] nums, int k) {
	    k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
	}

	public static void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
	/*
	 * Solution #2
		Runtime Complexity
		Linear, O(n).
		Memory Complexity
		Linear, O(N).
		Here 'd' is the number of places we are rotating the array by.
		
		Here is how the solution works.
		
		Store the last 'N' elements into a temporary array.
		Shift the original array towards right by 'L-N' places. Here, L is the length of array.
		Copy the temporary array at the beginning of the original array.
	 * */
	//solution 3
	static void rotate_array(List<Integer> arr, int n) {
		  int len = arr.size();
		  // Let's normalize rotations
		  // if n > array size or n is negative.
		  n = n % len;
		  if (n < 0) {
		    // calculate the positive rotations needed.
		    n = n + len;
		  }
		  
		  List<Integer> temp = Arrays.asList(new Integer[n]);
		  
		  // copy last N elements of array into temp
		  for (int i = 0; i < n; i++) {
		    temp.set(i, arr.get(len-n+i));
		  }
		  
		  // shift original array
		  for (int  i = len-1; i >= n; i--) {
		    arr.set(i, arr.get(i-n));	
		  }
		  
		  // copy temp into original array
		  for (int i = 0; i < n; i++) {
		    arr.set(i, temp.get(i));
		  }  
		}

}
