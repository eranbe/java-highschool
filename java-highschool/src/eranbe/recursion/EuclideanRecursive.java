package eranbe.recursion;

public class EuclideanRecursive {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("GCD של 105 ו-21 הוא: " + gcd(105, 21));
    }
}
