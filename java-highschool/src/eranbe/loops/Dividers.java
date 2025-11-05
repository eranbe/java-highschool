package eranbe.loops;

import java.util.Scanner;

/**
 * תוכנית שקולטת מספר חיובי שלם, מדפיסה את כל המחלקים שלו, וכמה מחלקים יש לו בסך הכל חוץ מ-1 ומעצמו.
 */
public class Dividers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num, dividerCount = 0;
		System.out.println("Enter a positive integer:");
		num = in.nextInt();
		// מספיק לבדוק עד num / 2.
		// חשבו מדוע זה נכון
		for (int i = 2; i < (num / 2); i++) {
			if (num % i == 0) {
				dividerCount++;
				System.out.println(num + " divides by " + i);
			}
		}
		System.out.println("Total number of dividers for " + num + " (excluding 1 and " + num + "): " + dividerCount);
	}

}
