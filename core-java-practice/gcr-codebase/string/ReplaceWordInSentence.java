import java.util.Scanner;

public class ReplaceWordInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Word to replace: ");
        String wordToReplace = sc.nextLine();
        System.out.print("Replacement word: ");
        String newWord = sc.nextLine();

        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {
            if (word.equals(wordToReplace)) {
                result += newWord + " ";
            } else {
                result += word + " ";
            }
        }

        System.out.println("Modified Sentence: " + result.trim());
    }
}