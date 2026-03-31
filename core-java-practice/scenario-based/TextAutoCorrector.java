package ScenarioBased;

public class TextAutoCorrector {

    public static String formatParagraph(String input) {

        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        // Remove extra spaces
        input = input.trim().replaceAll("\\s+", " ");

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            // After punctuation, ensure capitalization
            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;
                if (i + 1 < input.length() && input.charAt(i + 1) != ' ') {
                    result.append(' ');
                }
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String text = "hello   world.this is   java!how are you?  i am fine.";
        System.out.println(formatParagraph(text));
    }
}
