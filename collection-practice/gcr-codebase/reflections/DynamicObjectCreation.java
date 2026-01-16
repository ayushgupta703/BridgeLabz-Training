package reflection;

import java.lang.reflect.Constructor;

class Student {
	String name = "Xyz";
	int age = 20;
	
	public Student() {
		
	}
}

public class DynamicObjectCreation {
	public static void main(String[] args) throws Exception {
		Class<?> class1 = Student.class;
		Constructor<?> constructor = class1.getConstructor();
		Object obj = constructor.newInstance();
		System.out.println(obj.getClass().getName());
		Student student = (Student) obj;
		System.out.println(student.name);
		System.out.println(student.age);
	}
}
