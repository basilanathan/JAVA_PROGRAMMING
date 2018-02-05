package fb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 1. Using Set O(N)
 * 2. Sort the Array O(N Log N)
 * 3. Using HashMap O(N)
 * 
 */

/**
 * 
 * @author basila
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	
	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	
	Your algorithm should run in O(n) complexity.
 *
 */

//This problem can be done using sorting, but time complexity of sorting is O(nlogn). This problem requires O(n).

//Using a set to collect all elements that hasn’t been visited. search element will be O(1) and eliminates visiting element again.

/*
 * First turn the input into a set of numbers. That takes O(n) and then we can ask in O(1) 
 * whether we have a certain number.
 * 
 * check the left side for consecutiveness (val - 1) val--
 * check the right side for consecutiveness (val + 1) val++
 * 
 * get the sum += num - val
 * 
 * get max
 * 
 * */

public class LongestConsecutiveSequence {
	
	public int longerSequence(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num : nums) set.add(num);
		int max = 0;
		
		for(int num : nums) {
			if(set.remove(num)) {
				int val = num;
				int sum = 1;
				while(set.remove(val - 1)) {
					val--;
				}
				sum += num - val;
				
				val = num;
				
				while(set.remove(val + 1)) {
					val++;
				}
				sum += num - val;
				
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	
	
	/*
	Thougths:
	1. sort
	2. use a 'count' and 'max' to keep track of consecutive elements
	3. one-pass
	Note:
	Take care of equal numbers: skip/continue those
	*/

	public class Solution {
	    /**
	     * @param nums: A list of integers
	     * @return an integer
	     */
	    public int longestConsecutive(int[] num) {
	        if (num == null || num.length == 0) {
	            return 0;
	        }
	        if (num.length == 1) {
	            return 1;
	        }
	        int count = 1;
	        int max = 1;
	        Arrays.sort(num);
	        for (int i = 1; i < num.length; i++) {
	            if (num[i - 1] == num[i]) {
	                   continue;
	            } else if (num[i - 1] + 1 == num[i]) {
	                count++;
	                max = Math.max(count, max);
	            } else {
	                count = 1;
	            }
	        }
	        return max;
	    }
	}
	
	//solution 2 using has map
	
	/*
	 * 1. Want to check if a number's left and right is consecutive to itself, but cannot do it due to the given unsorted array: think about a Hashmap.
2. HashMap(Key, Value) = (the number itself, boolean: have been counted or not). If you count a number as a consecutive, you only need to count it once.
3. How HashMap works: 
	when checking a number's consecutive, look at number--, number++, see if they are in the HashMap. If exist, means consecutive.
	If a number exist in the hashmap and its value is 'true', then we need to skip this number beacuse it has been checked.
4. Track the total number consecutives of 1 perticular number, compare it with the maxL. Save the Math.max to maxL.
5. Depending on the problem, we can store a consecutive sequence or simply just its length: maxL. This problem wants the maxL.
	 * */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int maxL = 1;
        HashMap<Integer, Boolean> history = new HashMap<Integer, Boolean>();
        for (int i : num) {
            history.put(i, false);
        }
        for (int i : num) {
            if (history.get(i)) {
                continue;
            }
            //check ++ side
            int temp = i;
            int total = 1;
            while (history.containsKey(temp + 1)) {
                total++;
                temp++;
                history.put(temp, true);
            }
            //check -- side
            temp = i;
            while (history.containsKey(temp - 1)) {
                total++;
                temp--;
                history.put(temp, true);
            }
            maxL = Math.max(maxL, total);
        }
        return maxL;
    }
	
	public static void main(String[] args) {
		LongestConsecutiveSequence test = new LongestConsecutiveSequence();
		int[] testArray = {100, 4, 200, 1, 3, 2};
		
		System.out.println(test.longerSequence(testArray));
	}

}
