package eranbe.bagrut.q899371.example.q2;

import java.util.Scanner;

public class PhoneOrder {

	public static boolean check(int numProducts) {
		double sum = 0;
		Scanner in = new Scanner(System.in);
		for (int i = 1; i <= numProducts; i++) {
			System.out.print("Enter price for product " + i);
			double price = in.nextDouble();
			sum += price;
		}
		return sum > 150;
	}
	
	public static int checkAll() {
		int count = 0;
		Scanner in = new Scanner(System.in);
		for (int i = 1; i <= 850; i++) {
			System.out.print("Enter no of products for customer " + i);
			int numProducts = in.nextInt();
			if (check(numProducts)) {
				count++;
			}
		}
		return count;
	}
}
