package algosJava;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * If the celebrity is present in the party, we will call HaveAcquaintance() 3(N-1) times. 
 * Time: O(N)
 * Space: O(1)
 * 
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 * https://discuss.leetcode.com/category/347/find-the-celebrity
 *
 */

/*
 * Find Celebrity
 * - find candidate
 * - if candidate knows i, candidate can't be a celbrity. Make i the candidate
 * - exit out of first forloop - found a candidate that could be a potential celebrite
 * - check everyone else knows the candidate
 * - if the candidate knows the current person or the current person doesn't know the candidate then return -1
 * 
 * */

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class FindCelebrity {
	

    public int findCelebrity(int n) {
        //initialize candidate to 0
        int candidate = 0;
        //find viable candidate
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i; //if candidate knows i, then candidate can't be a celebrity. Make i the candidate
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
