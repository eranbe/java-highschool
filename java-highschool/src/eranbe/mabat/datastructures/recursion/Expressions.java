package eranbe.mabat.datastructures.recursion;

public class Expressions {
	public static void main(String[] args) {
		System.out.println(sum14(3));
		System.out.println(sum14(4));
		System.out.println(sum14(5));
		System.out.println(sum15(3));
		System.out.println(sum15(4));
		System.out.println(sum15(5));
		System.out.println(allMultiplesSmaller(3, 12));
		System.out.println(allMultiplesSmaller(3, 13));
		System.out.println(allMultiplesSmaller(33, 12));
		System.out.println(fibSquared(2));
		System.out.println(fibSquared(3));
		System.out.println(fibSquared(4));
		System.out.println(fibSquared(5));
		System.out.println(fibSquared(6));
		System.out.println(sumFibSquared(2));
		System.out.println(sumFibSquared(3));
		System.out.println(sumFibSquared(4));
		System.out.println(sumFibSquared(5));
		System.out.println(sumFibSquared(6));
	}
	
	// 14.
	public static int sum14(int n) {
		if (n == 1) {
			return 2;
		}
		int sum = sum14(n-1);
		if (n % 2 == 0) {
			sum += (int)Math.pow(n, 2);
		} else {
			sum += n*2;
		}
		return sum;
	}
	
	// 15.
	public static double sum15(int n) {
		if (n == 1) {
			return 1;
		}
		if (n % 2 == 0) {
			return sum15(n - 1);
		}
		double sum = sum15(n - 2);
		if (n % 4 == 1) {
			sum += n;
		} else {
			sum += Math.sqrt(n);
		}
		return sum;
	}

	// 16.
	public static int allMultiplesSmaller(int n1, int n2) {
		return allMultiplesSmallerHelper(n1, n1, n2);
	}
	public static int allMultiplesSmallerHelper(int n1, int n1Save, int n2) {
		if (n1 >= n2) {
			return 0;
		}
		return n1 + allMultiplesSmallerHelper(n1 + n1Save, n1Save, n2);
	}
	
	// 17a.
	public static int fibSquared(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		int prev = fibSquared(n-1);
		int prevprev = fibSquared(n-2);
		return prev * prev + prevprev * prevprev;
	}
	
	public static int sumFibSquared(int n) {
		if (n == 1) {
			return 0;
		}
		return fibSquared(n) + sumFibSquared(n-1);
	}
}
