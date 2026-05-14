package eranbe.arrays;

import java.util.Random;

/**
 * See https://youtu.be/A5w-dEgIU1M?si=zsMcRbUKxEeZ4mRQ&t=562 (until 10:30)
 */
public class GaltonBoard {
    public static void main(String[] args) {
        // הרצת הסימולציה עם פרמטרים משתנים
        int[] simulation1 = runGaltonSimulation(10, 500);
        System.out.println("--- לוח של  10 שורות ---");
        printBins(simulation1);

        int[] simulation2 = runGaltonSimulation(20, 1000);
        System.out.println("--- לוח של  20 שורות ---");
        printBins(simulation2);
    }

    /**
     * פעולה גנרית להרצת סימולציית לוח גלטון
     * @param rows מספר שורות הפינים בלוח
     * @param numBalls מספר הכדורים להרצה
     * @return מערך המכיל את התפלגות הכדורים בתאים הסופיים
     */
    public static int[] runGaltonSimulation(int rows, int numBalls) {
        Random rnd = new Random();
        int[] bins = new int[rows + 1];

        for (int b = 0; b < numBalls; b++) {
            int rightTurns = 0;
            for (int r = 0; r < rows; r++) {
                if (rnd.nextInt(2) == 1) {
                    rightTurns++;
                }
            }
            bins[rightTurns]++;
        }
        return bins;
    }

    /**
     * פעולה שמנהלת את הדפסת כל הלוח
     * @param bins המערך הסופי של הסימולציה
     */
    public static void printBins(int[] bins) {
        for (int i = 0; i < bins.length; i++) {
            System.out.print("Bin ");
            if (i < 10 ) {
            	System.out.print(" ");
            }
            System.out.print(i + ": ");
            for (int j = 0; j < bins[i]; j++) {
                System.out.print("*");
            }
            System.out.println(); // ירידת שורה בסוף ההדפסה
        }
    }

    /**
     * פעולה שמדפיסה שורת כוכביות לפי מספר נתון
     * @param count מספר הכוכביות להדפסה
     */
    public static void printRow(int count) {
    }
}
