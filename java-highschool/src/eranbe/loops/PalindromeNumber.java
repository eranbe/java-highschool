package eranbe.loops;

public class PalindromeNumber {
    public static void main(String[] args) {
        for (int num = 1; num <= 9999; num++) {
            int reversed = 0;
            int temp = num;

            while (temp > 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            if (num == reversed) {
                System.out.println(num + " הוא פלינדרום");
            }
        }
    }
}
