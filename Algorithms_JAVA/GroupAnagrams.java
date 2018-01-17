package algosJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import helpers.AssortedMethods;
import helpers.HashMapList;

public class GroupAnagrams {
	
	public class AnagramComparator implements Comparator<String> {
		private String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	
	public static void sort(String[] array) {
		HashMapList<String, String> mapList = new HashMapList<String, String>();
		
		//group words by anagram
		for(String s : array) {
			String key = sortChars(s);
			mapList.put(key, s);
		}
		
		//convert hash table into an array
		int index = 0;
		for(String key : mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);
			for(String t : list) {
				array[index] = t;
				index++;
			}
		}
	}

	private static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sort(array);
		System.out.println(AssortedMethods.stringArrayToString(array));
	}

}
