package String;
import java.util.Scanner;

public class PalindromeChecker {
	public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = getStringLength(text) - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static char[] reverseString(String text) {
        int len = getStringLength(text);
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = text.charAt(len - 1 - i);
        }
        return reversed;
    }

    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a text to check if it's a palindrome:");
        String inputText = sc.nextLine();

        boolean resultIterative = isPalindromeIterative(inputText);
        boolean resultRecursive = isPalindromeRecursive(inputText, 0, getStringLength(inputText) - 1);
        boolean resultArray = isPalindromeUsingArrays(inputText);

        System.out.println("\nPalindrome check results:");
        System.out.println("Using iterative method: " + (resultIterative ? "Palindrome" : "Not Palindrome"));
        System.out.println("Using recursive method: " + (resultRecursive ? "Palindrome" : "Not Palindrome"));
        System.out.println("Using array comparison: " + (resultArray ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
