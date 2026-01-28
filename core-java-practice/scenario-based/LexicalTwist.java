package scenaro_based;

import java.util.*;

public class LexicalTwist {
    public static boolean isInvalid(String word) {
        return word.trim().contains(" ");
    }

    public static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first word: ");
        String first = sc.nextLine();

        if (isInvalid(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.print("Enter the second word: ");
        String second = sc.nextLine();
        
        if (isInvalid(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }

        String reversedFirst =
                new StringBuilder(first).reverse().toString();

        if (reversedFirst.equalsIgnoreCase(second)) {
            String result = reversedFirst.toLowerCase();
            result = result.replaceAll("[aeiou]", "@");
            System.out.println(result);

        } else {
            String combined = (first + second).toUpperCase();

            int vowelCount = 0, consonantCount = 0;

            for (char ch : combined.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (isVowel(ch)) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }

            if (vowelCount > consonantCount) {
                Set<Character> vowels = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (isVowel(ch)) {
                        vowels.add(ch);
                    }
                    if (vowels.size() == 2) break;
                }

                for (char v : vowels) {
                    System.out.print(v);
                }

            } else if (consonantCount > vowelCount) {
                Set<Character> consonants = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (Character.isLetter(ch) && !isVowel(ch)) {
                        consonants.add(ch);
                    }
                    if (consonants.size() == 2) break;
                }

                for (char c : consonants) {
                    System.out.print(c);
                }

            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
        sc.close();
    }
}
