package cci.moderate;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Factorial Zeros: Write an algorithm which computes the number of trailing
 * zeros in n factorial.
 * 
 *  
 * </br>
 *
 */

public class FactorialZeroes {
	
	public static int factorial(int num) {
		if(num == 1) {
			return 1;
		} else if (num > 1) {
			return num * factorial(num - 1);
		} else {
			return -1;
		}
	}
	
	public static int factorsOf5(int i) {
		int count = 0;
		while(i % 5 == 0) {
			count++;
			i = i / 5; //important
		}
		return count;
	}
	
	public static int countFactZeros(int num) {
		int count = 0;
		for(int i = 2; i <= num; i++) {
			count += factorsOf5(i);
		}
		return count;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
		}
	}

}
