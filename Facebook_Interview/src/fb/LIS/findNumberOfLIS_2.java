package fb.LIS;

/**
* Time complexity is O(n^2).
* Space complexity is O(n)
* 
*/
public class findNumberOfLIS_2 {
	
	//driver method
	public static void main(String[] args) {
		
		findNumberOfLIS_2 lis = new findNumberOfLIS_2();
		int nums[] = { 1, 3, 5, 4, 7 };
		int result = lis.findNumberOfLIS(nums);
		System.out.println(result);
		
	}
	
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int res = 0;
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        for(int i = 0; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(len[j] + 1 == len[i]) cnt[i] += cnt[j];
                    if(len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }    
                }
            }
            if(len[i] == maxLen) res += cnt[i];
            if(len[i] > maxLen) {
                res = cnt[i];
                maxLen = len[i];
            }    
        }
        return res;
    }
}
