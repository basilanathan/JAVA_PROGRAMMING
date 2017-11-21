package fb.multiplystring;

/**
* Date 11/20/2017
* @author Basila Nathan
* 
* Time Complexity : O(m*n), where m and n are length of two number that need to be multiplied.
* 
* Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
* Note:
* The length of both num1 and num2 is < 110.
* Both num1 and num2 contains only digits 0-9.
* Both num1 and num2 does not contain any leading zero.
* You must not use any built-in BigInteger library or convert the inputs to integer directly.
* 
*/

public class Solution {
	public static void main(String[] args) {
		Solution mult = new Solution();
		
		String num1 = "1235421415454545454545454544";
		String num2 = "1714546546546545454544548544544545";
		
		String result = mult.multiply(num1, num2);
		System.out.println(result);
		
	}
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0"; //base case
        int n1 = num1.length(); //length of string 1
        int n2 = num2.length(); //length of string 2
        int[] products = new int[n1 + n2]; //length of product array
        for (int i = n1 - 1; i>= 0; i--) { //working backwards
            for (int j = n2 - 1; j >= 0; j--) {
                products[i + j + 1] += ((int)num1.charAt(i) - '0')*((int)num2.charAt(j) - '0');
            }
        }
        int digit = 0;
        StringBuilder sb = new StringBuilder();
        // can be i = products.length - 1
        for (int i = n1 + n2 - 1; i >= 0; i--) {
            int tmp = products[i] + digit;
            sb.append(tmp % 10); //store result
            digit = tmp / 10; //carry for next iteration
        }
        sb.reverse();
        if (sb.charAt(0) == '0') sb.deleteCharAt(0); //delete the zero at the end
        return sb.toString();
    }

}
