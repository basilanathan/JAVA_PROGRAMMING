package algosJava;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Number Max: Write a method that finds the maximum of two numbers. You should
 * not use if-else or any other comparison operator.
 * 
 * </br>
 *
 */

public class NumberMax {
	
	/* Flips a 1 to a 0 and a 0 to a 1 */
	public static int flip(int bit) {
		return 1 ^ bit;
	}	
	
	/* Returns 1 if a is positive, and 0 if a is negative */
	public static int sign(int a) {
		return flip((a >> 31) & 0x1);
	}
	
	public static int getMaxNaive(int a, int b) {
		int k = sign(a - b);
		int q = flip(k);
		return a * k + b * q;
	}
	
	public static int getMax(int a, int b) {
		int c = a - b;
		
		int sa = sign(a); // if a >= 0, then 1 else 0
		int sb = sign(b); // if b >= 0, then 1 else 0
		int sc = sign(c); // depends on whether or not a - b overflows
		
		/* We want to define a value k which is 1 if a > b and 0 if a < b. 
		 * (if a = b, it doesn't matter what value k is) */
		
		int use_sign_of_a = sa ^ sb; // If a and b have different signs, then k = sign(a)
		int use_sign_of_c = flip(sa ^ sb); // If a and b have the same sign, then k = sign(a - b)
		
		/* We can't use a comparison operator, but we can multiply values by 1 or 0 */
		int k = use_sign_of_a * sa + use_sign_of_c * sc;
		int q = flip(k); // opposite of k
		
		return a * k + b * q;
	}
	
	public static int MaxInteger(int a, int b) {
		int c = a-b;
		
		// get signs of a,b and c
		/* Returns 1 if a is positive, and 0 if a is negative */
		int sa = (a>>31) & 0x1;
		int sb = (b>>31) & 0x1;
		int sc = (c>>31) & 0x1;
		 
		int use_sign_a = sa ^ sb; // check if sign of ‘a’ and ‘b’ are different or not
		int use_sign_c = use_sign_a ^ 0x1; // If a, b have diff signs, use sign of ‘c’
		 
		 // The below expression selects either sign of a or sign of c, given that use_sign_a and use_sign_b are kind of complements.
		int k = use_sign_a * sa + use_sign_c * sc;
		 
		return a * (k^1) + b * k;
	}
	
	public static void main(String[] args) {
		int a = 26;
		int b = -15;
		
		System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));		
		
		a = -15;
		b = 2147483647;
		
		System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
	}

}
