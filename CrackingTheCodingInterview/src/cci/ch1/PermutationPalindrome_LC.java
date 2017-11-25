package cci.ch1;

import java.util.HashMap;

/**
 * 
 * @author basila
 * Time complexity : O(n). We traverse over the given string ss with nn characters once. We also traverse over the mapmap which can grow upto a size of nn in case all characters in ss are distinct.
 * Space complexity : O(n). The hashmap can grow upto a size of nn, in case all the characters in ss are distinct.
 *
 *https://leetcode.com/articles/palindrome-permutation/
 */

public class PermutationPalindrome_LC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pali = "rats live on no evil star";
		System.out.println(canPermutePalindrome(pali));

	}
	
	//(character​i, numberofoccurencesofcharacteri).
	 public static boolean canPermutePalindrome(String s) {
	     HashMap < Character, Integer > map = new HashMap < > ();
	     for (int i = 0; i < s.length(); i++) {
	         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
	     }
	     int count = 0;
	     for (char key: map.keySet()) {
	         count = count + map.get(key) % 2;
	     }
	     return count <= 1;
	 }
	
//    public static boolean canPermutePalindrome(String s) {
//        int[] map = new int[128];
//        for (int i = 0; i < s.length(); i++) {
//            map[s.charAt(i)]++;
//        }
//        int count = 0;
//        for (int key = 0; key < map.length && count <= 1; key++) {
//            count += map[key] % 2;
//        }
//        return count <= 1;
//    }

}
