package fb.glassdoor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * the complexity
Time O (N ^ 2) Space O (N ^ 2)

Ideas
We start from the first letter, traversing the dictionary to see from the first letter can form 
which word in the dictionary, if found, at the end of the word at the next letter, create a list, 
record this Word (save to a list of arrays). After traversing this dictionary and finding all 
the words that begin with the first letter, we move to the next round of search. The next round 
of searches starts only after the previously found word, and if the position is not the next 
letter of a word we skip. So we are equivalent to building a tree (actually an array of lists), 
each found word is a branch of the tree. With this "tree," then we use depth-first search to 
add the path to the result.
 * 
 *  c
	a
	t                *              *
	s -- cat         |              |
	a -- cats        cats          cats
	n                 \            /
	d                  \          /
	d -- and, sand      and    sand
	o                    \      /
	g                     \    /
	  -- dog                dog
	  
 *
 */

public class WordBreakII {
	
    
    public List<String> res = new LinkedList<String>();
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++){

        	// Looks only after the last letter of the word, otherwise skips
            if(dp[i]==null) continue;

         // See which word in the dictionary can be composed from the current letter
            for(String word : wordDict){
                int len = word.length();
                if(i + len > s.length()) continue;
                String sub = s.substring(i, i+len);
                if(word.equals(sub)){
                    if(dp[i + len] == null){
                        dp[i + len] = new ArrayList<String>();
                    }
                    dp[i + len].add(word);
                }
            }
        }
     // If there is no word at the end of the array, we can not find the decomposition method
        if(dp[s.length()]!=null) backTrack(dp, s.length(), new ArrayList<String>());
        return res;
    }
    
    private void backTrack(List<String> dp[], int end, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i = tmp.size() - 2; i >= 0; i--){
                path += " " + tmp.get(i);
            }
            res.add(path);
            return;
        }
        for(String word : dp[end]){
            tmp.add(word);
            backTrack(dp, end - word.length(), tmp);
            tmp.remove(tmp.size()-1);
        }
    }

}
