package str.stringManipulationIntro;

public class StringManipulation {
	
	public static String reverseString(String stringToReverse) {
		if(stringToReverse.length() < 2) {
			return stringToReverse;
		}
		return reverseString(stringToReverse.substring(1)) + stringToReverse.charAt(0);
		//"ello" + 'h'
		//"llo" + 'e' + 'h'
		//"lo" + 'l' + 'e' + 'h'
	}
	
	public static void main(String[] args) {
		//literal
		String string = "Hello World";
		
		//new operator --> HEAP
		String tString = new String("Hello World");
		
		//making a string
		
		//concatenate
		String h = "Hello ";
		String w = "World";
		System.out.println(h.concat(w));
		System.out.println(h + w + "s");
		
		//formating
		String d = String.format("Steve had %d cats", 5);
		System.out.println(d);
		
		//substrings
		System.out.println(h + d.substring(0, 5));
		
		//string instance methods
		
		//length
		String hiThere = "Hi there";
		System.out.println(hiThere.length());
		
		//charAt
		System.out.println(hiThere.charAt(3));
		
		//indexOf
		System.out.println(hiThere.indexOf('e'));
		System.out.println(hiThere.lastIndexOf('e'));
		
		//toUpperCase()
		System.out.println(hiThere.toUpperCase());
		//System.out.println(hiThere); //--> doesnt change, pointing to a space in memory
		
		//toLowerCase()
		System.out.println(hiThere.toLowerCase());
		
		//replace
		String hiThereReplaces = hiThere.replace('e', 'z');
		System.out.println(hiThereReplaces);
		//string is immutable!!! String is a data type that is immutable in JAVA
		
		//how to reverse a string in java
		
		String stringToReverse = "basila nathan";
		
		//1. Library --> StringBuilder
		StringBuilder sb = new StringBuilder(stringToReverse).reverse();
		System.out.println(sb);
		
		//2. iterative --> for loop or while loop
		String re = "";
		for(int i = stringToReverse.length() - 1; i >= 0; i--) {
			re = re + stringToReverse.charAt(i);
			//System.out.println(re);
		}
		System.out.println(re);
		
		//3. recurrsion
		System.out.println(reverseString(stringToReverse));
		
		
	}

}
//https://www.youtube.com/watch?v=80jTI3mKtmk
