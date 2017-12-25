package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
	
	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth term of the count-and-say sequence.
	
	Note: Each term of the sequence of integers will be represented as a string.
	
	Example 1:
	
	Input: 1
	Output: "1"
	Example 2:
	
	Input: 4
	Output: "1211"
	
 * Time: O(N ^ N) have to at least generate every solution from n = 1 to n = n, which is O(n) for each case.
 */

public class CountAndSay {
	
	//SOLUTION 1
	public static String countAndSay(int n) {
		String result = "1";
		
		for(int i = 1; i < n; i++) {
			result = build(result);
		}
		return result;
	}

	private static String build(String result) {
		StringBuilder sBuilder = new StringBuilder();
		
		char c = result.charAt(0); //2
		int count = 1;
		
		for(int i = 1; i < result.length(); i++) {
			if(result.charAt(i) == c) count++;
			
			else {
				sBuilder.append(count); //1 2
				sBuilder.append(c);
				c = result.charAt(i); //1
				count = 1;
			}
		}
		
		sBuilder.append(count); //1 2 1 1
		sBuilder.append(c);
		return sBuilder.toString();
	}
	
	//SOLUTION 2
    public static String countAndSay2(int n) {
        if(n <= 0) return "-1";
        String result = "1";
        
        for(int i = 1; i < n; i ++) {
            result = build2(result);
        }
        return result;
    }
    
    private static String build2(String result) {
        StringBuilder builder = new StringBuilder();
        int p = 0;
        while(p < result.length()) {
            char val = result.charAt(p);
            int count = 0;
            
            while(p < result.length() && 
              result.charAt(p) == val){
                p ++;
                count ++;
            }
            builder.append(String.valueOf(count));
            builder.append(val);
        }
        return builder.toString();
    }
    
    //SOLUTION 3
    public static String countAndSay3(int n) {
        String result = "1";
        for (int outer = 1; outer < n; outer++) {
            String previous = result;
            result = "";
            int count = 1;
            char say = previous.charAt(0);

            for (int i = 1; i < previous.length(); i++) {
                if (previous.charAt(i) != say) {
                    result = result + count + say;
                    count = 1;
                    say = previous.charAt(i);
                } else count++;
            }
            result = result + count + say;
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
		//System.out.println(countAndSay2(5));
		//System.out.println(countAndSay3(5));
	}

}
