package eranbe.arrays;

public class SumEvenInBorder {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(sumEvenInBorder(arr, 3, 8));

	}

	public static int sumEvenInBorder(int[] arr, int low, int high) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if (num % 2 == 0 && (num < low || num > high)) {
				sum += num;
			}
		}
		return sum;
	}
}
