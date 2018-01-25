package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

	For example,
	123 -> "One Hundred Twenty Three"
	12345 -> "Twelve Thousand Three Hundred Forty Five"
	1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Time: O(1) In the worst case scenario, when a number is greater than one billion, for example, 
 * the function helper is called a constant number of times
 */

public class IntegerToEnglishWords {
	
	private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public static String numberToWords(int num) {
    	
    		if(num== 0) return "Zero";
    		return helper(num);
    	
    }
    
    private static String helper(int num) {
    	
    		StringBuilder sBuilder = new StringBuilder();
	    	//String result = "";
    		
	    	if(num < 20) {
	    		
	    		sBuilder.append(LESS_THAN_20[num]);
	    		//result = LESS_THAN_20[num];
	    		
	    	} else if (num < 100)  {
	    		
	    		sBuilder.append(TENS[num/10] + " " + helper(num % 10));
	    		//result = TENS[num/10] + " " + helper(num % 10);
	    		
	    	} else if(num < 1000) {
	    		
	    		sBuilder.append(helper(num / 100) + " Hundred " + helper(num % 100));
	    		//result = helper(num / 100) + " Hundred " + helper(num % 100);
	    		
	    	} else if(num < 1000000) {
	    		
	    		sBuilder.append(helper(num / 1000) + " Thousand " + helper(num % 1000));
	    		//result = helper(num / 1000) + " Thousand " + helper(num % 1000);
	    		
	    	} else if (num < 1000000000) {
	    		
	    		sBuilder.append(helper(num / 1000000) + " Million " + helper(num % 1000000));
	        //result = helper(num / 1000000) + " Million " + helper(num % 1000000);
	    		
	    } else {
	    	
	    		sBuilder.append(helper(num / 1000000000) + " Billion " + helper(num % 1000000000));
	        //result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
	    		
	    }
	    	
	    	return sBuilder.toString().trim();
	    //return result.trim();
	    	
    }
    
    public static void main(String[] args) {
		System.out.println(numberToWords(1234800000));
	}
}
