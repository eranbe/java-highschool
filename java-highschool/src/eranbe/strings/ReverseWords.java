package eranbe.strings;

public class ReverseWords {

	public static void main(String[] args) {
		System.out.println(reverseWordsInternally("Hello World"));
		System.out.println(reverseWordsInternally("java programming is fun"));
		System.out.println(reverseWordsInternally("a b c"));
		System.out.println(reverseWordsInternally("level"));
		System.out.println(reverseWordsInternally("madam in eden im adam"));
		System.out.println(reverseWordsInternally(""));
		System.out.println(reverseWordsInternally("Programming is awesome"));
	}

	private static String reverseWordsInternally(String sentence) {
		String result = "";
		String word = "";
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (c == ' ') {
				result = result + reverseWord(word) + ' ';
				word = "";
			} else {
				word += c;
			}
		}
		if (word.length() > 0) {
			result = result + reverseWord(word);
		}
		return result;
	}

	private static String reverseWord(String word) {
		String result = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			result += word.charAt(i);
		}
		return result;
	}

}
