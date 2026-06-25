package eranbe.bagrut.q899371.a2026.q6;

public class Kaprekar {
    public static int leftDigits(int num, int k) {
        int numDigits = countDigits(num);
        int toRemove = numDigits - k;
        for (int i = 0; i < toRemove; i++) {
            num /= 10;
        }
        return num;
    }

    // פעולת עזר אשר סופרת כמה ספרות יש במספר חיובי
    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
    
    public static int rightDigits(int num, int k) {
        int newNum = 0;
        int mult = 1;
        while (k > 0) {
            newNum += mult * (num % 10);
            k--;
            mult *= 10;
            num /= 10;
        }
        return newNum;
    }
    
    public static int rightDigits2(int num, int k) {
    	int div = (int)Math.pow(10, k);
    	return num % div;
    }

    public static boolean isKaprekar(int num) {
        int squared = num * num;
        int halfNumDigits = countDigits(squared) / 2;
        return num == leftDigits(squared, halfNumDigits) + rightDigits(squared, halfNumDigits);
    }
    
    public static void main(String[] args) {
        int num = 260043100;
        System.out.println(leftDigits(num, 5));
        System.out.println(rightDigits(num, 5));
        System.out.println(isKaprekar(9));
        System.out.println(isKaprekar(4950));
        System.out.println(isKaprekar(10));
        // Print all Kaprekar numbers (but only where the square has an even number of digits!)
        // that int can handle.
        int max = (int)Math.sqrt(Integer.MAX_VALUE);
        for (int i = 1; i <= max; i++) {
        	if (isKaprekar(i)) {
        		System.out.println(i);
        	}
        }
    }
}
