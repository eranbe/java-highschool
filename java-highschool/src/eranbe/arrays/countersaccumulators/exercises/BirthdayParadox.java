package eranbe.arrays.countersaccumulators.exercises;

import java.util.Random;

/**
 * סימולציה עבור פרדוקס יום ההולדת
 * 
 * ימי השנה מיוצגים כמספרים בין 0 ל-364 (נתעלם משנים מעוברות)
 * 
 * התוצאה הצפויה היא שורש של (פיי כפול 365 חלקי 2), שזה יוצא בערך 24 https://www.google.com/search?q=sqrt(pi*365%2F2)
 * 
 * עוד מידע על פרדוקס יום ההולדת: 
 * https://he.wikipedia.org/wiki/%D7%A4%D7%A8%D7%93%D7%95%D7%A7%D7%A1_%D7%99%D7%95%D7%9D_%D7%94%D7%94%D7%95%D7%9C%D7%93%D7%AA
 * https://www.youtube.com/watch?v=KtT_cgMzHx8
 */
public class BirthdayParadox {

	public static void main(String[] args) {
		// נקרא לפעולה המון פעמים ונחשב את המספר הממוצע של ימי הולדת עד להתנגשות
		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += randomizeBirthdays();
		}
		double average = sum / 1000000.0;
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
