package eranbe.loops;

import java.util.*;

/**
 * https://chatgpt.com/share/67c0577f-5a48-8011-94a3-6026db36aec5 
 */
public class PiEstimate {
	public static void main(String[] args) {
		Random rnd = new Random();
		double x, y, estimate, count = 0, num = 1000000;//Integer.MAX_VALUE;
		long start, end;
		start = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			x = rnd.nextDouble(2) - 1;
			y = rnd.nextDouble(2) - 1;
			if (x *x + y * y <= 1) {
				count++;
			}
		}
		end = System.currentTimeMillis();
		estimate = 4 * count / (double) num;
		System.out.println("Estimated Pi: " + estimate);
		System.out.println("System Pi: " + Math.PI);
		System.out.println("Difference: " + Math.abs(estimate - Math.PI));
		System.out.println("Seconds it took: " + ((end - start) / 1000));
	}
}
