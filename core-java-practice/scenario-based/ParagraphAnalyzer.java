package ScenarioBased;

public class ParagraphAnalyzer {

    public static int countWords(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return 0;
        }
        return paragraph.trim().split("\\s+").length;
    }

    public static String longestWord(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        String[] words = paragraph.trim().split("\\s+");
        String longest = words[0];

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static String replaceWord(String paragraph, String oldWord, String newWord) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }
        return paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        String paragraph = "Java is powerful. Java is fast and Java is popular.";

        System.out.println("Word Count: " + countWords(paragraph));
        System.out.println("Longest Word: " + longestWord(paragraph));
        System.out.println("Replaced Text: " +
                replaceWord(paragraph, "java", "Python"));
    }
}
