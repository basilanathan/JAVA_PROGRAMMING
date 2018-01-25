package fb.glassdoor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * First, build a degree map for each character in all the words:
	
	w:0
	r:0
	t:0
	f:0
	e:0
	
	Then build the hashmap by comparing the adjacent words, the first character that is 
	different between two adjacent words reflect the lexicographical order. For example:
	
	 "wrt",
	 "wrf",
	    first different character is 3rd letter, so t comes before f
	
	 "wrf",
	 "er",
	    first different character is 1rd letter, so w comes before e
	The characters in set come after the key. x->y means letter x comes before letter y. 
	x -> set: y,z,t,w means x comes before all the letters in the set. The final HashMap "map" looks like.
	
	t -> set: f    
	w -> set: e
	r -> set: t
	e -> set: r
	and final HashMap "degree" looks like, the number means "how many letters come before the key":
	
	w:0
	r:1
	t:1
	f:1
	e:1
 * 
 * 
 * https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs
 * */

//space complexity: O(max(V, E)) while degree use O(V) and map uses O(E).
//time complexity: O(max(V, E)). V is the number of nodes and E is edge number in the graph.

public class Solution {
    private int aLen = 26;                  // len of alphabet
    public String alienOrder(String[] words) {
        // https://discuss.leetcode.com/topic/32900/easiest-java-bfs-solution/2
        // Toposort problem
        // BUILD GRAPH:
        ArrayList<HashSet<Integer>> neighbours = new ArrayList<>(aLen);       // adjacency list of nodes
        int[] degree = new int[aLen];      // degrees incoming
        buildGraph(words, degree, neighbours);
        
        // TOPOLOGICAL SORT:
        // The starting frontier is all characters with inbound edges of 0 since
        // the are earliest in the alien alphabet. Reduce all neighbours'
        // inbound edges by 1 since now we can reach to them next. If any of them
        // turn to 0, then add those to the frontier and repeat. Store the polled
        // values with inbound edges 0 in order that they come out. This is the
        // lexicographical ordering of the alien alphabet.
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = (int) q.poll();
            sb.append((char) (curr + 'a'));
            for (Integer i : neighbours.get(curr)) {
                degree[i] = degree[i] - 1;
                if (degree[i] == 0) q.add(i);
            }
        }
        
        // check if there are any characters to which we could not resolve.
        // if there exists any with deg > 0, then there was not substantial
        // data to decide where this character belonged
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] > 0) return "";
        }
        
        return sb.toString();

    }
    
    /* Step 1: build the graph.
    * For each character, count how many inbound edges there are,
    * where an inbound edge is defined s.t. for words w1 and w2,
    * where charAt(w1) != charAt(w2), w1 -> w2. We also keep a 
    * running list of neighbours for each character. */
    public void buildGraph(String[] words, int[] deg, ArrayList<HashSet<Integer>> n) {
        // init the neighbours array
        for (int i = 0; i < aLen; i++) n.add(new HashSet<Integer>());
        for (int i = 0; i < deg.length; i++) {
            deg[i] = -1;                // representing as not in the array
        }
        
        for (int i = 0; i < words.length; i++) {
            // build the indegrees for each character
            String currString = words[i];
            for (int j = 0; j < currString.length(); j++) {
                int currChar = currString.charAt(j) - 'a';
                if (deg[currChar] < 0) deg[currChar] = 0;           // set this character as seen if not yet
            }
        }
            
        for (int i = 1; i < words.length; i++) {
            // we want to compare pairs of words at idx words[i] and words[i+1]
            // for every letter in words[i], if we see that charAt(j_i) != charAt(j_i+1),
            // then we know that there is an inbound edge pointing from charAt(j_i) -> charAt(j_i+1),
            // since the char from w_i should come before w_i+1 lexiographically.
            String w1 = words[i-1];
            String w2 = words[i];
            
            if (w1.length() > w2.length()) {
                // corner case s.t. we might have "wrtkj" come before "wrt",
               // but this must never be the case
                if (w1.substring(0, w2.length()).equals(w2)) {
                    Arrays.fill(deg, 5);
                    return;
                }
            }
            
            for (int k = 0; k < Math.min(w1.length(), w2.length()); k++) {
                int c1 = w1.charAt(k) - 'a';
                int c2 = w2.charAt(k) - 'a';

                if (c1 != c2) {
                    // c1 -> c2 must be true
                    if (!n.get(c1).contains(c2)) {
                        // does c1 point to c2 already? 
                        // don't want to double count or produce a cycle
                        n.get(c1).add(c2);
                        deg[c2] = deg[c2] + 1;        // update the inbound for c2
                    }
                    break;                              // insubstantial evidence past this mismatch

                }
            }
        }
    }
}

