package eranbe.arrays.countersaccumulators.exercises;

import java.util.*;

public class BeautyContest {
    public static void main(String[] args) {
		int[] scores = createScores(20);
		readVotes(scores);
		printScores(scores);
		printWinnersAndCounts(scores);
	}

	private static void printScores(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i+1 != arr.length) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	private static void printWinnersAndCounts(int[] scores) {
		calcAndPrintPlace(scores, 1);
		calcAndPrintPlace(scores, 2);
		calcAndPrintPlace(scores, 3);
	}

	private static void calcAndPrintPlace(int[] scores, int place) {
		int first = scores[0];
		int firstPos = 0;
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > first) {
				first = scores[i];
				firstPos = i;
			}
		}
		System.out.println(place + ": " + (firstPos+1) + " score: " + first);
		scores[firstPos] = -1;
	}

	private static void readVotes(int[] scores) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Enter vote number " + (i+1) + " (first, second, third): ");
			int first = in.nextInt();
			int second = in.nextInt();
			int third = in.nextInt();
			scores[first-1] += 3;
			scores[second-1] += 2;
			scores[third-1] += 1;
		}
	}

	private static int[] createScores(int size) {
		return new int[size];
	}
}
