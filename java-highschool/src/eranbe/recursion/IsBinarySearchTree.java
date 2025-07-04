package eranbe.recursion;

import eranbe.datastructures.BinNode;

public class IsBinarySearchTree {
	public static boolean isBST(BinNode<Integer> node, Integer min, Integer max) {
	    if (node == null) {
	        return true;
	    }
	    if ((min != null && node.getValue() <= min) || (max != null && node.getValue() >= max)) {
	        return false;
	    }
	    return isBST(node.getLeft(), min, node.getValue()) && isBST(node.getRight(), node.getValue(), max);
	}
	
	public static boolean isBST(BinNode<Integer> root) {
		return isBST(root, null, null);
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
		System.out.println(isBST(bt));
	}

}
