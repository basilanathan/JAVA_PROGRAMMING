package cci.moderate;

import helpers.AssortedMethods;

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
	
	public static void main(String[] args) {
		String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
		
		String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
		for (String word : words) {
			System.out.println(word + ": " + wordFreq(wordlist, word));
		}
	}
}
