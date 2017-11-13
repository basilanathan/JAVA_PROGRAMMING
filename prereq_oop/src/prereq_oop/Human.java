package prereq_oop;

//contain info on how objects should be crated and how they should behave in the application
//blueprint, characeristics of what humans will  have
public class Human {
	String name;
	int age;
	int heighInInches;
	String eyeColor;
	
	public void speak() {
		System.out.println("Hello my name is" + name);
		System.out.println("i am " + age);
	}
	
}
