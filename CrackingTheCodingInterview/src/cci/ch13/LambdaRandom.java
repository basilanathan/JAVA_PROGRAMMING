package cci.ch13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement:
 * 
 * Write a function List<Integer> getRandomSubset(List<Integer> list) that returns a random subset
 * of arbitrary size.
 * 
 * </br>
 *
 */

public class LambdaRandom {
	
	public static List<Integer> getRandomSubset(List<Integer> list) {
		List<Integer> subset = new ArrayList<Integer>();
		Random random = new Random();
		for (int item : list) {
			if (random.nextBoolean()) {
				subset.add(item);
			}
		}
		return subset;
	}
	
 	public static void main(String... args) {	
 		List<Integer> list = new ArrayList<Integer>();
 		list.add(1);
 		list.add(2);
 		list.add(3);
 		list.add(4);
 		List<Integer> subset = getRandomSubset(list);
 		System.out.println(subset.toString());
 	}

}
