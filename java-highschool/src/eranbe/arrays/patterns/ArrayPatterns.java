package eranbe.arrays.patterns;

import java.util.*;

public class ArrayPatterns {
	// הדפסת מערך של מספרים
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// מציאת הערך המקסימלי במערך
	public static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	// מציאת האינדקס (על בסיס 0) של הערך המקסימלי במערך
	public static int findMaxIndex(int[] arr) {
		int max = arr[0];
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	// מציאת הערך המינימלי במערך 
	public static int findMin(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	// מציאת האינדקס (על בסיס 0) של הערך המינימלי במערך
	public static int findMinIndex(int[] arr) {
		int min = arr[0];
		int minIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	// חישוב סכום הערכים במערך
	public static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	// חישוב ממוצע הערכים במערך
	public static double average(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum / (double) arr.length;
	}

	// חישוב כמה ערכים במערך גדולים מערך נתון
	public static int countGreaterThan(int[] arr, int value) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > value) {
				count++;
			}
		}
		return count;
	}

	// החזרת מערך שמכיל את כל הערכים הגדולים מערך נתון
	public static int[] getGreaterThan(int[] arr, int value) {
		int count = countGreaterThan(arr, value);
		int[] result = new int[count];
		int nextPos = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > value) {
				result[nextPos] = arr[i];
				nextPos++;
			}
		}
		return result;
	}
	
	// מניית מספר נתון של ערכים במערך מונים
	public static int[] input_n_valuesToCountArray(int size, int count) {
		int[] arr = new int[size];
		int index;
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < count; i++) {
			index = in.nextInt();
			if (index < 1 || index > size) {
				System.out.println("ערך מחוץ לתחום");
			} else {
				arr[index-1]++;
			}
		}
		return arr;
	}

	// מניית ערכים במערך מונים עד זקיף
	public static int[] inputValuesToCountArrayUntilSentinal(int size, int sentinal) {
		int[] arr = new int[size];
		int index;
		Scanner in = new Scanner(System.in);
		index = in.nextInt();
		while (index != sentinal) {
			if (index < 1 || index > size) {
				System.out.println("ערך מחוץ לתחום");
			} else {
				arr[index-1]++;
			}
		}
		return arr;
	}

	// סכימת מספר נתון של ערכים במערך סוכמים
	public static int[] input_n_valuesToSumArray(int size, int count) {
		int[] arr = new int[size];
		int index, value;
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < count; i++) {
			index = in.nextInt();
			value = in.nextInt();
			if (index < 1 || index > size) {
				System.out.println("ערך מחוץ לתחום");
			} else {
				arr[index-1] += value;
			}
		}
		return arr;
	}

	// סכימת ערכים במערך מונים עד זקיף
	public static int[] inputValuesToSumArrayUntilSentinal(int size, int sentinal) {
		int[] arr = new int[size];
		int index, value;
		Scanner in = new Scanner(System.in);
		index = in.nextInt();
		value = in.nextInt();
		while (index != sentinal) {
			if (index < 1 || index > size) {
				System.out.println("ערך מחוץ לתחום");
			} else {
				arr[index-1] += value;
			}
		}
		return arr;
	}
	
	// העתקת מערך
	public static int[] duplicate(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	// היפוך מערך
	public static int[] reverse(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[arr.length - i - 1] = arr[i];
		}
		return result;
	}
	
	// הוספת קבוע לכל ערך
	public static int[] add(int[] arr, int value) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] += value;
		}
		return result;
	}
	
	// הכפלה של כל ערך בקבוע
	public static int[] multiply(int[] arr, int value) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] *= value;
		}
		return result;
	}
	
	// חיבור הערכים של שני מערכים
	public static int[] add(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			result[i] = arr1[i] + arr2[i];
		}
		return result;
	}
	
	// הכפלתהערכים של שני מערכים
	public static int[] multiply(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			result[i] = arr1[i] * arr2[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99, 110 };
		printArray(arr);
		System.out.println("max:" + findMax(arr));
		System.out.println("max index (0-based):" + findMaxIndex(arr));
		System.out.println("max index (1-based):" + (findMaxIndex(arr) + 1));
		System.out.println("min:" + findMin(arr));
		System.out.println("min index (0-based):" + findMinIndex(arr));
		System.out.println("min index (1-based):" + (findMinIndex(arr) + 1));
		System.out.println("sum:" + sum(arr));
		System.out.println("average:" + average(arr));
		System.out.println("How many greater than 50:" + countGreaterThan(arr, 50));
		System.out.println("Greater than 50:");
		printArray(getGreaterThan(arr, 50));
		System.out.print("duplicate:");
		printArray(duplicate(arr));
		System.out.print("reverse:");
		printArray(reverse(arr));
		System.out.print("add constant:");
		printArray(add(arr, 3));
		System.out.print("multiply constant:");
		printArray(multiply(arr, 2));
		System.out.print("add arrays:");
		printArray(add(arr, arr));
		System.out.print("multiply arrays:");
		printArray(multiply(arr, arr));
	}
}
