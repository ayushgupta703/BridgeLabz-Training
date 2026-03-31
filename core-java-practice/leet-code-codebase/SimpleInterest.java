import java.util.*;

public class SimpleInterest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double principal = sc.nextInt();
		double Rate = sc.nextInt();
		double Time = sc.nextInt();
		double simple_Interest = (principal * Rate * Time) / 100;
		System.out.print(simple_Interest);
		sc.close();
	}
}