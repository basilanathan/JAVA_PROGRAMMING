
public class Earth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Human tom;
//		tom = new Human();
//		
//		tom.name = "tom";
//		tom.age = 2;
//		tom.height = 23;
//		tom.eyeColor = "brown";
//		tom.speak();
//		
//		Human joe = new Human();
//		
//		joe.age = 36;
//		joe.eyeColor = "Green";
//		joe.name = "Joey";
//		joe.height = 68;
//		
//		joe.speak();
		
		Human human1 = new Human("Tom", 23, 60, "Blue");
		Human human2 = new Human("Blake", 25, 65, "Green");
		Human human3 = new Human("John", 27, 70, "Black");
		
		human1.speak();
		human2.speak();
		human3.speak();

	}

}
