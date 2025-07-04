package eranbe.simplegames;

import java.util.Scanner;
import java.util.Random;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Bulls and Cows!");
        System.out.println("I have generated a 4-digit secret number. The digits can be repeated.");
        System.out.println("Your goal is to guess it. A 'Bull' means a correct digit in the right position.");
        System.out.println("A 'Cow' means a correct digit but in the wrong position.\n");

        // Generate the secret number (with possible repeated digits)
        int digit1 = random.nextInt(10);
        int digit2 = random.nextInt(10);
        int digit3 = random.nextInt(10);
        int digit4 = random.nextInt(10);

        boolean gameWon = false;
        int attempts = 0;

        while (!gameWon) {
            System.out.print("Enter your 4-digit guess: ");
            int guess = scanner.nextInt();

            int guess1 = (guess / 1000) % 10;
            int guess2 = (guess / 100) % 10;
            int guess3 = (guess / 10) % 10;
            int guess4 = guess % 10;

            attempts++;
            int bulls = countBulls(digit1, digit2, digit3, digit4, guess1, guess2, guess3, guess4);
            int cows = countCows(digit1, digit2, digit3, digit4, guess1, guess2, guess3, guess4);

            System.out.println("Bulls: " + bulls + ", Cows: " + cows);

            if (bulls == 4) {
                System.out.println("Congratulations! You guessed the secret number in " + attempts + " attempts.");
                gameWon = true;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int countBulls(int d1, int d2, int d3, int d4, int g1, int g2, int g3, int g4) {
        int bulls = 0;

        // Check if the digit in the guess matches the corresponding secret digit
        if (d1 == g1) bulls++;
        if (d2 == g2) bulls++;
        if (d3 == g3) bulls++;
        if (d4 == g4) bulls++;

        return bulls;
    }

    private static int countCows(int d1, int d2, int d3, int d4, int g1, int g2, int g3, int g4) {
        int cows = 0;

        // Track if we've already matched a digit as a bull
        boolean d1Matched = false, d2Matched = false, d3Matched = false, d4Matched = false;
        boolean g1Matched = false, g2Matched = false, g3Matched = false, g4Matched = false;

        // Count cows (correct digits but in wrong positions)
        if (!g1Matched && (g1 == d2 || g1 == d3 || g1 == d4) && !d1Matched) {
            cows++;
            g1Matched = true;
        }
        if (!g2Matched && (g2 == d1 || g2 == d3 || g2 == d4) && !d2Matched) {
            cows++;
            g2Matched = true;
        }
        if (!g3Matched && (g3 == d1 || g3 == d2 || g3 == d4) && !d3Matched) {
            cows++;
            g3Matched = true;
        }
        if (!g4Matched && (g4 == d1 || g4 == d2 || g4 == d3) && !d4Matched) {
            cows++;
            g4Matched = true;
        }

        return cows;
    }
}

