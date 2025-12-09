package eranbe.bagrut.q899371.a2024.q3;

import java.util.Arrays;
import java.util.Random;

public class ShuffledArray {

	public static void main(String[] args) {
		int[] arr = {1223, 134, 245, 300, 111, 101, 777, 900, 195, 1234 };
		shuffle(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void shuffle(int[] arr) {
		Random rnd = new Random();
		int count = 0;
		while (count <= 30) {
			int idx1 = rnd.nextInt(arr.length);
			int idx2 = rnd.nextInt(arr.length);
			if (idx1 != idx2) {
				swap(arr, idx1, idx2);
				count++;
			}
		}
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
