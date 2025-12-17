import java.util.Scanner;

public class areaCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of circle: ");
        double radius = sc.nextDouble();
        double area = 22 / 7 * radius * radius;
        System.out.println("Area of circle: " + area);
        sc.close();
    }    
}
