package fb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author basila
 * 
 * 
 * Given an array of strings, group anagrams together.
	
	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:
	
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
 * 
 * Time: O(N * s log s) n is the number of string in strs array and s is the maximum 
 * length of string in the strs array.
 *
 */

public class GroupAnagrams {
	//Solution one
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
	
    //solution two
	public static List<List<String>> groupAnagrams2(String[] strs) {
		if(strs == null || strs.length == 0) return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStor = String.valueOf(ca);
			
			if(!map.containsKey(keyStor))
				map.put(keyStor, new ArrayList<String>());
			
			map.get(keyStor).add(s);
		}
		for(String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	/*
	 * we know each word can be represented by their counter array which counts 
	 * every letter's occurrences, so we can use this counter array as an ID for 
	 * the anagram, more specifically, use this counter array's hash code as the 
	 * key, the anagram list as the value, we can distribute all the words into 
	 * corresponding anagram group in O(n) time complexity.
	 * 
	 */
	
	//solution 3 (unique ID, no sorting) 
	//Time O(mn)
	public static int getID(String s){
        int[] counter   =   new int[26];
        for(char ch : s.toCharArray()){
            counter[ch - 'a']++;
        }
        
        return Arrays.hashCode(counter);    //use the counter array's hash code as this anagram's ID
    }
    
    //solution takes 18ms
    public static List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> groups   =   new ArrayList<>();
        Map<Integer, List<String>> anagramMap   =   new HashMap<>();
        
        for(String word : strs){
            int id   =   getID(word);   //unique for each anagram
            List<String> group  =   anagramMap.get(id);
            
            if(null == group){
                group  =   new ArrayList();
                anagramMap.put(id, group);
           
            }
            
            group.add(word);
        }
        
        groups.addAll(anagramMap.values());
        
        return groups;
    }
    
    public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println("Not sorted:  " + groupAnagrams1(strs));
		System.out.println("Sorted : " + groupAnagrams2(strs));
		System.out.println("Array HashCode : " + groupAnagrams3(strs));

	}

}
