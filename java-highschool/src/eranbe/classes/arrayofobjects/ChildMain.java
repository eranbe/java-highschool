package eranbe.classes.arrayofobjects;

import java.util.Scanner;

public class ChildMain {
	public static void main(String[] args) {
		Child[] children = readChildren(5);
		printGanHovaCount(children, 2025);
		printPaidLessThanAverage(children);
		printMostCommonAge(children, 2025);
	}
	
	public static Child[] readChildren(int howMany) {
		Scanner in = new Scanner(System.in);
		Child[] children = new Child[howMany];
		String name;
		int year, payment;
		for (int i = 0; i < children.length; i++) {
			System.out.println("Enter child name, year of birth, and payment");
			name = in.next();
			year = in.nextInt();
			payment = in.nextInt();
			children[i] = new Child(name, year, payment);
		}
		return children;
	}
	
	public static void printGanHovaCount(Child[] children, int thisYear) {
		int count = 0;
		for (int i = 0; i < children.length; i++) {
			int childAge = calcAge(children[i], thisYear);
			if (childAge >= 5 && childAge <= 6) {
				count++;
			}
		}
		System.out.println("There are " + count + " Gan Hova age children");
	}
	
	public static void printPaidLessThanAverage(Child[] children) {
		double average = calcAveragePayment(children);
		for (int i = 0; i < children.length; i++) {
			if (children[i].getPayment() < average) {
				System.out.println(children[i].getName() + " paid less than average");
			}
		}
	}
	
	public static double calcAveragePayment(Child[] children) {
		int sum = 0;
		for (int i = 0; i < children.length; i++) {
			sum += children[i].getPayment();
		}
		return sum / (double) children.length;
		
	}

	public static void printMostCommonAge(Child[] children, int thisYear) {
		int[] ageCounter = new int[8];
		for (int i = 0; i < children.length; i++) {
			ageCounter[calcAge(children[i], thisYear)]++;
		}
		int max = ageCounter[0];
		int maxPos = 0;
		for (int i = 1; i < ageCounter.length; i++) {
			if (ageCounter[i] > max) {
				max = ageCounter[i];
				maxPos = i;
			}
		}
		System.out.println("Most common age: " + maxPos);
	}
	
	public static int calcAge(Child child, int thisYear) {
		return thisYear - child.getYearOfBirth();
	}
}
