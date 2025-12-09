package eranbe.bagrut.q899371.a2024.q6;

public class DigitSum {

	public static void main(String[] args) {
		System.out.println(deepSum(5));
		System.out.println(deepSum(36));
		System.out.println(deepSum(942378));
		System.out.println(isCorrect());
		System.out.println(inBoth(36, 942378));
		System.out.println(inBoth(5, 942378));
	}

	public static int digitSum(int num1) {
		int sum = 0;
		while (num1 > 0) {
			sum += num1 % 10;
			num1 /= 10;
		}
		return sum;
	}
	
	public static int deepSum(int num1) {
		while (num1 > 10) {
			num1 = digitSum(num1);
		}
		return num1;
	}
	
	public static boolean isCorrect() {
		int evenCount = 0, oddCount = 0;
		for (int i = 1; i <= 999999; i++) {
			if (deepSum(i) % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}
		return evenCount > oddCount;
	}
	
	public static boolean digitExists(int num, int digit) {
		while (num > 0) {
			if (num % 10 == digit) {
				return true;
			}
			num /= 10;
		}
		return false;
	}
	
	public static boolean inBoth(int num1, int num2) {
		int deepSum1 = deepSum(num1);
		int deepSum2 = deepSum(num2);
		return digitExists(num2, deepSum1) && digitExists(num1, deepSum2);
	}
}
