package reflection;

import java.lang.reflect.*;

class Person {
	@SuppressWarnings("unused")
	private int age = 20;
}

public class AccessPrivateField {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		Field field = person.getClass().getDeclaredField("age");
		field.setAccessible(true);
		System.out.println(field.get(person));
		field.set(person, 25);
		System.out.println(field.get(person));
	}
}
