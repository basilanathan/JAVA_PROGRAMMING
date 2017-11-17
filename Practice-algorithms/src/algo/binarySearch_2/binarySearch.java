package algo.binarySearch_2;

public class binarySearch {
	
	public static void main(String[] args) {
		
		System.out.println(binarySearch(new int[] { 1, 4, 10, 20, 6, 500, 0, 3, 35, 78 }, 500));
		System.out.println(recursiveBinarySearch(new int[] { 1, 2, 3, 4, 7, 9, 12, 18 }, 0, 7, 18));
		
		
	}
	
	public static int binarySearch(int a [], int x) {
		int p = 0;
		int r = a.length - 1;
		if( p <= r) {
			int q = (p + r)/2;
			if(x < a[q]) return r = q - 1;
			else if (x > a[q]) return p = q + 1;
			else return q;
		}
		return -1;
		
	}
	
	public static int recursiveBinarySearch(int a [], int p, int r, int x) {
		if (p > r) {
			return -1;
		} else {
			int q = (p+r)/2;
			if(a[q] == x) {
				return q;
			} else if(a[q] > x) {
				return recursiveBinarySearch(a, p, q - 1, x);
			} else {
				return recursiveBinarySearch(a, q + 1, r, x);
			}
		}
	}

}
