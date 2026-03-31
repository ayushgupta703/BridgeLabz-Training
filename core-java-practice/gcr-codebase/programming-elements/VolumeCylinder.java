import java.util.*;

public class VolumeCylinder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double radius = sc.nextInt();
		double height = sc.nextInt();
		double vol = 3.14 * (radius * radius) * height;
		System.out.print(vol);
		sc.close();
	}
}