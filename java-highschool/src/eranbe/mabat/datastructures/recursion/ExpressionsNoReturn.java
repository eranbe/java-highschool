package eranbe.mabat.datastructures.recursion;

public class ExpressionsNoReturn {

	public static void main(String[] args) {
		printArithmeticSequence(2, 3, 5);
		System.out.println();
		printIncDiffSequence(7);
		System.out.println();
	}

	// 40.
	public static void printArithmeticSequence(int first, int d, int n) {
		if (n == 0) {
			return;
		}
		System.out.print(first);
		if (n != 1) {
			System.out.print(", ");	
		}
		printArithmeticSequence(first+d, d, n-1);
	}
	
	// 41.
	public static void printIncDiffSequence(int n) {
		printIncDiffSequence(1, 1, n);
	}

	private static void printIncDiffSequence(int i, int diff, int n) {
		if (n == 0) {
			return;
		}
		System.out.print(i);
		if (n != 1) {
			System.out.print(", ");
		}
		printIncDiffSequence(i+diff, diff+1, n-1);
	}
}
