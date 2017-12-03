package cci.ch3;

import java.util.LinkedList;

abstract class Animal {
	private int order;
	protected String name;
	public Animal(String n) {
		name = n;
	}
	public void setOrder(int ord) {
		order = ord;
	}
	
	public int getOrder() {
		return order;
	}
	
	//compare orders of the animal to return the older animal
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
	
}

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enque(Animal a) {
		a.setOrder(order);
		order++;
		if(a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if(a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}
	
	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeCats();
		} else if(cats.size() == 0) {
			return dequeDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}
	
	public Animal peek() {
		if (dogs.size() == 0) {
			return cats.peek();
		} else if (cats.size() == 0) {
			return dogs.peek();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dog;
		} else {
			return cat;
		}
	}
	
	public int size() {
		return dogs.size() + cats.size();
	}
	
	public Dog dequeueDogs() {
		return dogs.poll();
	}
	
	public Dog peekDogs() {
		return dogs.peek();
	}
	
	public Cat dequeueCats() {
		return cats.poll();
	}
	
	public Cat peekCats() {
		return cats.peek();
	}

}

public class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
	public String name() {
		return "Dog: " + name;
	}
}

public class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
	public String name() {
		return "Cat: " + name;
	}
}