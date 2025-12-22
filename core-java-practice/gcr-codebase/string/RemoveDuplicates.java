import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            if (result.indexOf(input.charAt(i)) == -1) {
                result += input.charAt(i);
            }
        }

        System.out.println("String after removing duplicates: " + result);
    }
}