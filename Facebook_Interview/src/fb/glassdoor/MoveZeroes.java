package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	
	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	
	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
 *
 *	https://leetcode.com/problems/move-zeroes/description/
 *	https://www.geeksforgeeks.org/move-zeroes-end-array/
 */

public class MoveZeroes {
	
	/*
	 * doesn’t use a temp variable and avoids unnecessary swaps when nums has leading non-zero element.
	 * Idea - Set leftMostZeroIndex to 0. Iterate through the array, at each iteration i, 
	 * if nums[i] != 0 and i > leftMostZeroIndex, replace the leftmost zero element 
	 * nums[leftMostZeroIndex] with nums[i], and set nums[i] to 0.
	 * 
	 * Note that i >= leftMostZeroIndex is always true, and i == leftMostZeroIndex happens when nums 
	 * has leading non-zero elements, e.g., nums = {2, 1, 3, 0, 5, 0, 6}. In such a case, we don’t 
	 * perform any swap, and keep incrementing i and leftMostZeroIndex until i > leftMostZeroIndex.
	 * */
	
	//when we encounter a non-zero element, we need to swap elements pointed by current and slow pointer, 
	//then advance both pointers. If it's zero element, we just advance current pointer.
	
	//Time : O(N)
	//Space : O(1)
	public void moveZeroes(int[] nums) {
	    int leftMostZeroIndex = 0; // The index of the leftmost zero
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] != 0) {
	            if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
	                nums[leftMostZeroIndex] = nums[i];
	                nums[i] = 0;
	            }

	            leftMostZeroIndex++;
	        }
	    }
	}
	
	
	// Shift non-zero values as far forward as possible
	// Fill remaining space with zeros
	
	//Time: O(N)
	//Space; 0(1)
	public void moveZeroes2(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    //// If the current element is not 0, then we need to
	    // append it just in front of last non 0 element we found.
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        
	    
	    // After we have finished processing new elements,
	    // all the non-zero elements are already at beginning of array.
	    // We just need to fill remaining array with 0's.
	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	public static int [] moveZeroes3(int[] nums) {
		int j = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		
		int [] myArray = moveZeroes(new int[] {0, 1, 0, 3, 12});
			for (int i = 0; i < myArray.length; i++) {
				System.out.println(myArray[i]);
			
		}
	
	}
}
