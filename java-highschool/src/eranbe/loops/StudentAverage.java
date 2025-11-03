package eranbe.loops;

import java.util.Scanner;

public class StudentAverage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int mathGrade, englishGrade, csGrade, count;
		double average;
		System.out.println("How many students? ");
		count = in.nextInt();
		for (int i = 1; i <= count; i++) {
			System.out.println("Enter grades for student number " + i);
			System.out.print("Enter math grade: ");
			mathGrade = in.nextInt();
			System.out.print("Enter English grade: ");
			englishGrade = in.nextInt();
			System.out.print("Enter Computer Science grade: ");
			csGrade = in.nextInt();
			average = (mathGrade + englishGrade + csGrade) / 3.0;
			System.out.println("The average grade for student number " + i + " is " + average);
		}
	}
}
