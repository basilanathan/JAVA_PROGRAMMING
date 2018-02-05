package fb.glassdoor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027
 * https://github.com/tongzhang1994/Facebook-Interview-Coding/blob/master/301.%20Remove%20Invalid%20Parentheses.java
 *
 */



public class RemoveInvalidParentheses {
	//)(
    //SOLUTION 1
    //Time: O(n), 2 pass
	//Simple version: only output the first valid
    public String removeInvalidParentheses2(String s) {
    	String r = remove(s, new char[]{'(', ')'});
    	String tmp = remove(new StringBuilder(r).reverse().toString(), new char[]{')', '('});
    	return new StringBuilder(tmp).reverse().toString();
    }
    private String remove(String s, char[] p) {
    	int stack = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == p[0])		stack++;
    		if (s.charAt(i) == p[1])		stack--;
    		if (stack < 0) {
    			s = s.substring(0, i) + s.substring(i + 1);
    			i--;
    			stack = 0;
    		}
    	}
    	return s;
    }
    
    /*
     * ( ) ( ) ) ( ) i = 4
     * 
     * ( ) ( ) ( ) i = 3 stack = 0
     * 
     * r = ( ) ( ) ( )
     * tmp = ( ) ( ) ( )
     * 
     * */
    
    //SOLUTION 2
    /*
     * If stack is negative then we haveg more ')'
     * if stack >= 0 then we have more '(' -> reverse and go through it again
     * 
     * there are k unique answers then this algorithm runs in roughly O(nk), where n is the length of the string.
     * 
     * */
    public List<String> removeInvalidParentheses(String s) {
    	List<String> res = new ArrayList<>();
    	dfs(res, s, new char[]{'(', ')'}, 0, 0);
    	return res;
    }
    
    /*
    s.length = 7
    ( ) ( ) ) ( ) i = 4
    
    ( ( ) ) ( ) i = 4, j= 1
    
    ( ) ( ( ) ) i = 0, j = 0

    */
    private void dfs(List<String> res, String s, char[] p, int iStart, int jStart) {
    	// find 1st invalid p[1]
    	int stack = 0, i;
    	for (i = iStart; i < s.length(); i++) {
    		if (s.charAt(i) == p[0])		stack++;
    		if (s.charAt(i) == p[1])		stack--;
    		// remove each (not consecutive) p[1] from jStart to i to make valid
    		if (stack < 0) {
    			for (int j = jStart; j <= i; j++) // <=
    				if (s.charAt(j) == p[1] && (j == jStart || s.charAt(j - 1) != p[1])) {
    					String r = s.substring(0, j) + s.substring(j + 1);
    					dfs(res, r, p, i, j);
    				}
    			return; // important!!
    		}
    	}
    	// stack >= 0 : try reverse s and re-do DFS; if already reversed, then add to res
    	String reverse = new StringBuilder(s).reverse().toString();
    	if (p[0] == '(') 
    		dfs(res, reverse, new char[]{')', '('}, 0, 0); // important: 0, 0
    	else
    		res.add(reverse);
    }
	
    //SOLUTION 3
    char[] forward={'(',')'};
    char[] backward={')','('};
    List<String> res=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        remove(s,0,0,forward);
        return res;
    }
    
    /*
    s.length = 7
    ( ) ( ) ) ( ) i = 4
    
    ( ( ) ) ( ) i = 4, j= 1
    
    ( ) ( ( ) ) i = 0, j = 0
    
    
    
    */
    
    void remove(String s, int i, int j, char[] inspection)
    {
        int count=0;
        for(;i<s.length();i++)
        {
            if(s.charAt(i)==inspection[0]) count++;
            if(s.charAt(i)==inspection[1]) count--;
            
            if(count<0)
            {
                for(;j<=i;j++)
                {
                    if(s.charAt(j)==inspection[1] && (j==0 || s.charAt(j)!=s.charAt(j-1)))
                    {
                        remove(s.substring(0,j)+s.substring(j+1,s.length()),i,j,inspection);
                    }
                }
                return;
            }
        }
        
        if(inspection==forward)
        {
            remove(new StringBuilder(s).reverse().toString(), 0,0, backward);
        }else
        {
            res.add(new StringBuilder(s).reverse().toString());
        }
    }
    
    public List<String> removeInvalidParentheses3(String s) {
        
        List<String> result = new ArrayList<>();
        if (s == null)  return result;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // avoid duplicate results
        queue.offer(s);
        visited.add(s);
        boolean foundValid = false;
        while (!queue.isEmpty()) {
          String r = queue.poll();
          if (isValid(r)) {
            result.add(r);
            foundValid = true;
      }
      // found valid, no need to remove anymore, just iterate the rest of q and add to res when necessary
      
      if (foundValid)    continue; 
      for (int i = 0; i < r.length(); i++) {
          if(r.charAt(i) != '(' && r.charAt(i) != ')')  continue;
          String temp = r.substring(0, i) + r.substring(i + 1);
          if (visited.contains(temp))  continue;
          visited.add(temp);
          queue.offer(temp);
      }
    }
    return result;
  }

  // Remember this method => Check that the brackets match

      private boolean isValid(String s) {
          
          int count = 0; // stack variable
          for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')    count++;
            if (s.charAt(i) == ')' && count-- == 0)  return false;
        }
      return count == 0;
  }
    
    public static void main(String[] args) {
		RemoveInvalidParentheses test = new RemoveInvalidParentheses();
		
		//String string = "()())()";
		//String string2 = "(a)())()";

		String string5 = "a(b)c)";
		String string3 = "(((((";
		String string4 = ")(";
		String string6 = "(()()(";
		String string7 = ")(())(";
				

		
		//System.out.println(test.removeInvalidParentheses2(string));
		//System.out.println(test.removeInvalidParentheses2(string2));

		System.out.println(test.removeInvalidParentheses2(string5));
		System.out.println(test.removeInvalidParentheses2(string3));
		System.out.println(test.removeInvalidParentheses2(string4));
		System.out.println(test.removeInvalidParentheses2(string6));
		System.out.println(test.removeInvalidParentheses2(string7));
		
		System.out.println(test.removeInvalidParentheses3(string5));
		System.out.println(test.removeInvalidParentheses3(string3));
		System.out.println(test.removeInvalidParentheses3(string4));
		System.out.println(test.removeInvalidParentheses3(string6));
		System.out.println(test.removeInvalidParentheses3(string7));




		
	}

}
