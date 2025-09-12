package eranbe.recursion;

public class Whats {
	public static int what1(int[] arr, int i) {
		if (arr.length == 0) {
			return 0;
		}
		if (i == 0) {
			return arr[i];
		} else {
			arr[i] = arr[i] + what1(arr, i-1);
			return arr[i];
		}
	}

	public static int what2(int[] arr, int i) {
		if (arr.length < 2) {
			return 0;
		}
		if (i < 2) {
			return arr[i];
		} else {
			arr[i] =  what2(arr, i-1) + what2(arr, i-2);
			return arr[i];
		}
	}
	
	public static int what3(int[] arr, int i, int n) {
		if (i < 0) {
			return 0;
		}
		int result = 0;
		if (arr[i] == n) {
			result = 1;
		}
		return result + what3(arr, i-1, n);
	}
	
	public static void what4(int[] arr, int i1, int i2) {
		if (i1 >= i2) {
			return;
		}
		int n = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = n;
		what4(arr, i1+1, i2-1);
	}
	
	public static boolean what5(int[] arr, int i) {
		if (i == 0) {
			return true;
		}
		return arr[i] >= arr[i-1] && what5(arr, i-1);
	}

	public static int what6(int[] arr, int i) {
		if (i == 0) {
			return arr[0];
		}
		return Math.max(arr[i], what6(arr, i-1));
	}
	
	public static int what7(int[] arr, int i) {
		if (i == 0) {
			return arr[0];
		}
		return Math.max(arr[i], what6(arr, i-2));
	}
	
	public static int what8(int[] arr, int i, int n) {
		if (i < 0) {
			return -1;
		}
		if (arr[i] == n) {
			return i;
		}
		return what8(arr, i-1, n);
	}

	public static int what9(int[] arr, int i) {
		if (i < 0) {
			return 0;
		}
		int result = 0;
		if (arr[i] % 2 == 0) {
			result += arr[i];
		}
		return result + what9(arr, i-1);
	}
	
	public static void what10(int[] arr, int i) {
		if (i < 0) {
			return;
		}
		arr[i] *= 2;
		what10(arr, i-1);
	}
	
	public static boolean what11(int[] arr, int i) {
		if (i < 0) {
			return true;
		}
		return arr[i] > 0 && what11(arr, i-1);
	}
	
	public static int[] what12(int[] arr, int i) {
		if (i < 0) {
			return new int[0];
		}
		int[] arr1 = what12(arr, i-1);
		int[] result = new int[arr1.length + 1];
		for (int j = 0; j < arr1.length; j++) {
			result[j] = arr1[j];
		}
		result[0] = arr[i];
		return result;
	}
	
	public static double what13(int[] arr, int i) {
		if (i == 0) {
			return arr[i];
		}
		double d = what13(arr, i-1);
		return (arr[i] + d * i) / (i + 1);
	}
	
	public static int[] what14(int[] arr, int i) {
		if (i < 0) {
			return new int[arr.length];
		}
		int[] arr1 = what14(arr, i-1);
		arr1[i] = arr[i];
		return arr1;
	}
}
