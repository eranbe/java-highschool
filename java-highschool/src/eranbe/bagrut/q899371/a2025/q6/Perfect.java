package eranbe.bagrut.q899371.a2025.q6;

public class Perfect {
	public static void main(String[] args) {
		System.out.println(isPerfect(6));
		System.out.println(isPerfect(28));
		System.out.println(isPerfect(8));
		noOdd();
	}

	// (א1)
	public static boolean isPerfect(int num) {
		int sumOfDivs = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sumOfDivs += i;
			}
		}
		return sumOfDivs == num;
	}
	
	// (א2)
	public static void thePerfects(int low, int high) {
		for (int i = low; i <= high; i++) {
			if (isPerfect(i)) {
				System.out.print(i + ", ");
			}
		}
	}
	
	// (ב)
	public static boolean noOdd() {
		for (int i = 3; i <= 999_999; i+=2) {
			if (isPerfect(i)) {
				System.out.println(i);
				return false;
			}
			if ((i+1) % 10_000 == 0) {
				System.out.print(i + "...");
			}
			if ((i+1) % 100_000 == 0) {
				System.out.println();
			}
		}
		return true;
	}
}
