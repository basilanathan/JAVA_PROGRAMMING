package fb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Time: O(4^n) or O(Max(3, 4) ^ n)
 * Space; O(4^n)  BFS- because it breads out
 * 4 comes from the maximum amount of letters possible for a digit.
 * For example, the number “9” has 4 letters: “wxyz.”
 * If the input is “9” you will get 4 results. If the input is “99” you will get 16 results, etc. 
 * At each digit, we take the previous results, and for EACH letter corresponding to the digit, 
 * we append the letter to the previous results.
 * 
 *
 */

/*
 * add(E e) Appends the specified element to the end of this list.
 * remove() Retrieves and removes the head (first element) of this list.
 * poll() Retrieves and removes the head (first element) of this list.
 * 
 * */

//2 - abc
//3 - def
//4 - ghi
//5 - jkl
//6 - mno
//7 - pqrs
//8 - tuv
//9 - wxyz

public class LetterCombinationsOfAPhoneNumber {
	
	//solution with FIFO queue
	public static List<String> letterCombinations(String digits)  {
		LinkedList<String> result  = new LinkedList<String>();
		
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		
		if(digits == null || digits.length() == 0) return result;
		
		result.add("");
		
		for(int i = 0; i < digits.length(); i++) {
			int current = Character.getNumericValue(digits.charAt(i));
			
			while(result.peek().length() == i) {
				
				String string = result.poll();
				
				for(char c : mapping[current].toCharArray()) {
					result.add(string + c);
				}
			}
		}
		return result;
	}
	
	//SECOND SOLUTION
	    public List<String> letterCombinations2(String digits) {
	        if (digits.isEmpty()) return new ArrayList<>();
	        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	        LinkedList<String> q = new LinkedList<>();
	        q.offer("");
	        while (!q.isEmpty()) {
	            if (q.peek().length() == digits.length()) break;
	            String s = q.poll();
	            for (char c : map[digits.charAt(s.length()) - '0'].toCharArray())
	                q.offer(s + c);
	        }
	        return q;
	    }
	
	public static void main(String[] args) {
		String test = "99";
		System.out.println(letterCombinations(test));
	}

}
