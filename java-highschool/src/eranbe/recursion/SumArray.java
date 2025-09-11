package eranbe.recursion;

/**
 * Sum the elements of an array using recursion.
 * 
 * Demonstrates passing an array to a recursive function, which is done by reference,
 * as well as demonstrates using a helper wrapper function that does some calculations
 * to prepare before calling the recursive method.
 * 
 * The same logic can be used for multiplying all the elements of the array - just
 * replace the + with * in the recursive method (and rename appropriately).
 */
public class SumArray {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
		System.out.println(sumArray(arr));
	}

	public static int sumArray(int[] arr) {
		// Handle the case of an array of size 0 - return 0
		if (arr.length == 0) {
			return 0;
		}
		// The recursive method calculates the sum up to index i,
		// so for the first iteration, point to the last element
		// of the array.
		return sumArrayRec(arr, arr.length-1);
	}

	/**
	 * The recursive function - takes the array (that we don't modify, just read
	 * from) and an index, and calculates, using recursion, the sum of the elements
	 * up to that element's index. 
	 */
	private static int sumArrayRec(int[] arr, int i) {
		if (i == 0) {
			// Halting condition - if we're at index 0, just return the value at that index
			return arr[0];
		} else {
			// Recursive call - add the current element to the result of the recursive call
			// on the rest of the array (by calling with the array and index i-1.
			return arr[i] + sumArrayRec(arr, i-1);
		}
	}
}
