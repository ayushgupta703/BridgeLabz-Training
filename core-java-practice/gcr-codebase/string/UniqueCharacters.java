package String;
import java.util.Scanner;

public class UniqueCharacters {
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

    public static char[] findUniqueCharacters(String str) {
        int len = getStringLength(str);
        char[] uniqueChars = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char currentChar = str.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueChars[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        System.arraycopy(uniqueChars, 0, result, 0, uniqueCount);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = sc.nextLine();

        char[] uniqueChars = findUniqueCharacters(inputString);

        System.out.print("Unique characters in the string: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        sc.close();
    }
}
