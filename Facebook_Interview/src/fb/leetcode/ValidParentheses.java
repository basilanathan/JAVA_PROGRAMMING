package fb.leetcode;

import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	
	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) //check if odd
            return false;
        
        Stack<Character> stack = new Stack<Character>();
      //"(, {, [, ], }, )"
        for(char c : s.toCharArray()) { //read each charachter in the string
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

}

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
}
