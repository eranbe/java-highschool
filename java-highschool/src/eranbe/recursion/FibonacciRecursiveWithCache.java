package eranbe.recursion;

import java.util.Scanner;

/**
 * This version of Fibonacci recursive uses an array to remember Fibonacci
 * numbers already calculated so not to calculate them again, and thus save
 * a lot of compute time. 
 */
public class FibonacciRecursiveWithCache {
    // פונקציה לחישוב מספר פיבונאצ'י ה-n עם תכנון דינאמי
    public static int fibonacci(int n, int[] memo) {
        if (n <= 0) {
            throw new IllegalArgumentException("n חייב להיות מספר חיובי");
        } else if (n == 1 || n == 2) {
            return 1;
        }
        
        if (memo[n] != 0) {
            return memo[n];
        }
        
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("הכנס מספר שלם חיובי: ");
        int n = scanner.nextInt();
        scanner.close();

        try {
            int[] memo = new int[n + 1];
            int result = fibonacci(n, memo);
            System.out.println("המספר ה-" + n + " בסדרת פיבונאצ'י הוא: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}