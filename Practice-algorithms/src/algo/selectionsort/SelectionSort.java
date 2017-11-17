package algo.selectionsort;

public class SelectionSort {
	
	public static void main(String[] args) {
		int [] myArray = selectionSort(new int[] {9, 8, 3, 13, 87, 12, 99});
		for (int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
		
	}
	
	public static int [] selectionSort(int [] a) {
		for(int i = 0; i < a.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < a.length - 1; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		return a;
		
	}

}
