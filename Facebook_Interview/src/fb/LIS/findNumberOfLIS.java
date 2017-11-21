package fb.LIS;
/**
* Time complexity is O(n^2).
* Space complexity is O(n)
* 
*/

import java.util.Arrays;

class findNumberOfLIS {
	//driver method
	public static void main(String[] args) {
		
		findNumberOfLIS lis = new findNumberOfLIS();
		int nums[] = { 1, 3, 5, 4, 7 };
		int result = lis.findNumberOfLISS(nums);
		System.out.println(result);
		
	}
    public int findNumberOfLISS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1); //size array

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i) if (nums[i] < nums[j]) {
                if (lengths[i] >= lengths[j]) {
                    lengths[j] = lengths[i] + 1;
                    counts[j] = counts[i];
                } else if (lengths[i] + 1 == lengths[j]) {
                    counts[j] += counts[i];
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }
}