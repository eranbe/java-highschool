package eranbe.bagrut.q899371.a2024.q1;

public class Q1 {
	public static void main(String[] args) {
		int[] arr = {30, 141, 324, 623, 8004, 458, 6 };
		func(arr);
		int[] arr2 = {10, 1, 1, 1};
		func(arr2);
		int[] arr3 = { 1, 10, 20, 30 };
		func(arr3);
	}

	public static void func(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i] / 10;
			int digit = num % 10;
			if (digit == i)
				count++;
		}
		System.out.println(count);
	}
}
