package String;
import java.util.Scanner;

public class CharacterFrequencyNestedLoop {
	public static String[] findCharFrequencies(String input) {
        char[] chars = input.toCharArray();
        int[] freq = new int[chars.length];
//        boolean[] counted = new boolean[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && chars[j] != '0') {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        String[] result = new String[chars.length];

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0' && freq[i] > 0) {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        String[] finalResult = new String[index];
        System.arraycopy(result, 0, finalResult, 0, index);
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        String[] frequencies = findCharFrequencies(input);

        System.out.println("Character frequencies:");
        for (String s : frequencies) {
            System.out.println(s);
        }

        scanner.close();
    }
}
