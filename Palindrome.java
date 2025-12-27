/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
		System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		if (s.length() == 1 || s.length() == 0) {
			return true;
		}
		// Helpful for my understanding on how i got it wrong at the start:
		// System.out.println(s.substring(0,1) + " " + s.substring(s.length() - 1));
		boolean result = s.substring(0, 1).equals(s.substring(s.length() - 1));
		return result && isPalindrome(s.substring(1, s.length() - 1));
    }
}