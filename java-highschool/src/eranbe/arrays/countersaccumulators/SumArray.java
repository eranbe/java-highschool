package eranbe.arrays.countersaccumulators;

import java.util.*;

public class SumArray {
	public static int[] reset(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0;
		return arr;
	}

	public static void inputAndSum(int[] arr) {
		Scanner in = new Scanner(System.in);
		int num, play;
		System.out.println("Enter the play number (1 - " + arr.length + ")"
				+ " and num of tickets (positive numbe). 0 0 to end");
		play = in.nextInt();
		num = in.nextInt();
		while (num != 0 && play != 0) {
/*			if (play < 1 || play > arr.length) {
				System.out.println("Ilegal play number: " + num);
			} else if (num < 1) {
				System.out.println("Num tickets should be more than 0");
			} else {*/
				arr[play - 1] = arr[play - 1] + num;
				System.out.println("The play number and the number of tickets ");
				play = in.nextInt();
				num = in.nextInt();
			//}
		}
	}

	public static void printTicketsPerPlay(int[] arr) {
		// פעולה המקבלת מערך של מספרי כרטיסים לכל הצגה
		// ומדפיסה את מספר הכרטיסים לכל הצגה
		System.out.println("Tickets per play:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(" The play: " + (i + 1) + ", num of tickets: " + arr[i]);

	}

	public static void printZeroTickets(int[] arr) {
		// פעולה המקבלת מערך של מספרי כרטיסים להצגה
		// ומדפיסה את מספרי ההצגות שלא נרכשו אליהן כרטיסים
		System.out.println("Zero tickets plays:");
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 0)
				System.out.println("The play: " + (i + 1) + ", no tickets purchased");
	}

	public static void main(String[] args) {
		int[] ArrPlay = reset(10);
		inputAndSum(ArrPlay);
		printTicketsPerPlay(ArrPlay);
		printZeroTickets(ArrPlay);
	}
}
