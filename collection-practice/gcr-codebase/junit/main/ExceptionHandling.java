package BridgeLabz_Training.jUnit;

public class ExceptionHandling {
	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Division By Zero Not Allowed");
		}
		return a/b;
	}
}
