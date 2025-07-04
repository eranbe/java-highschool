package eranbe;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    private static final int[] COINS = {10, 50, 100, 200, 500, 1000}; // ערכי המטבעות באגורות

    public static void main(String[] args) {
        int totalAmount = 390; // דוגמה לסכום כסף
        List<List<Integer>> combinations = getCombinations(totalAmount);
        System.out.println("מספר האפשרויות: " + combinations.size());
        System.out.println("כל האפשרויות להרכבת הסכום:");
        for (List<Integer> combination : combinations) {
            for (int i = 0; i < combination.size(); i++) {
                if (COINS[combination.size()-i-1] >= 100) {
                    System.out.print(COINS[combination.size()-i-1] / 100 + " ש\"ח x " + combination.get(i) + " ");
                } else {
                    System.out.print(COINS[combination.size()-i-1] + " אגורות x " + combination.get(i) + " ");
                }
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getCombinations(int amount) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(amount, COINS.length - 1, new ArrayList<>(), result);
        return result;
    }

    private static void getCombinations(int amount, int coinIndex, List<Integer> current, List<List<Integer>> result) {
        if (amount == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (coinIndex < 0 || amount < 0) {
            return;
        }

        for (int i = 0; i * COINS[coinIndex] <= amount; i++) {
            current.add(i);
            getCombinations(amount - i * COINS[coinIndex], coinIndex - 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}