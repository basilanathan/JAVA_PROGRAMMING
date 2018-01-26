package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 */



public class MinimumSizeSubarraySum {
	
	/*
	 * O(N) - keep a moving window expand until sum>=s, then shrink util sum<s. 
	 * Each time after shrinking, update length.
	 * */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, from = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                win = Math.min(win, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }

}
/*
 * As to NLogN solution, logN immediately reminds you of binary search. In this case, 
 * you cannot sort as the current order actually matters. How does one get an ordered array then? 
 * Since all elements are positive, the cumulative sum must be strictly increasing. Then, 
 * a subarray sum can expressed as the difference between two cumulative sum. Hence, given a start 
 * index for the cumulative sum array, the other end index can be searched using binary search.
 * */
class Solution {
    public int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1]; //initialize array
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1]; //calc cummulative sum
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums); //sums[i] + s == key -> trying to find index of the key in binary search 
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i; //if key found in sums array update min length
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
           int mid = (lo + hi) / 2;
           if (sums[mid] >= key){
               hi = mid - 1;
           } else {
               lo = mid + 1;
           }
        }
        return lo;
    }
}



//O(NLogN) - search if a window of size k exists that satisfy the condition


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 1, j = nums.length, min = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (windowExist(mid, nums, s)) { //if there is a window from start to mid update min == mid
                j = mid - 1;
                min = mid;
            } else i = mid + 1;
        }
        return min;
    }


    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) sum -= nums[i - size]; //closing the window from the front
            sum += nums[i];
            if (sum >= s) return true; //window exists
        }
        return false;
    }
}
