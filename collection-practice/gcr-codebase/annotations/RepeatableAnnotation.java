package annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
	String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
	BugReport[] value();
}

class Bug {
	@BugReport(description = "Bug1 Detected")
	@BugReport(description = "Bug2 Detected")
	@BugReport(description = "Bug3 Detected")
	public void reportBug() {
		System.out.println("Bugs Has Been Reported...");
	}
}

public class RepeatableAnnotation {
	public static void main(String[] args) throws Exception {
		Bug bug = new Bug();
		Method method = bug.getClass().getMethod("reportBug");
		BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
		for (BugReport bugged : bugReports) {
			System.out.println("Bugs: " + bugged.description());
			System.out.println("------------------------");
		}
	}
}
