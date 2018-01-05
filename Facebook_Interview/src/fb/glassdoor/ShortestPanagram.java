package fb.glassdoor;

import java.util.HashMap;
import java.util.Map;

public class ShortestPanagram {
	
	   String shortestPangram(String s, Map dict) {
	        if(dict.isEmpty()) return "";
	        Map letters = new HashMap<>();
	        int size = dict.size();
	        String minPangram = null;
	        int l = 0, r = 0;
	        while(r < s.length()) {
	            char c = s.charAt(r);
	            if(dict.containsKey(c)) {
	                letters.put(c, letters.getOrDefault(c, 0) + 1);
	                if(letters.get(c) == dict.get(c)) {
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
