package eranbe.bagrut.q899371.a2024.q2;

import java.util.Arrays;

public class PasswordArray {

	public static void main(String[] args) {
		int[] arr = {1223, 134, 245, 300, 111, 101, 777, 900, 195, 1234 };
		System.out.println(getPass2(arr, 300));
		System.out.println(Arrays.toString(arr));
		System.out.println(getPass2(arr, 8888));
		System.out.println(Arrays.toString(arr));
	}
	
	public static boolean getPass(int[] arr, int password) {
		if (isNewPassword(arr, password)) {
			shiftPasswordsRight(arr);
			arr[0] = password;
			return true;
		} else {
			return false;
		}
	}

	private static void shiftPasswordsRight(int[] arr) {
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i+1] = arr[i];
		}
	}

	private static boolean isNewPassword(int[] arr, int password) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == password) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean getPass2(int[] arr, int password) {
		// Check if password was already used.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == password) {
				return false;
			}
		}
		// Password is new
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = password;
		return true;
	}
}
