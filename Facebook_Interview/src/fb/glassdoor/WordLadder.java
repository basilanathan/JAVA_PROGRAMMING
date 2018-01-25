package fb.glassdoor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 *
 */

/*
 * Breadth-first search
 * the complexity
 * Time O (N) space O (N)
 * 
 * Ideas
 * Because of the shortest path required, if we use depth-first search then we have to traverse all 
 * the paths to determine which ones are the shortest ones, whereas with breadth-first search, we can 
 * terminate early once we have found the target, and depending on the breadth-first property, 
 * we are certain Is the first search through a short path to the target. In addition, to avoid 
 * loops and double counting, when we find a new word that exists in the dictionary, we remove it 
 * from the dictionary. This is done because, according to breadth-first, we first find that the path 
 * of word A must be the shortest path from the initial word to word A, and we do not need to recalculate 
 * other paths that may pass through word A.
 * 
 * https://segmentfault.com/a/1190000003698569
 * https://discuss.leetcode.com/category/135/word-ladder
 * 
 * */

public class WordLadder {
	
	public int ladderLength1(String b, String e, Set<String> dict) {
	    if(b.equals(e)) return 1;
	    
	    Queue<String> q = new LinkedList<String>();
	    q.add(b);
	    dict.remove(b);

	    int level=2;
	    
	    while(!q.isEmpty()) {
	        int sz = q.size();
	        
	        for(int i=0; i<sz; i++) {
	            String tmp = q.poll();
	            
	            for(int j=0; j<tmp.length(); j++) {
	                char[] chars = tmp.toCharArray();
	                
	                for(char c='a'; c<='z'; c++) {
	                    chars[j] = c;
	                    String tmp2 = new String(chars);
	                    
	                    if(tmp2.equals(e)) return level;
	                    
	                    if(dict.remove(tmp2)) {
	                        q.add(tmp2);
	                    }
	                }
	            }
	        }
	        
	        level++;
	    }
	    
	    return 0;
	}
	
	/*THOUGHTS
	 * It's much faster than one-end search indeed as explained in wiki.
BFS isn't equivalent to Queue. Sometimes Set is more accurate representation for nodes of level. (also handy since we need to check if we meet from two ends)
It's safe to share a visited set for both ends since if they meet same string it terminates early. (vis is useful since we cannot remove word from dict due to bidirectional search)
It seems like if(set.add()) is a little slower than if(!contains()) then add() but it's more concise.
	 * 
	 * */
	
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList), startSet = new HashSet<>(), endSet = new HashSet<>(), vis = new HashSet<>();
    startSet.add(beginWord);
    if (dict.contains(endWord)) endSet.add(endWord); // all transformed words must be in dict (including endWord)
    for (int len = 2; !startSet.isEmpty(); len++) {
        Set<String> nq = new HashSet<>();
        for (String w : startSet) {
            for (int j = 0; j < w.length(); j++) {
                char[] ch = w.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                    ch[j] = c;
                    String check = new String(ch);
                    if (endSet.contains(check)) return len; // meet from two ends
                    if (dict.contains(check) && vis.add(check)) nq.add(check); // not meet yet, vis is safe to use
                }
            }
        }
        startSet = (nq.size() < endSet.size()) ? nq : endSet; // switch to small one to traverse from other end
        endSet = (startSet == nq) ? endSet : nq;
    }
    return 0;
}
	
	//solution 2
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<String> queue = new LinkedList<String>();

     // step is used to record the number of hops
        int step = 2;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();

         // Control size to ensure that while a while loop only calculates nodes of the same level, a bit like binary tree level order traversal
            for(int j = 0; j < size; j++){
               String currWord = queue.poll();

            // loop the word from the first letter to the last letter
                for(int i = 0; i < endWord.length(); i++){
                	// This bit is replaced by 25 other letters
                    for(char letter = 'a'; letter <= 'z'; letter++){
                        StringBuilder newWord = new StringBuilder(currWord);
                        newWord.setCharAt(i, letter);
                        if(endWord.equals(newWord.toString())){
                            return step;    
                        } else if(wordDict.contains(newWord.toString())){
                            wordDict.remove(newWord.toString());
                            queue.offer(newWord.toString());
                        }
                    }
                } 
            }
            step++;
        }
        return 0;
    }

}
