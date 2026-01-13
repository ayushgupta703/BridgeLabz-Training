package regexQ;

public class CensorWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String regex = "(?i)damn|stupid"; // (?i) = case-insensitive

        String result = text.replaceAll(regex, "****");
        System.out.println(result);
    }
}
