
import java.util.*;

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class CustomException {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("Age must be 18 or above");
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            validateAge(sc.nextInt());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
