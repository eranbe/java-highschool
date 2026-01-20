package eranbe.conditions;

import java.util.Scanner;

public class LightHeavyPair {

	public static void main(String[] args) {
		countHeavyLightPairs(3);
	}

	public static int sumDigits(int n) {
		if (n < 0) {
			return 0;
		}
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
	public static int countHeavyLightPairs(int n) {
		Scanner in = new Scanner(System.in);
		int count = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Enter 2 positive numbers:");
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			if (sumDigits(num1) > sumDigits(num2)) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
}
