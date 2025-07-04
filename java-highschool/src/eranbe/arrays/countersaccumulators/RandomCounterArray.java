package eranbe.arrays.countersaccumulators;

import java.util.*;

/**
 * התוכנית מגרילה
 * 100 
 * מספרים חד ספרתיים ומדפיסה:
 * את הספרה שהוגרלה הכי מעט פעמים
 * את הספרה שהוגרלה הכי הרבה פעמים
 * את כל מערך המונים
 */
public class RandomCounterArray {
	// פעולה המקבלת מערך מונים ריק ומאפסת את איברי המערך
	// שימו לב! העברת מערך כפרמטר לפעולה
	public static void reset(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	// פעולה המקבלת מערך מאופס, וכמה פעימים להגריל ספרות. מגרילה ספרות, ומגדילה את המונה שלהן
	public static void randomDigit(int[] arr, int howMany) {
		Random rnd = new Random();
		int num;
		for (int i = 0; i < howMany; i++) {
			num = rnd.nextInt(arr.length);
			arr[num]++;
		}
	}

	// פעולה המקבלת מערך מונים מלא, ומחזירה את הספרה שהוגרלה הכי פחות פעמים
	public static int minNumber(int[] arr) {
		int digit = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				digit = i;
			}
		}
		return digit;
	}

	// פעולה המקבלת מערך מונים מלא, ומחזירה את הספרה שהוגרלה הכי הרבה פעמים
	public static int maxNumber(int[] arr) {
		int digit = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				digit = i;
			}
		}
		return digit;
	}

	// פעולה שמדפיסה מערך מונים
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.println("the digit " + i + " appears " + arr[i] + " times");
	}

	public static void main(String[] args) {
		int[] digits = new int[10];
		reset(digits);
		randomDigit(digits, Integer.MAX_VALUE);
		System.out.println("The digit " + minNumber(digits) + " appears the min number of times");
		System.out.println("The digit " + maxNumber(digits) + " appears the max number of times");
		printArr(digits);
	}
}
