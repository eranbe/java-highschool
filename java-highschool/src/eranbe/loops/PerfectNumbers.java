package eranbe.loops;

public class PerfectNumbers {
    public static void main(String[] args) {
        for (int num = 2; num <= 10000; num++) {
            int sum = 0;

            // חישוב סכום המחלקים של num (ללא עצמו)
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }

            // בדיקה אם המספר מושלם
            if (sum == num) {
                System.out.println(num + " הוא מספר מושלם.");
            }
        }
    }
}
