package eranbe.recursion;

import java.util.Scanner;

public class Collatz {

	public static int calcNextStep(int n) {
		System.out.print(" -> " + n);
		if (n == 1) {
			return 1;
		}
		else if (n % 2 == 0) {
			return 1 + calcNextStep(n / 2);
		}
		else {
			return 1 + calcNextStep(n * 3 + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter a positive integer (0 to stop):");
		int n = in.nextInt();
		while (n > 0) {
			int steps = calcNextStep(n);
			System.out.println();
			System.out.println(steps + " steps");
			System.out.println("Enter a positive integer (0 to stop):");
			n = in.nextInt();
		}
	}
}
