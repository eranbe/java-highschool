package eranbe.arrays;

import java.util.*;

public class UpgoingOdds2 {

	public static int[] createRandomOdds(int size) {
		int[] odds = new int[size];
		Random rnd = new Random();
		for (int i = 0; i < odds.length; i++) {
			// נייצר מספרים בטווח 0-449 
			// נכפיל אותם בשתיים כדי לקבל מספרים זוגיים בטווח 0-898 
			// נוסיף למספרים הזוגיים בטווח את המספר 101
			// כדי להגיע לאי-זוגיים בטווח 101-999 
			odds[i] = rnd.nextInt(450) * 2 + 101;
		}
		return odds;
	}

	public static boolean isUpgoing(int num) {
		// 10 מובטח להיות גדול מכל ספרה
		int currDigit = 10;
		int nextDigit = num % 10;
		// נבדוק שהספרה הבאה קטנה מהספרה הקודמת
		while (nextDigit < currDigit) {
			currDigit = nextDigit;
			num = num / 10;
			nextDigit = num % 10;
		}
		// אם יצאנו מהלולאה והספרה הבאה היא 0
		// אז המספר הוא עולה, כי אין ספרה שקטנה מ-0
		// וגם לא יתכן שיש לנו שני אפסים רצופים
		return nextDigit == 0;
	}

	public static boolean[] markUpgoing(int[] randomOdds) {
		boolean[] upgoingPositions = new boolean[randomOdds.length];
		for (int i = 0; i < randomOdds.length; i++) {
			// נסמן תא במערך upgoingPositions
			// במיקום i 
			// ב-true
			// אם במערך randomOdds
			// יש בתא מספר עולה
			upgoingPositions[i] = isUpgoing(randomOdds[i]);
		}
		return upgoingPositions;
	}

	public static int countUpgoing(boolean[] upgoingPositions) {
		int count = 0;
		for (int i = 0; i < upgoingPositions.length; i++) {
			if (upgoingPositions[i]) {
				count++;
			}
		}
		return count;
	}

	public static int[] copyUpgoing(boolean[] upgoingPositions, int[] randomOdds) {
		int upgoingCount = countUpgoing(upgoingPositions);
		int[] upgoing = new int[upgoingCount];
		// nextPos יצביע לנו על המקום הפנוי הבא במערך העולים
		int nextPos = 0;
		for (int i = 0; i < upgoingPositions.length; i++) {
			if (upgoingPositions[i]) {
				upgoing[nextPos] = randomOdds[i];
				nextPos++;
			}
		}
		return upgoing;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}

    public static void main(String[] args) {
		int[] randomOdds = createRandomOdds(10);
		// מערך עזר שמסומנים בו התאים ב-randomOdds
		// בהם יש מספרים עולים
		boolean[] upgoingPositions = markUpgoing(randomOdds);
		System.out.println("כמות המספריים העולים: " + countUpgoing(upgoingPositions));
		int[] upgoing = copyUpgoing(upgoingPositions, randomOdds);
		System.out.println("Odds array:");
		printArray(randomOdds);
		System.out.println("Upgoing array:");
		printArray(upgoing);
	}
}
