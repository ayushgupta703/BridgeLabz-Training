package annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
	String level() default "high";
}

class LevelManager {
	@ImportantMethod
	public void Importance1() {
		System.out.println("Decide Importance of Method(Default High)");
	}
	
	@ImportantMethod(level = "medium")
	public void Importance2() {
		System.out.println("Decide Importance of Method(Default High)");
	}
}

public class CustomImportantMethod {
	public static void main(String[] args) {
		LevelManager levelManager = new LevelManager();
		Method[] methods = levelManager.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(ImportantMethod.class)) {
				ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
				System.out.println("Method: " + method.getName());
				System.out.println("Level: " + importantMethod.level());
				System.out.println("-----------------------");
			}
		}
	}
}
