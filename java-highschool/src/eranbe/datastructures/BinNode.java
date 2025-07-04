package eranbe.datastructures;

public class BinNode<T> {
	private BinNode<T> left;
	private T value;
	private BinNode<T> right;

	public BinNode(T x) {
		this(null, x, null);
	}

	public BinNode(BinNode<T> left, T x, BinNode<T> right) {
		this.left = left;
		this.value = x;
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T x) {
		value = x;
	}

	public BinNode<T> getLeft() {
		return left;
	}

	public BinNode<T> getRight() {
		return right;
	}

	public void setLeft(BinNode<T> left) {
		this.left = left;
	}

	public void setRight(BinNode<T> right) {
		this.right = right;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public String toString() {
		return value.toString();
	}
}
