package eranbe.simplegames;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		// boolean playAgain = true;

		System.out.println("Welcome to the Number Guessing Game!");

		// while (playAgain) {
		int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
		int attempts = 0;
		boolean guessedCorrectly = false;

		System.out.println("\nI have chosen a number between 1 and 100. Can you guess it?");
		System.out.println("Enter your guesses:");

		while (!guessedCorrectly) {
			System.out.print("Your guess: ");
			int playerGuess = scanner.nextInt();
			attempts++;

			if (playerGuess < 1 || playerGuess > 100) {
				System.out.println("Please guess a number between 1 and 100.");
			} else if (playerGuess < numberToGuess) {
				System.out.println("Too low! Try again.");
			} else if (playerGuess > numberToGuess) {
				System.out.println("Too high! Try again.");
			} else {
				System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
				guessedCorrectly = true;
			}
		}

		// System.out.print("\nDo you want to play again? (yes/no): ");
		// String response = scanner.next().toLowerCase();
		// playAgain = response.equals("yes") || response.equals("y");
		// }

		System.out.println("Thanks for playing!");
		scanner.close();
	}
}
