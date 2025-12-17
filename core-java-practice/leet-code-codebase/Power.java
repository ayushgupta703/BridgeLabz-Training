import java.util.*;

public class Power {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int exp = sc.nextInt();
		double pow = Math.pow(base, exp);
		System.out.println(base + " raise to the power " + exp + " is " + pow);
		sc.close();
	}
}