package functional_interfaces;

interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;

        boolean upper = false, lower = false, digit = false, special = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            else if (Character.isLowerCase(c)) lower = true;
            else if (Character.isDigit(c)) digit = true;
            else special = true;
        }
        return upper && lower && digit && special;
    }
}

public class PasswordStrengthValidator {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Strong@123"));
    }
}
