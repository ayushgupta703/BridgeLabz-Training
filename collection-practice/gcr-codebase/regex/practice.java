package regexQ;

import java.util.regex.*;
import java.util.Scanner;
public class practice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		Email Validation
		String mailRegex = "^[a-zA-Z0-9_-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$";
		Pattern patternMail = Pattern.compile(mailRegex);
		String mail = scanner.next();
		Matcher matcherMail = patternMail.matcher(mail);
		System.out.println(mail.matches(".*" + mailRegex + ".*"));
		while (matcherMail.find()) {
            System.out.println("Matched: " + matcherMail.group());
        }
		
		
//		Password validation
		String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[*!@#$_-])[A-Za-z0-9*!@#$_-]{10,}$";
		Pattern patternPass = Pattern.compile(passRegex);
		String pass = scanner.next();
		Matcher matcherPass = patternPass.matcher(pass);
		System.out.println(pass.matches(passRegex));
		while (matcherPass.find()) {
            System.out.println("Matched: " + matcherPass.group());
        }
		scanner.close();
	}
}
