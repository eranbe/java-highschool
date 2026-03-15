package eranbe.mabat.datastructures.recursion;

public class Numbers {
	public static void main(String[] args) {
		System.out.println(sumToN(10));
		System.out.println(oddProductToN(5));
		System.out.println(oddProductToN(6));
		System.out.println(factorial(6));
		System.out.println(numDigits(5678));
		System.out.println(sumEvenDigits(5678));
		System.out.println(sumEvenDigits(579));
		System.out.println(leftDigit(579));
		System.out.println(leftDigit(9));
		System.out.println(quotient(15, 7));
		System.out.println(quotient(5, 7));
		System.out.println(quotient(21, 7));
		System.out.println(reminder(15, 7));
		System.out.println(reminder(5, 7));
		System.out.println(reminder(21, 7));
		System.out.println(isDigitInNum(54321, 4));
		System.out.println(isDigitInNum(54321, 9));
		System.out.println(isDigitInNum(54021, 0));
		System.out.println(isMultiple(16, 4));
		System.out.println(isDigitInNum(15, 4));
		System.out.println(isDigitInNum(3, 4));
		System.out.println(isPrime(11));
		System.out.println(isPrime(49));
		System.out.println(isAllEvenOrAllOddDigits(13579));
		System.out.println(isAllEvenOrAllOddDigits(24680));
		System.out.println(isAllEvenOrAllOddDigits(123579));
		System.out.println(sameNumDigits(12345, 67890));
		System.out.println(sameNumDigits(1234, 67890));
		System.out.println(sameNumDigits(12345, 6));
	}
	
	// 1.
	public static int sumToN(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sumToN(n-1);
	}
	
	// 2.
	public static int oddProductToN(int n) {
		if (n == 1) {
			return 1;
		}
		if (n % 2 == 1) {
			return n * oddProductToN(n-2);
		}
		return oddProductToN(n - 1);
	}
	
	// 3.
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	// 4.
	public static int numDigits(int n) {
		if (n < 10) {
			return 1;
		}
		return 1 + numDigits(n / 10);
	}
	
	// 5.
	public static int sumEvenDigits(int n) {
		if (n == 0) {
			return 0; 
		}
		int sum = sumEvenDigits(n / 10);
		int digit = n % 10;
		if (digit % 2 == 0) {
			sum += digit;
		}
		return sum;
	}
	
	// 6.
	public static int leftDigit(int n) {
		if (n < 10) {
			return n;
		}
		return leftDigit(n / 10);
	}
	
	// 7.
	public static int quotient(int n, int m) {
		if (n < m) {
			return 0;
		}
		return 1 + quotient(n-m, m);
	}

	// 8.
	public static int reminder(int n, int m) {
		if (n < m) {
			return n;
		}
		return reminder(n-m, m);
	}
	
	// 9.
	public static boolean isDigitInNum(int num, int digit) {
		if (num == 0) {
			return false;
		}
		int rightDigit = num % 10;
		if (rightDigit == digit) {
			return true;
		}
		return isDigitInNum(num / 10, digit);
	}
	
	// 10.
	public static boolean isMultiple(int x, int y) {
		if (x < y) {
			return false;
		}
		if (x == y) {
			return true;
		}
		return isMultiple(x-y, y);
	}
	
	// 11.
	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		int root = (int)Math.sqrt(n);
		for (int i = 3; i <= root; i++) {
			if (isMultiple(n, i)) {
				return false;
			}
		}
		return true;
	}
	
	// 12.
	public static boolean isAllDigitsSameEvenity(int n, int evenOrOdd) {
		if (n == 0) {
			return true;
		}
		int digit = n % 10;
		if (digit % 2 != evenOrOdd) {
			return false; 
		}
		return isAllDigitsSameEvenity(n / 10, evenOrOdd);
	}
	
	public static boolean isAllEvenOrAllOddDigits(int n) {
		return isAllDigitsSameEvenity(n, 0) || isAllDigitsSameEvenity(n, 1);
	}
	
	// 13.
	public static boolean sameNumDigits(int n, int m) {
		return numDigits(n) == numDigits(m);
	}
}
