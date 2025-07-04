package eranbe.loops;

import java.util.Scanner;

import java.util.Scanner;

public class Collatz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("הכנס מספר שלם חיובי: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("יש להזין מספר חיובי בלבד.");
            return;
        }

        int steps = 0;
        System.out.println("שרשרת קולץ עבור " + n + ":");

        while (n != 1) {
            System.out.print(n + " → ");
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }

        System.out.println("1");
        System.out.println("מספר הצעדים: " + steps);
    }
}
