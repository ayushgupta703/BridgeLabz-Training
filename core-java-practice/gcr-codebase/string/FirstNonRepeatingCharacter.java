package String;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
	public static Character findFirstNonRepeatingChar(String str) {
        int[] freq = new int[256];

        int length = getStringLength(str);

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return null;
    }

    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = sc.nextLine();

        Character result = findFirstNonRepeatingChar(inputString);

        if (result != null) {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("There is no non-repeating character in the string.");
        }

        sc.close();
    }
}
