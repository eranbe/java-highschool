package eranbe.arrays;

import java.util.*;

public class UpDown {

	public static boolean isUpDown(int[] arr) {
		boolean isGoingUp = true; 
		for (int i = 0; i < arr.length - 1; i++) {
			if (isGoingUp) {
				if (arr[i] > arr[i+1]) {
					isGoingUp = false;
				} else if (arr[i] == arr[i+1]) {
					return false;
				} else {
					// still going up
				}
			} else { // isGoingUp == false - started going down
				if (arr[i] <= arr[i+1]) {// not going down anymore
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isUpDown2(int[] arr) {
		boolean isGoingUp = true;
		int i = 0;
		while (isGoingUp && i < arr.length - 1) {
			if (arr[i] == arr[i+1]) {
				return false;
			}
			if (arr[i] > arr[i+1]) {
				isGoingUp = false;
			}
			i++;
		}
		while (!isGoingUp && i < arr.length - 1) {
			if (arr[i] == arr[i+1]) {
				return false;
			}
			if (arr[i] < arr[i+1]) {
				return false;
			}
			i++;
		}
		return true;
	}
	
	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i+1 != arr.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	private static int[] createRandomArray(int size) {
		int[] result = new int[size];
		Random rnd = new Random();
		for (int i = 0; i < result.length; i++) {
			result[i] = rnd.nextInt(10, 100);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = createRandomArray(10);
		printArray(arr);
		System.out.println("Is up-down array? " + isUpDown(arr));
		System.out.println("Is up-down array 2? " + isUpDown2(arr));
		int[] arr2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 80 };
		printArray(arr2);
		System.out.println("Is up-down array? " + isUpDown(arr2));
		System.out.println("Is up-down array 2? " + isUpDown2(arr2));
		int[] arr3 = { 10, 20, 30, 40, 50, 60, 90, 80, 90, 80 };
		printArray(arr3);
		System.out.println("Is up-down array? " + isUpDown(arr3));
		System.out.println("Is up-down array 2? " + isUpDown2(arr3));
	}
}
