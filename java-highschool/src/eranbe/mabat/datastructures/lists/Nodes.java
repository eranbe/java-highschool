package eranbe.mabat.datastructures.lists;

import static eranbe.mabat.datastructures.lists.ListUtils.contains;

import java.util.Scanner;

import eranbe.datastructures.Node;

public class Nodes {

	public static void main(String[] args) {
		//buildAndPrintNumOccurrencesPerCharEx15();
		buildAndPrintNumOccurrencesPerCharEx16();

	}

	// 15a.
	public static int numOccurrences(Node<Character> head, char c) {
		int count = 0;
		while (head != null) {
			if (head.getValue() == c) {
				count++;
			}
			head = head.getNext();
		}
		return count;
	}
	
	// 15b.
	public static void buildAndPrintNumOccurrencesPerCharEx15() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		Node<Character> node = null;
		for (int i = 0; i < input.length(); i++) {
			node = new Node<Character>(input.charAt(i), node);
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			char smallC = (char)(c + 'a' - 'A');
			System.out.print("" + c + smallC + ": " + (numOccurrences(node, c) + numOccurrences(node, smallC)) + ", ");
		}
		System.out.println();
	}
	
	// 16a.
	public static void printNumOccurences(Node<Character> head) {
		Node<Character> seen = null;
		while (head != null) {
			char curr = head.getValue();
			if (!contains(seen, curr)) {
				// it's ok to call numOccurrences with the current head, as
				// we know that the char 'curr' didn't appear in any previous
				// node.
				System.out.print(curr + ": " + numOccurrences(head, curr) + ", ");
				seen = new Node<Character>(curr, seen);
			}
			head = head.getNext();
		}
		System.out.println();
	}
	
	// 16b.
	public static void buildAndPrintNumOccurrencesPerCharEx16() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		Node<Character> node = null;
		for (int i = 0; i < input.length(); i++) {
			node = new Node<Character>(input.charAt(i), node);
		}
		printNumOccurences(node);
	}
}
