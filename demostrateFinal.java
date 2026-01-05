package reviews;

public class demostrateFinal {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block: No exception expected.");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Inside catch block: An exception was caught.");
        } finally {
            System.out.println("Inside finally block: Cleanup complete.");
        }
        System.out.println("Rest of the code after the try-catch-finally block.");
    }
}
