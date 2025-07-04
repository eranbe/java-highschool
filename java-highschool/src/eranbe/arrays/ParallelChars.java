package eranbe.arrays;

import java.util.*;

public class ParallelChars {
	public static void printArray(char[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i+1 != arr.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	private static char[] readArray(int size) {
		char[] result = new char[size];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter " + size + " small chars (a-z)");
		int i = 0;
		while (i < 10) {
			char c = in.next().charAt(0);
			if (c >= 'a' && c <= 'z') {
				result[i] = c;
				i++;
			} else {
				System.out.println("illegal char. enter a-z");
			}
		}
		return result;
	}

	private static int switchChars(char[] charsArr) {
		int switchCount = 0;
		for (int i = 0; i < charsArr.length / 2; i++) {
			char low = charsArr[i];
			char high = charsArr[charsArr.length - i - 1];
			if (charsArr[i] + 1 == charsArr[charsArr.length - i - 1]) {
				char tmp = charsArr[i];
				charsArr[i] = charsArr[charsArr.length - i - 1];
				charsArr[charsArr.length - i - 1] = tmp;
				switchCount++;
			}
		}
		return switchCount;
	}

	public static void main(String[] args) {
		char[] charsArr = readArray(10);
		System.out.println("Before switch");
		printArray(charsArr);
		int switchCount = switchChars(charsArr);
		System.out.println("After switch");
		printArray(charsArr);
		System.out.println("Switched " + switchCount + " chars");
	}
}
