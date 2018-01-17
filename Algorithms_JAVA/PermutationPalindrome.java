package algosJava;

/**
 * 
 * @author basila
 * @date 11/24/2017
 * 
 * Time O(N) where n is the length of the string
 */

public class PermutationPalindrome {
	
	//driver method
	public static void main(String[] args) {
		String pali = "rats live on no evil star";
		System.out.println(isPalindrome(pali));
	}
	
	public static boolean isPalindrome(String phrase) {
		int[] table = buildCharTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	//check that no more than one character has an odd count
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for(int count : table) {
			if(count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	//map each character to a number a -> 0, b -> 1, c ->2, etc
	//non letter characters map to -1
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z) {
			return val - a;
		}
		return - 1;
	}
	//count how many times each character appears. 
	public static int[] buildCharTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	

}
