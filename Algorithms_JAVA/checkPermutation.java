package algosJava;

/**
 * 
 * @author basila nathan
 * @date 11/24/2017
 * 
 * Time O(N)
 *
 */

//is the permutation analysis case sensitive
//is whitespace significant 
//strings of different legths cannot be permutations of each other

public class checkPermutation {
	//driver method
	public static void main(String[] args) {
		
		String [][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for(String [] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean perms = permutation(word1, word2);
			System.out.println(word1 + " " + word2 + ": " + perms);
		}
		
	}
	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean permutation(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

}
