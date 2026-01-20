package eranbe.conditions;

public class IsStrictlyIncreasing {

	public static void main(String[] args) {
		System.out.println(isStrictlyInceasing(1489));
		System.out.println(isStrictlyInceasing(1449));
		System.out.println(isStrictlyInceasing(153));
		System.out.println(isStrictlyInceasing(2));
	}
	
	public static boolean isStrictlyInceasing(int n) {
		if (n <= 0) {
			return false;
		}
		int lastDigit = n % 10;
		n = n / 10;
		while (n > 0) {
			int digit = n % 10;
			if (digit >= lastDigit) {
				return false;
			}
			lastDigit = digit;
			n = n / 10;
		}
		return true;
	}

}
