package cci.ch1;

public class StringCompression_B {
	
	//driver method
	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compress("aaaaabbbbaaaabbddc"));
		System.out.println(compress("abcdefghijklmno"));

	}
	
	public static String compress(String str) {
		//check the final length and return the input string if final length is longer
		int finalLength = countCompression(str);
		if(finalLength >= str.length()) return str;
		
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			//if next character is different than current append charAt(i) and countConsecutive to compressed
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	
	public static int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		
		for(int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			//if next character is diff than current increase length
			if( i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

}
