package eranbe.arrays.countersaccumulators.exercises;

import java.util.Random;

public class BirthdayParadox {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 100000; i++) {
			sum += randomizeBirthdays();
		}
		double average = sum / 100000.0;
		System.out.println("Average:" + average);
   }

	public static int randomizeBirthdays() {
		Random rand = new Random();
        int daysInYear = 365;
        boolean[] daysOfYear = new boolean[daysInYear];
        boolean hasCollision = false;
        int count = 0;

        while (!hasCollision) {
            int day = rand.nextInt(daysInYear);
            count++;
            if (daysOfYear[day]) {
            	hasCollision = true;
            } else {
            	daysOfYear[day] = true;
            }
        }
        System.out.println("Collision after " + count + " birthdays.");
        return count;
	}
}
