package fb.glassdoor;

/*
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
	
	Example 1:
	Input: "aba"
	Output: True
	
	Example 2:
	Input: "abca"
	Output: True
	
	Explanation: You could delete the character 'c'.
	Note:
	The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * */

public class ValidPalindromeII {
	
    public boolean validPalindrome(String s) {
        char[] sc = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right){
          if(sc[left] != sc[right]){
            return helper(sc, left + 1, right) || helper(sc, left, right - 1);
          }
          left++;
          right--;
        }
          return true;
      }

      boolean helper(char[] sc, int left, int right){
         while(left < right){
           if(sc[left] != sc[right]) return false;
           left++; right--;
         }
        return true;
      }

}
