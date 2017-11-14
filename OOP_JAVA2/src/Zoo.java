//objects are a runtime concept. when we run the application the objects get created.
//how the objects will react during runtime. 
public class Zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal animal1 = new Animal(12, "Male", 23);
		System.out.println(animal1.age);
		animal1.eat();
		
		//Chicken chick1 = new Chicken(3, "Male", 32);
		//chick1.fly();
		
		Sparrow spa1 = new Sparrow(4, "female", 5);
		spa1.fly();
		
		Bird bird1 = new Bird(3, "Female", 10);
		bird1.eat();
		bird1.fly();

	}

}
//everything needs to be in methods, they do all the work in a java application
//main method- strating point of every java application
//when you hit the run button - two memory locations.
//-stack = frame is going to be crated (main)
//-heap = still inside the main method. 
//instance variable = a varaible that belongs to a instance.
