package cci.ch13;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * In terms of inheritance what is the effect of keepin a constructor private.
 * - can't create an object of that class
 * - need a create object method
 * 
 * </br>
 *
 */

public class PrivateConstructor {
	
	/* In java, when a class is defined it gets a default public constructor.
	 * When we talk about inheritance, it allows us to use the properties and methods
	 * of the other class. The class which is using the properties and method is
	 * called a sub class whereas the class which actually owns those properties and methods
	 * is called a super class. 
	 * For this particular problem, when a constructor is declared as private, 
	 * it can be accessed by all those classes which can access the private methods
	 * of the that class. Moreover, a private constructor will not allow the class to
	 * be instantiated */
	
	private static PrivateConstructor object = null;
	
	/**
	 * Private Constructor
	 */
	private PrivateConstructor() {
		
	}
	
	/**
	 * Method to make sure only one instance is created
	 * @return {@link PrivateConstructor}
	 */
	public static PrivateConstructor objectCreationMethod(){
		/* This logic will ensure that no more than one object can be created at a time */
		if(object == null){
			object = new PrivateConstructor();
		}
		return object;
	}
	
	/**
	 * Method to display a message
	 */
	public void display(){
		System.out.println("Singleton class Example");
	}
	
	/**
	 * Main method to test the execution of program
	 * No unit tests needed
	 * @param args
	 */
	public static void main(String[] args) {
		/* Creating singleton instance of the class because object cannot
		 * be created due to the existence of private constructor.
		 * You can instantiate the class here because this main method
		 * is inside the PrivateConstructor class and private methods can be 
		 * accessed within the class. */
		PrivateConstructor singeltonClass = PrivateConstructor.objectCreationMethod();
		singeltonClass.display();
	}

}
