package algosJava;

import java.math.BigDecimal;

public class StringRotation {
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
	
	public static boolean isSubstring(String big, String small) {
		if(big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		//check is s1 and s2 are equal length and are not empty
		if(len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}

}
