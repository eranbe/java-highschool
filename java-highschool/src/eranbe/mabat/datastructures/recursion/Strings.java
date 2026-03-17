package eranbe.mabat.datastructures.recursion;

public class Strings {
	public static void main(String[] args) {
		System.out.println(countSmallLetters("ABC"));
		System.out.println(countSmallLetters("abc"));
		System.out.println(countSmallLetters("AbC"));
		System.out.println(countSmallLetters(""));
		System.out.println(countSmallLetters2("ABC"));
		System.out.println(countSmallLetters2("abc"));
		System.out.println(countSmallLetters2("AbC"));
		System.out.println(countSmallLetters2(""));
		System.out.println(isAlpha("ABC"));
		System.out.println(isAlpha("AB&C"));
		System.out.println(isAlpha2("ABC"));
		System.out.println(isAlpha2("AB&C"));
		System.out.println(addStarAfter3("abcdef"));
		System.out.println(addStarAfter3("abcde"));
		System.out.println(addStarAfter3("abc"));
		System.out.println(addStarAfter3("ab"));
		System.out.println(addStarAfter3(""));
		System.out.println(addStarAfter3_2("abcdef"));
		System.out.println(addStarAfter3_2("abcde"));
		System.out.println(addStarAfter3_2("abc"));
		System.out.println(addStarAfter3_2("ab"));
		System.out.println(addStarAfter3_2(""));
		System.out.println(reverse("abcdef"));
		System.out.println(reverse2("abcdef"));
	}
	
	// 31.
	public static int countSmallLetters(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		char c = s.charAt(0); 
		if (c >= 'a' && c <= 'z') {
			result = 1;
		}
		return result + countSmallLetters(s.substring(1));
	}
	
	// 31. - without substring
	public static int countSmallLetters2(String s) {
		return countSmallLetters2(s, 0);
	}

	private static int countSmallLetters2(String s, int i) {
		if (s == null || i == s.length()) {
			return 0;
		}
		int result = 0;
		char c = s.charAt(i); 
		if (c >= 'a' && c <= 'z') {
			result = 1;
		}
		return result + countSmallLetters2(s, i+1);
	}

	// 32.
	public static boolean isAlpha(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		char c = s.charAt(0); 
		if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
			return false;
		}
		return isAlpha(s.substring(1));
	}
	
	// 32. - without substring
	public static boolean isAlpha2(String s) {
		return isAlpha2(s, 0);
	}

	private static boolean isAlpha2(String s, int i) {
		if (s == null || i == s.length()) {
			return true;
		}
		char c = s.charAt(i); 
		if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
			return false;
		}
		return isAlpha2(s, i+1);
	}
	
	// 33.
	public static String addStarAfter3(String s) {
		if (s.length() < 3) {
			return s;
		}
		String first3 = s.substring(0, 3);
		return first3 + "*" + addStarAfter3(s.substring(3));
	}

	// 33. - without substring
	public static String addStarAfter3_2(String s) {
		return addStarAfter3_2(s, 0);
	}
	
	private static String addStarAfter3_2(String s, int i) {
		if (i == s.length()) {
			return "";
		}
		String result = addStarAfter3_2(s, i+1);
		if (i % 3 == 2) {
			result = "*" + result;
		}
		return "" + s.charAt(i) + result;
	}
	
	// 34.
	public static String reverse(String s) {
		if (s == null | s.length() == 0) {
			return "";
		}
		return "" + s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}
	
	// 34. - without substring
	public static String reverse2(String s) {
		return reverse2(s, s.length()-1);
	}

	private static String reverse2(String s, int i) {
		if (i < 0) {
			return "";
		}
		return "" + s.charAt(i) + reverse2(s, i-1);
	}
}
