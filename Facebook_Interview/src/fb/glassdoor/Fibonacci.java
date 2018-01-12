package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Find the Nth number in Fibonacci sequence.
	A Fibonacci sequence is defined as follow:
	The first two numbers are 0 and 1.
	The i th number is the sum of i-1 th number and i-2 th number.
	The first ten numbers in Fibonacci sequence is:
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
	Example
	Given 1, return 0
	Given 2, return 1
	Given 10, return 34
	Note
	The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
 * 
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 */

public class Fibonacci {
	
	/*
	 * storing the previous two numbers only because that is all we need to get the next 
	 * Fibonacci number in series. SPACE OPTIMIZATION
	 * 
	 * Time: O(N)
	 * Space: O(N)
	 * */
	
    public int fibonacci(int n) {
        if (n <= 1) {
            return 0;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i < n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
    
    /*
    Thoughts:
    Bottomup with for loop.
    1. If non-recursion, do for loop for that n
    2. Note: this specfiic problem is not 0-based. it's 1-based.
    3. return fib[n]
    
    Method 2 ( Use Dynamic Programming )
    We can avoid the repeated work by storing the Fibonacci numbers calculated so far.
    
    * Time: O(N)
    * Space: O(N)
    */
    
    public int fibonacci2(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }
    
    /*
     * Recursion
     * Time: T(n) = T(n-1) + T(n-2) 
     * Space: O(N)
     * */
    
    public int fibonacci3(int n) {
        if (n <= 1) {
            return 0;
        } 
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
