package fb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * 
 * You have a room with n people. A celebrity walks in. Everyone knows the celebrity, 
 * the celebrity knows no one. Non-celebrities may/may not know anyone in the room. 
 * Give an algorithm to find the celebrity. Discuss the complexity.
 * 
 * 
 * Our algorithm consists of two phases: in the elimination phase, we eliminate all but one 
 * person from being the celebrity; in the verification phase we check whether this one 
 * remaining person is indeed a celebrity.
 * 
 * Time: O(N)
 * Space; O(1)
 * 
 * http://yuanhsh.iteye.com/blog/2183929
 * - using stack and queue
 *
 */
/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class FindTheCelebrity extends Relation {
	

    public int findCelebrity(int n) {
        //initialize candidate to 0
        int candidate = 0;
        //find viable candidate
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        //check that everyone else knows the candidate
        for(int i = 0; i < n; i++) {
            //if the candidate knows the current person or the current person does not know the candidate, return -1 (candidate is not a celebrity)
            if(i != candidate && knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        //return the celebrity
        return candidate;
    }
    
    //QUEUE SOLUTION
    public int findCelebrity(int[] persons) {  
        Queue<Integer> queue = new LinkedList<>();  
        for(int p:persons) {  
            queue.offer(p);  
        }  
        while(queue.size()>1) {  
            int a = queue.poll();  
            int b = queue.poll();  
            if(hasAcquiantance(a, b)) {  
                queue.offer(b);  
            } else {  
                queue.offer(a);  
            }  
        }  
        int c = queue.poll(); // possible celebrity  
        for(int p:persons) {  
            if(p == c) continue;  
            if(hasAcquiantance(c, p) || !hasAcquiantance(p, c))  
                return -1;  
        }  
        return c;  
    }  

}
