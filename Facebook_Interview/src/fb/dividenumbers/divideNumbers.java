package fb.dividenumbers;

public class divideNumbers {
	
	public static void main(String[] args) {
		//divideNumbers_ex(300, 30);
		//System.out.println(divideNumbers_ex(300, 30));
		//System.out.println(divideNumbers_ex(9, 3));
		//System.out.println(divideNumbers_ex(23, 2));
		divideNumbers_ex(41, 5);


	}
	
	public static void divideNumbers_ex(int a , int b){
//		int quotient = 0;
//		while (a >= b) {
//			quotient++;
//			a -= b;
//		}
//		return quotient;
		
        int rem = a;
        int ans =0;
        while(rem>=b){
            rem-=b; //41 - 5 = 36 // 31 //26 //21 
            ans++; //1 //2 //3 //4
        }
        System.out.println("ans:"+ans+"|rem="+rem);


	}
		
}
