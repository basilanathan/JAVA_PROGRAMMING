package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	
	The number of ways decoding "12" is 2.
 * 
 * I used a dp array of size n + 1 to save subproblem solutions. dp[0] means an empty string 
 * will have one way to decode, dp[1] means the way to decode a string of size 1. I then 
 * check one digit and two digit combination and save the results along the way. In the end, 
 * dp[n] will be the end result.
 * 
 * Time: should be O(n), where n is the length of String
 * Space: should be O(n), where n is the length of String
 * 
 * https://leetcode.com/problems/decode-ways/discuss/30358
 * 
 */

public class DecodeWays {
	
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1; //empty string -> will  have one way to decode
        dp[1] = s.charAt(0) != '0' ? 1 : 0; ////way to decode a string of size 1
        for(int i = 2; i <= n; i++) {
        	//check one digit and two digit combination
        	//start from left -> 1234
            int first = Integer.valueOf(s.substring(i-1, i));  //i = 2 -> 2 //i = 3 -> 3 //i = 4 -> 4
            int second = Integer.valueOf(s.substring(i-2, i));  //i = 2 -> 12 // i = 3 -> 23 //i = 4 -> 34
            if(first >= 1 && first <= 9) {
               dp[i] = dp[i-1]; //one number -> one way to decode it  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    
    /* 1234
     * n = 4
     * 
     * i = 2
     * 	first = 2
     * 	second = 12
     * i = 3
     * 	first = 3
     * 	second = 23
     * 
     * i = 4
     * 	first = 4
     * 	second = 34
     * 
     * dp array
     * array index -> 0 1 2 3 4
     * 				  1 1 2 3 3
     * 
     * */
    
    public static void main(String[] args) {
		String test1 = "1234";
		System.out.println("Answer: " + numDecodings(test1));
		
		for(int i = 2; i <= 4; i++) {
			System.out.print(test1.substring(i - 1, i) + " ");
			
			System.out.print(test1.substring(i - 2, i) + " " + "|");

		}
		
	}

}
