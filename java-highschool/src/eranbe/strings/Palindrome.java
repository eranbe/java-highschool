package eranbe.strings;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("madamimadam"));
		System.out.println(isPalindrome("hello"));
		System.out.println(isPalindrome("Able was I ere I saw Elba"));
		System.out.println(isPalindrome("level"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome(null));
	}

	private static boolean isPalindrome(String text) {
		if (text == null || text .length() == 0) {
			return true;
		}
		text = text.toLowerCase();
		int left = 0;
		int right = text.length() - 1;
		while (left < right) {
			if (text.charAt(left) != text.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
