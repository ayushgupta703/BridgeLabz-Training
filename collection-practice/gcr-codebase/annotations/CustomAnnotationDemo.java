package annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface TaskInfo {
	String priority();
	String assignedTo();
}

class TaskManager {
	@TaskInfo(priority = "High", assignedTo = "XYZ")
	public void completeTask() {
		System.out.println("Task Is Being Completed...");
	}
}

public class CustomAnnotationDemo {
	public static void main(String[] args) throws Exception {
		TaskManager taskManager = new TaskManager();
		Method method = taskManager.getClass().getMethod("completeTask");
		if (method.isAnnotationPresent(TaskInfo.class)) {
			TaskInfo info = method.getAnnotation(TaskInfo.class);
			System.out.println(info);
			System.out.println("Priority: " + info.priority());
			System.out.println("Assigned To: " + info.assignedTo());
		}
		
	}
}
