package fb.careercup;

/**
 * 
 * @author basila
 * 
 * Given an array of integers and a number x, find the smallest subarray with 
 * sum greater than the given value.
 * 
 * Examples:
	arr[] = {1, 4, 45, 6, 0, 19}
	   x  =  51
	Output: 3
	Minimum length subarray is {4, 45, 6}
	
	arr[] = {1, 10, 5, 2, 7}
	   x  = 9
	Output: 1
	Minimum length subarray is {10}

 * https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 *
 */

public class SmallestSubArraySumGreaterThanK {
	
	//Time: O(N2)
	
	public static int smallestSubArray(int[] array, int k) {
		
		/*
		 * A simple solution is to use two nested loops. The outer loop picks a starting element, 
		 * the inner loop considers all elements (on right side of current start) as ending element. 
		 * Whenever sum of elements between current start and end becomes more than the given number, 
		 * update the result if current length is smaller than the smallest length so far.
		 * 
		 * */
		
		if(array.length == 0 || array == null) return 0;
		//initialize length of smallest subarray as n + 1
		int minLength = array.length + 1;
		
		//pick every element as starting point
		for(int start = 0; start < array.length; start++) {
			//initialize sum starting with current start
			int currentSum = array[start];
			
			//if first element itself is greater or equal
			if(currentSum >= k) return 1;
			
			//try different end points for current start
			for(int end = start + 1; end < array.length; end++) {
				
				//add last element to current sum
				currentSum += array[end];
				
				// If sum becomes more than x and length of
                // this subarray is smaller than current smallest
                // length, update the smallest length (or result)
				if (currentSum >= k && (end - start + 1) < minLength) {
					minLength = (end - start + 1);
					
				}
			}
		}
		return minLength;
		
	}
	
	//Time: O(N) worst case each element will be added or subtracted once from the current sum
	
	// Returns length of smallest subarray with sum greater than k.
    // If there is no subarray with given sum, then returns n+1
	public static int smallestSubArrayOP(int[] array, int k) {
		// Initialize current sum and minimum length
		int currentSum = 0, minLength = array.length + 1;
		
		// Initialize starting and ending indexes
		int start = 0, end = 0;
		
		while(end < array.length) {
			
	        // Keep adding array elements while current sum
	        // is smaller than x
	        while (currentSum <= k && end < array.length)
	        {
	            // Ignore subarrays with negative sum if
	            // x is positive.
	            if (currentSum <= 0 && k > 0)
	            {
	                start = end;
	                currentSum = 0;
	            }
			
			// Keep adding array elements while current sum
            // is smaller than k
				currentSum += array[end++];
	        }
	        
			// If current sum becomes greater than k.
			while(currentSum >= k && start < array.length) {
				// Update minimum length if needed
				if(end - start < minLength)
					minLength = end - start;
				
				// remove starting elements
				currentSum -= array[start++];
			}
		}
		return minLength;
	}
	
	public static void main(String[] args) {
		int arr1[] = {1, 4, 45, 6, 10, 19}; //{ 45, 6}
        int k = 51;
        int arr2[] = {3, 8, 8}; //{8, 8}
        int k1 = 16;
        //int n1 = arr1.length;
        int res1 = smallestSubArray(arr1, k);
        int res2 = smallestSubArray(arr2, k1);
        
        int res3 = smallestSubArrayOP(arr1, k);
        int res4 = smallestSubArrayOP(arr2, k1);

        System.out.println(res1);
        System.out.println(res2);
        
        System.out.println(res3);
        System.out.println(res4);
	}

}
