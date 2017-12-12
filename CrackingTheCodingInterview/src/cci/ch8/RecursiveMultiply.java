package cci.ch8;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Write a recursive function to multiple two positive 
 * integers, without using the * or / operator. You can
 * use addition, subtraction and bit shifting, but you should
 * minimize the number of those operations.
 * 
 * <br>
 * 
 * Time O(log s) s is the smaller of two numbers
 *
 */

public class RecursiveMultiply {
	
	/**
	 * Method to find the product of two numbers 
	 * 
	 * @param first
	 * @param second
	 * @return {@link int}
	 */
	public static int product(int a, int b) {
		/* Find the bigger and smaller number out of 2 */
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		/* Find there product */
		return findProduct(smaller, bigger);
	}

	/**
	 * Method to find product of two numbers
	 * 
	 * @param smaller
	 * @param bigger
	 * @return {@link int}
	 */
	private static int findProduct(int smaller, int bigger) {
		/* If smaller is 0, and we multiply, we get 0 */
		if (smaller == 0 || bigger == 0) return 0;
		/* If smaller is one, and we multiply, we get bigger number */
		if (smaller == 1) return bigger;
		if(bigger == 1) return smaller;
		/* Divide the smaller by 2 */
		int s = smaller >> 1;
		/* Get the product for that half */
		int halfProduct = findProduct(s, bigger);
		/* If there is no remainder, we know its twice of half product
		 * else, it's twice of half product and bigger number */
		if (smaller % 2 == 0) {
			return halfProduct + halfProduct;
		} else {
			return halfProduct + halfProduct + bigger;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findProduct(7, 8));
	}

}
