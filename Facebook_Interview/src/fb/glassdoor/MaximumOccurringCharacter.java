package fb.glassdoor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author basila
 * 
 * 
 * 
 * https://stackoverflow.com/questions/21750365/how-to-find-the-most-frequently-occurring-character-in-a-string-with-java
 *
 */
public class MaximumOccurringCharacter {
	//SOLUTION 1
	//Time O(N)
	//Space: O(N)
	public char maximumOccurringChar2(String str) {
        // Create array to keep the count of individual
        // characters and initialize the array as 0
		int count[] = new int[256];
		
		// Construct character count array from the input
        // string.
		int length = str.length();
		for (int i = 0; i < length; i++) {
			count[str.charAt(i)]++;
		}
		
		int max = -1;
		char result = ' ';
		
        // Traversing through the string and maintaining
        // the count of each character
		for(int i = 0; i < length; i++) {
			if (max < count[str.charAt(i)] && count[str.charAt(i)] > 1) {
				max = count[str.charAt(i)];
				result = str.charAt(i);
			}
		}
		return result;
	}

	
	//SOLUTION 2
	//This is a typical case for a Map<String, Integer> where keys are characters, and thus limited 
	//in number, and values are frequencies. Solution is O(N) -- one scan to populate the map and one 
	//scan through a tiny map to find the highest frequency.
	
    public List<Character> maximumOccurringChars(String str) {
        return maximumOccurringChars(str, false);
    }

    // set skipSpaces true if you want to skip spaces
    public List<Character> maximumOccurringChars(String str, Boolean skipSpaces) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> occurrences = new ArrayList<>();
        int maxOccurring = 0;

        // creates map of all characters
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (skipSpaces && ch == ' ')      // skips spaces if needed
                continue;

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

            if (map.get(ch) > maxOccurring) {
                maxOccurring = map.get(ch);         // saves max occurring
            }
        }

        // finds all characters with maxOccurring and adds it to occurrences List
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxOccurring) {
                occurrences.add(entry.getKey());
            }
        }

        return occurrences;
    }
    
    static final String TEST_CASE_1 = "AABBBCCCCDDDDDDDDDD";
    static final String TEST_CASE_2 = "aaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcddddeeeeee";
    static final String TEST_CASE_3 = "dbc";

    public static void main(String[] args) {
    		MaximumOccurringCharacter test = new MaximumOccurringCharacter();
        List<Character> result = test.maximumOccurringChars(TEST_CASE_1, true);
        System.out.println(result);
        System.out.println(test.maximumOccurringChar2(TEST_CASE_2));
    }

}
