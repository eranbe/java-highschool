package eranbe.mabat.datastructures.recursion;

public class NumbersCharsNoReturn {

	public static void main(String[] args) {
		printCharsBetween('a', 'z');
		System.out.println();
		printCharsBetween('b', 'a');
		System.out.println();
		printCharsBetween('b', 'b');
		System.out.println();
		printDivisors(24);
		System.out.println();
		printDivisors(31);
		System.out.println();
		printAllEvenDigits(1234567890);
		System.out.println();
		printReversed(1234567890);
		printMultiplicationMatrix(1, 1);
	}
	
	// 35.
	public static void printCharsBetween(char c1, char c2) {
		if (c2 < c1) {
			return;
		}
		System.out.print(c1);
		printCharsBetween((char)(c1+1), c2);
	}

	// 36.
	public static void printDivisors(int num) {
		printDivisors(num, 1);
	}
	
	public static void printDivisors(int num, int candidate) {
		if (candidate > num) {
			return;
		}
		if (num % candidate == 0) {
			System.out.print(candidate + ", ");
		}
		printDivisors(num, candidate + 1);
	}
	
	// 37.
	public static void printAllEvenDigits(int num) {
		if (num == 0) {
			return;
		}
		int digit = num % 10;
		if (digit % 2 == 0) {
			System.out.print(digit);
		}
		printAllEvenDigits(num / 10);
	}
	
	// 38.
	public static void printReversed(int num) {
		if (num == 0) {
			return;
		}
		printReversed(num / 10);
		System.out.println(num % 10);
	}
	
	// 39.
	public static void printMultiplicationMatrix(int n, int m) {
		if (n > 10 || m > 10) {
			return;
		}
		int product = n * m;
		if (product < 10) {
			System.out.print(" ");
		}
		System.out.print(product);
		if (m == 10) {
			System.out.println();
			printMultiplicationMatrix(n+1, 1);
		} else {	
			System.out.print(",");
			printMultiplicationMatrix(n, m+1);
		}
	}
}
