package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
	String role();
}

class Role {
	@RoleAllowed(role = "Admin")
	public void deleteUser() {
		System.out.println("User Deleted Successfully!!");
	}
	
	@RoleAllowed(role = "User")
	public void viewProfile() {
		System.out.println("Profile Viewed!!");
	}
}

public class RoleAllowedAnnotation {
	static String currentRole = "Admin";
	
	public static void main(String[] args) throws Exception {
		Role role = new Role();
		Method[] methods = role.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(RoleAllowed.class)) {
				RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
				String requiredRole = roleAllowed.role();
				System.out.println("Trying to access method: " + method.getName());
				System.out.println("Required Role: " + requiredRole);
				System.out.println("Current Role: " + currentRole);
				
				if (requiredRole.equals(currentRole)) {
					method.invoke(role);
				} else {
					System.out.println("Access Denied!!");
				}
				System.out.println("----------------");
			}
		}
	}
}
