package eranbe.bagrut.q899371.a2023;

public class Decipher {
	public static void main(String[] args) {
		int[] arr = {2, 4, 1, 0, 3};
		int[] arr1 = {3, 4, 2, 1, 0};
		System.out.println(originalText("rdoWl", arr));
		System.out.println(originalText("dyutS", arr1));
	}
	
	public static String originalText(String str, int[] arr) {
		char[] result = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[arr[i]] = str.charAt(i);
		}
		return new String(result);
	}
}
