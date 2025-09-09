package eranbe.datastructures.bintree;

import eranbe.datastructures.*;
import eranbe.datastructures.linkedlist.Item;

public class EncodedString {

	// Part 1: print all expanded paths (wrapper method)
	public static void printAllDecodedPaths(BinNode<Item> t) {
		// Start with an empty string path
		printAllDecodedPaths(t, "");
	}
	
	// helper method to check if a node is a leaf
	public static boolean isLeaf(BinNode<Item> bt) {
		return bt.getLeft() == null && bt.getRight() == null; 
	}
	
	// helper method to expand an item to the string it represents
	public static String expandItem(Item item) {
		String result = "";
		for (int i = 0; i < item.getCount(); i++) {
			result = result + item.getCh();
		}
		return result;
	}

	public static void printAllDecodedPaths(BinNode<Item> t, String pathSoFar) {
		if (t == null) {
			return;
		}
		pathSoFar = pathSoFar + expandItem(t.getValue());
		if (isLeaf(t)) {
			System.out.println(pathSoFar);
		} else {
			printAllDecodedPaths(t.getLeft(), pathSoFar);
			printAllDecodedPaths(t.getRight(), pathSoFar);
		}
	}

	// Part 2: get the length of the longest decoded string. Very similar to part 1
	// but here we check the decoded string length and locate the longest one
	public static int getMaxDecodedStringLength(BinNode<Item> t) {
		return getMaxDecodedStringLength(t, "");
	}

	public static int getMaxDecodedStringLength(BinNode<Item> t, String pathSoFar) {
		if (t == null) {
			return 0;
		}
		pathSoFar = pathSoFar + expandItem(t.getValue());
		if (isLeaf(t)) {
			return pathSoFar.length();
		} else {
			return Math.max(
					getMaxDecodedStringLength(t.getLeft(), pathSoFar), 
					getMaxDecodedStringLength(t.getRight(), pathSoFar));
		}
	}

	// Part 3: unrelated to the other 2 parts
	
	// Wrapper
	public static boolean isAllTwoLetterNamesLongerThanNum(BinNode<String> t, int num) {
		int twoLetterNamesCount = countTwoLetterNames(t);
		return twoLetterNamesCount * 2 >  num;
	}
	
	// Post-order scan
	public static int countTwoLetterNames(BinNode<String> t) {
		if (t == null) {
			return 0;
		}
		int result = countTwoLetterNames(t.getLeft()) + countTwoLetterNames(t.getRight());
		if (t.getValue().length() == 2) {
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		BinNode<Item> bt = new BinNode<Item>(
				new BinNode<Item>(
					null, 
					new Item(2, 'C'), 
					new BinNode<Item>(
							new Item(2, 'D')
					)
				),
				new Item(3, 'A'),
				new BinNode<Item>(
						new Item(1, 'B')));
		printAllDecodedPaths(bt);
		System.out.println("Max decoded string length: " + getMaxDecodedStringLength(bt));

		BinNode<String> btNames = new BinNode<String>(
				new BinNode<String>(
					null, 
					"גל", 
					new BinNode<String>("רן")
				),
				"שולמית",
				new BinNode<String>("רן"));
		System.out.println(isAllTwoLetterNamesLongerThanNum(btNames, 7)); // false
		System.out.println(isAllTwoLetterNamesLongerThanNum(btNames, 5)); // true
	}
}
