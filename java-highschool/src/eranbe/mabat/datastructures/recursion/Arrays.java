package eranbe.mabat.datastructures.recursion;

import java.util.Random;

public class Arrays {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arr2 = { 1, -2, 3, -4, 5, -6, 7, -8, 9, -10};
		int[] arr3 = { 4, 6, 8, 10 };
		int[][] mat = {{ 1, 2, 3 },
				       { 2, 3, 4 },
				       { 3, 4, 5 }};
		int[][] sparseMat = {{ 1, 0, 0 },
			                 { 0, 1, 0 },
			                 { 0, 0, 1 }};
		System.out.println(sumUntilIndex(arr, 4));
		System.out.println(sumFromIndex(arr, 5));
		System.out.println(positiveUntilIndex(arr2, 5));
		System.out.println(isSortedUp(arr));
		System.out.println(isSortedUp(arr2));
		System.out.println(index(arr, 6));
		System.out.println(index(arr, 99));
		System.out.println(hasPrime(arr));
		System.out.println(hasPrime(arr3));
		System.out.println(equalArrays(arr, arr));
		System.out.println(equalArrays(arr, arr2));
		System.out.println(count(mat, 3));
		System.out.println(count(mat, 4));
		System.out.println(count(mat, 5));
		System.out.println(count(mat, 6));
		System.out.println(allGreaterThan(mat, 4));
		System.out.println(allGreaterThan(mat, 0));
		System.out.println(isSparseMatrix(mat));
		System.out.println(isSparseMatrix(sparseMat));
		System.out.println(numRowsHaveNum(mat, 3));
		System.out.println(numRowsHaveNum(mat, 2));
		System.out.println(numRowsHaveNum(mat, 1));
		System.out.println(numRowsHaveNum(mat, 0));
	}
	
	// 18.
	public static int sumUntilIndex(int[] arr, int i) {
		if (i == 0) {
			return arr[0];
		}
		return arr[i] + sumUntilIndex(arr, i-1);
	}
	
	// 19.
	public static int sumFromIndex(int[] arr, int i) {
		if (i == arr.length - 1) {
			return arr[arr.length - 1];
		}
		return arr[i] + sumFromIndex(arr, i + 1);
	}
	
	// 20.
	public static int positiveUntilIndex(int[] arr, int i) {
		if (i == 0) {
			if (arr[0] > 0) {
				return 1;
			} else {
				return 0;
			}
		}
		int val = 0;
		if (arr[i] > 0) {
			val = 1;
		}
		return val + positiveUntilIndex(arr, i - 1);
	}
	
	// 21.
	public static boolean isSortedUp(int[] arr) {
		return isSortedUp(arr, 1);
	}
	
	public static boolean isSortedUp(int[] arr, int i) {
		if (i == arr.length) {
			return true;
		}
		if (arr[i-1] >= arr[i]) {
			return false;
		}
		return isSortedUp(arr, i+1);
	}
	
	// 22.
	public static int index(int[] arr, int num) {
		return index(arr, num, 0);
	}

    public static int index(int[] arr, int num, int i) {
    	if (i == arr.length) {
    		return -1;
    	}
    	if (arr[i] == num) {
    		return i;
    	}
    	return index(arr, num, i+1); 
    }
    
    // 23.
    public static boolean isRandomIndexPalindrome(char[] arr) {
    	Random rnd = new Random();
    	int idx1 = rnd.nextInt(arr.length);
    	int idx2 = rnd.nextInt(arr.length);
    	int low = Math.min(idx1,  idx2);
    	int high = Math.max(idx1,  idx2);
    	return isPalindrome(arr, low, high);
    }
    
    public static boolean isPalindrome(char[] arr, int low, int high) {
    	if (low >= high) {
    		return true;
    	}
    	if (arr[low] != arr[high]) {
    		return false;
    	}
    	return isPalindrome(arr, low+1, high-1);
    }
    
    // 24.
    public static boolean isPalindrome(char[] arr) {
    	return isPalindrome(arr, 0, arr.length-1);
    }
    
    // 25.
    public static boolean hasPrime(int[] arr) {
    	return hasPrime(arr, 0);
    }
    
    public static boolean hasPrime(int[] arr, int i) {
    	if (i == arr.length) {
    		return false;
    	}
    	if (Numbers.isPrime(arr[i])) {
    		return true;
    	}
    	return hasPrime(arr, i+1);
    }
    
    // 26.
    public static boolean equalArrays(int[] arr1, int[] arr2) {
    	return equalArrays(arr1, arr2, 0);
    }

    public static boolean equalArrays(int[] arr1, int[] arr2, int i) {
    	if (i == arr1.length) {
    		return true;
    	}
    	if (arr1[i] != arr2[i]) {
    		return false;
    	}
    	return equalArrays(arr1, arr2, i+1);
    }
    
    // 27.
    public static int count(int[][] mat, int num) {
    	return count(mat, num, 0);
    }
    
    public static int count(int[][] mat, int num, int row) {
    	if (row == mat.length) {
    		return 0;
    	}
    	return count(mat[row], num, 0) + count(mat, num, row+1);
    }
    
    public static int count(int[] arr, int num, int i) {
    	if (i == arr.length) {
    		return 0;
    	}
    	int result = 0;
    	if (arr[i] == num) {
    		result = 1;
    	}
    	return result + count(arr, num, i + 1);
    }
    
    // 28.
    public static boolean allGreaterThan(int[][] mat, int num) {
    	return allGreaterThan(mat, num, 0);
    }

    public static boolean allGreaterThan(int[][] mat, int num, int row) {
    	if (row == mat.length) {
    		return true;
    	}
    	return allGreaterThan(mat[row], num, 0) && allGreaterThan(mat, num, row+1);
    }
    
    public static boolean allGreaterThan(int[] arr, int num, int i) {
    	if (i == arr.length) {
    		return true;
    	}
    	return (arr[i] > num) && allGreaterThan(arr, num, i + 1);
    }
    
    // 29.
    public static boolean isSparseMatrix(int[][] mat) {
    	return isSparseMatrix(mat, 0);
    	//return isSparseRow(mat[0], 0, 0) && isSparseMatrix(mat, 1);
    }
    
    public static boolean isSparseRow(int[] arr, int i, int row) {
    	if (i == arr.length) {
    		return true;
    	}
    	if (i == row && arr[i] != 1) {
    		return false;
    	}
    	if (i != row && arr[i] != 0) {
    		return false;
    	}
    	return isSparseRow(arr, i+1, row);
    }
    
    public static boolean isSparseMatrix(int[][] mat, int row) {
    	if (row == mat.length) {
    		return true;
    	}
    	return isSparseRow(mat[row], 0, row) && isSparseMatrix(mat, row+1);
    }
    
    // 30.
    public static int numRowsHaveNum(int[][] mat, int num) {
    	return numRowsHaveNum(mat, num, 0);
    }
    
    public static boolean hasNum(int[] arr, int num, int i) {
    	if (i == arr.length ) {
    		return false;
    	}
    	if (arr[i] == num) {
    		return true;
    	}
    	return hasNum(arr, num, i+1);
    }
    
    public static int numRowsHaveNum(int[][] mat, int num, int row) {
    	if (row == mat.length) {
    		return 0;
    	}
    	int result = 0;
    	if (hasNum(mat[row], num, 0)) {
    		result = 1;
    	}
    	return result + numRowsHaveNum(mat, num, row+1);
    }
}

