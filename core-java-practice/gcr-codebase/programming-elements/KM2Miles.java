import java.util.*;

public class KM2Miles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double Kilogram = sc.nextInt();
		double Miles = Kilogram * 0.621371;
		System.out.print(Miles);
		sc.close();
	}
}