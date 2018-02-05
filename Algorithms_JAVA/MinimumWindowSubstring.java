package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * 1. Use two pointers: start and end to represent a window.
	2. Move end to find a valid window.
	3. When a valid window is found, move start to find a smaller window.
	To check if a window is valid, we use a map to store (char, count) for chars in t. 
	And use counter for the number of chars of t to be found in s. The key part is map[c1]--;. 
	We decrease count for each char in s. If it does not exist in t, the count will be negative.
 *	
 *	Time: O(N)
 *	Space: O(N)
 */

public class MinimumWindowSubstring {
	//solution 1 using hash map
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap();
        for(char c : s.toCharArray())
            map.put(c,0);
        
        // Statistic for count of char in t
        for(char c : t.toCharArray())
        {
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                return "";
        }
        // counter represents the number of chars of t to be found in s.
        int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
        // Move end to find a valid window.
        while(end < s.length())
        {
            // If char in s exists in t, decrease counter
            char c1 = s.charAt(end);
            if(map.get(c1) > 0)
                counter--;
            map.put(c1,map.get(c1)-1); //If char does not exist in t,  will be negative.

            end++;
            
            //// When we found a valid window, move start to find smaller window.
            while(counter == 0)
            {
                if(minLen > end-start)
                {
                    minLen = end-start;
                    minStart = start;
                }

                // When char exists in t, increase counter.
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2)+1);

                if(map.get(c2) > 0)
                    counter++;

                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    }
    
    //solution 2
	
	  public String minWindow(String s, String t) {
		    int [] map = new int[128];
		    //statistic for count of char in t
		    for (char c : t.toCharArray()) {
		      map[c]++;
		    }
		    //counter represents the number of chars of t to be found in s
		    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
		    //move end to find a valid window
		    while (end < s.length()) {
		      final char c1 = s.charAt(end);
		      //if char in s exists in t, decreaese the counter
		      if (map[c1] > 0) counter--;
		      //if char doesn't exist in t then this will turn negative
		      map[c1]--;
		      end++;
		      //when we find a valid window, move start to find smaller window
		      while (counter == 0) {
		        if (minLen > end - start) {
		          minLen = end - start;
		          minStart = start;
		        }
		        final char c2 = s.charAt(start);
		        map[c2]++;
		        //if char exists in t increase counter
		        if (map[c2] > 0) counter++;
		        start++;
		      }
		    }

		    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
		  }
	  
	  public static void main(String[] args) {
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		System.out.println(test.minWindow(s, t));
	}

}
