package eranbe.arrays.countersaccumulators.exercises;

import java.util.*;

public class RenuarShirts {
	public static void main(String[] args) {
		int[] shirtsPerMonth = readShirtSales();
		printArray(shirtsPerMonth);
		printNoSaleMonths(shirtsPerMonth);
		printMoreThanAverageMonths(shirtsPerMonth);
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

	private static void printMoreThanAverageMonths(int[] shirtsPerMonth) {
		double average = calcAverage(shirtsPerMonth);
		System.out.println("Average is: " + average);
		System.out.print("More than average months: ");
		for (int i = 0; i < shirtsPerMonth.length; i++) {
			if (shirtsPerMonth[i] > average) {
				System.out.print((i+1) + " ");
			}
		}
		System.out.println();
		
	}

	private static double calcAverage(int[] shirtsPerMonth) {
		int sum = 0;
		for (int i = 0; i < shirtsPerMonth.length; i++) {
			sum += shirtsPerMonth[i];
		}
		double average = sum / 12.0;
		return average;
	}

	private static void printNoSaleMonths(int[] shirtsPerMonth) {
		System.out.print("No sale months: ");
		for (int i = 0; i < shirtsPerMonth.length; i++) {
			if (shirtsPerMonth[i] == 0) {
				System.out.print((i+1) + " ");
			}
		}
		System.out.println();
	}

	private static int[] readShirtSales() {
		Scanner in = new Scanner(System.in);
		int month, count;
		int[] shirtsPerMonth = new int[12];
		System.out.println("Enter sales data: Month (1-12), no of shirts sold.");
		int read = 0;
		while (read < 10) {
			month = in.nextInt();
			count = in.nextInt();
			if (month < 1 || month > 12) {
				System.out.println("Illegal month");
			} else if (count < 1) {
				System.out.println("no of sold shirts should be more than 0");
			} else {
				shirtsPerMonth[month - 1] += count;
				read++;
			}
		}
		return shirtsPerMonth;
	}
}