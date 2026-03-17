package eranbe.mabat.datastructures.recursion;

public class ArraysNoReturn {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arr2 = { 1, 2, 1, 4, 1, 6, 1, 8, 1, 10};
		double[] dArr = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		double[] dArr2 = { 5.0, 2.0, 3.0, 4.0, 5.0 };
		double[] dArr3 = { 1.0, 2.0, 5.0, 5.0, 4.0 };
		int[][] mat = {{ 1, 2, 3 },
				{4, 3, 2},
				{3, 5, 4},
				{3, 3, 3},
				{3, 3, 2},
				{3, 2, 3},
				{2, 3, 3}};
		printEvenIndices(arr);
		printSmallerThanFollowing(arr);
		printSmallerThanFollowing(arr2);
		printMaxValueIndices(dArr);
		printMaxValueIndices(dArr2);
		printMaxValueIndices(dArr3);
		printMaxInEachRow(mat, 0);
		printSubMat(mat, 2, 1);
	}

	// 42.
	public static void printEvenIndices(int[] arr) {
		printEvenIndices(arr, 0);
	}

	private static void printEvenIndices(int[] arr, int i) {
		if (i >= arr.length) {
			System.out.println();
			return;
		}
		System.out.print(arr[i] + ", ");
		printEvenIndices(arr, i+2);
	}
	
	// 43.
	public static void printSmallerThanFollowing(int[] arr) {
		printSmallerThanFollowing(arr, 0);
	}

	private static void printSmallerThanFollowing(int[] arr, int i) {
		if (i >= arr.length - 1) {
			System.out.println();
			return;
		}
		if (arr[i] < arr[i+1]) {
			System.out.print(arr[i] + ", ");
		}
		printSmallerThanFollowing(arr, i+1);
	}
	
	// 44.
	public static void printMaxValueIndices(double[] arr) {
		printMaxValueIndices(arr, 0, Double.MIN_VALUE);
	}

	private static double printMaxValueIndices(double[] arr, int i, double maxValue) {
		if (i >= arr.length) {
			return maxValue;
		}
		if (arr[i] > maxValue) {
			maxValue = arr[i];
		}
		maxValue = printMaxValueIndices(arr, i+1, maxValue);
		if (arr[i] == maxValue) {
			System.out.print(i + ", ");
		}
		if (i == 0) {
			System.out.println();;
		}
		return maxValue;
	}
	
	// 45.
	public static void printMaxInEachRow(int[][] mat, int startRow) {
		if (startRow >= mat.length) {
			System.out.println();
			return;
		}
		printMaxInRow(mat[startRow], mat[startRow][0], 1);
		printMaxInEachRow(mat, startRow + 1);
	}

	private static void printMaxInRow(int[] row, int currMax, int col) {
		if (col >= row.length) {
			System.out.print("row max: " + currMax + ", ");
			return;
		}
		if (row[col] > currMax) {
			currMax = row[col];
		}
		printMaxInRow(row, currMax, col+1);
	}
	
	// 46.
	public static void printSubMat(int[][] mat, int i, int j) {
		if (i >= mat.length) {
			return;
		}
		printRowFrom(mat[i], j);
		printSubMat(mat, i+1, j);
	}

	private static void printRowFrom(int[] row, int j) {
		if (j >= row.length) {
			System.out.println();
			return;
		}
		System.out.print(row[j] + ", ");
		printRowFrom(row, j+1);
	}
}
