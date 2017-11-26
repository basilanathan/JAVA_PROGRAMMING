package cci.ch1;

/**
 * 
 * @author basila
 * @date 11/25/207
 * 
 * Time: O(N)
 * Space: O(1)
 *
 */

public class StringCompression {
	
	//driver method 
	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compress("abcdefghijklmno"));

	}
	
	public static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			count++;
			
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}
		//result = testCondition ? value1 : value2
		//if conpressed.length is less that str.length then return the compressed if not return original str
		return compressed.length() < str.length() ? compressed.toString() : str;
		
	}

}
