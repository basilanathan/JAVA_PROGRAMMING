package cci.ch8;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Implement an algorithm to print all valid (i.e properly
 * opened and closed) combinations of n pairs of parentheses.
 * Example :
 * Input : 3
 * Output : "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * <br>
 *
 */

public class Parens {
	public static Set<String> generateParens(int n) {
		Set<String> result = new HashSet<>();
		generateParens(result, "", n, n);
		return result;
	}
	
	/*keep track of the number of left and right parenthesis allowed. If there are left parens remaining
	 * we'll insert a left paren and recurse. If there are more right parens remaining than left ( if there
	 * are more left parens in use than right parens), then we'll insert a right paren and recurse*/

	private static void generateParens(Set<String> result, String prefix, int left, int right) {
		/* Here left and right are number of "(" and ")" remaining
		 * respectively. If left is greater, then we should stop */
		if (left > right) return;
		
		/* When there is no left and right, just return the prefix */
		if(left == 0 && right == 0) {
			result.add(prefix);
			return;
		}
		
		/* If left has more then 0 parenthesis, add that */
		if (left > 0) {
			generateParens(result, prefix + "(", left - 1, right);
		}
		/* If right has more then 0 parenthesis, add that */
		if (right > 0) {
			generateParens(result, prefix + ")", left, right - 1);
		}
	}
	
	public static void main(String[] args) {
		Set<String> list = generateParens(3);
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}

}
