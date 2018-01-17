package algosJava;

/**
 * 
 * @author basila
 * @date 11/24/2017
 * 
 * Time O(N)
 */

public class CheckPermutation_B {
	//driver method
	public static void main(String[] args) {
		
		String [][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "ldeoh"}};
		for(String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			
			boolean perms = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + perms);
		}
		
	}
	
	public static boolean permutation(String s, String t) {
		if(s.length() != t.length()) return false;
		
		int[] letters = new int[128];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++; //go through all the characters and incremenent each value of array to one
		}
		
		for(int i = 0; i < t.length(); i++) {
			letters[t.charAt(i)]--; //go through all the characters decrement id the value is allready there
			if(letters[t.charAt(i)] < 0) { //if there are negative numbers then then string contains values that are not present in the first string
				return false; //contains a letter not in the first string
			}
		}
		return true; //letters array contains no negative values
	}

}
