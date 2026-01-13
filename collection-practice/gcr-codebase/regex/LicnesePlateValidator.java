package regexQ;

public class LicnesePlateValidator {
	public static void main(String[] args) {
		String regex = "^[A-Z]{2}\\d{4}$";
		String input = "AB1234";
		if(input.matches(regex)) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}		
	}
}
