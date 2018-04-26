package fb.glassdoor;

public class LongestIncreasingSubArray {
	
	public static int longestSubArray(int[] nums) {
		int max = 1, len = 1, maxIndex = 0;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i - 1])
				len++;
			else {
				if(max < len) {
					max = len;
					//maxIndex = i - max;
				}
					
				len = 1;
			}
		}
		if(max < len) {
			max = len;
			//maxIndex = nums.length - max;
		}
		
//		for(int i = maxIndex; i < max + maxIndex; i++) {
//			System.out.println(nums[i] + " ");
//		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubArray test = new LongestIncreasingSubArray();
		int[] testArray = {5, 6, 3, 5, 7, 8, 9, 1, 2};
		System.out.println(test.longestSubArray(testArray));
	}

}
