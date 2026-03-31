import java.util.*;

public class Avg3Num {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		double Avg = (a + b + c) / 3;
		System.out.print(Avg);
		sc.close();

	}
}