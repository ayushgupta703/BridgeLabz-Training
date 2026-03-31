package regexQ;

public class ColorHexCodeValidator {
	public static void main(String[] args) {
		String regex = "^#[A-Fa-f\\d]{6}$";
		String input = "#FFA500";
		if (input.matches(regex)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}
}
