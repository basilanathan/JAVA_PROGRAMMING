package fb.glassdoor;

/*
 * 1 approach

	1) sort array by abs(x) as key (e.g. [1,2,3,-4,5,-6])
	2) return [x**2 for x in array]
	
	O(n log n) time 
	O(1) additional space
	
	2 approach
	
	1) do sqr for all negative and reverse list, do sqr for positive
	2) merge 2 arrays like in merge sort but only 1 iteration needed
	
	O(n) time
	O(n) additional space (because of merge)
	
	Actually it IS possible to do merge in linear time and constant extra space. By algorithm is not trivial :)
	
	Google for it: Bing-Chao Huang, Michael A. Langston, “Practical In-Place Merging” (1988).
	
	So best solution will be:
	O(n) time
	O(1) extra space
 * 
 * */

public class SortedSquare {
	
	//	O(n) time
	//  O(1) extra space
	
	public int[] sortedSquare(int[] sortedArray) {
		int[] sortedSquare = new int[sortedArray.length];
		int front = 0;
		int back = sortedArray.length - 1;
		int current = sortedArray.length - 1;
		
		while(front <= back) {
			int frontSquare = sortedArray[front] * sortedArray[front];
			int backSquare = sortedArray[back] * sortedArray[back];
			
			if(frontSquare <= backSquare) {
				sortedSquare[current--] = backSquare;
				back--;
			} else {
				sortedSquare[current--] = frontSquare;
				front++;
			}
		}
		
		return sortedSquare;
	}
	
	public void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		SortedSquare test = new SortedSquare();
		int[] testArray = {-6,-4,1,2,3,5};
		
		int[] resultArray = test.sortedSquare(testArray);
		
		test.printArray(resultArray);
	}

}
