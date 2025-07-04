package eranbe.arrays.countersaccumulators.exercises;

import java.util.*;
public class SumOfPrev {
	public static void main(String[] args) {
		int howMany = 10;
		int[] arr = readArray(howMany);
		printArray(arr);
		int[] sumArr = calcSumArray(arr);
		printArray(sumArr);
	}

	private static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	private static int[] calcSumArray(int[] arr) {
		int[] result = new int[arr.length];
		result[0] = arr[0];
		for (int i = 1; i < result.length; i++) {
			result[i] = arr[i] + result[i-1];
		}
		return result;
	}

	private static int[] readArray(int howMany) {
		System.out.println("Enter " + howMany + " numbers");
		Scanner in = new Scanner(System.in);
		int[] result = new int[howMany];
		for (int i = 0; i < result.length; i++) {
			result[i] = in.nextInt();
		}
		return result;
	}
}
