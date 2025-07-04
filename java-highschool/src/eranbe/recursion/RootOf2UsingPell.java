package eranbe.recursion;

import java.util.Scanner;

public class RootOf2UsingPell {
    // פונקציה רקורסיבית לחישוב מספר פל ה-n
    public static int pell(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n חייב להיות מספר חיובי");
        } else if (n == 0) {
        	return 0;
        } else if (n == 1) {
            return 1;
        }
        return 2 * pell(n - 1) + pell(n - 2);
    }


    // פונקציה לחישוב מספר פל-n עם תכנון דינאמי
    public static int pell(int n, int[] memo) {
        if (n < 0) {
            throw new IllegalArgumentException("n חייב להיות מספר חיובי");
        } else if (n == 0) {
        	return 0; 
        } else if (n == 1) {
            return 1;
        }
        
        if (memo[n] != 0) {
            return memo[n];
        }
        
        memo[n] = 2 * pell(n - 1, memo) + pell(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("הכנס מספר שלם חיובי: ");
        int n = scanner.nextInt();
        scanner.close();

        try {
            //int[] memo = new int[n + 1];
            int n1 = pell(n/*, memo*/);
            int n2 = pell(n-1/*, memo*/);
            double calculated = (n1 / (double) n2) - 1.0; 
            System.out.println(calculated);
            System.out.println(Math.sqrt(2));
            System.out.println("Diff: " + Math.abs(calculated - Math.sqrt(2)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

	}
}
