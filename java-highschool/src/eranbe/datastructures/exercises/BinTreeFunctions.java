package eranbe.datastructures.exercises;

import eranbe.datastructures.*;

public class BinTreeFunctions {
	
	public static void printPreOrder(BinNode<Integer> bt) {
		if (bt!= null) {
			System.out.print(bt.getValue() + ", ");
			printPreOrder(bt.getLeft());
			printPreOrder(bt.getRight());
		}
	}

	public static void printInOrder(BinNode<Integer> bt) {
		if (bt!= null) {
			printInOrder(bt.getLeft());
			System.out.print(bt.getValue() + ", ");
			printInOrder(bt.getRight());
		}
	}

	public static void printPostOrder(BinNode<Integer> bt) {
		if (bt!= null) {
			printPostOrder(bt.getLeft());
			printPostOrder(bt.getRight());
			System.out.print(bt.getValue() + ", ");
		}
	}

	public static int sumNodes(BinNode<Integer> bt) {
		if (bt == null) {
			return 0;
		}
		return bt.getValue() + sumNodes(bt.getLeft()) + sumNodes(bt.getRight());
	}
	
	public static boolean isLeaf(BinNode<Integer> bt) {
		return bt.getLeft() == null && bt.getRight() == null; 
	}
	
	public static int countLeafs(BinNode<Integer> bt) {
		if (bt == null) {
			return 0;
		}
		if (isLeaf(bt)) {
			return 1;
		}
		return countLeafs(bt.getLeft()) + countLeafs(bt.getRight());
	}
	
	public static int countSingleChildren(BinNode<Integer> bt) {
		if (bt == null || isLeaf(bt)) {
			return 0;
		}
		if (bt.hasLeft() && !bt.hasRight()) {
			return 1 + countSingleChildren(bt.getLeft());
		}
		if (!bt.hasLeft() && bt.hasRight()) {
			return 1 + countSingleChildren(bt.getRight());
		}
		return countSingleChildren(bt.getLeft()) + countSingleChildren(bt.getRight());
	}
	
	public static int countEvenNodes(BinNode<Integer> bt) {
		if (bt == null) return 0;
		int count = countEvenNodes(bt.getLeft()) + countEvenNodes(bt.getRight());
		if (bt.getValue() % 2 == 0) {
			count++; 
		}
		return count;
	}
	public static boolean exists(BinNode<Integer> bt, int value) {
		if (bt == null) {
			return false;
		}
		if (bt.getValue() == value) {
			return true;
		}
		return exists(bt.getLeft(), value) || exists(bt.getRight(), value);
	}

	public static boolean isAllOdd(BinNode<Integer> bt) {
		if (bt == null) {
			return true;
		}
		if (bt.getValue() % 2 == 1) {
			return false;
		}
		return isAllOdd(bt.getLeft()) && isAllOdd(bt.getRight());
	}

	public static boolean isBalanced(BinNode<Integer> bt) {
		if (bt == null || isLeaf(bt)) {
			return true;
		}
		int leftHeight = height(bt.getLeft());
		int rightHeight = height(bt.getRight());
		if (Math.abs(rightHeight - leftHeight) > 1) {
			return false;
		}
		return isBalanced(bt.getLeft()) && isBalanced(bt.getRight());
	}
	
	public static int height(BinNode<Integer> bt) {
		if (bt == null) return 0;
		if (isLeaf(bt)) return 1;
		return 1 + Math.max(height(bt.getLeft()), height(bt.getRight()));
	}
	
	public static boolean isGradient(BinNode<Integer> bt) {
		if (bt == null) return false;
		if (isLeaf(bt)) return true;
		if (!bt.hasLeft() || !bt.hasRight()) {
			return false;
		}
		int value = bt.getValue();
		int leftValue = bt.getLeft().getValue();
		int rightValue = bt.getRight().getValue();
		
		if (leftValue >= rightValue || rightValue >= value) {
			return false;
		}
		return isGradient(bt.getLeft()) && isGradient(bt.getRight());
	}
	
	public static void divideEvensBy2(BinNode<Integer> bt) {
		if (bt != null) {
			int value = bt.getValue(); 
			if (value % 2 == 0) {
				bt.setValue(value / 2);
			}
			divideEvensBy2(bt.getLeft());
			divideEvensBy2(bt.getRight());
		}
	}
	
	/**
	 * 0 - no children
	 * 1 - has only left child
	 * 2 - has only right child
	 * 3 - has both children
	 */
	public static int childCode(BinNode<Integer> bt) {
		if (!bt.hasLeft() && !bt.hasRight()) {
			return 0;
		}
		if (bt.hasLeft() && bt.hasRight()) {
			return 3;
		}
		if (bt.hasLeft()) {
			return 1;
		}
		return 2;
	}
	
	public static void addBroToSingleChildren(BinNode<Integer> bt) {
		int ck = childCode(bt);
		if (ck != 0) {
			if (ck == 1) {
				bt.setLeft(new BinNode<Integer>(0));
			} else if (ck == 2) {
				bt.setRight(new BinNode<Integer>(0));
			}
			addBroToSingleChildren(bt.getLeft());
			addBroToSingleChildren(bt.getRight());
		}
	}
	
	public static int maxChain(BinNode<Integer> bt) {
		int ck = childCode(bt);
		if (ck == 0) {
			return bt.getValue();
		}
		if (ck == 1) {
			return bt.getValue() + maxChain(bt.getLeft());
		}
		if (ck == 2) {
			return bt.getValue() + maxChain(bt.getRight());
		}
		return bt.getValue() + Math.max(maxChain(bt.getLeft()), maxChain(bt.getRight()));
	}
	
	public static boolean existsInList(Node<Pair<Character, Integer>> lst, char c) {
		while (lst != null) {
			if (lst.getValue().getKey() == c) {
				return true;
			}
			lst = lst.getNext();
		}
		return false;
	}
	
	public static int countChar(BinNode<Character> bt, char c) {
		if (bt == null) {
			return 0;
		}
		int count = countChar(bt.getLeft(), c) + countChar(bt.getRight(), c);
		if (bt.getValue() == c) {
			count++;
		}
		return count;
	}
	
	public static void charCounts(BinNode<Character> bt, Node<Pair<Character, Integer>> lst) {
		if (bt != null) {
			if (!existsInList(lst, bt.getValue())) {
				int charCount = countChar(bt, bt.getValue());
				lst = new Node<Pair<Character, Integer>>(new Pair<Character, Integer>(bt.getValue(), charCount));
			}
			charCounts(bt.getLeft(), lst);
			charCounts(bt.getRight(), lst);
		}
	}
	
	public static Node<Pair<Character, Integer>> charCounts(BinNode<Character> bt) {
		Node<Pair<Character, Integer>> lst = null;
		charCounts(bt, lst);
		return lst;
	}
}
