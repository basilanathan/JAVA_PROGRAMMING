package cci.ch1;

/**
 * @author basila nathan
 * @date 11/24/2017
 * 
 * Time: O(n) where n is the length of the string
 * Space: O(1)
 *
 */

//ask interviewer if the string is an ASCII string or a Unicode string
public class isUnique {
	
	//driver method
	public static void main(String[] args) {
		String[] words = { "abcde", "hello", "apple", "kite", "padle"};
		for(String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
		
	}
	
	public static boolean isUniqueChars(String str) {
		if(str.length() > 128) { //immediately return false if the string is greater than 128
			return false;
		}
		
		boolean[] char_set = new boolean[128]; //create an array of boolean values
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		
		return true;
	}


}
