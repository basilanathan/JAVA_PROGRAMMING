
public class Human {
	
	String name;
	int age;
	int height;
	String eyeColor;
	
	public Human() {
		
	}
	
	public void speak() {
		System.out.println("Hello my name is " + name);
		System.out.println("I am " + age + " years old");
		System.out.println("my eye color is " + eyeColor);
		System.out.println("i am " + height + " inches tall");
	}
	
	public void walking() {
		System.out.println("walking.....");
	}
	public void eating() {
		System.out.println("eating.....");
	}	
	public void working() {
		System.out.println("working.....");
	}
}
