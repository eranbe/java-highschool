package eranbe.mabat.datastructures.lists;

import eranbe.datastructures.IntNode;
import eranbe.datastructures.Node;

public class ListUtils {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 6, 3, 4, 4, 4, 22, 3}; 
		IntNode node = createIntList(arr);
		printIntList(node);
	}
	public static IntNode createIntList(int[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		IntNode node = new IntNode(values[values.length-1]);
		for (int i = values.length-2; i >= 0; i--) {
			node = new IntNode(values[i], node);
		}
		return node;
	}
	
	public static <T> Node<T> createList(T[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		Node<T> node = new Node<T>(values[values.length-1]);
		for (int i = values.length-2; i >= 0; i--) {
			node = new Node<T>(values[i], node);
		}
		return node;
	}
	
	public static void printIntList(IntNode head) {
		while (head != null) {
			System.out.print(head.getValue() + ", ");
			head = head.getNext();
		}
		System.out.println();
	}
	
	public static <T> void printList(Node<T> head) {
		while (head != null) {
			System.out.print(head.getValue() + ", ");
			head = head.getNext();
		}
		System.out.println();
	}
	
	public static boolean contains(IntNode head, int value) {
		while (head != null) {
			if (head.getValue() == value) {
				return true;
			}
			head = head.getNext();
		}
		return false;
	}

	public static <T> boolean contains(Node<T> head, T value) {
		while (head != null) {
			if (head.getValue().equals(value)) {
				return true;
			}
			head = head.getNext();
		}
		return false;
	}

	public static boolean safeAddNext(IntNode curr, IntNode next) {
		if (curr == null)
			return false;
		if (next == null && curr.getNext() != null)
			return false;
		next.setNext(curr.getNext());
		return true;
	}

	public static <T> boolean safeAddNext(Node<T> curr, Node<T> next) {
		if (curr == null)
			return false;
		if (next == null && curr.getNext() != null)
			return false;
		next.setNext(curr.getNext());
		return true;
	}

	public static boolean safeRemoveNext(IntNode node) {
		if (node == null || node.getNext() != null)
			return false;
		node.setNext(node.getNext().getNext());
		return true; 
	}

	public static <T> boolean safeRemoveNext(Node<T> node) {
		if (node == null || node.getNext() != null)
			return false;
		node.setNext(node.getNext().getNext());
		return true; 
	}
}
