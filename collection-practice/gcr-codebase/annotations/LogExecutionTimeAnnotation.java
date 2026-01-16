package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Execution {
	@LogExecutionTime
	public void smallTask() {for(int i = 0; i < 1000; i++);}
	
	@LogExecutionTime
	public void longTask() {for(int i = 0; i < 1000000; i++);}
}

public class LogExecutionTimeAnnotation {
	public static void main(String[] args) throws Exception {
		Execution execution = new Execution();
		Method[] methods = execution.getClass().getDeclaredMethods();
		for(Method method : methods) {
			if (method.isAnnotationPresent(LogExecutionTime.class)) {
				long startTime = System.currentTimeMillis();
				method.invoke(execution);
				long endTime = System.currentTimeMillis();
				Long executionTime = endTime - startTime;
				System.out.println(method.getName() + " exectued in " + executionTime + " MilliSeconds");
				System.out.println("---------------------------");
			}
		}
	}
}
