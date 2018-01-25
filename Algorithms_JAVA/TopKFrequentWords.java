package fb.glassdoor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author basila
 * 
 * Given a non-empty list of words, return the k most frequent elements.

	Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
	
	Example 1:
	Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
	Output: ["i", "love"]
	Explanation: "i" and "love" are the two most frequent words.
	    Note that "i" comes before "love" due to a lower alphabetical order.
	    
	Example 2:
	Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
	Output: ["the", "is", "sunny", "day"]
	Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
	    with the number of occurrence being 4, 3, 2 and 1 respectively.
	
	Note:
	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	Input words contain only lowercase letters.
	
	Follow up:
	Try to solve it in O(n log k) time and O(n) extra space.
 *
 *
 *https://discuss.leetcode.com/topic/107751/my-simple-java-solution-using-hashmap-priorityqueue-o-nlogk-time-o-n-space/2
 */

/*HashMap
 * "i" -> 2
 * "love" -> 2
 * "leetcode" - > 1
 * "coding" -> 1
 * 
 * Bucket
 * 0
 * 1 -> "leetcode" "coding"
 * 2 -> "i" "love"
 * 
 * */

public class TopKFrequentWords {
	
	public List<String> topKFrequentWord(String[] words, int k) {
		//initialize a hashmap
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for(String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
			max = Math.max(max, map.get(w));
		}
		
		//initialize bucket
		List<String>[] bucket = new ArrayList[max + 1];
		for(String w : map.keySet()) {
			int freq = map.get(w);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(w);
		}
		
		List<String> result = new ArrayList<>();
		for(int i = max; i > 0 && k > 0; i--) {
			if (bucket[i] != null) {
				Collections.sort(bucket[i]);
				List<String> list = bucket[i];
				for(String w : list) {
					result.add(w);
					k--;
					if(k == 0) break;
				}
			}
		}
		return result;
	}
	
	//Solution 2
	//The idea is to keep a count of each word in a HashMap and then insert in a Priority Queue.
	//While inserting in pq, if the count of two words is same then insert based on string compare of the keys.
	
	//Time: O(N log K)
	//Space: O(N)
	//The size of the priority queue is k. Each insertion takes logk time and we are iterating over n 
	//distinct words in the worst case and inserting them into the priority queue which makes the total 
	//runtime nlogk.
	public List<String> topKFrequentWord2(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for(String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
       );
        
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }
        List<String> result = new LinkedList<>();
        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());
        
        return result;
	}
	
	public static void main(String[] args) {
		TopKFrequentWords test = new TopKFrequentWords();
		String[] teStrings = {"i", "love", "leetcode", "i", "love", "coding"};
		
		System.out.println(test.topKFrequentWord(teStrings, 2));
	}
}
