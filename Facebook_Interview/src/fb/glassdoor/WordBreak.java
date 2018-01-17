package fb.glassdoor;

import java.util.Arrays;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	For example, given s = "leetcode", dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
 *
 *the complexity
	Time O (N ^ 2) Space O (N)
	
	Ideas
	If a word exists in a decomposition method, each piece in the dictionary after decomposition is 
	bound to meet the following conditions: For the last division point of the word, the string from 
	the division point to the end of the word is a word, and The string from the beginning of this 
	division to the beginning of the word is also decomposable. So as long as the validation satisfies 
	this condition, we can be sure that this longer string is also decomposable.
	
	Therefore, we use the outer loop to control the length of the string to be verified, 
	and the inner loop to find such a split point, the string can be divided into a word 
	and a sub-substring can also be resolved. At the same time, we use an array to record 
	the decomposition of the string length increases as the case for later use to avoid double counting.
 */

public class WordBreak {
	
	/* given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * length = 8
	 * l e e t c o d e
	 * 0 1 2 3 4 5 6 7 8 
	 * t f f f t f f f t
	 * 
	 * 
	 * */
	
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[s.length()]=true;

     // outer loop increment length
        for(int i = s.length()-1; i >=0 ; i--){

        	// inner loop to find the split point
            for(int j = i; j < s.length(); j++){
                String sub = s.substring(i,j+1);
                if(wordDict.contains(sub) && dp[j+1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
