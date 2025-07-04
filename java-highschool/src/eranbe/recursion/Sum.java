package eranbe.recursion;

public class Sum {
	public static int sumRec(int n) {
	    if (n == 1) {
	        return 1;
	    }
	    return n + sumRec(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(sumRec(100));
	}
}
