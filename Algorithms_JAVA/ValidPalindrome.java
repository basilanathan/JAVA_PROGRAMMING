package fb.glassdoor;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Example
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
Challenge
O(n) time without extra memory.
Company： Microsoft Uber Facebook Zenefits
Hide Tags Two Pointers String
Hide Similar Problems (E) Palindrome Linked List
*/

public class ValidPalindrome {
	//using isLetterOrDigit
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--])) 
                return false;
        }
        return true;
    }

}

/*
recap:
Use regular expression [^a-zA-Z0-9] to replace all non-alphanumeric chars with ""
*/
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        final String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/*
3.4.2016 recap
Filter the String first, then check Palindrome
But uses extra space to filter the string. Can also just manipulate string on itself. no big deal
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        StringBuffer sb = new StringBuffer();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c <= 'z' && c >= 'a') || (c >= '0' && c <= '9')) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
