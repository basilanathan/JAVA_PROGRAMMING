package cci.moderate;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Write a program to swap two numbers in place.
 * i.e You cannot use temporary variables
 * 
 * </br>
 *
 */

public class NumberSwapper {
	
	public static void swap(int a, int b) {
		//swap a = 9, b == 4
		
		a = a - b; //diff = 5
		b = a + b; // 5 + 4 = 9
		a = b - a; //(a + b) - a = 9 - 5 = 4
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	public static void main(String[] args) {
		int a = 167432;
		int b = 933339;
		
		swap(a, b);
		
	}

}
