package eranbe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CoinCombination {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the amount in shekels: ");
		double amountInShekels = scanner.nextDouble();

		// המרה לשקלים כדי להתאים למערך המטבעות באגורות
		int amountInAgorot = (int) (amountInShekels * 100);

		int[] coins = { 10, 50, 100, 200, 500 }; // מטבעות באגורות
		Set<List<Integer>> uniqueCombinations = new HashSet<>();
		getUniqueCombinations(coins, amountInAgorot, new ArrayList<>(), uniqueCombinations);

		System.out.println("Unique combinations:");
		int i = 1;
		for (List<Integer> combination : uniqueCombinations.stream().sorted(new Comparator<List<Integer>>() {
			public int compare(List<Integer> o1, List<Integer> o2) {
				return Integer.valueOf(o1.size()).compareTo(o2.size());
			};
		}).collect(Collectors.toList())) {
			System.out.print(i++ + ": [");
			for (int coin : combination.stream().sorted(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.valueOf(o1).compareTo(o2);				}
			}).collect(Collectors.toList())) {
				System.out.print(coin / 100.0 + " ");
			}
			System.out.println("]");
			if (i > 100) break;
		}
	}

	private static void getUniqueCombinations(int[] coins, int amount, List<Integer> combination,
			Set<List<Integer>> result) {
		if (amount == 0) {
			result.add(new ArrayList<>(combination));
			return;
		}

		for (int coin : coins) {
			if (coin <= amount) {
				combination.add(coin);
				getUniqueCombinations(coins, amount - coin, combination, result);
				combination.remove(combination.size() - 1);
			}
		}
	}
}
