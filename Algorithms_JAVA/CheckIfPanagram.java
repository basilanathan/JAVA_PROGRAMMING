package algosJava;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * Time: O(N)
 * Space: O(N)
 * 
 * SET DOESNT ALLOW DUPLICATES!!
 * 
 * https://www.youtube.com/watch?v=B3pmqwOEmGE
 *
 */

public class CheckIfPanagram {
	
	public boolean isPanagram(String s) {
	    //s = s.toLowerCase();  
	    Set<Character> setValue = new HashSet<Character>(); 

	    String replaced = s.replaceAll(" ","").toLowerCase();
	     for(int i = 0; i<replaced.length(); i++)
	     {
	         setValue.add(replaced.charAt(i));
	     }

	    if(setValue.size() == 26)
	    {
	        System.out.println("pangram");
	        return true;
	    }
	    else
	    {
	        System.out.println("not pangram");
	        return false;
	    }
	}
	
	//using an Array
	//Time: O(N)
	//Space: O(1);
	public boolean isPangram2(String s) {
		if(s.length() < 26) return false;
		
		String replaced = s.replaceAll(" ","").toLowerCase();
		
		boolean[] char_set = new boolean[26];
		
		for(int i = 0; i < replaced.length(); i++) {
			int index = replaced.charAt(i) - 'a';
			if(!char_set[index]) {
				char_set[index] = true;
			}
		}
		
		for(int i = 0; i < char_set.length; i++) {
			if (char_set[i] == false) {
				return false;
			}
		}
		return true;

	}
	
	public static void main(String[] args) {
		CheckIfPanagram test = new CheckIfPanagram();
		String s = "The quick brown fox jumps over the lazy dog";
		String a = "The quick brown jumps over the lazy dog";
		
		System.out.println(test.isPanagram(s));
		System.out.println(test.isPanagram(a));
		
		System.out.println(test.isPangram2(s));
		System.out.println(test.isPangram2(a));


	}

}

//String hi = "abcdefghijklmnopqrstuvwxyz";
//char letters[] = hi.toCharArray();
//boolean isPangram = true;
//for(int i =0; i<hi.length(); i++){
//    if(s.contains(String.valueOf(letters[i]))==false){
//        isPangram = false;
//        break;
//    }
//}
//if(isPangram){
//    System.out.println("pangram");
//    return true;
//}
//else{
//    System.out.println("not pangram");
//    return false;
//}
