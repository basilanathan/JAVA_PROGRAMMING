package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
 *
 */

//https://discuss.leetcode.com/category/73/valid-number

public class ValidNumber {
	
    public boolean isNumber(String s) {
        if (s == null) return false;
        
        s = s.trim();
        int n = s.length();
        
        if (n == 0) return false;
        
        // flags
        int signCount = 0;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasPoint = false;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            // invalid character
            if (!isValid(c)) return false;
            
            // digit is always fine
            if (c >= '0' && c <= '9') hasNum = true;
            
            // e or E
            if (c == 'e' || c == 'E') {
                // e cannot appear twice and digits must be in front of it
                if (hasE || !hasNum) return false; //if there already is an e and no numbers in front
                // e cannot be the last one
                if (i == n - 1) return false;
                
                hasE = true;
            }
            
            // decimal place
            if (c == '.') {
                // . cannot appear twice and it cannot appear after e
                if (hasPoint || hasE) return false;
                // if . is the last one, digits must be in front of it, e.g. "7."
                if (i == n - 1 && !hasNum) return false;
                
                hasPoint = true;
            }
            
            // signs
            if (c == '+' || c == '-') {
                // no more than 2 signs
                if (signCount == 2) return false;
                // sign cannot be the last one
                if (i == n - 1) return false;
                // sign can appear in the middle only when e appears in front
                if (i > 0 && !hasE) return false;
                
                signCount++;
            }
        }
        
        return true;
    }
    
    //return true if the charchter is ., +, -, e, E, 0 - 9
    boolean isValid(char c) {
        return c == '.' || c == '+' || c == '-' || c == 'e' || c == 'E' || c >= '0' && c <= '9';
    }

}
/*
 * The idea is pretty straightforward. A valid number is composed of the significand and the exponent (which is optional). As we go through the string, do the following things one by one:
	
	skip the leading whitespaces;
	check if the significand is valid. To do so, simply skip the leading sign and count the number of digits and the number of points. A valid significand has no more than one point and at least one digit.
	check if the exponent part is valid. We do this if the significand is followed by ‘e’. Simply skip the leading sign and count the number of digits. A valid exponent contain at least one digit.
	skip the trailing whitespaces. We must reach the ending 0 if the string is a valid number.
 * 
 * https://leetcode.com/problems/valid-number/discuss/23762
 * */
public class Solution {
    public boolean isNumber(String s) {
    	char[] c=s.trim().toCharArray();

        if (c.length==0) return false;

        int i=0,num=0;
        if (c[i]=='+'||c[i]=='-') i++;

        for(;i<c.length&&(c[i]>='0'&&c[i]<='9');i++) num++;
        if (i<c.length&&c[i]=='.')i++;
        for(;i<c.length&&(c[i]>='0'&&c[i]<='9');i++) num++;

        if (num==0) return false;

        if (i==c.length) return true;
        else if (i<c.length&&c[i]!='e') return false;
        else i++;

        num=0;
        if (i<c.length&&(c[i]=='+'||c[i]=='-')) i++;

        for(;i<c.length&&(c[i]>='0'&&c[i]<='9');i++) num++;
        if (num==0) return false;

        if (i==c.length) return true;
        else return false;
    }
}
