package fb.glassdoor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * Running output of string "abcd":
	
	Step 1: Merge [a] and b: [ba, ab]
	
	Step 2: Merge [ba, ab] and c: [cba, bca, bac, cab, acb, abc]
	
	Step 3: Merge [cba, bca, bac, cab, acb, abc] and d: [dcba, cdba, cbda, cbad, dbca, bdca, bcda, bcad, 
	dbac, bdac, badc, bacd, dcab, cdab, cadb, cabd, dacb, adcb, acdb, acbd, dabc, adbc, abdc, abcd]
 *
 * Page (71) in Cracking the Coding Interview Book, 6th Edition.	
 * https://stackoverflow.com/questions/27553704/complexity-of-printing-string-permutations
 * http://javabypatel.blogspot.in/2015/08/program-to-print-permutations-of-string-without-repetition.html
 * 
 * Time: O(N * N!)
 */

public class StringPermutation {
	
	/**
	 * List permutation of a string
	 * 
	 * @param s the input string
	 * @return  the list of permutation
	 */
	public static ArrayList<String> permutation(String s) {
	    // The result
	    ArrayList<String> res = new ArrayList<String>();
	    // If input string's length is 1, return {s}
	    if (s.length() == 1) {
	        res.add(s);
	    } else if (s.length() > 1) {
	        int lastIndex = s.length() - 1;
	        // Find out the last character
	        String last = s.substring(lastIndex);
	        // Rest of the string
	        String rest = s.substring(0, lastIndex);
	        // Perform permutation on the rest string and
	        // merge with the last character
	        res = merge(permutation(rest), last);
	    }
	    return res;
	}
	
	/*
	 * a b c lastIndex = 2
	 * last = c
	 * rest = a b
	 * merge(permutation(a b), c)
	 * 
	 * 		a b lastIndex = 1
	 * 		last = b
	 * 		rest = a
	 * 		merge(permutation(a), b)
	 * 
	 * 			res = {a}
	 * 				merge({a}, b)
	 * 				{ab, ba}
	 * 
	 * 		merge({ab, ba}, c)
	 * 		{cab, acb, abc, cba, bca, bac}
	 * 				
	 * 
	 * */

	/**
	 * @param list a result of permutation, e.g. {"ab", "ba"}
	 * @param c    the last character
	 * @return     a merged new list, e.g. {"cab", "acb" ... }
	 */
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
	    ArrayList<String> res = new ArrayList<String>();
	    // Loop through all the string in the list
	    for (String s : list) {
	        // For each string, insert the last character to all possible postions
	        // and add them to the new list
	        for (int i = 0; i <= s.length(); ++i) {
	        	//at position i insert c
	            String ps = new StringBuffer(s).insert(i, c).toString(); // ba ab //cab, acb, abc
	            																	//cba, bca, bac
	            
	            res.add(ps); //ba ab //cab, acb, abc
	            						//cba, bca, bac
	        }
	    }
	    return res;
	}
	
	//Java implementation without recursion
	
	public Set<String> permutate(String s){
	    Queue<String> permutations = new LinkedList<String>();
	    Set<String> v = new HashSet<String>();
	    permutations.add(s);

	    while(permutations.size()!=0){
	        String str = permutations.poll();
	        if(!v.contains(str)){
	            v.add(str);
	            for(int i = 0;i<str.length();i++){
	                String c = String.valueOf(str.charAt(i));
	                permutations.add(str.substring(i+1) + c +  str.substring(0,i));
	            }
	        }
	    }
	    return v;
	}
	
	public static void main(String[] args) {
		StringPermutation test = new StringPermutation();
		String string = "abcd";
		System.out.println(test.permutate(string));
		System.out.println(test.permutation(string));
	}

}
