package eranbe.loops;

public class Harshad {
    public static void main(String[] args) {
        for (int num = 1; num <= 999; num++) {
            int sum = 0;
            int temp = num;

            while (temp > 0) {
                sum += temp % 10;   // הוספת ספרה לסכום
                temp /= 10;         // הסרת הספרה
            }

            if (sum != 0 && num % sum == 0) {
                System.out.println(num + " הוא מספר הרשד");
            }
        }
    }
}
