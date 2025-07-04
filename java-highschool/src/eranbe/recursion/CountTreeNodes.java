package eranbe.recursion;

import eranbe.datastructures.BinNode;

public class CountTreeNodes {
	public static <T> int countNodes(BinNode<T> node) {
	    if (node == null) {
	        return 0;
	    }
	    return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
	}
	
	public static void main(String[] args) {
		BinNode<Integer> bt = new BinNode<Integer>(
				new BinNode<Integer>(
					null, 
					2, 
					new BinNode<Integer>(3)
				),
				4,
				new BinNode<Integer>(5));
		System.out.println(countNodes(bt));
	}
}
