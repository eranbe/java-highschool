package eranbe.datastructures.exercises;

import eranbe.datastructures.BinNode;

/**
 * https://g.co/gemini/share/b0baac0d2f41
 */
public class MorrisPreorderTraversal {

    public void morrisPreorder(BinNode<Integer> root) {
    	BinNode<Integer> current = root;
        while (current != null) {
            if (current.getLeft() == null) {
                System.out.print(current.getValue() + " ");
                current = current.getRight();
            } else {
            	BinNode<Integer> predecessor = current.getLeft();
                while (predecessor.getRight() != null && predecessor.getRight() != current) {
                    predecessor = predecessor.getRight();
                }

                if (predecessor.getRight() == null) {
                    System.out.print(current.getValue() + " "); // Process current node before going left
                    predecessor.setRight(current);
                    current = current.getLeft();
                } else {
                    predecessor.setRight(null);
                    current = current.getRight();
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	BinNode<Integer> root = new BinNode<Integer>(1);
        root.setLeft(new BinNode<Integer>(2));
        root.setRight(new BinNode<Integer>(3));
        root.getLeft().setLeft(new BinNode<Integer>(4));
        root.getLeft().setRight(new BinNode<Integer>(5));

        MorrisPreorderTraversal traversal = new MorrisPreorderTraversal();
        System.out.println("Morris Preorder Traversal:");
        traversal.morrisPreorder(root); // Output: 1 2 4 5 3
    }
}