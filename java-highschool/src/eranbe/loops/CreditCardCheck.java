package eranbe.loops;

import java.util.Scanner;

public class CreditCardCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("הכנס מספר כרטיס אשראי: ");
        String card = input.nextLine();

        int length = card.length();
        if (length < 13 || length > 19) {
            System.out.println("מספר לא חוקי. הזן בין 13 ל-19 ספרות.");
            return;
        }

        for (int i = 0; i < length; i++) {
            char c = card.charAt(i);
            if (c < '0' || c > '9') {
                System.out.println("מספר לא חוקי. ודא שכל התווים הם ספרות.");
                return;
            }
        }

        int sum = 0;
        boolean doubleIt = false;

        for (int i = length - 1; i >= 0; i--) {
            int digit = card.charAt(i) - '0';

            if (doubleIt) {
                int product = digit * 2;

                // חישוב סכום ספרות של product
                if (product > 9) {
                    int tens = product / 10;
                    int ones = product % 10;
                    product = tens + ones;
                }

                sum += product;
            } else {
                sum += digit;
            }

            doubleIt = !doubleIt;
        }

        if (sum % 10 == 0) {
            System.out.println("כרטיס האשראי תקין ✅");
        } else {
            System.out.println("כרטיס האשראי לא תקין ❌");
        }
    }
}
