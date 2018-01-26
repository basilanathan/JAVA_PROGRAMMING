package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Given two binary strings, return their sum (also a binary string).
 *	For example,
 *	a = "11"
 *	b = "1"
 *	Return "100".
 *
 *https://www.youtube.com/watch?v=jB_sRh5yoZk
 *http://web.math.princeton.edu/math_alive/1/Lab1/BinAdd.html
 *
 *Time : O(N + M)
 *
 */

//The idea is to start from last characters of two strings and compute digit sum 
//one by one. If sum becomes more than 1, then store carry for next digits.

/*
 * when you add 1 and 1; the result is two (as always), but since two is written as 10 in binary, we get, after summing 1 + 1 in binary, a digit 0 and a carry of 1.
	
	Therefore in binary:
	0 + 0 = 0
	0 + 1 = 1
	1 + 0 = 1
	1 + 1 = 10 (which is 0 carry 1)
	Example. Suppose we would like to add two binary numbers 10 and 11. We start from the 
	last digit. Adding 0 and 1, we get 1 (no carry). That means the last digit of the answer 
	will be one. Then we move one digit to the left: adding 1 and 1 we get 10. Hence, 
	the answer is 101.

 * */

public class AddBinary {
    public String addBinary(String a, String b) {
        
        StringBuilder result = new StringBuilder();
        
        int carry = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while(i >= 0 || j >= 0) {
            
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
            
        }
        
        if(carry != 0) result.append(carry);
        return result.reverse().toString();
        
    }

}

/*
//Thougths:
1. Turn string binary format into integer
2. add integer
3. turn integer into binary string
Note: this just test if we know how to manipulate string/binary/Integer
*/

public class Solution {
  /**
   * @param a a number
   * @param b a number
   * @return the result
   */
  public String addBinary(String a, String b) {
      if (a == null || b == null || a.length() == 0 || b.length() == 0) {
          return null;
      }
      int decimalA = Integer.parseInt(a, 2);
      int decimalB = Integer.parseInt(b, 2);
      
      int sum = decimalA + decimalB;
      
      return Integer.toBinaryString(sum);
  }
}
