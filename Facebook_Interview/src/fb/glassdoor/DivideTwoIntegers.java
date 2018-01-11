package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Division of two numbers is a repeated subtraction of dividend and divisor till the 
 * dividend becomes less than the divisor.
 * 
 * In every step,
 * the divisor is subtracted from the remainder of previous step.
 * the remainder of the subtraction is treated as the dividend of the next step.
 * These steps are carried out till the difference of any step(or dividend of next step) 
 * becomes less than the divisor. At the end, the digit which is left finally is the remainder 
 * and the number of steps carried out is the quotient
 * It can be observed that in all steps the divisor(or the number which is subtracted) remains the same, 
 * only the dividend keeps on changing.
 * 
 * 
 * For Example, if 13 is divided by 4, then according to above logic, the division would consist of following steps:

	13 – 4 = 9
	9 – 4 = 5
	5 – 4 = 1
 *
 *
 *	https://leetcode.com/problems/divide-two-integers/discuss/13397
 */

//ONLY WORKS FOR POSITIVE NUMBERS

public class DivideTwoIntegers {
	
	public void divide(int dividend, int divisor) {
		int quotient = 0;
		while(dividend >= divisor) {
			dividend = dividend - divisor;
			quotient++;
		}
		
		System.out.println("Quotient: " + quotient);
		System.out.println("Remainder: " + dividend);
	}
	
	/*
	 * 8 / 2 = 4
	 * sum = 2 multiple = 1
	 * sum = 4 multiple = 2 + divideOpt(4/2)
	 * 							sum = 2 multiple = 1 + divideOpt(2/2)
	 * 													sum = 2 multiple = 1 + divideOpt(0/2)
	 * 																				return 0;
	 * 
	 * 
	 * */
	//Time: O(logN)
	//Space: O(logN)
	
	//HANDLES POSITIVE AND NEGATIVE NUMBERS!!!
	// if asked to use this solution go to https://leetcode.com/problems/divide-two-integers/discuss/13397
    public int divideOpt(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
                //8 / -2                  ||      -8 / 2 -> SING = -1
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) 
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE; // 8 / 0 -> Integer.MAX_VALUE
        
        //   0 / 2           ||     8 / 10  -> RETURN 0
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0; 

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans); //IMPORTANT
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend), 
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

	public static void main(String[] args) {
		DivideTwoIntegers test = new DivideTwoIntegers();
		
		test.divide(10, 3);
		System.out.println("Optimized: " + test.divideOpt(-9, 2));
	}

}
