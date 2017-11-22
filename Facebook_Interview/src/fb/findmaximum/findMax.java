package fb.findmaximum;

public class findMax {
	
	//driver method
	
	public static void main(String[] args) {
		//findMax_ex("11");
		System.out.println(findMax_ex("11"));
		System.out.println(findMax_ex("111"));
	}
	
	//The idea here is to parse through the input one number at a time and if the number is 0 or 1 then use + else use *.

	//n * 0 = 0 but n + 0 = n, which is greater
	//n * 1 = n but n + 1 = n + 1, which is greater
	
	public static int findMax_ex(String input) {
		if (input == null) return -1;
		if(input.length() == 1) return Character.getNumericValue(input.charAt(0));
		
		int a = Character.getNumericValue(input.charAt(0));
		int result = a;
		
		for(int i = 0; i < input.length() -1 ; i++) {
			int n = Character.getNumericValue(input.charAt(i));
			int m = Character.getNumericValue(input.charAt(i + 1));
			
			if (n == 0 || n == 1 || m == 0 || m == 1) {
				result = result + m;
			} else {
				result = result * m;
			}
		}
		return result;
	}

}
