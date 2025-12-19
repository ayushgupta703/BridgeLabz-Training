import java.util.Scanner;

public class CentimeterToFeet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double heightInCm = sc.nextDouble();
        double heightInInch = heightInCm / 2.54;
        double heightInFeet = heightInInch / 12;
        System.out.println("Your Height in Cm is " + heightInCm + " while in Feet is " + heightInFeet + " and in Inches is " + heightInInch);
        sc.close();
    }}
