package eranbe.arrays;

public class ReverseWords {

	public static void main(String[] args) {
		char[] arr = { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd' };
		char[] arr2 = { 'o', 'n', 'e' };
		char[] arr3 = { 't', 'w', 'o', ' ' };
		reverseWords(arr);
		reverseWords(arr2);
		reverseWords(arr3);
		System.out.println(arr);
		System.out.println(arr2);
		System.out.println(arr3);
	}

	private static void reverseWords(char[] arr) {
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (c == ' ') {
				reverseWord(arr, start, i-1);
				start = i+1;
			}
		}
		reverseWord(arr, start, arr.length-1);
	}
	
	private static void reverseWord(char[] arr, int start, int end) {
		char temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
