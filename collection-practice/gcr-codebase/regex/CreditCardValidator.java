package regexQ;

public class CreditCardValidator {
    public static void main(String[] args) {
        String card = "4123456789012345";
        String regex = "^(4|5)\\d{15}$";

        System.out.println(card.matches(regex));
    }
}
