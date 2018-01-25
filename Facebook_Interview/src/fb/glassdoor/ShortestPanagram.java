package fb.glassdoor;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author basila
 * 
 * Find the shortest pangram in a sentence?
 * It is a typical sliding window algorithm on which many string problems are based.
 * 
 * https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
 *
 */

public class ShortestPanagram {
	
	   String shortestPangram(String s, Map dict) {
	        if(dict.isEmpty()) return ""; //check if dict is empty
	        Map letters = new HashMap<>();
	        int size = dict.size();
	        String minPangram = null;
	        int l = 0, r = 0;
	        while(r < s.length()) {
	            char c = s.charAt(r);
	            if(dict.containsKey(c)) { //if dict has the character
	                letters.put(c, letters.getOrDefault(c, 0) + 1); //put the letter in hashmap
	                if(letters.get(c) == dict.get(c)) { //reduce the size of dict
	                    size--;
	                    if(size == 0) {
	                        while(size == 0 || !dict.containsKey(s.charAt(l))) {
	                            if (size == 0 && (minPangram == null || r - l + 1 < minPangram.length())) {
	                                minPangram = s.substring(l, r + 1);
	                            }
	                            char discard = s.charAt(l);
	                            if(dict.containsKey(discard)) {
	                                letters.put(discard, letters.get(discard) + 1);
	                                if(letters.get(discard) < dict.get(discard)) {
	                                    size++;
	                                }
	                            }
	                            l++;
	                        }
	                    }
	                }
	            }
	            r++;
	        }
	        return minPangram;
	    }

}
