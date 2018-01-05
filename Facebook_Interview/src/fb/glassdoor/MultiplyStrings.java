package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
	
	Note:
	
	The length of both num1 and num2 is < 110.
	Both num1 and num2 contains only digits 0-9.
	Both num1 and num2 does not contain any leading zero.
	You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * Time Complexity : O(m*n), where m and n are length of two number that need to be multiplied.
 * 
 * 
 *	https://leetcode.com/problems/multiply-strings/description/
 */

public class MultiplyStrings {
	
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) return "0";
		int n1 = num1.length();
		int n2 = num2.length();
		
		int[] answer = new int[n1 + n2];
		
		for(int i = n1 -1; i >=0; i--) {
			for(int j = n2 - 1; j >=0; j--) {
				answer[i + j + 1] += (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
			}
		}
		int carry = 0;
		StringBuilder sBuilder = new StringBuilder();
		for(int i = answer.length - 1; i >= 0; i--) {
			int temp = answer[i] + carry;
			sBuilder.append(temp % 10);
			carry = temp / 10;
		}
		sBuilder.reverse();
		while(sBuilder.charAt(0) == '0') sBuilder.deleteCharAt(0);
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		MultiplyStrings test = new MultiplyStrings();
		String num1 = "0000654154154151454545415415454";
		String num2 = "635165615631563165451451465146540000";
		System.out.println(test.multiply(num1, num2));
	}

}
