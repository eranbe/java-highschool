package eranbe.loops;

import java.util.Scanner;

public class IsraeliIDCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("הכנס מספר תעודת זהות (9 ספרות): ");
        String id = input.nextLine();

        // בדיקה ידנית שכל התווים הם ספרות ואורך תקין
        if (id.length() != 9) {
            System.out.println("קלט לא חוקי. ודא שהזנת 9 ספרות.");
            return;
        }

        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (c < '0' || c > '9') {
                System.out.println("קלט לא חוקי. ודא שהזנת רק ספרות.");
                return;
            }
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = id.charAt(i) - '0';
            int factor = (i % 2 == 0) ? 1 : 2;
            int product = digit * factor;

            // חישוב סכום ספרות אם product דו־ספרתי
            if (product > 9) {
                int tens = product / 10;
                int ones = product % 10;
                product = tens + ones;
            }

            sum += product;
        }

        if (sum % 10 == 0) {
            System.out.println("תעודת הזהות תקינה ✅");
        } else {
            System.out.println("תעודת הזהות לא תקינה ❌");
        }
    }
}
