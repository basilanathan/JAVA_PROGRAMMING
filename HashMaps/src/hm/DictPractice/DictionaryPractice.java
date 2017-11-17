package hm.DictPractice;

import java.util.HashMap;
import java.util.Map;

public class DictionaryPractice {
	
	public static void main(String[] args) {
		Map<String, String> englSpanishDictionary = new HashMap<String, String>();
		
		//Putting things inside our dictionary
		englSpanishDictionary.put("Monday", "Lunes");
		englSpanishDictionary.put("Tuesday", "Martes");
		englSpanishDictionary.put("Wednesday", "Miercoles");
		englSpanishDictionary.put("Thursday", "Jueves");
		englSpanishDictionary.put("Friday", "Viernes");
		englSpanishDictionary.put("Saturday", "Sabado");
		englSpanishDictionary.put("Sunday", "Domingo");
		
		//retrieve things from dictionary
		System.out.println(englSpanishDictionary.get("Monday"));
		System.out.println(englSpanishDictionary.get("Tuesday"));
		System.out.println(englSpanishDictionary.get("Wednesday"));
		System.out.println(englSpanishDictionary.get("Thursday"));
		System.out.println(englSpanishDictionary.get("Friday"));
		System.out.println(englSpanishDictionary.get("Saturday"));
		System.out.println(englSpanishDictionary.get("Sunday"));
		
		//print out all keys
		System.out.println(englSpanishDictionary.keySet());
		
		//pritn out all values
		System.out.println(englSpanishDictionary.values());
		
		//print out size
		System.out.println("The size of our dictionary is " + englSpanishDictionary.size());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		//Shopping List
		Map<String, Boolean> shoppingList = new HashMap<String, Boolean>();
		
		//put some stuff in the dictionary
		shoppingList.put("Ham", true);
		shoppingList.put("Bread", Boolean.TRUE);
		shoppingList.put("Oreos", Boolean.TRUE);
		shoppingList.put("Eggs", Boolean.FALSE);
		shoppingList.put("Sugar", false);
		
		//retrieve items
		System.out.println(shoppingList.get("Ham"));
		System.out.println(shoppingList.get("Oreos"));
		
		System.out.println(shoppingList.toString());
		//remove
		shoppingList.remove("Eggs");
		
		//replace valuse for certain key
		shoppingList.replace("Bread", Boolean.FALSE);
		
		//key value pair print out
		System.out.println(shoppingList.toString());
		//clear our dictioanry
		shoppingList.clear();
		System.out.println(shoppingList.toString());

		

	}

}
