package eranbe.bagrut.q899371.example.q6;

import java.util.Random;

public class PairOfNums {
	private int num1;
	private int num2;
	
	public PairOfNums(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	@Override
	public String toString() {
		return "(" + num1 + "," + num2 + ")";
	}

	public boolean endStart() {
		int lsd1 = num1 % 10;
		int lsd2 = num2 % 10;
		int msd1 = msd(num1);
		int msd2 = msd(num2);
		return lsd1 == msd2 || lsd2 == msd1;
	}

	private int msd(int num) {
		int digit = num % 10;
		while (num > 0) {
			digit = num % 10;
			num = num / 10;
		}
		return digit;
	}
	
	public static PairOfNums[] generate(int n) {
		PairOfNums[] result = new PairOfNums[n];
		int count = 0;
		Random rnd = new Random();
		while (count < n) {
			int num1 = rnd.nextInt(1000)+1;
			int num2 = rnd.nextInt(1000)+1;
			PairOfNums pair = new PairOfNums(num1, num2);
			if (pair.endStart()) {
				result[count] = pair;
				count++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		PairOfNums[] nums = generate(10);
		for (int i = 0; i < nums.length; i++) {
			System.out.println((i+1) + ": " + nums[i]);
		}
	}
}
