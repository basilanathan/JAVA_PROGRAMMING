package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Method 1 (Brute Force) 
	If the length of string is n, then there can be n*(n+1)/2 possible substrings. 
	A simple way is to generate all the substring and check each one whether it has 
	exactly k unique characters or not. If we apply this brute force, it would take 
	O(n2) to generate all substrings and O(n) to do a check on each one. 
	Thus overall it would go O(n3).
	
	We can further improve this solution by creating a hash table and while generating 
	the substrings, check the number of unique characters using that hash table. 
	Thus it would improve up to O(n2).
	
	Method 2 (Linear Time) 
	The problem can be solved in O(n). Idea is to maintain a window and add elements 
	to the window till it contains less or equal k, update our result if required 
	while doing so. If unique elements exceeds than required in window, 
	start removing the elements from left side.
 *
 *	Time: O(N)
 *	Space: O(N)
 */

public class LongestSubstringKDistinctCharacters {
	
	  public int lengthOfLongestSubstringKDistinct(String s, int k) {
		    int[] map = new int[256];
		    int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

		    while (end < s.length()) {
		      final char c1 = s.charAt(end);
		      if (map[c1] == 0) counter++;
		      map[c1]++;
		      end++;

		      while (counter > k) {
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
		LongestSubstringKDistinctCharacters test = new LongestSubstringKDistinctCharacters();
		String s = "aabacbebebe";
		int k = 3;
		
		System.out.println(test.lengthOfLongestSubstringKDistinct(s, k));
	}

}
