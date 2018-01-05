package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Time: O(N)
 * Space: O(N)
 *
 */

public class LongestSubstring2DistinctCharacters {
	
	public int lengthOfLongestSubstringTwoDistinct(String s) {
	    int[] map = new int[128];
	    int start = 0, end = 0, maxLen = 0, counter = 0;

	    while (end < s.length()) {
	      final char c1 = s.charAt(end);
	      if (map[c1] == 0) counter++;
	      map[c1]++;
	      end++;

	      while (counter > 2) {
	        final char c2 = s.charAt(start);
	        if (map[c2] == 1) counter--;
	        map[c2]--;
	        start++;
	      }

	      maxLen = Math.max(maxLen, end - start);
	    }

	    return maxLen;
	  }
	
	public static void main(String[] args) {
		LongestSubstring2DistinctCharacters test = new LongestSubstring2DistinctCharacters();
		
		String s = "eceba"; //output: "ece" -> 3
		System.out.println(test.lengthOfLongestSubstringTwoDistinct(s));
	}

}
