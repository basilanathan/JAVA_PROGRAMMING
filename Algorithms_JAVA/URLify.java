package algosJava;

public class URLify {
	//driver method
	public static void main(String[] args) {
		
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		//int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, 13);	
		System.out.println("\"" + URLify.charArrayToString(arr) + "\"");
		
	}
	
	// 1. count the number of white spaces
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index;
		for(int i = 0; i < trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
	// 2. second pass is done in reverse order , we edit the string. if there is a space replace is with %20
		//if there is no space then copy the original character.
		index = trueLength + spaceCount * 2;
		if(trueLength < str.length) str[trueLength] = '\0'; //End the array
		for(int i = trueLength - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	public static String charArrayToString(char[] array) {
		StringBuilder buffer = new StringBuilder(array.length);
		for(char c : array) {
			if(c == 0) {
				break;
			}
			buffer.append(c);
		}
		return buffer.toString();
	}

}
