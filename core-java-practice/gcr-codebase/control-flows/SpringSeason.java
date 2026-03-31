import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month and day: ");
        int month = sc.nextInt(), day = sc.nextInt();

        boolean isSpring = (month == 3 && day >= 20) ||
                           (month == 4 || month == 5) ||
                           (month == 6 && day <= 20);

        System.out.println(isSpring ? "It's a Spring Season" : "Not a Spring Season");
        sc.close();
    }
}