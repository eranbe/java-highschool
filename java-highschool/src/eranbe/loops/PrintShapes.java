package eranbe.loops;

import java.util.Scanner;

public class PrintShapes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter square width:");
		int width = in.nextInt();
		System.out.print("Enter square length:");
		int length = in.nextInt();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.print("Enter triangle height:");
		int height = in.nextInt();
		for (int i = 1; i <= height; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < height; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	

		System.out.println();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < height-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
}
