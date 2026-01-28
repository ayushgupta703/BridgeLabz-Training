package scenaro_based;

import java.util.Scanner;

public class FlipKey {

    public static String CleanseAndInvert(String input) {
        if (input == null || input.length() < 6) {
            return "";
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
                return "";
            }
        }

        String lower = input.toLowerCase();
        String filtered = "";

        for (int i = 0; i < lower.length(); i++) {
            int ascii = (int) lower.charAt(i);
            if (ascii % 2 != 0) {
                filtered += lower.charAt(i);
            }
        }

        String reversed = "";
        for (int i = filtered.length() - 1; i >= 0; i--) {
            reversed += filtered.charAt(i);
        }

        String result = "";
        for (int i = 0; i < reversed.length(); i++) {
            if (i % 2 == 0) {
                result += Character.toUpperCase(reversed.charAt(i));
            } else {
                result += reversed.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String input = sc.nextLine();

        String key = CleanseAndInvert(input);

        if (key.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + key);
        }
        sc.close();
    }
}
