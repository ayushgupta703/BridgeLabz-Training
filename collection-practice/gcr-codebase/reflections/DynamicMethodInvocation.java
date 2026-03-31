package reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
	public int addition(int a, int b) {return a + b;}
	public int subtract(int a, int b) {return a - b;}
	public int multiply(int a, int b) {return a * b;}
}

public class DynamicMethodInvocation {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Operation(addition, subtract, multiply): ");
		String operation = scanner.next();
		MathOperations mOperations = new MathOperations();
		Method[] methods = mOperations.getClass().getDeclaredMethods();
		for(Method method : methods) {
			if(method.getName().equals(operation.toLowerCase())) {
				System.out.println(method.invoke(mOperations, 4, 2));
			}
		}
		scanner.close();
	}
}
