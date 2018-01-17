package algosJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * Given a list determine if contiguous elements of the list sum to an 
 * input number. For example array/list [6, 5, 3, 2, 1, 7] and input 8
 * the numbers 5 + 3 = 8.
 * 
 * Time: O(N)
 * Space: O(1)
 * 
 * https://www.careercup.com/question?id=5320653514211328
 *
 */

public class ListSumInput {
	
	 //Time: O(N)
	 //Space: O(1)
	
	//use two pointers
	public boolean listSumInput(List<Integer> list, int input) {
		int tail = 0;
		int sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			while(sum > input) {
				sum -= list.get(tail++);
			}
			if(sum == input) return true;
		}
		return false;
	}

	//print out the sub arrays.
	//Time: O(N)
	//Space: O(1)
	public void listSumInput2(List<Integer> list, int input) {
		int start = 0, end = 0, sum = 0;
		//int num = 0;
		
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			
			if (sum > input) {
				while(sum > input) {
					sum -= list.get(start);
					start++;
				}
			}
			if(sum == input) {
				printSubArray(list, start, (end = i));
//				sum -= list.get(start);
//				start++;
			}
		}
		//return;
	}

	private void printSubArray(List<Integer> list, int start, int end) {
		//List<Integer> result = new ArrayList<Integer>();
		while(start <= end) {
		System.out.print(list.get(start++) + " ");
		}
		System.out.println(" ");
		//return;
	}
	
	public static void main(String[] args) {
		ListSumInput test = new ListSumInput();
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 5, 3, 2, 1, 7));
		
		System.out.println(test.listSumInput(list, 10));
		test.listSumInput2(list, 10);
		
	}
	
	//O(N^2)
//    public static void main(String[] args) {
//
//        Integer[] array = {6, 5, 3, 2, 1, 7};
//
//        Integer targetValue = 10;
//
//        for (int i = 0; i < array.length; i++) {
//            Integer sum = array[i];
//            List<Integer> result = new ArrayList<Integer>();
//            result.add(array[i]);
//            for (int j = i + 1; sum < targetValue && j < array.length; j++) {
//                sum += array[j];
//                result.add(array[j]);
//            }
//            if (sum == targetValue) {
//                result.forEach(x -> System.out.print(x + " "));
//                System.out.println();
//            }
//        }
//    }

}
