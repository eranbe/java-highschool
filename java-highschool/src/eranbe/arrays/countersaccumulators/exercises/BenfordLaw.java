package eranbe.arrays.countersaccumulators.exercises;

import java.util.Random;

public class BenfordLaw {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] leadingDigits = new int[10]; // index 1–9
        int totalNumbers = 1000;

        for (int i = 0; i < totalNumbers; i++) {
            int a = rand.nextInt(9000) + 1000; // מספר בין 1000 ל-9999
            int b = rand.nextInt(90) + 10;     // מספר בין 10 ל-99
            int result = a * b;

            // שליפת הספרה הראשונה
            int firstDigit = Integer.parseInt(Integer.toString(result).substring(0, 1));
            leadingDigits[firstDigit]++;
        }

        System.out.println("התפלגות הספרות הראשונות (" + totalNumbers + " תוצאות):");

        for (int i = 1; i <= 9; i++) {
            int count = leadingDigits[i];
            double percent = (100.0 * count) / totalNumbers;

            System.out.print(i + ": " + count + " פעמים ");
            System.out.println("(" + String.format("%.1f", percent) + "%)");
        }
    }
}
