package eranbe.datastructures.exercises;

import eranbe.datastructures.*;

public class Eratosthenes {
	private Node<Integer> first;
	
	public Eratosthenes(int n) {
		// createNodes(n)
		first = createNodesRecursive(2, n);
		primes();
	}

	private void createNodes(int n) {
		first = new Node<Integer>(2);
		Node<Integer> current = first;
		for (int i = 3; i <= n; i++) {
			Node<Integer> next = new Node<Integer>(i);
			current.setNext(next);
			current = next;
		}		
	}
	
	private Node<Integer> createNodesRecursive(int current, int max) {
		if (current == max) {
			return new Node<Integer>(current, null);
		}
		return new Node<Integer>(current, createNodesRecursive(current+1, max));
	}
	
	private void primes() {
		Node<Integer> currPrime = first;
		while (currPrime != null) {
			Node<Integer> iterator = currPrime.getNext();
			Node<Integer> prev = currPrime;
			while (iterator != null) {
				if (iterator.getValue() % currPrime.getValue() == 0) {
					Node<Integer> next = iterator.getNext();
					prev.setNext(next);
					iterator = next;
				} else {
					prev = iterator;
					iterator = iterator.getNext();
				}
			}
			currPrime = currPrime.getNext();
		}
	}
	
	// Also print the number of primes at the beginning. 
	public String toString() {
		String result = "";
		Node<Integer> curr = first;
		int count = 0;
		while (curr != null) {
			result += curr.getValue();
			if (curr.getNext() != null) {
				result += ",";
			}
			curr = curr.getNext();
			count++;
		}
		return "[count: " + count + "] " + result;
	}
	
	public static void main(String[] args) {
		Eratosthenes e1 = new Eratosthenes(30);
		System.out.println(e1);
		Eratosthenes e2 = new Eratosthenes(1000);
		System.out.println(e2);
	}
}
