package fb.glassdoor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Time: O(nlogn) -> it's because poll() itself is O(nlogn) and even tho we only have a limited number of entries in the PriorityQueue, the number isn't input independent
//Space: O(N)
//The PriorityQueue Method is O(n) as well because you have only constant number (at most 52) of Map.Entry 
//to maintain. The bottleneck is the first for loop which is O(n).

//Solution 1
public class Solution {
    public String frequencySort(String s) {
        Map<Character, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, new StringBuilder()).append(c));
        }
        
        PriorityQueue<StringBuilder> queue = new PriorityQueue<>((a, b) -> (b.length() - a.length()));
        queue.addAll(map.values());
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}

//Solution 2
public class SortCharactersByFrequency {
	//buildl hashmap with frequency
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(Character c : s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		//use max priority queue
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                        return b.getValue() - a.getValue();
                    }
                }
            );
        
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
        	Map.Entry entry = pq.poll();
        	//append to string builder
        	for(int i = 0; i < (int)entry.getValue(); i++) {
        		sb.append(entry.getKey());
        	}
      }
        return sb.toString();
	}

}
