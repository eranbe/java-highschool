package eranbe.arrays.countersaccumulators.exercises;

import java.util.*;
public class Playground {

	public static void main(String[] args) {
		int[] buildingKids = reset(50);
		readInput(buildingKids);
		double average = calcAverageKids(buildingKids);
		printArray(buildingKids);
		printPlaygroundBuildings(buildingKids, average);
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i+1 != arr.length) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	private static void printPlaygroundBuildings(int[] buildingKids, double average) {
		System.out.println("average is: " + average);
		System.out.println("Build playgrunds at the following buildings");
		for (int i = 0; i < buildingKids.length; i++) {
			if (buildingKids[i] > average) {
				System.out.print((i+1) + " ");
			}
		}
		System.out.println();
	}

	private static double calcAverageKids(int[] buildingKids) {
		int sum = 0;
		for (int i = 0; i < buildingKids.length; i++) {
			sum += buildingKids[i];
		}
		return sum / (double) buildingKids.length;
	}

	private static void readInput(int[] buildingKids) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter building (1-50) and age. 0 0  to end");
		int building = in.nextInt();
		int age = in.nextInt();
		while (building != 0 && age != 0) {
			if (age < 15) {
				buildingKids[building-1]++;
			}
			building = in.nextInt();
			age = in.nextInt();
		}
	}

	private static int[] reset(int size) {
		return new int[size];
	}
}
