package algosJava;

import java.util.HashMap;

import helpers.AssortedMethods;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Design a method to find the frequency of occurrences
 * of any given word in a book. What if we were running
 * this algorithm multiple times?
 * 
 * </br>
 *
 */

public class WordFrequencies {
	
	public static int wordFreq(String[] book, String word) {
		word = word.trim().toLowerCase();
		int count = 0;
		for(String w : book) {
			if (w.trim().toLowerCase().equals(word)) {
				count++;
			}
		}
		return count;
	}
	
	public static HashMap<String, Integer> setupDictionary(String[] book) {
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		for(String word : book) {
			word = word.trim().toLowerCase();
			if (word.trim() != "") {
				if (!table.containsKey(word)) {
					table.put(word, 0);
				}
				table.put(word, table.get(word) + 1);
			}
		}
		return table;
	}
	
	public static int getFrequency(HashMap<String, Integer> table, String word) {
		if (table == null || word == null) return -1;
		
		word = word.trim().toLowerCase();
		
		if (table.containsKey(word)) {
			return table.get(word);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
		
		HashMap<String, Integer> dictionary = setupDictionary(wordlist);
		
		String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
		for (String word : words) {
			System.out.println(word + ": " + getFrequency(dictionary, word));
		}
	}
}
