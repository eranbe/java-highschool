package eranbe.arrays;

public class LeaderNumber {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 1, 10, 3, 4, 5, 6 };
		int[] arr3 = { 1, 10, 3, 12, 5, 6 };
		System.out.println(findLeaderIndex(arr1, 2));
		System.out.println(findLeaderIndex(arr2, 2));
		System.out.println(findLeaderIndex(arr3, 2));

	}

	public static int getMaxInRange(int[] arr, int from, int to) {
		if (from > to) {
			return Integer.MIN_VALUE;
		}
		int max = arr[from];
		for (int i = from + 1; i <= to; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static int findLeaderIndex(int[] arr, int k) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > getMaxInRange(arr, i + 1, Math.min(i+k+1, arr.length-1))) {
				return i;
			}
		}
		return arr.length - 1;
	}
}
