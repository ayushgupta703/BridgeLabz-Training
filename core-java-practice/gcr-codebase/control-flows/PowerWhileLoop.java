public class PowerWhileLoop {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();
        System.out.print("Enter the power: ");
        int power = sc.nextInt();
        int result = 1, counter = 0;
        while (counter < power) {
            result *= number;
            counter++;
        }
        System.out.println(number + " raised to the power " + power + " is " + result);
        sc.close();
    }
}
