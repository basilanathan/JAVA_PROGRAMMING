package fb.glassdoor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 *
 *https://discuss.leetcode.com/topic/48158/3-java-solution-using-array-maxheap-treemap/13?page=1
 */

/*
 * HashMap
 * 1 -> 3
 * 2 -> 2
 * 3 -> 1
 * 
 * Bucket
 * 
 * 0 1 2 3 4 5 6
 *   3 2 1
 * 
 * */

//Time: O(N)
//Space: O(N)

public class TopKFrequentElements {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		//initialize HashMap
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		//initialize Bucket
		List<Integer>[] bucket = new List[nums.length + 1];
		for(int n : map.keySet()) {
			int freq = map.get(n);
			if(bucket[freq] == null) {
				bucket[freq] = new LinkedList<>();
			}
			bucket[freq].add(n);
		}
		
		//iterate through bucket and to result
		List<Integer> result = new LinkedList<>();
		for(int i = bucket.length - 1; i > 0 && k > 0; i--) {
			if (bucket[i] != null) {
				List<Integer> list = bucket[i];
				for(int n: list) { //takes care of nums with same frequencies
					result.add(n);
					k--;
					if(k == 0) break;
				}
			}
		}
		return result;
	}
	
	//using minHeap  maintain a min heap with size k and kick off the least frequent one.
	//time: O(nlog k)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer,Integer> e : freq.entrySet()) {
            q.offer(e);
            if (q.size() > k) {
                q.poll();
            }
        }

        List<Integer> ret = new ArrayList<>();
        while (!q.isEmpty()) {
            ret.add(q.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

}
