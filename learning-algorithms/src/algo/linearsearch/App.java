package algo.linearsearch;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//LINEAR GROWTH RATE O(n)
	public static int linearSearch(int [] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return i;
			}
		}
		return -1;
	}

}
