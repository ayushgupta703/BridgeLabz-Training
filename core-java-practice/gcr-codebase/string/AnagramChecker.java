package String;
import java.util.Scanner;

public class AnagramChecker {
	public static boolean areAnagrams(String text1, String text2) {
        int len1 = getStringLength(text1);
        int len2 = getStringLength(text2);

        if (len1 != len2) {
            return false;
        }

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < len1; i++) {
            char ch = text1.charAt(i);
            freq1[ch]++;
        }

        for (int i = 0; i < len2; i++) {
            char ch = text2.charAt(i);
            freq2[ch]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
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

        System.out.println("Enter the first text:");
        String text1 = sc.nextLine();

        System.out.println("Enter the second text:");
        String text2 = sc.nextLine();

        if (areAnagrams(text1, text2)) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }

        sc.close();
    }
}
