package fb.coderust;

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

/*
 * /*
    Just 1 binary search: this is the better solution
    //Observation: 
    //1. There is only one break point
    //2. There has to be a side that's continous, either first section or second section.
    //3. Need to locate that continous section, then check if target is part of the continous section
*/

/*
 * 1) everytime check if targe == nums[mid], if so, we find it.
2) otherwise, we check if the first half is in order (i.e. nums[left]<=nums[mid]) 
  and if so, go to step 3), otherwise, the second half is in order,   go to step 4)
3) check if target in the range of [left, mid-1] (i.e. nums[left]<=target < nums[mid]), if so, do search in the first half, i.e. right = mid-1; otherwise, search in the second half left = mid+1;
4)  check if target in the range of [mid+1, right] (i.e. nums[mid]<target <= nums[right]), if so, do search in the second half, i.e. left = mid+1; otherwise search in the first half right = mid-1;
 * 
 * */

public class SearchRotatedArray {
	//solution 1
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {  // eg. 3,4,5,6,1,2
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {  // eg. 5,6,1,2,3,4
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        if (start == end && target != nums[start]) return -1;
        return start;
    }
	
    //solution 2
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
