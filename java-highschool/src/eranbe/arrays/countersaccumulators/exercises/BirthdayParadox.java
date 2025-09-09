package eranbe.arrays.countersaccumulators.exercises;

import java.util.Random;

/**
 * סימולציה עבור פרדוקס יום ההולדת
 * 
 * ימי השנה מיוצגים כמספרים בין 0 ל-364 (נתעלם משנים מעוברות)
 */
public class BirthdayParadox {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 100000; i++) {
			sum += randomizeBirthdays();
		}
		double average = sum / 100000.0;
		System.out.println("Average:" + average);
   }

	/**
	 * פעולה שמייצרת ימי הולדת עד שיש התנגשות, ומחזירה כמה ימי הולדת נוצרו
	 */
	public static int randomizeBirthdays() {
		Random rand = new Random();
        int daysInYear = 365;
        boolean[] daysOfYear = new boolean[daysInYear];
        int count = 0;
        boolean hasCollision = false;

        while (!hasCollision) {
        	// נגריל יום הולדת
            int day = rand.nextInt(daysInYear);
            // נגדיל את מונה הימים שהגרלנו
            count++;
            // האם יש התנגשות של ימי הולדת? האם כבר היה לנו יום הולדת ביום זה?
            if (daysOfYear[day]) {
            	hasCollision = true;
            } else {
            	// נסמן שראינו יום הולדת ביום זה
            	daysOfYear[day] = true;
            }
        }
        System.out.println("Collision after " + count + " birthdays.");
        return count;
	}
}
