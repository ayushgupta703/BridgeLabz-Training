import java.util.Scanner;

public class areaTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Base and Height in cm:");
		double base = sc.nextDouble();
		double height = sc.nextDouble();
		double areaCm = 0.5 * base * height;
		double areainches = areaCm / 6.4516;
		System.out.println("Area Of triangle having Base and Height " + base + "and" + height + "in square centimeters is " + areaCm + "and in square inches is " + areainches);
		sc.close();
	}
}