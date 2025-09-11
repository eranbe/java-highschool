package eranbe.recursion;

import java.util.Scanner;

public class FibonacciRecursive {
    // פונקציה רקורסיבית לחישוב מספר פיבונאצ'י ה-n
    public static int fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n חייב להיות מספר חיובי");
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("הכנס מספר שלם חיובי: ");
        int n = scanner.nextInt();
        int result = fibonacci(n);
        System.out.println("המספר ה-" + n + " בסדרת פיבונאצ'י הוא: " + result);
    }
}