package cci.ch8;

import java.util.ArrayList;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Permutations without Dups: write a method
 * to compute all permutations of a string unique 
 * characters.
 * 
 * <br>
 *
 */

public class PermutationsWithoutDups {
	
	public static ArrayList<String> getPerms(String remainder) {
		//a b c
		int len = remainder.length(); //3
		ArrayList<String> result = new ArrayList<String>();
		
		if (len == 0) {
			result.add(""); // Be sure to return empty string!
			return result;
		}
		
		for(int i = 0; i < len; i++) {
			/* Remove char i and find permutations of remaining characters.*/
			String before = remainder.substring(0, i); //a
			String after = remainder.substring(i + 1, len); //bc
			ArrayList<String> partials = getPerms(before + after); //bc and cb
			
			//prepend char i to each permutation
			for(String s : partials) {
				result.add(remainder.charAt(i) + s); //abc, acb
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
