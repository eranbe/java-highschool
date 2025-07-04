package eranbe.recursion;

public class BinarySearch {
	public static int binarySearch(int[] arr, int target, int left, int right) {
	    if (left > right) {
	        return -1;
	    }
	    int mid = left + (right - left) / 2;
	    if (arr[mid] == target) {
	        return mid;
	    } else if (arr[mid] > target) {
	        return binarySearch(arr, target, left, mid - 1);
	    } else {
	        return binarySearch(arr, target, mid + 1, right);
	    }
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(binarySearch(arr, 8, 0, arr.length));
	}
}
