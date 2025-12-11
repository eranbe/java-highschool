package eranbe.bagrut.q899371.a2023;

import java.util.*;
public class Darts {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(success(scan.nextInt()));
	}
	
	public static boolean success(int num) {
		int[] scores = new int[num];
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double average;
		int sixOrMoreCount = 0;
		// read the scores
		for (int i = 0; i < scores.length; i++) {
			System.out.println("Enter score for dart #" + (i+1));
			scores[i] = scan.nextInt();
			sum += scores[i];
		}
		average = sum / (double) scores.length;
		if (average > 5.0) {
			return true;
		}
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] == 10) {
				return true;
			}
			if (scores[i] >= 6) {
				sixOrMoreCount++;
			}
		}
		return (sixOrMoreCount / (double) num) > 0.5;
	}
}
