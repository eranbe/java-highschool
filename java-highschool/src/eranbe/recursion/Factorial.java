package eranbe.recursion;

public class Factorial {
	public static int factorial(int n) {
		if (n < 2) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
