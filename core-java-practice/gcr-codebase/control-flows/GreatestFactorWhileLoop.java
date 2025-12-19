public class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int counter = number - 1;
        int greatestFactor = 1;
        while (counter > 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("Greatest factor of " + number + " besides itself is " + greatestFactor);
        sc.close();
    }
}
