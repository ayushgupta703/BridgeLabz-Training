package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ToDo {
	String task();
	String assignedTo();
	String priority() default "Medium";
}

class ToDoManager {
	@ToDo(task = "Update UI", assignedTo = "XYZ", priority = "High")
	public void Feature1() {
		System.out.println("Feature1 Pending..");
	}
	
	@ToDo(task = "Database Connection", assignedTo = "ABC")
	public void Feature2() {
		System.out.println("Feature2 Pending..");
	}
}

public class ToDoAnnotation {
	public static void main(String[] args) 	throws Exception {
		ToDoManager toDoManager = new ToDoManager();
		Method[] methods = toDoManager.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(ToDo.class)) {
				ToDo manager = method.getAnnotation(ToDo.class);
				System.out.println("Feature: " + method.getName());
				System.out.println("Pending Task: " + manager.task());
				System.out.println("Assigned To: " + manager.assignedTo());
				System.out.println("Priority: " + manager.priority());
				System.out.println("------------------------------");
			}
		}
	}
}
