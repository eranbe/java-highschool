package eranbe.arrays;

public class CountIsolatedZeros {

	public static void main(String[] args) {
		int[] arr = { 0 , 1, 0, 1, 0, 1, 1, 0, 1};
		System.out.println(countIsolatedZeros(arr));
	}

	public static int countIsolatedZeros(int[] arr) {
		if (arr.length <= 2) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] == 0 && arr[i-1] == 1 && arr[i + 1] == 1) {
				count++;
			}
		}
		return count;
	}
}
