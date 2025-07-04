package eranbe.arrays;

public class SortedArrayCount {

	public static void main(String[] args) {
		//int[] arr = { 1, 1, 1, 3, 4, 4, 7, 7, 7, 7, 8, 8};
		int[] arr = {1, 1};
		printArray(zip(arr));
	}
	
	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i+1 != arr.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	

	public static int[] trim(int[] arr) {
		int i = 0;
		while (i < arr.length && arr[i] != 0) {
			i++;
		}
		if (i == arr.length) {
			return arr;
		}
		int[] result = new int[i];
		for (int j = 0; j < result.length; j++) {
			result[j] = arr[j];
		}
		return result;
	}

	public static int[] zip(int[] arr) {
		int[] tmpArr = new int[arr.length * 2];
		int currCount = 1;
		tmpArr[0] = arr[0];
		int tmpArrNextPos = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i+1]) {
				tmpArr[tmpArrNextPos++] = currCount;
				currCount = 1;
				tmpArr[tmpArrNextPos++] = arr[i+1];
			} else {
				currCount++;
			}
			printArray(tmpArr);
		}
		tmpArr[tmpArrNextPos] = currCount;
		printArray(tmpArr);
		return trim(tmpArr);
	}
}
