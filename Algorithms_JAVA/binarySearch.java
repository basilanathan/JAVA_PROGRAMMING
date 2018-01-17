package algosJava;

public class binarySearch {
	
	public static int BinarySearch(int x, int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] < x) {
				low = mid + 1;
			} else if(arr[mid] > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int binarySearchRecursive(int[] a, int x, int low, int high) {
		if (low > high) return -1; // Error
		
		int mid = (low + high) / 2;
		if (a[mid] < x) {
			return binarySearchRecursive(a, x, mid + 1, high);
		} else if (a[mid] > x) {
			return binarySearchRecursive(a, x, low, mid - 1);
		} else {
			return mid;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {3, 6, 9, 12, 15, 18};
		for (int i = 0; i < 20; i++) {
			int loc = BinarySearch(i, array);
			int loc2 = binarySearchRecursive(array, i, 0, array.length - 1);
			System.out.println(i + ": " + loc + " " + loc2);
		}
	}

}
