package eranbe.arrays;

import java.util.*;

public class GoldbachCheck {
    
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i < isPrime.length; i++) {
        	isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    
    public static int[] isEvenAsSumOfTwoPrimes(int n) {
    	int[] result = {0, 0};
        if (n < 4 || n % 2 != 0) return result; // מספרים קטנים מ-4 או אי-זוגיים לא נבדקים
        
        boolean[] isPrime = sieveOfEratosthenes(n);
        
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                System.out.println(n + " = " + i + " + " + (n - i));
                result[0] = i;
                result[1] = n - i;
                return result;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	/*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an even number: ");
        int n = scanner.nextInt();
        scanner.close();
        int[] result = isEvenAsSumOfTwoPrimes(n); 
        if (result[0] != 0) {
            System.out.println(n + " can be expressed as the sum of two prime numbers.");
        } else {
            System.out.println(n + " cannot be expressed as the sum of two prime numbers.");
        }
        */
    	int smallestPrime = 0;
    	int num = 0;
    	int[] result;
    	for (int i = 2; i <= 100000; i+=2) {
    		result = isEvenAsSumOfTwoPrimes(i);
    		if (result[0] > smallestPrime) {
    			smallestPrime = result[0];
    			num = i;
    		}
    	}
    	System.out.println("Smallest prime part: " + smallestPrime + " num: " + num);
    }
}
