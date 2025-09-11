package eranbe.recursion;

public class RecursionExercises {

    // 1. פיבונאצ'י
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 2. עצרת (Factorial)
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // 3. בעיית קולאץ
    public static void collatz(int n) {
        System.out.print(n + " ");
        if (n == 1) return;
        if (n % 2 == 0)
            collatz(n / 2);
        else
            collatz(3 * n + 1);
    }

    // 4. סכום ספרות
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumDigits(n / 10);
    }

    // 5. היפוך מספר
    public static int reverseNumber(int n) {
        return reverseHelper(n, 0);
    }

    private static int reverseHelper(int n, int result) {
        if (n == 0) return result;
        return reverseHelper(n / 10, result * 10 + n % 10);
    }

    // 6. חזקות
    public static int power(int base, int exp) {
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }

    // 7. בדיקת פולינדרום (מספר)
    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }

    // 8. סכום של מערך
    public static int sumArray(int[] arr) {
    	if (arr.length == 0) return 0;
    	return sumArrayHelper(arr, 0);
    }
    public static int sumArrayHelper(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + sumArrayHelper(arr, index + 1);
    }

    // 9. מקסימום במערך
    public static int maxInArray(int[] arr) {
    	return maxInArrayHelper(arr, 0);
    }

    public static int maxInArrayHelper(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        return Math.max(arr[index], maxInArrayHelper(arr, index + 1));
    }

    // 10. בדיקת ראשוניות
    public static boolean isPrime(int n) {
        return isPrimeHelper(n, 2);
    }

    private static boolean isPrimeHelper(int n, int divisor) {
        if (n <= 1) return false;
        if (divisor * divisor > n) return true;
        if (n % divisor == 0) return false;
        return isPrimeHelper(n, divisor + 1);
    }

    // 11. המרה לבינארי
    public static String toBinary(int n) {
        if (n == 0) return "0";
        return toBinaryHelper(n);
    }

    private static String toBinaryHelper(int n) {
        if (n == 0) return "";
        return toBinaryHelper(n / 2) + (n % 2);
    }

    // 12. סכום סדרה חשבונית (a + (a + d) + ...)
    public static int arithmeticSum(int a, int d, int n) {
        if (n == 1) return a;
        return a + arithmeticSum(a + d, d, n - 1);
    }

    // 13. מספר משולשי (Triangular number)
    public static int triangularNumber(int n) {
        if (n == 1) return 1;
        return n + triangularNumber(n - 1);
    }

    // 14. סדרת לוקאס
    public static int lucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        return lucas(n - 1) + lucas(n - 2);
    }

    // 14.1 סדרת פל
    public static int pell(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return lucas(n - 1) + 2* lucas(n - 2);
    }

    // 15. מגדלי האנוי
    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("העבר דיסק 1 מ-" + from + " ל-" + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("העבר דיסק " + n + " מ-" + from + " ל-" + to);
        hanoi(n - 1, aux, to, from);
    }

    // דוגמה לשימוש
    public static void main(String[] args) {
        System.out.println("פיבונאצ'י (6): " + fibonacci(6));
        System.out.println("עצרת (5): " + factorial(5));
        System.out.print("קולאץ (13): ");
        collatz(13);
        System.out.println("\nסכום ספרות (1234): " + sumDigits(1234));
        System.out.println("היפוך מספר (1234): " + reverseNumber(1234));
        System.out.println("2 בחזקת 5: " + power(2, 5));
        System.out.println("12321 הוא פלינדרום? " + isPalindrome(12321));
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("סכום מערך: " + sumArray(arr));
        System.out.println("מקסימום במערך: " + maxInArray(arr));
        System.out.println("7 הוא ראשוני? " + isPrime(7));
        System.out.println("המרת 13 לבינארי: " + toBinary(13));
        System.out.println("סכום 4 איברים של סדרה חשבונית (a=1, d=2): " + arithmeticSum(1, 2, 4));
        System.out.println("מספר משולשי של 5: " + triangularNumber(5));
        System.out.println("לוקאס של 5: " + lucas(5));
        System.out.println("פל של 5: " + pell(5));
        System.out.println("מגדלי האנוי עם 3 דיסקים:");
        hanoi(3, 'A', 'C', 'B');
    }
}
