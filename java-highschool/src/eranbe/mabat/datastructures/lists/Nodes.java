package eranbe.mabat.datastructures.lists;

import static eranbe.mabat.datastructures.lists.ListUtils.contains;
import static eranbe.mabat.datastructures.lists.ListUtils.createList;
import static eranbe.mabat.datastructures.lists.ListUtils.printList;
import java.util.Scanner;

import eranbe.datastructures.Node;

public class Nodes {

	public static void main(String[] args) {
		//buildAndPrintNumOccurrencesPerCharEx15();
		//buildAndPrintNumOccurrencesPerCharEx16();
		Character[] mathExp = { '1', '+', '2', '3', '*', '4' };
		printList(calcMathExpressions(createList(mathExp)));
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
	
	// 17.
	public static Node<Integer> calcMathExpressions(Node<Character> head) {
		if (head == null) {
			return null;
		}
		int operand1 = head.getValue() - '0';
		head = head.getNext();
		char operator = head.getValue();
		head = head.getNext();
		int operand2 = head.getValue() - '0';
		int value = 0;
		if (operator == '+') {
			value = operand1 + operand2;
		} else if (operator == '-') {
			value = operand1 - operand2;
		} else if (operator == '*') {
			value = operand1 * operand2;
		} else if (operator == '/') {
			value = operand1 / operand2;
		}
		return new Node<Integer>(value, calcMathExpressions(head.getNext()));
	}
}
