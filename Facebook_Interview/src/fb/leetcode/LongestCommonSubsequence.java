package fb.leetcode;

/*
Thoughts:
Sequence DP.
Common Subsequence: doesn't have to be conneccted subsequence.
Consider the last position of each string, there are 3 possible conditions:
1. A's last index is not part of common subsequence.   Next step, consider: A[0 ~ n-1] and B
2. B's last index is not part of common subsequence    Next step, consider: B[0 ~ n-1] and A
3. A's last index == B's last index, +1 on the result.    Next step, consider: A[0 ~ n-1] and B[0 ~ n-1]
=> Each condition results in a sub problem.
dp[i][j]: longest common subsequence length for items: A[0 ~ i - 1] and B[0 ~ j - 1]
dp[i][j] = Max{dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + 1| A[i - 1]==B[i - 1] }
Space: O(MN)
Time: O(MN)
*/
/*
Thoughts:
dp[i][j] represent max LCS length for A[0, i - 1], B[0, j - 1]
Conditions:
- A[i-1] != B[j - 1]: no action
- A[i-1] == B[j - 1]: dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
*/

public class LongestCommonSubsequence {
	
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Init
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                // Base condition: equals to previous's best
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    // match, take previous' best + 1
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

}

/*
Preivous Note.
Thinking process:
Using DP.
check[i][j] means: the length of longest common subsequnce between A(0 ~ i) and B(0 ~ j).
Then there are two ways to reach check[i][j]:
1. A(i-1) == B(j - 1), then check[i][j] = check[i - 1][j - 1] + 1;
2. A(i-1) != B(j - 1), then pick the max between (i-1,j) ,  (i,j-1)  and (i, j )
Note: check[][] is initialized with all 0's. Index (0,0) is used as starting 0.
 */
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[][] check = new int[A.length()  + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    check[i][j] = check[i - 1][j - 1] + 1;
                } else {
                    check[i][j] = Math.max(check[i][j], check[i - 1][j]);
                    check[i][j] = Math.max(check[i][j], check[i][j - 1]);
                }
            }
        }
        return check[A.length()][B.length()];
    }
}
