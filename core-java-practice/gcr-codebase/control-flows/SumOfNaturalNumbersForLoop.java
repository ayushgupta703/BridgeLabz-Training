public class SumOfNaturalNumbersForLoop {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n > 0) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            int formulaSum = n * (n + 1) / 2;
            System.out.println("Sum using loop: " + sum);
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Results match: " + (sum == formulaSum));
        } else {
            System.out.println(n + " is not a natural number.");
        }
        sc.close();
    }
}
