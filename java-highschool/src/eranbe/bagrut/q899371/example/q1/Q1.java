package eranbe.bagrut.q899371.example.q1;

import java.util.Arrays;

public class Q1 {

	public static void main(String[] args) {
		int[] a = { 2, 8, 8, 8, 1, 24, 7, 7, 6 };
		int[] b = { 0, 0, 0, 0, 0, 0, 0, 0 };
		what(a, b);
		System.out.println(Arrays.toString(b));
		int[] aa = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] bb = { 0, 0, 0, 0, 0, 0, 0, 0 };
		what(aa, bb);
		System.out.println(Arrays.toString(bb));
	}
	
	public static void what(int[] a, int[] b) {
		int count = 0;
		for (int i = 0; i < (a.length-1); i++) {
			if (a[i] == a[i+1]) {
				b[count] = a[i];
				count++;
			}
		}
	}
}
