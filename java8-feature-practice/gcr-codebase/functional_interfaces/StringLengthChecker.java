package functional_interfaces;

import java.util.Scanner;
import java.util.function.Function;

public class StringLengthChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int charLimit = 15;
		Function<String, Integer> lengthFinder = s -> s.length();
        System.out.print("Enter Your String: ");
		int length = lengthFinder.apply(scanner.nextLine());
		if (length > charLimit) {
			System.out.println("Character Limit Exceeded!!");
		} else {
			System.out.println("String Under Character Limit!!");
		}
		scanner.close();
	}
}
