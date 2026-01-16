package reflection;

import java.lang.reflect.Method;

class Calculator {
	@SuppressWarnings("unused")
	private int multiply(int a, int b) {
		int c = a * b;
		return c;
	}
}

public class InvokePrivateMethod {
	public static void main(String[] args)throws Exception {
		Calculator calculator = new Calculator();
		Method method = calculator.getClass().getDeclaredMethod("multiply", int.class, int.class);
		method.setAccessible(true);
		System.out.println(method.invoke(calculator, 2, 4));
	}
}
