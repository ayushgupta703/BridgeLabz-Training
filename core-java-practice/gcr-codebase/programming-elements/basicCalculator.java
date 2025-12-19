import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        int sub = num1 - num2;
        int mul = num1 * num2;
        int div = num1 / num2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers" + num1 + " and " + num2 + " is " + sum + ", " + sub + ", " + mul + ", " + div);
        sc.close();
    }
}