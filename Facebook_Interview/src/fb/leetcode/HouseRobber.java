package fb.leetcode;

public class HouseRobber {
	
	public int houseRobber(int[] nums) {
		int n = nums.length;
		if(n == 0) return 0;
		if(n == 1) return nums[0];
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(dp[0], nums[1]);
		int max = dp[1];
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
