package eranbe.arrays.countersaccumulators.exercises;

import java.util.Random;

/**
 * סימולציה להדגמת חוק בנפורד
 * 
 * עוד מידע על חוק בנפורד:
 * <link>https://www.lbscience.org/blog/2020/06/17/%d7%97%d7%95%d7%a7-%d7%91%d7%a0%d7%a4%d7%95%d7%a8%d7%93-%d7%95%d7%9e%d7%9c%d7%97%d7%9e%d7%94-%d7%91%d7%94%d7%95%d7%a0%d7%90%d7%95%d7%aa/</link>
 * <link>https://www.youtube.com/watch?v=FnAMpDgTPbk</link>
 */
public class BenfordLaw {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] leadingDigits = new int[10]; // לא נשתמש בתא 0 אלא רק בתאים  1–9
        int totalNumbers = 10000;

        for (int i = 0; i < totalNumbers; i++) {
        	// יצירת תוצאת חישוב אקראית
        	int calc = generateRandomCalculation(rand);
            // שליפת הספרה הראשונה
            int firstDigit = extractFirstDigit(calc);
            leadingDigits[firstDigit]++;
        }

        printCountArray(leadingDigits, totalNumbers);
        printCountArrayAsHistogram(leadingDigits, totalNumbers);
    }

	public static int generateRandomCalculation(Random rand) {
		// ניצור חישובים אקראיים
		int a = rand.nextInt(9000) + 1000; // מספר בין 1000 ל-9999
		int b = rand.nextInt(90) + 10;     // מספר בין 10 ל-99
		int result = a * b;
		return result;
	}

	public static void printCountArray(int[] leadingDigits, int totalNumbers) {
        System.out.println("התפלגות הספרות הראשונות (" + totalNumbers + " תוצאות):");

		for (int i = 1; i <= 9; i++) {
            int count = leadingDigits[i];
            double percent = (100.0 * count) / totalNumbers;

            System.out.print(i + ": " + count + " פעמים ");
            System.out.println("(" + String.format("%.1f", percent) + "%)");
        }
	}

	public static void printCountArrayAsHistogram(int[] leadingDigits, int totalNumbers) {
		System.out.println("התפלגות הספרות הראשונות (" + totalNumbers + " תוצאות) כגרף:");
		for (int i = 1; i <= 9; i++) {
            int count = leadingDigits[i];
            double percent = (100.0 * count) / totalNumbers;
            int length = (int)Math.round(percent);
            System.out.print(i + ": " );
            for (int j = 0; j < length; j++) {
            	System.out.print("*");
            }
            System.out.println();
        }
	}

	public static int extractFirstDigit(int number) {
		int digit = 0;
		while (number > 0) {
			digit = number % 10;
			number = number / 10;
		}
		return digit;
	}
}
