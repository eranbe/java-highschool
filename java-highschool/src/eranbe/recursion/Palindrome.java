package eranbe.recursion;

public class Palindrome {
	public static boolean isPalindrome(int n) {
	    String s = Integer.toString(n);
	    return isPalindromeHelper(s, 0, s.length() - 1);
	}

	private static boolean isPalindromeHelper(String s, int left, int right) {
	    if (left >= right) {
	        return true;
	    }
	    if (s.charAt(left) != s.charAt(right)) {
	        return false;
	    }
	    return isPalindromeHelper(s, left + 1, right - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(123454321));
		System.out.println(isPalindrome(121212));
	}
}
