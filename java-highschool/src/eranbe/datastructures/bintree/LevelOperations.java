package eranbe.datastructures.bintree;

import static eranbe.datastructures.BinNode.isLeaf;

import eranbe.datastructures.BinNode;
import eranbe.datastructures.Queue;

/**
 * See
 * https://docs.google.com/presentation/d/1lQLC3Eh_qNKYLvZn-TwdqWyJVk_4tGRQ/edit?usp=sharing&ouid=101494708632928300874&rtpof=true&sd=true
 */
public class LevelOperations {
	public static boolean evenOddLevel(BinNode<Integer> t) {
		if (t == null)
			return true;
		if (t.hasLeft())
			if (t.getValue() % 2 == t.getLeft().getValue() % 2)
				return false;
		if (t.hasRight())
			if (t.getValue() % 2 == t.getRight().getValue() % 2)
				return false;
		return evenOddLevel(t.getLeft()) && evenOddLevel(t.getRight());
	}

	public static boolean isDownUpValueTree(BinNode<Integer> t) {
		return isDownUpValueTree(t, 0);
	}

	private static boolean isDownUpValueTree(BinNode<Integer> t, int level) {
		if (t == null)
			return true;
		if (level % 2 == 0) {
			if (t.hasLeft())
				if (t.getValue() <= t.getLeft().getValue())
					return false;
			if (t.hasRight())
				if (t.getValue() <= t.getRight().getValue())
					return false;
		} else {
			if (t.hasLeft())
				if (t.getValue() >= t.getLeft().getValue())
					return false;
			if (t.hasRight())
				if (t.getValue() >= t.getRight().getValue())
					return false;
		}
		return isDownUpValueTree(t.getLeft(), level + 1) && isDownUpValueTree(t.getRight(), level + 1);
	}

	public static int sumByLevel(BinNode<Integer> t, int level) {
		if (t == null)
			return 0;
		if (level == 0)
			return t.getValue();
		else
			return sumByLevel(t.getLeft(), level - 1) + sumByLevel(t.getRight(), level - 1);
	}

	public static void printByLevel(BinNode<Integer> t, int level) {
		if (t != null) {
			if (level == 0)
				System.out.print(t.getValue() + ",");
			else {
				printByLevel(t.getLeft(), level - 1);
				printByLevel(t.getRight(), level - 1);
			}
		}
	}

	public static int nodeCountByLevel(BinNode<Integer> t, int level) {
		if (t == null)
			return 0;
		if (level == 0)
			return 1;
		return nodeCountByLevel(t.getLeft(), level - 1) + nodeCountByLevel(t.getRight(), level - 1);
	}

	public static int leafCountByLevel(BinNode<Integer> t, int level) {
		if (t == null)
			return 0;
		if (level == 0)
			if (isLeaf(t))
				return 1;
			else // We can stop here - no need to dive deeper. Just return 0 as it's not a leaf.
					// Code will also work if we remove this else - level will be negative and
					// eventually we'll reach null and return 0.
				return 0;
		return leafCountByLevel(t.getLeft(), level - 1) + leafCountByLevel(t.getRight(), level - 1);
	}

	public static boolean isLevelFull(BinNode<Integer> t, int level) {
		if (t == null)
			return false;
		if (level == 0 && isLeaf(t))
			return true;
		return isLevelFull(t.getLeft(), level - 1) && isLevelFull(t.getRight(), level - 1);
	}

	public static void searchByLevel(BinNode<Integer> t) {
		Queue<BinNode<Integer>> q = new Queue<BinNode<Integer>>();
		q.insert(t);
		while (!q.isEmpty()) {
			t = q.remove();
			System.out.print(t.getValue() + " ");
			if (t.hasLeft())
				q.insert(t.getLeft());
			if (t.hasRight())
				q.insert(t.getRight());
		}
		System.out.println();
	}

	public static int height(BinNode<Integer> t) {
		if (t == null)
			return -1;
		return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
	}
}
