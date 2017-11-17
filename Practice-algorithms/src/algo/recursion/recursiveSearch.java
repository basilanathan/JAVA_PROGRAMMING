package algo.recursion;

public class recursiveSearch {
	public static void main(String[] args) {
		
		System.out.println(recursiveLinearSearch(new int[] { 1, 4, 10, 20, 6, 500, 0, 3, 35, 78 }, 0, 35));
		
		
		
	}
	
	public static int recursiveLinearSearch(int a[], int i, int x) {
		if(i > a.length - 1) {
			return -1;
		} else if (a[i] == x) {
			return i;
		} else {
			return recursiveLinearSearch(a, i + 1, x);
		}
	}

}
