package eranbe.mabat.datastructures.lists;

import eranbe.datastructures.IntNode;

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
	
	public static void printIntList(IntNode head) {
		while (head != null) {
			System.out.print(head.getValue() + ", ");
			head = head.getNext();
		}
		System.out.println();
	}
}
