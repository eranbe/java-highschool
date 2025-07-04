package eranbe.simplegames;

import java.util.*;

public class PrisonersGame {
	
	private static void shuffleArray(int[] arr) {
		Random rnd = new Random();
		for (int i = 0; i < arr.length; i++) {
			int idxToSwap = rnd.nextInt(arr.length);
			int tmp = arr[idxToSwap];
			arr[idxToSwap] = arr[i];
			arr[i] = tmp;
		}
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}
	private static String walk(int[] arr, int i) {
		int stepCount = 0;
		int cellToCheck = i;
		String path = "";
		while (stepCount < 50) {
			path = path + cellToCheck + ",";
			if (arr[cellToCheck] == i) {
				System.out.println("Found path for prisoner " + i + " " + path);
				return "";
			}
			stepCount++;
			cellToCheck = arr[cellToCheck];
		}
		return path;
	}
	
	public static void main(String args[]) {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		shuffleArray(arr);
		printArray(arr);
		boolean success = true;
		String path = null;
		int i = 0;
		while (i < 100 && success) {
			path = walk(arr, i);
			success = path.isEmpty();
			i++;
		}
		System.out.println("Success: " + success + " Prisoners " + i + " Path: " + path);
	}

}
