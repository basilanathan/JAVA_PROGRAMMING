package algosJava;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author basila
 * 
 * Problem: Write a method to compute all permutations of a string whose
 * characters are not necessarily unique. The list of permutations should not
 * have duplicates.
 *
 * Solution: HashTable, key: char, value count
 * 
 * p(a - 2| b - 4| c - 1) = {a + p(a - 1| b - 4| c - 1 )} + {b + p(a - 2| b - 3|
 * c - 1 )} + {c + p(a - 2| b - 4| c - 0 )}
 *
 */

public class PermutationsWithDups {
	//aabbbbc
	public static ArrayList<String> printPerms(String s) {
		ArrayList<String> result = new ArrayList<String>(); //result array
		HashMap<Character, Integer> map = buildFreqTable(s); //map
		printPerms(map, "", s.length(), result); //printPerm method
		return result;
	}

	private static HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : s.toCharArray()) { //a a b b b b c
			if (!map.containsKey(c)) {
				map.put(c, 0); 
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}
	
	public static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
		//base case permutation has been completed
		if(remaining == 0) {
			result.add(prefix);
			return;
		}
		
		//try remaining letters for next char. and generate remaining permutations
		for(Character c : map.keySet()) { // a a b b b b c
			int count = map.get(c); //1
			if (count > 0) {
				map.put(c, count - 1); // a -> 0
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c, count);
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "aabbbbc";
		ArrayList<String> result = printPerms(s);
		System.out.println("Count: " + result.size());
		for (String r : result) {
			System.out.println(r);
		}
	}

}
