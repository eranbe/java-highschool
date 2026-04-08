package eranbe.mabat.datastructures.lists;

import static eranbe.mabat.datastructures.lists.ListUtils.createIntList;
import static eranbe.mabat.datastructures.lists.ListUtils.printIntList;

import java.util.Random;
import java.util.Scanner;

import eranbe.datastructures.IntNode;

public class IntNodes {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 6, 3, 4, 4, 4, 22, 3};
		int[] arrSorted = { 1, 3, 4, 5, 6, 9, 10 };
		int[] arrEvenOddSame = { 2, 3, 2, 3 };
		int[] arr1 = { 2 };
		int[] arr2 = { 2, 3 };
		int[] arr3 = { 2, 3, 4 };
		System.out.println(countNumSequences(createIntList(arr), 4));
		System.out.println(isSortedUp(createIntList(arr)));
		System.out.println(isSortedUp(createIntList(arrSorted)));
		System.out.println(evenOdd(createIntList(arr)));
		System.out.println(evenOdd(createIntList(arrSorted)));
		System.out.println(evenOdd(createIntList(arrEvenOddSame)));
		printAllGreaterThanNext(createIntList(arr));
		System.out.println(isBalanced(createIntList(arrEvenOddSame)));
		System.out.println(isBalanced(createIntList(arr)));
		printValuesBetweenIndices(createIntList(arr), 3, 6);
		//printIntList(buildReverseList());
		IntNode random50 = buildRandomUnique2DigitList(); 
		printIntList(random50);
		printIntList(buildComplementary2DigitList(random50));
		printIntList(nFromBeginner(5, 4));
		printIntList(remove(createIntList(arr), 4));
		printIntList(unique(createIntList(arr)));
		printIntList(ex13(createIntList(arr)));
		printIntList(ex13(createIntList(arrSorted)));
		printIntList(ex13(createIntList(arr2)));
		printIntList(ex13(createIntList(arr3)));
		printIntList(ex13(createIntList(arr1)));
		printIntList(removeDupsAndAddRemoveCount(createIntList(arr3), createIntList(arr2)));
	}

	// 2.
	public static int countNumSequences(IntNode head, int num) {
		int result = 0;
		boolean inSequence = false;
		while (head != null) {
			if (head.getValue() == num) {
				if (!inSequence) {
					inSequence = true;
					result++;
				}
			} else {
				inSequence = false;
			}
			head = head.getNext();
		}
		return result;
	}
	
	// 3.
	public static boolean isSortedUp(IntNode head) {
		if (head == null) {
			return true;
		}
		int val = head.getValue();
		head = head.getNext();
		while (head != null) {
			if (head.getValue() < val) {
				return false;
			}
			val = head.getValue();
			head = head.getNext();
		}
		return true;
	}
	
	// 4. 
	public static char evenOdd(IntNode head) {
		int evenCount = 0, oddCount = 0;
		while (head != null) {
			if (head.getValue() % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
			head = head.getNext();
		}
		if (evenCount > oddCount) {
			return 'z';
		} else if (evenCount < oddCount) {
			return 'e';
		} else {
			return 's';
		}
	}
	
	// 5.
	public static void printAllGreaterThanNext(IntNode head) {
		if (head == null) {
			return;
		}
		while (head.hasNext()) {
			int val = head.getValue();
			if (val > head.getNext().getValue()) {
				System.out.print(val + ", ");
			}
			head = head.getNext();
		}
		// Last element implicitly larger than next (which is null);
		System.out.println(head.getValue());
	}
	
	// 6.
	public static boolean isBalanced(IntNode head) {
		// calc avg
		double sum = 0;
		int count = 0;
		IntNode curr = head;
		while (curr != null) {
			sum += curr.getValue();
			count++;
			curr = curr.getNext();
		}
		double avg = sum / count;
		// count smaller
		int smallerCount = 0;
		curr = head;
		while (curr != null) {
			if (curr.getValue() < avg) {
				smallerCount++;
			}
			curr = curr.getNext();
		}
		return smallerCount == count - smallerCount;
	}
	
	// 7.
	public static void printValuesBetweenIndices(IntNode head, int low, int high) {
		int count = 1;
		while (head != null && count <= high) {
			if (count >= low) {
				System.out.print(head.getValue() + ", ");
			}
			count++;
			head = head.getNext();
		}
		System.out.println();
	}
	
	// 8.
	public static IntNode buildReverseList() {
		Scanner in = new Scanner(System.in);
		int val = in.nextInt();
		IntNode head = null;
		while (val != -999) {
			head = new IntNode(val, head);
			val = in.nextInt();
		}
		return head;
	}
	
	// 9a.
	public static IntNode buildRandomUnique2DigitList() {
		int count = 0;
		IntNode head = null;
		Random rnd = new Random();
		while (count < 50) {
			int num = rnd.nextInt(99-10+1)+10;
			if (countNumSequences(head, num) == 0) {
				head = new IntNode(num, head);
				count++;
			}
		}
		return head;
	}
	
	// 9b.
	public static IntNode buildComplementary2DigitList(IntNode head) {
		IntNode result = null;
		for (int i = 99; i >= 10; i--) {
			if (countNumSequences(head, i) == 0) {
				result = new IntNode(i, result);
			}
		}
		return result;
	}
	
	// 10.
	public static IntNode nFromBeginner(int beginner, int n) {
		IntNode result = null;
		while (n > 0) {
			result = new IntNode(beginner + n - 1, result);
			n--;
		}
		return result;
	}
	
	// 11.
	public static IntNode remove(IntNode head, int n) {
		IntNode dummy = new IntNode(Integer.MAX_VALUE, head);
		head = dummy;
		while (head != null) {
			if (head.hasNext() && head.getNext().getValue() == n) {
				head.setNext(head.getNext().getNext());
			} else {
				head = head.getNext();
			}
		}
		return dummy.getNext();
	}
	
	// 12.
	public static IntNode unique(IntNode head) {
		IntNode result = null;
		while (head != null) {
			if (countNumSequences(result, head.getValue()) == 0) {
				result = new IntNode(head.getValue(), result);
			}
			head = head.getNext();
		}
		return result;
	}
	
	// 13.
	public static IntNode ex13(IntNode head) {
		if (head == null) {
			return null;
		}
		IntNode dummy = new IntNode(Integer.MAX_VALUE, head);
		head = dummy;
		// count how many nodes in list
		int count = 0;
		while (head.hasNext()) {
			count++;
			head = head.getNext();
		}
		if (count % 2 == 0) {
			head = dummy;
			for (int i = 0; i <= count/2 - 2; i++) {
				head = head.getNext();
			}
			if (head.getNext().getValue() > head.getNext().getNext().getValue()) {
				head.setNext(head.getNext().getNext());
			} else {
				head.getNext().setNext(head.getNext().getNext().getNext());
			}
		} else {
			dummy.setNext(dummy.getNext().getNext());
			head = dummy;
			// also handle the case of list of length 1
			while (head.hasNext() && head.getNext().hasNext()) {
				head = head.getNext();
			}
			head.setNext(null);
		}
		return dummy.getNext();
	}
	
	// 14.
	public static IntNode removeDupsAndAddRemoveCount(IntNode chain1, IntNode chain2) {
		IntNode dummy = new IntNode(Integer.MAX_VALUE, chain1);
		IntNode head = dummy;
		int removeCount = 0;
		while (head.hasNext()) {
			if (countNumSequences(chain2, head.getNext().getValue()) > 0) {
				head.setNext(head.getNext().getNext());
				removeCount++;
			} else {
				head = head.getNext();
			}
		}
		head.setNext(new IntNode(removeCount, null));
		return dummy.getNext();
	}
}
