package algosJava;

public class OneAway {
	
	//driver method
	public static void main(String[] args) {
		String a = "pale";
		String b = "ple";
		boolean isOneEdit = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit);
	}
	
	public static boolean oneEditAway(String first, String second) {
		//if(first.length() == 0 && second.length() == 0) return false;
		if(first.length() == second.length()) {
			return oneEditReplace(first, second);
		}
		if(first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		}
		if(first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(foundDifference) { //if false return false else set to true and return true
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	
	//Check if you can insert a character into s1 to make s2.

	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		      //pale                   //ple
		while(index2 < s2.length() && index1 < s1.length()) { 
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(index1 != index2) {
					return false;
				}
				index2++; //increments the pointer to the longer string
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

}
