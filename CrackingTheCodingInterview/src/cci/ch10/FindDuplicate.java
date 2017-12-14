package cci.ch10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * You have an array with all the numbers from 1 to N,
 * where N is at most 32000. The array may have duplicate 
 * entries and you do not know what N is. With only 4 kilo
 * bytes of memory available, how would you print all
 * duplicate elements in the array?
 * 
 * </br>
 * 
 * Brute Force: O(N^2)
 * Set: O(N) - time O(N) - space
 * Sort: O(N log N)- time O(1)- space
 * Encoding O(N) - time O(1) - space
 * 
 */

public class FindDuplicate {
	
	public static ArrayList<Integer> findDuplicatesBF(int[] array) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				count++;
				if (array[i] == array[j] && i != j) {
					result.add(array[i]);
				}
			}
		}
		System.out.println("number of comparisons " + count);
		return result;
	}
	
	//[2, 1, 2, 1, 2]
	public static List<Integer> findDuplicatesOP(int[] array) {
		//Set does not allow duplicate elements.
		Set<Integer> resultSet = new HashSet<>();
		
		for(int i = 0; i < array.length; i++) {
			int index = Math.abs(array[i]) - 1;
			if (array[index] < 0) {
				resultSet.add(Math.abs(array[i]));
				System.out.println(resultSet);
			} else {
				array[index] = -array[index];
			}
		}
		for(int i = 0; i < array.length; i++) {
			array[i] = Math.abs(array[i]);
		}
		
		return new ArrayList(resultSet);
	
	}
	
	public static void main(String[] args) {
		//int[] array = {1, 2, 3, 4, 5, 5, 6, 7, 8, 3, 4, 9, 10};
		int[] array = {2, 1, 2, 1, 2, 2};
		//System.out.println("Brute Force Solution " + findDuplicatesBF(array));
		System.out.println("Optimized solution " + findDuplicatesOP(array));
	}

}
