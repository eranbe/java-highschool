package eranbe.bagrut.q899371.a2025.q3;

public class Narcicist {
	public static void main(String[] args) {
		System.out.println(isNarc(407));
		System.out.println(isNarc(58));
		theNarc(10000);
	}

	private static void theNarc(int n) {
		for (int i = 1; i <= n; i++) {
			if (isNarc(i)) {
				System.out.print(i + ", ");
			}
		}
		System.out.println();
	}

	public static boolean isNarc(int num) {
		int digitCount = countDigits(num);
		int sumOfPowers = sumPowers(num, digitCount);
		return sumOfPowers == num;
	}

	private static int sumPowers(int num, int digitCount) {
		int sum = 0;
		int digit;
		while (num > 0) {
			digit = num % 10;
			sum += Math.pow(digit, digitCount);
			num = num / 10;
		}
		return sum;
	}

	private static int countDigits(int num) {
		int count = 0;
		while (num > 0) {
			num = num / 10;
			count++;
		}
		return count;
	}
}
