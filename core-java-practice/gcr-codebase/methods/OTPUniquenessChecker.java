
import java.util.Arrays;

public class OTPUniquenessChecker {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; // ensures OTP is between 100000 and 999999
    }

    // Method to generate an array of 10 OTPs
    public static int[] generateMultipleOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        int[] otpList = generateMultipleOTPs(10);
        System.out.println("Generated OTPs: " + Arrays.toString(otpList));
        boolean unique = areOTPsUnique(otpList);
        System.out.println("Are all OTPs unique? " + unique);
    }
}
