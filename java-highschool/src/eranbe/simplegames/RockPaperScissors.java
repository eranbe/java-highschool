package eranbe.simplegames;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        // boolean playAgain = true;

        System.out.println("Welcome to Rock-Paper-Scissors!");

        // while (playAgain) {
            System.out.println("\nChoose your move: (0 = Rock, 1 = Paper, 2 = Scissors)");
            int playerChoice;
            //while (true) {
                System.out.print("Your choice: ");
                playerChoice = scanner.nextInt();
            //    if (playerChoice >= 0 && playerChoice <= 2) {
            //        break;
            //    } else {
            //        System.out.println("Invalid input. Please choose 0, 1, or 2.");
            //    }
            //}

            int computerChoice = random.nextInt(3);

            System.out.println("You chose: " + choices[playerChoice]);
            System.out.println("Computer chose: " + choices[computerChoice]);

            if (playerChoice == computerChoice) {
                System.out.println("It's a tie!");
            } else if ((playerChoice == 0 && computerChoice == 2) ||
                       (playerChoice == 1 && computerChoice == 0) ||
                       (playerChoice == 2 && computerChoice == 1)) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            //System.out.print("\nDo you want to play again? (yes/no): ");
            //String response = scanner.next().toLowerCase();
            //playAgain = response.equals("yes") || response.equals("y");
        //}

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
