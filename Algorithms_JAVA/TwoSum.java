package algosJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/two-sum/solution/
 * https://www.educative.io/collection/page/5642554087309312/5679846214598656/830001
 *
 */

public class TwoSum {
	
	/*
	 * Hints
		Hashable
		Sort array
		
		Solution #1
		Runtime Complexity
		Linear, O(n).
		
		Memory Complexity
		Linear, O(n).
		
		In this solution, we'll use the following algorithm to find a pair that sum up to target (say 'val').
		
		Scan whole array once and store visited elements in a hash set.
		During scan, for every element 'e' in array, we check if 'val' - 'e' is present in the hash 
		set i.e. 'val' - 'e' is already visited.
		If 'val' - 'e' is found in the hash set, it means there is a pair (e, val - e) in array whose 
		sum is equal to the given val.
		If we have exhausted all elements in the array and didn't find any such pair, function will return false.
	 * */
	
	// find_sum_of_two function return true if
	// there are two values in array who
	// sum to value and returns false otherwise
	static boolean find_sum_of_two(int[] A, int val) {
	  Set<Integer> found_values = new HashSet<Integer>();
	  for (int a : A) {
	    if (found_values.contains(val - a)) {
	      return true;
	    }

	    found_values.add(a);
	  }

	  return false;
	}
	
	/*
	 * Solution #2
	Runtime Complexity
	Linearithmic, O(n logn).
	
	Here 'n logn' is the time complexity required to sort the array. For a sorted array, 
	the complexity would be linear, O(n).
	
	Memory Complexity
	Constant, O(1).
	
	This solution requires that the input array is already sorted.
	 * */
	
	// find_sum_of_two_2 function return true if
	// there are two values in array who
	// sum to value and returns false otherwise
	// this solution works only if data is sorted.
	// does not require any extra memory.
	static boolean find_sum_of_two_2(int[] A, int val) {

	  for (int i = 0, j = A.length - 1; i < j;) {
	    int sum = A[i] + A[j];
	    if (sum == val) {
	      return true;
	    }

	    if (sum < val) {
	      ++i;
	    } else {
	      --j;
	    }
	  }

	  return false;
	}
	
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
