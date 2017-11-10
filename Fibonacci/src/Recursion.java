
public class Recursion {

	public static void main(String[] args) {
//		System.out.println(fibonacci(3));
//		System.out.println(fibonacci(4));
		
		int index = 0;
		while (true) {
			System.out.println(fibonacci(index));
			index++;
		}


	}
	
	public static int fibonacci(int n) {
		if (n == 0) return 0;
		if (n <= 2) return 1;
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
