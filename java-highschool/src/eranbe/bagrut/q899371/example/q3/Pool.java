package eranbe.bagrut.q899371.example.q3;

import java.util.Scanner;

public class Pool {

	public static void main(String[] args) {
		count();
	}
	
	public static int[] checkAge(int age) {
		int[] result = new int[3];
		if (age < 12) {
			result[0] = 0;
			result[1] = 0;
			result[2] = 0;
		} else if (age < 16) {
			result[0] = 1;
			result[1] = 0;
			result[2] = 0;
		} else if (age < 18) {
			result[0] = 1;
			result[1] = 1;
			result[2] = 0;
		} else {
			result[0] = 1;
			result[1] = 1;
			result[2] = 1;
		}
		return result;
	}

	public static int[] checkAge2(int age) {
		int[] under12 = { 0, 0, 0 };
		int[] under16 = { 1, 0, 0 };
		int[] under18 = { 1, 1, 0 };
		int[] rest    = { 1, 1, 1 };
		if (age < 12) {
			return under12;
		} else if (age < 16) {
			return under16;
		} else if (age < 18) {
			return under18;
		} else {
			return rest;
		}
	}
	
	public static int[] checkAge3(int age) {
		int[] result = new int[3];
		if (age >= 12) {
			result[0] = 1;
		} 
		if (age >= 16) {
			result[1] = 1;
		} 
		if (age >= 18) {
			result[2] = 1;
		}
		return result;		
	}

	public static void count() {
		Scanner in = new Scanner(System.in);
		int[] counts = new int[3];
		System.out.println("Enter age: ");
		int age = in.nextInt();
		int[] ageCheckResult = checkAge(age);
		while (canEnter(ageCheckResult)) { // or age >= 12
			for (int i = 0; i < counts.length; i++) {
				counts[i] += ageCheckResult[i];
			}
			System.out.println("Enter age: ");
			age = in.nextInt();
			ageCheckResult = checkAge(age);
		}
		System.out.println(counts[0] + "," + counts[1] + "," + counts[2]);
	}

	/**
	 * Check that there is at least one thing the visitor can use.
	 */
	public static boolean canEnter(int[] ageCheckResult) {
		for (int i = 0; i < ageCheckResult.length; i++) {
			if (ageCheckResult[i] != 0)
				return true;
		}
		return false;
	}
}
