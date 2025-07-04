package eranbe.datastructures;

public class Stack<T> {
	private Node<T> first;
	public Stack() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(T value) {
		first = new Node<T>(value, first);
	}
	
	public T pop() {
		T value = first.getValue();
		first = first.getNext();
		return value;
	}
	
	public T top() {
		return first.getValue();
	}
	
	public String toString() {
		String result = "[";
		Node<T> p = first;
		while (p != null) {
			result = result + p.getValue();
			if (p.getNext() != null) {
				result = result + ",";
			}
			p = p.getNext();
		}
		result = result + "]";
		return result;
	}
}
