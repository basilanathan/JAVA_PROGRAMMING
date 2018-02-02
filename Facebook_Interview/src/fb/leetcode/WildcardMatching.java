package fb.leetcode;

/**
 * 
 * @author basila
 *
 */

/*
 * Thougts:
 * 1. dp[i][j] = dp[i - 1][j - 1] if str[i] == pattern[j] or pattern[j] == "?"
 * 2. dp[i][j] = dp[i-1][j] || dp[i][j-1] if pattern[j] == *
 * 3. else dp[i][j] == fasle;
 * 
 * */
//https://www.youtube.com/watch?v=3ZDZ-N0EPV0
//https://leetcode.com/problems/wildcard-matching/discuss/

public class WildcardMatching {
	
	//Time: O(M * N)
	//Space: O(M * N)
	
    public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true; // string and pattern are null so set to true
		
		for (int i = 1; i <= m; i++) {
			dp[i][0] = false; //pattern is null string and string is x -> there is no match so set the whole column to false
		}
		
		for(int j = 1; j <= n; j++) {
			if(p.charAt(j-1) == '*'){
				dp[0][j] = true; //true only when there is a star because star can represent an empty string
			} else {
				break;
			}
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if (p.charAt(j-1) != '*') {
					dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?');
				} else {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[m][n];
	}
    
    //second solution 
    //Time O(N)
    
    /*
     * Loop
	
	keep two pointers in S and P here i and j
	
	if S[i] == P[j] or P[j] == '?' we keep moving
	
	if '*' exist in P then we mark the position in P as star and mark position in s as s_star
	
	Loop over s until S[i] == P[star + 1]
	otherwise
	False
	
	note that S = 'a' P = 'a*******' is still True
	So we need to loop over P to check this case
	
	if we can compare p to the end that means True
     * 
     * */
    boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
}

}
