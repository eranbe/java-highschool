package eranbe.bagrut.q899271.a2025.q3;

import eranbe.datastructures.BinNode;

public class LeftKTree {
	public static boolean isLeftK(BinNode<Integer> tree, int k) {
		if (tree == null) {
			return true;
		}
		if (tree.getLeft() != null && k == 0) {
			return false;
		}
		return isLeftK(tree.getLeft(), k-1) && isLeftK(tree.getRight(), k);
	}

	public static void main(String[] args) {
		BinNode<Integer> tree = constructTree1();
		System.out.println(isLeftK(tree, 1));
		tree = constructTree2();
		System.out.println(isLeftK(tree, 1));
		tree = constructTree3();
		System.out.println(isLeftK(tree, 1));
		System.out.println(isLeftK(tree, 2));
		System.out.println(isLeftK(tree, 3));
		System.out.println(isLeftK(tree, 4));

	}

	private static BinNode<Integer> constructTree1() {
		return new BinNode<Integer>(
				new BinNode<Integer>(1),
				1,
				new BinNode<Integer>(
						new BinNode<Integer>(
								null,
								1,
								new BinNode<Integer>(1)),
						1,
						new BinNode<Integer>(
								new BinNode<Integer>(1),
								1,
								new BinNode<Integer>(1)
						)
				)
			);
	}

	private static BinNode<Integer> constructTree2() {
		return new BinNode<Integer>(
				new BinNode<Integer>(
						null,
						1,
						new BinNode<Integer>(1)),
				1,
				new BinNode<Integer>(
						new BinNode<Integer>(1),
						1,
						new BinNode<Integer>(
								new BinNode<Integer>(1),
								1,
								new BinNode<Integer>(1)
						)
				)
			);
	}
	
	private static BinNode<Integer> constructTree3() {
		return new BinNode<Integer>(
				new BinNode<Integer>(
						null,
						1,
						new BinNode<Integer>(1)),
				1,
				new BinNode<Integer>(
						new BinNode<Integer>(
								new BinNode<Integer>(1),
								1,
								new BinNode<Integer>(1)
						),
						1,
						new BinNode<Integer>(1)
				)
			);
	}

}
