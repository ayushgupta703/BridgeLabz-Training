package BridgeLabz_Training.jUnit;

public class StringUtils {
	public String toReverse(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
		    rev += str.charAt(i);
		}
		return rev;
	}
	
	public boolean isPalindrome(String str) {
		String rev = toReverse(str);
		return str.equals(rev);
	}
	
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
