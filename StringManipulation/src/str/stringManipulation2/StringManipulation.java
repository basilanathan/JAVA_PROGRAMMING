package str.stringManipulation2;

public class StringManipulation {
	public static void main(String[] args) {
		
		//INSTANCE METHODS
		
		//int compareTo(String s)
		//0 -- =
		//+ -- > 
		//- -- <
		
		String hiThere = "Hi There!";
		System.out.println(hiThere.compareTo("hi there!"));
		System.out.println(hiThere.toLowerCase().compareTo("hi there!"));
		System.out.println(hiThere.compareTo("Hi There!"));
		System.out.println(hiThere.compareTo(new String("Hi There!")));
		System.out.println(hiThere.compareTo(hiThere));
		
		//String[] split(String regex)
		String story = "She goes to the store.";
		// Q: How many words are in the document?
		String[] wordList = story.split(" ");
		
		for(int i = 0; i < wordList.length; i++) {
			System.out.print(wordList[i] + " | ");
		}
		System.out.println();
		System.out.println(wordList.length);
		
		//boolean startsWith(String prefix)
		String shells = "Sean sells seashells at the seashore";
		System.out.println(shells.startsWith("Se"));
		
		//Q: How many words in a given document start with "se"?
		//Q: What is a word?
		
		//1. toLowerCase; --> amke sure everyhting is in the same case
		//2. split
		//3. take out stuff like comas, periods, etc..
		
		String [] shellList = (shells.toLowerCase()).split(" ");
		int count = 0;
		for(String s : shellList) {
			if (s.startsWith("se")) {
				count++;
			}
		}
		System.out.println(count);
		
		//string trim() --> trims of space in the beginnign and end
		
		String movies = "          I am going to the movies         b";
		System.out.println(movies);
		System.out.println(movies.trim());
		//to get rid of the large space in the middle
		String cleaned = movies.replaceAll("\\s+", " ");
		System.out.println(cleaned);
		
		//static String valueOf (primitive x)
		String num = String.valueOf(5);
		String character = String.valueOf('a');
		String bool = String.valueOf(true);
		
		System.out.println(5);
		System.out.println(character);
		System.out.println(bool);
		
		//if you need to get input from the user
		Integer userInt = Integer.valueOf(num);
		Boolean userBool = Boolean.valueOf(bool);
		Character character2 = character.charAt(0);
		
	}

}
//https://www.youtube.com/watch?v=67T3qPDoDr8