public class AlienOrder {
	
	public String alienOrder1(String[] words) {
	    Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
	    Map<Character, Integer> degree=new HashMap<Character, Integer>();
	    String result="";
	    if(words==null || words.length==0) return result;
	    for(String s: words){
	        for(char c: s.toCharArray()){
	            degree.put(c,0);
	        }
	    }
	    /* Step 1: build the graph.
	     * For each character, count how many inbound edges there are,
	     * where an inbound edge is defined s.t. for words w1 and w2,
	     * where charAt(w1) != charAt(w2), w1 -> w2. We also keep a 
	     * running list of neighbours for each character. */
	    for(int i=0; i<words.length-1; i++){
	        String cur=words[i];
	        String next=words[i+1];
	        //check for cases like, ["wrtkj","wrt"]; it's invalid, because this input is not in sorted lexicographical order
	        if( cur.length() > next.length() && cur.startsWith(next) )
	            return "";
	        
	        int length=Math.min(cur.length(), next.length());
	        for(int j=0; j<length; j++){
	            char c1=cur.charAt(j);
	            char c2=next.charAt(j);
	            if(c1!=c2){
	                Set<Character> set=new HashSet<Character>();
	                if(map.containsKey(c1)) set=map.get(c1);
	                if(!set.contains(c2)){
	                    set.add(c2);
	                    map.put(c1, set);
	                    degree.put(c2, degree.get(c2)+1);
	                }
	                break;
	            }
	        }
	    }
	    Queue<Character> q=new LinkedList<Character>();
	    for(char c: degree.keySet()){
	        if(degree.get(c)==0) q.add(c);
	    }
	    while(!q.isEmpty()){
	        char c=q.remove();
	        result+=c;
	        if(map.containsKey(c)){
	            for(char c2: map.get(c)){
	                degree.put(c2,degree.get(c2)-1);
	                if(degree.get(c2)==0) q.add(c2);
	            }
	        }
	    }
	    if(result.length()!=degree.size()) return "";
	    return result;
	}
	
	//solution 2
	
	public String alienOrder(String[] words) {
		  Map<Character, Integer> indegree = new HashMap();
		  Map<Character, Set<Character>> adjList = new HashMap();
		    
		  for(String w: words){
		    for(char c: w.toCharArray()){
		       indegree.put(c, 0); 
		    }  
		  }  
		    
		  for(int i = 1; i < words.length; i++){
		    char[] pre = words[i - 1].toCharArray();
		    char[] cur = words[i].toCharArray();
		    int j = 0;
		    while(j < pre.length && j < cur.length){
		      if(pre[j] != cur[j]){
		        Set<Character> set = adjList.getOrDefault(pre[j], new HashSet());
		        if(!set.contains(cur[j])){
		          indegree.put(cur[j], indegree.get(cur[j]) + 1);
		          set.add(cur[j]);
		          adjList.put(pre[j], set);
		        }
		        break;
		      }
		      j++;
		    }
		  
		    if(j == cur.length && pre.length > j){
		      return "";
		    }
		  }
		    
		    
		  
		  Queue<Character> queue = new LinkedList();
		  for(Map.Entry<Character, Integer> entry: indegree.entrySet()){
		    if(entry.getValue() == 0){
		      queue.offer(entry.getKey());
		    }
		  }
		  
		  StringBuilder sb = new StringBuilder();
		  while(!queue.isEmpty()){
		    char node = queue.poll();
		    sb.append(node);
		    if(adjList.containsKey(node)){
		      Set<Character> set = adjList.get(node);
		      for(char c: set){
		        int idr = indegree.get(c) - 1;
		        indegree.put(c, idr);
		        if(idr == 0){
		         queue.offer(c); 
		        }
		      }
		    }
		  }
		  if(sb.length() != indegree.size()) return "";  
		  return sb.toString();
		}

}
