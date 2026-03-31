package String;
import java.util.Scanner;

public class CharacterFrequencies {
	public static String[][] findFrequencies(String str) {
        int[] freq = new int[256];

        int length = getStringLength(str);

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = Character.toString((char)i);
                result[index][1] = Integer.toString(freq[i]);
                index++;
            }
        }

        return result;
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

        String[][] frequencies = findFrequencies(inputString);

        System.out.println("Character frequencies:");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println("Character: '" + frequencies[i][0] + "' - Frequency: " + frequencies[i][1]);
        }

        sc.close();
    }
}
