package eranbe.arrays.countersaccumulators.exercises;

import java.util.*;

// what if the first and second are tied or second and third and so on? 
public class StudentCouncil {
	public static void main(String[] args) {
		int numCandidates = 5;
		Scanner in = new Scanner(System.in);
		System.out.println("How many students in the class?");
		int numStudents = in.nextInt();
		int[] studentVotes = new int[numCandidates];
		System.out.println("Enter student votes. Enter candidate num (1-" + numCandidates + ")");
		int i = 1;
		while (i <=  numStudents) {
			System.out.print("Enter student # " + i +  " vote: ");
			int vote = in.nextInt();
			if (vote < 1 || vote > numCandidates) {
				System.out.println("Ilegal candidate id");
			} else {
				studentVotes[vote-1]++;
				i++;
			}
		}
		printVotes(studentVotes);
		printFirstAndSecond(studentVotes);
	}

	private static void printVotes(int[] studentVotes) {
		System.out.print("[");
		for (int i = 0; i < studentVotes.length; i++) {
			System.out.print(studentVotes[i]);
			if (i < studentVotes.length -1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	private static void printFirstAndSecond(int[] studentVotes) {
		int firstIndex = 0;
		int secondIndex = 0;
		int first = studentVotes[firstIndex];
		int second = studentVotes[secondIndex];
		for (int i = 1; i < studentVotes.length; i++) {
			if (studentVotes[i] > first) {
				second = first;
				secondIndex = firstIndex;
				first = studentVotes[i];
				firstIndex = i;
			} else if (studentVotes[i] > second) {
				second = studentVotes[i];
				secondIndex = i;
			}
		}
		System.out.println("First: " + (firstIndex+1) + " (" + first + " votes)");
		System.out.println("Second: " + (secondIndex+1) + " (" + second + " votes)");
	}
}
