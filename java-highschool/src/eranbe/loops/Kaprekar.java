package eranbe.loops;

public class Kaprekar {
    public static void main(String[] args) {
        for (int num = 1; num <= 9999; num++) {
            int square = num * num;

            // ספירת ספרות ב־num (כמה ספרות יש במספר המקורי)
            int temp = num;
            int digits = 0;
            while (temp > 0) {
                digits++;
                temp /= 10;
            }

            // בסיס החיתוך (10 בחזקת מספר הספרות)
            int divider = 1;
            for (int i = 0; i < digits; i++) {
                divider *= 10;
            }

            // חלוקה לשני חלקים: ימין ושמאל
            int right = square % divider;
            int left = square / divider;

            if (right > 0 && left + right == num) {
                System.out.println(num + " הוא מספר קפרקר (כי " + left + " + " + right + " = " + num + ")");
            }
        }
    }
}
