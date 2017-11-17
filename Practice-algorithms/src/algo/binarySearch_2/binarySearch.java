package algo.binarySearch_2;

public class binarySearch {
	
	public static void main(String[] args) {
		
		System.out.println(binarySearch(new int[] { 1, 4, 10, 20, 6, 500, 0, 3, 35, 78 }, 500));
		
		
		
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

}
