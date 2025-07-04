package eranbe;

public class CoinCombinations {
    public static void findCombinations(int[] coins, int amount, int[] combination, int index) {
        if (amount == 0) {
            printCombination(coins, combination);
            return;
        }

        if (index >= coins.length || amount < 0) {
            return;
        }

        for (int i = amount / coins[index]; i >= 0; i--) {
            combination[index] = i;
            findCombinations(coins, amount - i * coins[index], combination, index + 1);
        }
    }

    public static void printCombination(int[] coins, int[] combination) {
        System.out.print("צירוף אפשרי: ");
        for (int i = 0; i < coins.length; i++) {
            if (combination[i] > 0) {
                if (coins[i] >= 100) {
                    System.out.printf("%d מטבעות של %d שקלים, ", combination[i], coins[i] / 100);
                } else {
                    System.out.print(combination[i] + " מטבעות של " + coins[i] + " אגורות, ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] coins = {10, 50, 100, 200, 500, 1000};
        int amount = 390; // 1 שקל ו-50 אגורות

        int[] combination = new int[coins.length];
        findCombinations(coins, amount, combination, 0);
    }
}