package String;
import java.util.Scanner;

public class UniqueCharacterFrequencies {
	public static char[] uniqueCharacters(String str) {
        int len = getStringLength(str);
        char[] tempUnique = new char[len];
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
                tempUnique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        System.arraycopy(tempUnique, 0, uniqueChars, 0, uniqueCount);

        return uniqueChars;
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

    public static String[][] findFrequencies(String str) {
        int[] freq = new int[256];
        int len = getStringLength(str);

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        char[] uniqueChars = uniqueCharacters(str);

        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = Character.toString(uniqueChars[i]);
            result[i][1] = Integer.toString(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = sc.nextLine();

        String[][] freqs = findFrequencies(inputString);

        System.out.println("Frequencies of unique characters:");
        for (int i = 0; i < freqs.length; i++) {
            System.out.println("Character: '" + freqs[i][0] + "' - Frequency: " + freqs[i][1]);
        }

        sc.close();
    }
}
