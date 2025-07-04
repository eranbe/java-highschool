package eranbe.loops;

import java.util.*;

public class Rhombos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an odd value for the diagonal: ");
		int direction = 1;
		
		int diagonal = in.nextInt();
		System.out.println();
		int spaces = diagonal / 2;
		int stars = 1;
		for (int i = 0; i < diagonal; i++) {
			for (int j = 0; j < spaces; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < stars; j++) {
				System.out.print("*");
			}
			System.out.println();
			spaces = spaces - direction;
			stars = stars + (2 * direction);
			if (i == (diagonal / 2 ) - 1) {
				direction = -direction;
			}
		}
	}
}
