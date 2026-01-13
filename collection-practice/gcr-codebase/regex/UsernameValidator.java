package regexQ;

public class UsernameValidator {
	public static void main(String[] args) {
		String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
		String input = "user_123";
		if (input.matches(regex)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
	}
}
