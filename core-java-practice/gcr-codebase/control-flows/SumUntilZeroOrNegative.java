public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = sc.nextDouble();
            if (value <= 0) {
                break;
            }
            total += value;
        }
        System.out.println("Total sum is: " + total);
        sc.close();
    }
}
