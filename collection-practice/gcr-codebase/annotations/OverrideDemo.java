package annotation;

class Animal {
	public void makeSound() {
		System.out.println("Animal Make Sound.");
	}
}

class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Dog Barks.");
	}
}

public class OverrideDemo {
	public static void main(String[] args) {
		Animal d = new Dog();
		d.makeSound();
	}
}
