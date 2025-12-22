import java.util.Scanner;

public class LexicographicalCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        int len = Math.min(str1.length(), str2.length());
        boolean equal = true;

        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                equal = false;
                if (str1.charAt(i) < str2.charAt(i))
                    System.out.println(str1 + " comes before " + str2);
                else
                    System.out.println(str2 + " comes before " + str1);
                break;
            }
        }

        if (equal) {
            if (str1.length() == str2.length())
                System.out.println("Strings are equal.");
            else if (str1.length() < str2.length())
                System.out.println(str1 + " comes before " + str2);
            else
                System.out.println(str2 + " comes before " + str1);
        }
    }
}