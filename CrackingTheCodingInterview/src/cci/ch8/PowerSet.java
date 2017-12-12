package cci.ch8;

import java.util.ArrayList;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Write a method to return all subsets of a set.
 * 
 * <br>
 * 
 * Time Complexity : O(n2^n)
 * Space Complexity : O(n2^n)
 *
 *
 *http://javabypatel.blogspot.in/2015/10/all-subsets-of-set-powerset.html
 */

public class PowerSet {
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubSets;
		
		//if we are at last index, return empty set
		if(set.size() == index) {
			allSubSets = new ArrayList<ArrayList<Integer>>();
			allSubSets.add(new ArrayList<Integer>()); //empty set
		} else {
			//find subsets by moving on to next index
			allSubSets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
			
			//check for each set
			for(ArrayList<Integer> subset : allSubSets) {
				ArrayList<Integer> newSubSet = new ArrayList<>();
				newSubSet.addAll(subset);
				newSubSet.add(item);
				moreSubSets.add(newSubSet);
			}
			allSubSets.addAll(moreSubSets);
		}
		return allSubSets;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); //compute 2^n
		for(int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}

	private static ArrayList<Integer> convertToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		
		System.out.println(getSubSets(list).toString());		
	}

}
