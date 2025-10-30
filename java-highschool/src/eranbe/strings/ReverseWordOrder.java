package eranbe.strings;

public class ReverseWordOrder {

	public static void main(String[] args) {
		System.out.println(reverseWordOrder("Hello World"));
		System.out.println(reverseWordOrder("Java programming is fun"));
		System.out.println(reverseWordOrder("one"));
		System.out.println(reverseWordOrder("a b c d"));
		System.out.println(reverseWordOrder(" leading and trailing spaces "));

	}

	private static String reverseWordOrder(String sentence) {
		String result = "";
		String word;
		while (sentence.lastIndexOf(' ') != -1) {
			word = sentence.substring(sentence.lastIndexOf(' ') + 1);
			result += word + " ";
			sentence = sentence.substring(0, sentence.lastIndexOf(' '));
		}
		result += sentence;
		return result;
	}
}
