package eranbe.loops;

import java.util.Scanner;

public class EuclideanGCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("הכנס את המספר הראשון: ");
        int a = input.nextInt();
        System.out.print("הכנס את המספר השני: ");
        int b = input.nextInt();

        int originalA = a, originalB = b;

        // שמירה על חיוביות
        a = Math.abs(a);
        b = Math.abs(b);

        // אלגוריתם אוקלידס
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        System.out.println("המחלק המשותף הגדול ביותר של " + originalA + " ו-" + originalB + " הוא: " + a);
    }
}
